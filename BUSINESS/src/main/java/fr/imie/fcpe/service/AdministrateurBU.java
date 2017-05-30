package fr.imie.fcpe.service;

import fr.imie.fcpe.*;
import fr.imie.fcpe.mapping.AdministrateurMapping;
import fr.imie.fcpe.model.AdministrateurBO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import io.jsonwebtoken.*;
import java.util.Date;

@Stateless
public class AdministrateurBU {
	
    @PersistenceContext
    EntityManager em;

    public AdministrateurBO findOneByAuth(AdministrateurBO admin) {
        try {
            AdministrateurEntity adminEntity = (AdministrateurEntity) em.createNamedQuery("AdministrateurEntity.findOneByAuth").setParameter("identifiant", admin.getIdentifiant()).setParameter("motdepasse", admin.getMotdepasse()).getSingleResult();
            admin = AdministrateurMapping.mapAdministrateurEntityToBO(adminEntity);
            String token = createJWT(admin.getIdentifiant(), "FCPE", "admin group auth", 10000);
            admin.setToken(token);
            return admin;
        }catch (NoResultException ex){
            return null;
        }
    }

    //Sample method to construct a JWT
    private String createJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("toto");
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }
}
