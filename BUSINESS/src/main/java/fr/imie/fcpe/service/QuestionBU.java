package fr.imie.fcpe.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.fcpe.AdministrateurEntity;
import fr.imie.fcpe.FormulaireEntity;
import fr.imie.fcpe.QuestionEntity;
import fr.imie.fcpe.ReponseProposeeEntity;
import fr.imie.fcpe.TypeQuestionEntity;
import fr.imie.fcpe.mapping.QuestionMapping;
import fr.imie.fcpe.model.QuestionBO;

@Stateless
public class QuestionBU {
	
    @PersistenceContext
    EntityManager em;

    public QuestionBO findOne(Integer idQuestion) {
        QuestionEntity questionEntity = em.find(QuestionEntity.class, idQuestion);
        QuestionBO question = QuestionMapping.mapQuestionEntityToBO(questionEntity);
        return question;
    }

    public List<QuestionBO> findAll() {
        @SuppressWarnings("unchecked")
        List<QuestionEntity> data = em.createNamedQuery("QuestionEntity.findAll").getResultList();
        
        // All the questions will be sort by the field Intitule
//        Collections.sort(data, new Comparator<QuestionEntity>() {
//        	@Override
//        	public int compare(QuestionEntity qe2, QuestionEntity qe1) {
//        		return  qe2.getIntitule().compareTo(qe1.getIntitule());
//        	}
//        });

        List<QuestionBO> questionsBO = new ArrayList<QuestionBO>();

        for(QuestionEntity questionEntity: data){
            questionsBO.add(QuestionMapping.mapQuestionEntityToBO(questionEntity));
        }

        return questionsBO;
    }

    public QuestionBO create(QuestionBO question) {
    	String labelTypeQuestion = QuestionMapping.typeQuestionFrontEndToBackEnd.get(question.getTypeQuestion());
    	TypeQuestionEntity typeQuestionEntity = (TypeQuestionEntity)em.createNamedQuery("TypeQuestionEntity.findOneByLabel").setParameter("label", labelTypeQuestion).getSingleResult();
    	
    	AdministrateurEntity administrateurEntity = em.find(AdministrateurEntity.class, question.getAdministrateur());

    	List<FormulaireEntity> formulairesEntity = new ArrayList<>();
    	for (Integer idForm : question.getFormulaires()) {
    		FormulaireEntity formulaireEntity = em.find(FormulaireEntity.class, idForm);
    		formulairesEntity.add(formulaireEntity);
    	}
    	
    	QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, null, formulairesEntity);
    	em.persist(questionEntity);

    	List<ReponseProposeeEntity> reponsesProposeesEntity = new ArrayList<>();
    	for (String labelReponseProposee : question.getReponsesProposees()) {
    		ReponseProposeeEntity reponseProposeeEntity = new ReponseProposeeEntity();
    		reponseProposeeEntity.setLabel(labelReponseProposee);
    		reponseProposeeEntity.setQuestion(questionEntity);
    		em.persist(reponseProposeeEntity);
    		reponsesProposeesEntity.add(reponseProposeeEntity);
		}
    	
    	// Persist the question with the link to ReponsesProposees
    	questionEntity.setReponseproposees(reponsesProposeesEntity);
    	em.merge(questionEntity);
    	
    	return question;
    }

    public QuestionBO update(QuestionBO question) {
    	String labelTypeQuestion = QuestionMapping.typeQuestionFrontEndToBackEnd.get(question.getTypeQuestion());
    	TypeQuestionEntity typeQuestionEntity = (TypeQuestionEntity)em.createNamedQuery("TypeQuestionEntity.findOneByLabel").setParameter("label", labelTypeQuestion).getSingleResult();
    	
    	AdministrateurEntity administrateurEntity = em.find(AdministrateurEntity.class, question.getAdministrateur());
    	
    	List<FormulaireEntity> formulairesEntity = new ArrayList<>();
    	for (Integer idForm : question.getFormulaires()) {
    		FormulaireEntity formulaireEntity = em.find(FormulaireEntity.class, idForm);
    		formulairesEntity.add(formulaireEntity);
    	}

    	@SuppressWarnings("unchecked")
		List<ReponseProposeeEntity> reponsesProposeesEntity = em.createNamedQuery("ReponseProposeeEntity.findAllWithQuestionId").setParameter("id", question.getId()).getResultList();
    	Map<ReponseProposeeEntity, Boolean> reponsesProposeesValidees = new HashMap<>();
    	
    	reponsesProposeesEntity.forEach((item) -> reponsesProposeesValidees.put(item, false));

    	QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, reponsesProposeesEntity, formulairesEntity);
    	questionEntity = em.merge(questionEntity);

    	for (String labelReponseProposee : question.getReponsesProposees()) {
    		ReponseProposeeEntity reponseProposeeEntityToUpdate = isReponseProposeeToUpdate(labelReponseProposee, reponsesProposeesEntity);
    		if (reponseProposeeEntityToUpdate != null) {
    			em.merge(reponseProposeeEntityToUpdate);
        		reponsesProposeesValidees.put(reponseProposeeEntityToUpdate, true);
    		}
    		else {
        		ReponseProposeeEntity reponseProposeeEntity = new ReponseProposeeEntity();
        		reponseProposeeEntity.setLabel(labelReponseProposee);
        		reponseProposeeEntity.setQuestion(questionEntity);
        		em.persist(reponseProposeeEntity);
        		reponsesProposeesEntity.add(reponseProposeeEntity);

    		}
		}
		
    	reponsesProposeesValidees.forEach((item, bool) -> {
    		if (bool == false) {
    			em.remove(item);
    			reponsesProposeesEntity.remove(item);
    		}
    	});
    	
    	// Persist the question with the link to ReponsesProposees
    	questionEntity.setReponseproposees(reponsesProposeesEntity);
    	em.merge(questionEntity);
    	
    	question = QuestionMapping.mapQuestionEntityToBO(questionEntity);
    	return question;
    }
    
    /**
     * 
     * @param reponseProposee
     * @param reponsesProposeesEntity
     */
    private ReponseProposeeEntity isReponseProposeeToUpdate(String reponseProposee, List<ReponseProposeeEntity> reponsesProposeesEntity)  {
    	for (ReponseProposeeEntity reponseProposeeEntity : reponsesProposeesEntity) {
			if (reponseProposee.equals(reponseProposeeEntity.getLabel())) {
				return reponseProposeeEntity;
			}
		}
    	return null;
    }
    
    public QuestionBO delete(Integer idQuestion) {
        QuestionBO question = findOne(idQuestion);
        question.setId(idQuestion);
        question.setArchive(true);
        
    	String labelTypeQuestion = QuestionMapping.typeQuestionFrontEndToBackEnd.get(question.getTypeQuestion());
    	TypeQuestionEntity typeQuestionEntity = (TypeQuestionEntity)em.createNamedQuery("TypeQuestionEntity.findOneByLabel").setParameter("label", labelTypeQuestion).getSingleResult();

    	AdministrateurEntity administrateurEntity = em.find(AdministrateurEntity.class, question.getAdministrateur());

    	List<FormulaireEntity> formulairesEntity = new ArrayList<>();
    	for (Integer idForm : question.getFormulaires()) {
    		FormulaireEntity formulaireEntity = em.find(FormulaireEntity.class, idForm);
    		formulairesEntity.add(formulaireEntity);
    	}
    	
        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, null, formulairesEntity);
        em.merge(questionEntity);
        return question;
    } 
}
