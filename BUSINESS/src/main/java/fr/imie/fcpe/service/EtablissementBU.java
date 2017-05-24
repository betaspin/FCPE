package fr.imie.fcpe.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.fcpe.EtablissementEntity;
import fr.imie.fcpe.TypeEtablissementEntity;
import fr.imie.fcpe.mapping.EtablissementMapping;
import fr.imie.fcpe.model.EtablissementBO;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class EtablissementBU {

    @PersistenceContext
    EntityManager em;

    public EtablissementBO findOne(Integer idEtablissement) {
        EtablissementEntity etablissementEntity = em.find(EtablissementEntity.class, idEtablissement);
        EtablissementBO etablissement = EtablissementMapping.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
    }

    public List<EtablissementBO> findAll() {
        @SuppressWarnings("unchecked")
        List<EtablissementEntity> data = em.createNamedQuery("EtablissementEntity.findAll").getResultList();

        List<EtablissementBO> etablissementsBO = new ArrayList<EtablissementBO>();

        for(EtablissementEntity etablissementEntity: data){
            etablissementsBO.add(EtablissementMapping.mapEtablissementEntityToBO(etablissementEntity));
        }

        return etablissementsBO;
    }

    public EtablissementBO create(EtablissementBO etablissement) {
    	// TODO
        List<TypeEtablissementEntity> typesEtablissementEntity = null;
    	
        EtablissementEntity etablissementEntity = EtablissementMapping.mapEtablissementBOToEntity(etablissement, typesEtablissementEntity);
        em.persist(etablissementEntity);
        return etablissement;
    }

    public EtablissementBO update(EtablissementBO etablissement) {
    	// TODO
        List<TypeEtablissementEntity> typesEtablissementEntity = null;
    	
        EtablissementEntity etablissementEntity = EtablissementMapping.mapEtablissementBOToEntity(etablissement, typesEtablissementEntity);
        etablissementEntity = em.merge(etablissementEntity);
        etablissement = EtablissementMapping.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
    }

    public EtablissementBO delete(Integer idEtablissement) {
    	// TODO
        List<TypeEtablissementEntity> typesEtablissementEntity = null;
    	
        EtablissementBO etablissement = findOne(idEtablissement);
        etablissement.setId(idEtablissement);
        etablissement.setArchive(true);
        EtablissementEntity etablissementEntity = EtablissementMapping.mapEtablissementBOToEntity(etablissement, typesEtablissementEntity);
        em.merge(etablissementEntity);
        return etablissement;
    }
}
