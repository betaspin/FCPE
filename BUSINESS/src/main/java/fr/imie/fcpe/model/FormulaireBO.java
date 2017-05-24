package fr.imie.fcpe.model;

import java.util.List;

public class FormulaireBO {

	private Integer id;
	private Boolean archive;
	private Boolean etat;
	private Integer idEtablissement;
	private String nom;
	private Boolean statut;
	private String tag;

	private Integer administrateur;
	private List<Integer> questions;

	public FormulaireBO() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getArchive() {
		return this.archive;
	}

	public void setArchive(Boolean archive) {
		this.archive = archive;
	}

	public Boolean getEtat() {
		return this.etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public Integer getIdEtablissement() {
		return this.idEtablissement;
	}

	public void setIdEtablissement(Integer idEtablissement) {
		this.idEtablissement = idEtablissement;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Boolean getStatut() {
		return this.statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Integer getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Integer administrateur) {
		this.administrateur = administrateur;
	}

	public List<Integer> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<Integer> questions) {
		this.questions = questions;
	}

	public Integer addQuestion(Integer question) {
		getQuestions().add(question);

		return question;
	}

	public Integer removeQuestion(Integer question) {
		getQuestions().remove(question);

		return question;
	}

}