package fr.imie.fcpe.mapping;

import fr.imie.fcpe.model.QuestionBO;
import fr.imie.fcpe.model.QuestionJson;

/**
 * Created by user on 30/05/2017.
 */
public class QuestionMap {

    public static QuestionBO mapQuestionJsonToBO(final QuestionJson questionJson){
        QuestionBO questionBO = new QuestionBO();
        questionBO.setId(questionJson.getId());
        questionBO.setIntitule(questionJson.getIntitule());
        questionBO.setObligatoire(questionJson.getObligatoire());
        questionBO.setAideContextuelle(questionJson.getAideContextuelle());
        questionBO.setStatut(questionJson.getStatut());
        questionBO.setEtat(questionJson.getEtat());
        questionBO.setTag(questionJson.getTag());
        questionBO.setArchive(questionJson.getArchive());
        questionBO.setFormulaires(questionJson.getFormulaires());
        questionBO.setTypeQuestion(questionJson.getTypeQuestion());
        questionBO.setEtablissement(questionJson.getEtablissement());
        questionBO.setAdministrateur(questionJson.getAdministrateur());
        questionBO.setReponsesProposees(questionJson.getReponsesProposees());
        return questionBO;
    }

    public static QuestionJson mapQuestionBOToJson(final QuestionBO questionBO){
        QuestionJson questionJson = new QuestionJson();
        questionJson.setId(questionBO.getId());
        questionJson.setIntitule(questionBO.getIntitule());
        questionJson.setObligatoire(questionBO.getObligatoire());
        questionJson.setAideContextuelle(questionBO.getAideContextuelle());
        questionJson.setStatut(questionBO.getStatut());
        questionJson.setEtat(questionBO.getEtat());
        questionJson.setTag(questionBO.getTag());
        questionJson.setArchive(questionBO.getArchive());
        questionJson.setFormulaires(questionBO.getFormulaires());
        questionJson.setTypeQuestion(questionBO.getTypeQuestion());
        questionJson.setEtablissement(questionBO.getEtablissement());
        questionJson.setAdministrateur(questionBO.getAdministrateur());
        questionJson.setReponsesProposees(questionBO.getReponsesProposees());
        return questionJson;
    }
}
