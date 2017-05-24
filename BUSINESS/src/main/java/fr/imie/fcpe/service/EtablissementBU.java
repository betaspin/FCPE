package fr.imie.fcpe.service;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import fr.imie.fcpe.EtablissementEntity;
import fr.imie.fcpe.mapping.EtablissementMapping;
import fr.imie.fcpe.model.EtablissementBO;

@Stateless
public class EtablissementBU {
//    public class EtablissementBU implements ICRUD<EtablissementBO> {

    @PersistenceContext
    EntityManager em;

    public EtablissementBU() {
    }

//    @Override
    public EtablissementBO findOne(Integer idEtablissement) {
        EtablissementEntity etablissementEntity = em.find(EtablissementEntity.class, idEtablissement);
        EtablissementBO etablissement = EtablissementMapping.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
    }

//    @Override
    public List<EtablissementBO> findAll() {
        @SuppressWarnings("unchecked")
        List<EtablissementEntity> data = em.createNamedQuery("EtablissementEntity.findAll").getResultList();

        List<EtablissementBO> etablissementsBO = new ArrayList<EtablissementBO>();

        for(EtablissementEntity etablissementEntity: data){
            etablissementsBO.add(EtablissementMapping.mapEtablissementEntityToBO(etablissementEntity));
        }

        return etablissementsBO;
    }

//    @Override
    public EtablissementBO create(EtablissementBO etablissement) {
        EtablissementEntity etablissementEntity = EtablissementMapping.mapEtablissementBOToEntity(etablissement);
        em.persist(etablissementEntity);
        return etablissement;
    }

//    @Override
    public EtablissementBO update(EtablissementBO etablissement) {
        EtablissementEntity etablissementEntity = EtablissementMapping.mapEtablissementBOToEntity(etablissement);
        etablissementEntity = em.merge(etablissementEntity);
        etablissement = EtablissementMapping.mapEtablissementEntityToBO(etablissementEntity);
        return etablissement;
    }

//    @Override
    public EtablissementBO delete(Integer idEtablissement) {
        EtablissementBO etablissement = findOne(idEtablissement);
        etablissement.setId(idEtablissement);
        etablissement.setArchive(true);
        EtablissementEntity etablissementEntity = EtablissementMapping.mapEtablissementBOToEntity(etablissement);
        em.merge(etablissementEntity);
        //em.remove(etablissementEntity);
        return etablissement;
    }
}
