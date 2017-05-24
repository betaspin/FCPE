package fr.imie.fcpe.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.fcpe.AdministrateurEntity;
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
    	//TODO
    	TypeQuestionEntity typeQuestionEntity = null;
//    	TypeQuestionEntity typeQuestionEntity = em.find(TypeQuestionEntity.class, question.getTypeQuestion());
    	AdministrateurEntity administrateurEntity = em.find(AdministrateurEntity.class, question.getAdministrateur());
    	// TODO
    	List<ReponseProposeeEntity> reponsesProposeesEntity = null;
        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, reponsesProposeesEntity);
        // TODO Test version - no persistence at this time
        //        em.persist(questionEntity);
        return question;
    }

    public QuestionBO update(QuestionBO question) {
    	// TODO
    	TypeQuestionEntity typeQuestionEntity = null;
    	// TODO
    	AdministrateurEntity administrateurEntity = null;
    	// TODO
    	List<ReponseProposeeEntity> reponsesProposeesEntity = null;
        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, reponsesProposeesEntity);
        questionEntity = em.merge(questionEntity);
        question = QuestionMapping.mapQuestionEntityToBO(questionEntity);
        return question;
    }

    public QuestionBO delete(Integer idQuestion) {
        QuestionBO question = findOne(idQuestion);
        question.setId(idQuestion);
        question.setArchive(true);
        
        // TODO
    	TypeQuestionEntity typeQuestionEntity = null;
    	// TODO
    	AdministrateurEntity administrateurEntity = null;
    	// TODO
    	List<ReponseProposeeEntity> reponsesProposeesEntity = null;
        QuestionEntity questionEntity = QuestionMapping.mapQuestionBOToEntity(question, typeQuestionEntity, administrateurEntity, reponsesProposeesEntity);
        em.merge(questionEntity);
        return question;
    } 
}
