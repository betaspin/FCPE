package fr.imie.fcpe.service;

import fr.imie.fcpe.model.TypeEtablissementBO;

public class TypeEtablissementMap {

    public static TypeEtablissementWO mapTypeEtablissementBOToTypeEtablissementWO(TypeEtablissementBO typeEtablissementBO){
        TypeEtablissementWO typeEtablissementWO = new TypeEtablissementWO();
        typeEtablissementWO.setId(typeEtablissementBO.getId());
        typeEtablissementWO.setLabel(typeEtablissementBO.getLabel());
        return typeEtablissementWO;
    }

    public static TypeEtablissementBO mapTypeEtablissementWOToTypeEtablissementBO(TypeEtablissementWO typeEtablissementWO){
        TypeEtablissementBO typeEtablissementBO = new TypeEtablissementBO();
        typeEtablissementBO.setId(typeEtablissementWO.getId());
        typeEtablissementBO.setLabel(typeEtablissementWO.getLabel());
        return typeEtablissementBO;
    }
}
