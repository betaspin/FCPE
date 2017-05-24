package fr.imie.fcpe.mapping;

import fr.imie.fcpe.QuestionEntity;
import fr.imie.fcpe.ReponseProposeeEntity;
import fr.imie.fcpe.model.QuestionBO;
import fr.imie.fcpe.model.ReponseProposeeBO;

public class ReponseProposeeMapping {

    public static ReponseProposeeBO mapReponseProposeeEntityToBO(ReponseProposeeEntity reponseProposeeEntity, QuestionBO questionBO){
    	ReponseProposeeBO reponseProposeeBO = new ReponseProposeeBO();
        reponseProposeeBO.setId(reponseProposeeEntity.getId());
        reponseProposeeBO.setLabel(reponseProposeeEntity.getLabel());
        reponseProposeeBO.setQuestion(questionBO.getId());
        return reponseProposeeBO;
    }

    public static ReponseProposeeEntity mapReponseProposeeBOToEntity(ReponseProposeeBO reponseProposeeBO, QuestionEntity questionEntity){
    	ReponseProposeeEntity reponseProposeeEntity = new ReponseProposeeEntity();
        reponseProposeeEntity.setId(reponseProposeeBO.getId());
        reponseProposeeEntity.setLabel(reponseProposeeBO.getLabel());
        reponseProposeeEntity.setQuestion(questionEntity);
        return reponseProposeeEntity;
    }

}
