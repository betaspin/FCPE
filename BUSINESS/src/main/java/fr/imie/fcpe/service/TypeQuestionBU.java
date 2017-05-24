package fr.imie.fcpe.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.imie.fcpe.TypeQuestionEntity;
import fr.imie.fcpe.mapping.TypeQuestionMapping;
import fr.imie.fcpe.model.TypeQuestionBO;

@Stateless
public class TypeQuestionBU {

    @PersistenceContext
    EntityManager em;
	
	public TypeQuestionBO findOne(Integer id) {
		TypeQuestionEntity typeQuestionEntity = em.find(TypeQuestionEntity.class, id);
        TypeQuestionBO question = TypeQuestionMapping.mapTypeQuestionEntityToBO(typeQuestionEntity);
        return question;
	}

	public List<TypeQuestionBO> findAll() {
        @SuppressWarnings("unchecked")
        List<TypeQuestionEntity> data = em.createNamedQuery("TypeQuestionEntity.findAll").getResultList();

        List<TypeQuestionBO> typeQuestionsBO = new ArrayList<TypeQuestionBO>();

        for(TypeQuestionEntity typeQuestionEntity: data){
            typeQuestionsBO.add(TypeQuestionMapping.mapTypeQuestionEntityToBO(typeQuestionEntity));
        }

        return typeQuestionsBO;
	}

}
