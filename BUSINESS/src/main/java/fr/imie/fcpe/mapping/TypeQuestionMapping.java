package fr.imie.fcpe.mapping;

import fr.imie.fcpe.TypeQuestionEntity;
import fr.imie.fcpe.model.TypeQuestionBO;

public class TypeQuestionMapping {

    public static TypeQuestionBO mapTypeQuestionEntityToBO(TypeQuestionEntity typeQuestionEntity){
        TypeQuestionBO typeQuestionBO = new TypeQuestionBO();
        typeQuestionBO.setId(typeQuestionEntity.getId());
        typeQuestionBO.setLabel(typeQuestionEntity.getLabel());
        return typeQuestionBO;
    }

    public static TypeQuestionEntity mapTypeQuestionBOToEntity(TypeQuestionBO typeEtablissementBO){
        TypeQuestionEntity typeQuestionEntity = new TypeQuestionEntity();
        typeQuestionEntity.setId(typeEtablissementBO.getId());
        typeQuestionEntity.setLabel(typeEtablissementBO.getLabel());
        return typeQuestionEntity;
    }

}
