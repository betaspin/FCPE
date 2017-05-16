package fr.imie.fcpe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless(name = "EtablissementEJB")
public class EtablissementBU implements IEtabllissement{

    @PersistenceContext
    EntityManager em;

    public EtablissementBU() {
    }

    @Override
    public List<EtablissementBO> findAll() {
        @SuppressWarnings("unchecked")
        List<EtablissementEntity> data = em.createNamedQuery("EtablissementEntity.findAll").getResultList();

        List<EtablissementBO> etablissementsBO = new ArrayList<EtablissementBO>();

        for(EtablissementEntity etablissementEntity: data){
            etablissementsBO.add(EtablissementBO.mapEtablissementEntityToBO(etablissementEntity));
        }

        return etablissementsBO;
    }

    @Override
    public EtablissementBO createEtablissement(EtablissementBO etablissement) {
        EtablissementEntity etablissementEntity = EtablissementBO.mapEtablissementBOToEntity(etablissement);
        em.persist(etablissementEntity);
        return etablissement;
    }
}
