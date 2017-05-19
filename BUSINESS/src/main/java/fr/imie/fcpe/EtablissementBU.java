package fr.imie.fcpe;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class EtablissementBU implements ICRUD<EtablissementBO> {

    @PersistenceContext
    EntityManager em;

    public EtablissementBU() {
    }

    @Override
    public EtablissementBO findOne(Integer idEtablissement) {
        EtablissementEntity etablissementEntity = em.find(EtablissementEntity.class, idEtablissement);
        EtablissementBO etablissement = EtablissementMap.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
    }

    @Override
    public List<EtablissementBO> findAll() {
        @SuppressWarnings("unchecked")
        List<EtablissementEntity> data = em.createNamedQuery("EtablissementEntity.findAll").getResultList();

        List<EtablissementBO> etablissementsBO = new ArrayList<EtablissementBO>();

        for(EtablissementEntity etablissementEntity: data){
            etablissementsBO.add(EtablissementMap.mapEtablissementEntityToBO(etablissementEntity));
        }

        return etablissementsBO;
    }

    @Override
    public EtablissementBO create(EtablissementBO etablissement) {
        EtablissementEntity etablissementEntity = EtablissementMap.mapEtablissementBOToEntity(etablissement);
        em.persist(etablissementEntity);
        return etablissement;
    }

    @Override
    public EtablissementBO update(EtablissementBO etablissement) {
        EtablissementEntity etablissementEntity = EtablissementMap.mapEtablissementBOToEntity(etablissement);
        etablissementEntity = em.merge(etablissementEntity);
        etablissement = EtablissementMap.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
    }

    @Override
    public EtablissementBO delete(Integer idEtablissement) {
        EtablissementBO etablissement = findOne(idEtablissement);
        etablissement.setId(idEtablissement);
        etablissement.setArchive(true);
        EtablissementEntity etablissementEntity = EtablissementMap.mapEtablissementBOToEntity(etablissement);
        em.merge(etablissementEntity);
        //em.remove(etablissementEntity);
        return etablissement;
    }
}
