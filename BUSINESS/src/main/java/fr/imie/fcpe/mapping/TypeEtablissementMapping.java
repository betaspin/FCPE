package fr.imie.fcpe.mapping;

import fr.imie.fcpe.TypeEtablissementEntity;
import fr.imie.fcpe.model.TypeEtablissementBO;

public class TypeEtablissementMapping {

    public static TypeEtablissementBO mapTypeEtablissementEntityToBO(TypeEtablissementEntity typeEtablissementEntity){
        TypeEtablissementBO typeEtablissementBO = new TypeEtablissementBO();
        typeEtablissementBO.setId(typeEtablissementEntity.getId());
        typeEtablissementBO.setLabel(typeEtablissementEntity.getLabel());
        return typeEtablissementBO;
    }

    public static TypeEtablissementEntity mapTypeEtablissementBOToEntity(TypeEtablissementBO typeEtablissementBO){
        TypeEtablissementEntity typeEtablissementEntity = new TypeEtablissementEntity();
        typeEtablissementEntity.setId(typeEtablissementBO.getId());
        typeEtablissementEntity.setLabel(typeEtablissementBO.getLabel());
        return typeEtablissementEntity;
    }

}
