package fr.imie.fcpe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless(name = "EtablissementEJB")
public class EtablissementBU implements IEtablissement{

    @PersistenceContext
    EntityManager em;

    public EtablissementBU() {
    }

    @Override
    public EtablissementBO findOne(Integer idEtablissement) {
        EtablissementEntity etablissementEntity = em.find(EtablissementEntity.class, idEtablissement);
        EtablissementBO etablissement = EtablissementBO.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
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

    @Override
    public EtablissementBO updateEtablissement(EtablissementBO etablissement) {
        EtablissementEntity etablissementEntity = EtablissementBO.mapEtablissementBOToEntity(etablissement);
        etablissementEntity = em.merge(etablissementEntity);
        etablissement = EtablissementBO.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
    }

    @Override
    public EtablissementBO deleteEtablissement(Integer idEtablissement) {
        EtablissementBO etablissement = findOne(idEtablissement);
        etablissement.setId(idEtablissement);
        etablissement.setArchive(true);
        EtablissementEntity etablissementEntity = EtablissementBO.mapEtablissementBOToEntity(etablissement);
        em.merge(etablissementEntity);
        //em.remove(etablissementEntity);
        return etablissement;
    }
}
