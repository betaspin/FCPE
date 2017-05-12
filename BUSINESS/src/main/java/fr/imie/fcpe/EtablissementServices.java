package fr.imie.fcpe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless(name = "EtablissementEJB")
public class EtablissementServices {

    @PersistenceContext
    EntityManager em;

    public EtablissementServices() {
    }

    public List<EtablissementBO> findAll(){
        em.createNativeQuery("INSERT INTO etablissement (id) VALUES (1)").executeUpdate();

        @SuppressWarnings("unchecked")
        List<EtablissementEntity> data = em.createNamedQuery("EtablissementEntity.findAll").getResultList();

        List<EtablissementBO> etablissementsBO = new ArrayList<EtablissementBO>();

        for(EtablissementEntity etablissementEntity: data){
            etablissementsBO.add(EtablissementBO.mapEtablissementEntityToBO(etablissementEntity));
        }

        return etablissementsBO;
    }
}
