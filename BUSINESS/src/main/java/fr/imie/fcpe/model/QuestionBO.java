package fr.imie.fcpe.model;

import java.util.List;

public class QuestionBO {

	private Integer id;
	private String intitule;
	private Boolean obligatoire;
	private String aideContextuelle;
	private Boolean statut;
	private Boolean etat;
	private String tag;
	private Boolean archive;
	private List<Integer> formulaires;
	private String typeQuestion;
	private Integer etablissement;
	private Integer administrateur;
	private List<String> reponsesProposees;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Boolean getObligatoire() {
		return obligatoire;
	}

	public void setObligatoire(Boolean obligatoire) {
		this.obligatoire = obligatoire;
	}

	public String getAideContextuelle() {
		return aideContextuelle;
	}

	public void setAideContextuelle(String aideContextuelle) {
		this.aideContextuelle = aideContextuelle;
	}

	public Boolean getStatut() {
		return statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Boolean getArchive() {
		return archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}
	
	public List<Integer> getFormulaires() {
		return this.formulaires;
	}

	public void setFormulaires(List<Integer> formulaires) {
		this.formulaires = formulaires;
	}

	public Integer addFormulaire(Integer formulaire) {
		getFormulaires().add(formulaire);

		return formulaire;
	}

	public Integer removeFormulaire(Integer formulaire) {
		getFormulaires().remove(formulaire);

		return formulaire;
	}
	
	public String getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	public Integer getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(Integer etablissement) {
		this.etablissement = etablissement;
	}

	public Integer getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Integer administrateur) {
		this.administrateur = administrateur;
	}

	public List<String> getReponsesProposees() {
		return reponsesProposees;
	}

	public void setReponsesProposees(List<String> reponsesProposees) {
		this.reponsesProposees = reponsesProposees;
	}

	public String addReponseProposee(String reponse) {
		getReponsesProposees().add(reponse);

		return reponse;
	}

	public String removeReponseProposee(String reponse) {
		getReponsesProposees().remove(reponse);

		return reponse;
	}

}
