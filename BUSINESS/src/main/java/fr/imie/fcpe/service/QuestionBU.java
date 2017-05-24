package fr.imie.fcpe.service;

import java.util.ArrayList;
import java.util.List;

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

    	// TODO
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
//    	// TODO
//    	TypeQuestionEntity typeQuestionEntity = null;
//    	// TODO
//    	AdministrateurEntity administrateurEntity = null;
//    	// TODO
//    	List<ReponseProposeeEntity> reponsesProposeesEntity = null;
//        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, reponsesProposeesEntity);
//        questionEntity = em.merge(questionEntity);
//        question = QuestionMapping.mapQuestionEntityToBO(questionEntity);
//        return question;
    	return null;
    }

    public QuestionBO delete(Integer idQuestion) {
//        QuestionBO question = findOne(idQuestion);
//        question.setId(idQuestion);
//        question.setArchive(true);
//        
//        // TODO
//    	TypeQuestionEntity typeQuestionEntity = null;
//    	// TODO
//    	AdministrateurEntity administrateurEntity = null;
//    	// TODO
//    	List<ReponseProposeeEntity> reponsesProposeesEntity = null;
//        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, reponsesProposeesEntity);
//        em.merge(questionEntity);
//        return question;
    	return null;
    } 
}
