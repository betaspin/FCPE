package fr.imie.fcpe.service;

import fr.imie.fcpe.model.EtablissementBO;
import fr.imie.fcpe.model.TypeEtablissementBO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betaspin on 24/05/17.
 */
public class EtablissementMap {
    public static EtablissementWO mapEtablissementBOToEtablissementWO(EtablissementBO etablissementBO){

        EtablissementWO etablissementWO = new EtablissementWO();
        etablissementWO.setId(etablissementBO.getId());
        etablissementWO.setNom(etablissementBO.getNom());
        etablissementWO.setVille(etablissementBO.getVille());

        // TypeEtablissement mapping
        List<TypeEtablissementWO> typesWO = new ArrayList<>();
        List<TypeEtablissementBO> typesBO = etablissementBO.getTypes();
        for(TypeEtablissementBO typeBO : typesBO){
            typesWO.add(TypeEtablissementMap.mapTypeEtablissementBOToTypeEtablissementWO(typeBO));
        }
        etablissementWO.setTypes(typesWO);

        return etablissementWO;
    }

    public static EtablissementBO mapEtablissementWOToEtablissementBO(EtablissementWO etablissementWO){

        EtablissementBO etablissementBO = new EtablissementBO();
        etablissementBO.setId(etablissementWO.getId());
        etablissementBO.setNom(etablissementWO.getNom());
        etablissementBO.setVille(etablissementWO.getVille());

        // TypeEtablissement mapping
        List<TypeEtablissementBO> typesBO = new ArrayList<>();
        List<TypeEtablissementWO> typesWO = etablissementWO.getTypes();
        for(TypeEtablissementWO typeWO : typesWO){
            typesBO.add(TypeEtablissementMap.mapTypeEtablissementWOToTypeEtablissementBO(typeWO));
        }
        etablissementBO.setTypes(typesBO);

        return etablissementBO;
    }
}
