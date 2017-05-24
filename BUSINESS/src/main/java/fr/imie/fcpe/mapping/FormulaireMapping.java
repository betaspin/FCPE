package fr.imie.fcpe.mapping;

import java.util.ArrayList;
import java.util.List;

import fr.imie.fcpe.AdministrateurEntity;
import fr.imie.fcpe.FormulaireEntity;
import fr.imie.fcpe.QuestionEntity;
import fr.imie.fcpe.model.FormulaireBO;

/**
 * Created by user on 23/05/2017.
 */
public class FormulaireMapping {
	
	public static FormulaireBO mapFormulaireEntityToBO(FormulaireEntity formulaireEntity) {
		FormulaireBO formulaireBO = new FormulaireBO();
		formulaireBO.setId(formulaireEntity.getId());
		formulaireBO.setNom(formulaireEntity.getNom());
		formulaireBO.setStatut(formulaireEntity.getStatut());
		formulaireBO.setEtat(formulaireEntity.getEtat());
		formulaireBO.setTag(formulaireEntity.getTag());
		formulaireBO.setArchive(formulaireEntity.getArchive());
		
		formulaireBO.setIdEtablissement(formulaireEntity.getIdEtablissement());
		formulaireBO.setAdministrateur(formulaireEntity.getId());
		
		List<Integer> questionsBO = new ArrayList<>();
        for (QuestionEntity question : formulaireEntity.getQuestions()) {
        	questionsBO.add(question.getId());
		}
        formulaireBO.setQuestions(questionsBO);
		
		return formulaireBO;
	}

	public static FormulaireEntity mapFormulaireBOToEntity(FormulaireBO formulaireBO, AdministrateurEntity administrateurEntity, List<QuestionEntity> questionsEntity) {
		FormulaireEntity formulaireEntity = new FormulaireEntity();
		formulaireEntity.setId(formulaireBO.getId());
		formulaireEntity.setNom(formulaireBO.getNom());
		formulaireEntity.setStatut(formulaireEntity.getStatut());
		formulaireEntity.setEtat(formulaireEntity.getEtat());
		formulaireEntity.setTag(formulaireEntity.getTag());
		formulaireEntity.setArchive(formulaireBO.getArchive());
		
		formulaireEntity.setIdEtablissement(formulaireBO.getIdEtablissement());
		formulaireEntity.setAdministrateur(administrateurEntity);
        formulaireEntity.setQuestions(questionsEntity);
		
		return formulaireEntity;
	}

}
