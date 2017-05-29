package fr.imie.fcpe.mapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.imie.fcpe.AdministrateurEntity;
import fr.imie.fcpe.FormulaireEntity;
import fr.imie.fcpe.QuestionEntity;
import fr.imie.fcpe.ReponseProposeeEntity;
import fr.imie.fcpe.TypeQuestionEntity;
import fr.imie.fcpe.model.QuestionBO;

/**
 * Utility class to transform QuestionEntity object to QuestionBO object and vice versa
 */
public class QuestionMapping {
	
	/**
	 * Transform a QuestionEntity object to a QuestionBO object
	 * @param questionEntity QuestionEntity to transform
	 * @return the corresponding QuestionBO object
	 */
	public static QuestionBO mapQuestionEntityToBO(final QuestionEntity questionEntity) {
		QuestionBO questionBO = new QuestionBO();
		questionBO.setId(questionEntity.getId());
		questionBO.setIntitule(questionEntity.getIntitule());
		questionBO.setObligatoire(questionEntity.getObligatoire());
		questionBO.setAideContextuelle(questionEntity.getAideContextuelle());
		questionBO.setStatut(questionEntity.getStatut());
		questionBO.setEtat(questionEntity.getEtat());
		questionBO.setTag(questionEntity.getTag());
		questionBO.setArchive(questionEntity.getArchive());
		questionBO.setTypeQuestion(QuestionMapping.typeQuestionBackEndToFrontEnd.get(questionEntity.getTypequestion().getLabel()));
		questionBO.setAdministrateur(questionEntity.getAdministrateur().getId());
		
		List<String> rpBO = new ArrayList<>();
        for (ReponseProposeeEntity reponse : questionEntity.getReponsesProposees()) {
        	rpBO.add(reponse.getLabel());
		}
		questionBO.setReponsesProposees(rpBO);
		
		List<Integer> formBO = new ArrayList<>();
		for (FormulaireEntity form : questionEntity.getFormulaires()) {
			formBO.add(form.getId());
		}
		questionBO.setFormulaires(formBO);
		
		return questionBO;
	}

	/**
	 * Transform a QuestionBO object to a QuestionEntity object
	 * @param questionBO QuestionBO to transform
	 * @param typeQuestionEntity
	 * @param administrateurEntity
	 * @param reponsesProposeesEntity
	 * @return the corresponding QuestionEntity object
	 */
	public static QuestionEntity mapQuestionBOToEntity(final QuestionBO questionBO, final TypeQuestionEntity typeQuestionEntity, final AdministrateurEntity administrateurEntity, final List<ReponseProposeeEntity> reponsesProposeesEntity, final List<FormulaireEntity> formulairesEntity) {
		QuestionEntity questionEntity = new QuestionEntity();
		questionEntity.setId(questionBO.getId());
		questionEntity.setIntitule(questionBO.getIntitule());
		questionEntity.setObligatoire(questionBO.getObligatoire());
		questionEntity.setAideContextuelle(questionBO.getAideContextuelle());
		questionEntity.setStatut(questionBO.getStatut());
		questionEntity.setEtat(questionBO.getEtat());
		questionEntity.setTag(questionBO.getTag());
		questionEntity.setArchive(questionBO.getArchive());
		questionEntity.setTypeQuestion(typeQuestionEntity);
		questionEntity.setAdministrateur(administrateurEntity);
		questionEntity.setReponseproposees(reponsesProposeesEntity);
		questionEntity.setFormulaires(formulairesEntity);
		return questionEntity;
	}
	
	/**
	 * Map to switch from the FrontEnd label value to the BackEnd label value
	 */
	public static final Map<String, String> typeQuestionFrontEndToBackEnd = createMapTypeQuestionFrontEndToBackEnd();
    private static Map<String, String> createMapTypeQuestionFrontEndToBackEnd() {
        Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("radio", "Bouton radio");
        myMap.put("checkbox", "Case à cocher");
        myMap.put("text", "Texte Libre");
        myMap.put("date", "Date");
        myMap.put("number", "Nombre");
        return myMap;
    }
	
	/**
	 * Map to switch from the BackEnd label value to the FrontEnd label value
	 */
	public static final Map<String, String> typeQuestionBackEndToFrontEnd = createMapTypeQuestionBackEndToFrontEnd();
    private static Map<String, String> createMapTypeQuestionBackEndToFrontEnd() {
        Map<String,String> myMap = new HashMap<String,String>();
        myMap.put("Bouton radio", "radio");
        myMap.put("Case à cocher", "checkbox");
        myMap.put("Texte Libre", "text");
        myMap.put("Date", "date");
        myMap.put("Nombre", "number");
        myMap.put("Liste déroulante", "checkbox");
        return myMap;
    }

}
