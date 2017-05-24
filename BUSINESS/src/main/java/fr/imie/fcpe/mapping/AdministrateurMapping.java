package fr.imie.fcpe.mapping;

import java.util.ArrayList;
import java.util.List;

import fr.imie.fcpe.AdministrateurEntity;
import fr.imie.fcpe.EtablissementEntity;
import fr.imie.fcpe.FormulaireEntity;
import fr.imie.fcpe.QuestionEntity;
import fr.imie.fcpe.RoleEntity;
import fr.imie.fcpe.model.AdministrateurBO;

public class AdministrateurMapping {

    public static AdministrateurBO mapAdministrateurEntityToBO(AdministrateurEntity administrateurEntity){
        AdministrateurBO administrateurBO = new AdministrateurBO();
        
        administrateurBO.setArchive(administrateurEntity.getArchive());
        administrateurBO.setEmail(administrateurEntity.getEmail());
        administrateurBO.setEtat(administrateurEntity.getEtat());
        administrateurBO.setIdentifiant(administrateurEntity.getIdentifiant());
        administrateurBO.setMotdepasse(administrateurEntity.getMotdepasse());
        administrateurBO.setNom(administrateurEntity.getNom());
        administrateurBO.setPrenom(administrateurEntity.getPrenom());
        administrateurBO.setStatut(administrateurEntity.getStatut());
        
        List<Integer> etablissementsBO = new ArrayList<>();
        for (EtablissementEntity etablissement : administrateurEntity.getEtablissements()) {
        	etablissementsBO.add(etablissement.getId());
		}
        administrateurBO.setEtablissements(etablissementsBO);
        
        List<String> rolesBO = new ArrayList<>();
        for (RoleEntity role : administrateurEntity.getRoles()) {
        	rolesBO.add(role.getLabel());
		}
        administrateurBO.setRoles(rolesBO);
        
        List<Integer> formulairesBO = new ArrayList<>();
        for (FormulaireEntity form : administrateurEntity.getFormulaires()) {
        	formulairesBO.add(form.getId());
		}
        administrateurBO.setFormulaires(formulairesBO);
        
        List<Integer> questionsBO = new ArrayList<>();
        for (QuestionEntity question : administrateurEntity.getQuestions()) {
        	questionsBO.add(question.getId());
		}
        administrateurBO.setQuestions(questionsBO);
        return administrateurBO;
    }

    public static AdministrateurEntity mapAdministrateurBOToEntity(AdministrateurBO administrateurBO, List<EtablissementEntity> etablissementsEntity, List<RoleEntity> rolesEntity, List<FormulaireEntity> formulairesEntity, List<QuestionEntity> questionsEntity) {
        AdministrateurEntity administrateurEntity = new AdministrateurEntity();
        
        administrateurEntity.setArchive(administrateurEntity.getArchive());
        administrateurEntity.setEmail(administrateurEntity.getEmail());
        administrateurEntity.setEtat(administrateurEntity.getEtat());
        administrateurEntity.setIdentifiant(administrateurEntity.getIdentifiant());
        administrateurEntity.setMotdepasse(administrateurEntity.getMotdepasse());
        administrateurEntity.setNom(administrateurEntity.getNom());
        administrateurEntity.setPrenom(administrateurEntity.getPrenom());
        administrateurEntity.setStatut(administrateurEntity.getStatut());
        administrateurEntity.setEtablissements(etablissementsEntity);
        administrateurEntity.setRoles(rolesEntity);
        administrateurEntity.setFormulaires(formulairesEntity);
        administrateurEntity.setQuestions(questionsEntity);
        
        return administrateurEntity;
    }

}
