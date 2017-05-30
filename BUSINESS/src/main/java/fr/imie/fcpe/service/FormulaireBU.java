package fr.imie.fcpe.service;

import fr.imie.fcpe.AdministrateurEntity;
import fr.imie.fcpe.FormulaireEntity;
import fr.imie.fcpe.QuestionEntity;
import fr.imie.fcpe.TypeQuestionEntity;
import fr.imie.fcpe.mapping.FormulaireMapping;
import fr.imie.fcpe.mapping.QuestionMapping;
import fr.imie.fcpe.model.FormulaireBO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class FormulaireBU {
//    public class FormulaireBU implements ICRUD<FormulaireBO> {

    @PersistenceContext
    EntityManager em;

    public FormulaireBU() {
    }

    //    @Override
    public FormulaireBO findOne(Integer idFormulaire) {
        FormulaireEntity formulaireEntity = em.find(FormulaireEntity.class, idFormulaire);
        FormulaireBO formulaire = FormulaireMapping.mapFormulaireEntityToBO(formulaireEntity);
        return formulaire;
    }

    //    @Override
    public List<FormulaireBO> findAll() {
        @SuppressWarnings("unchecked")
        List<FormulaireEntity> data = em.createNamedQuery("FormulaireEntity.findAll").getResultList();

        List<FormulaireBO> formulairesBO = new ArrayList<FormulaireBO>();

        for (FormulaireEntity formulaireEntity : data) {
            formulairesBO.add(FormulaireMapping.mapFormulaireEntityToBO(formulaireEntity));
        }

        return formulairesBO;
    }

    //    @Override
    public FormulaireBO create(FormulaireBO formulaire) {
        FormulaireEntity formulaireEntity = FormulaireMapping.mapFormulaireBOToEntity(formulaire, AdministrateurEntity.administrateurBouchon(), getListQuestionEntity(formulaire));
        em.persist(formulaireEntity);
        return formulaire;
    }

    //    @Override
    public FormulaireBO update(FormulaireBO formulaire) {
        FormulaireEntity formulaireEntity = FormulaireMapping.mapFormulaireBOToEntity(formulaire, AdministrateurEntity.administrateurBouchon(), getListQuestionEntity(formulaire));
        formulaireEntity = em.merge(formulaireEntity);
        formulaire = FormulaireMapping.mapFormulaireEntityToBO(formulaireEntity);
        return formulaire;
    }

    //    @Override
    public FormulaireBO delete(Integer idFormulaire) {

        FormulaireBO formulaire = findOne(idFormulaire);
        formulaire.setId(idFormulaire);
        formulaire.setArchive(true);

        // A voir
        //   Integer idAdmin = formulaire.getAdministrateur();
        //     AdministrateurEntity administrateurEntity = (AdministrateurEntity)em.createNamedQuery("AdministrateurEntity.findOne").setParameter("id", idAdmin).getSingleResult();

        FormulaireEntity formulaireEntity = FormulaireMapping.mapFormulaireBOToEntity(formulaire, AdministrateurEntity.administrateurBouchon(), getListQuestionEntity(formulaire));
        em.merge(formulaireEntity);
        //em.remove(formulaireEntity);
        return formulaire;
    }


    private List<QuestionEntity> getListQuestionEntity(FormulaireBO formulaire){

        List<Integer> listIdQuestion = formulaire.getQuestions();
        List<QuestionEntity> listQuestions = new ArrayList();
        QuestionEntity questionEntity;

        for (Integer id : listIdQuestion) {
            questionEntity = (QuestionEntity) em.createNamedQuery("QuestionEntity.findOne").setParameter("id", id).getSingleResult();

            listQuestions.add(questionEntity);
        }
        return listQuestions;
    }

}
