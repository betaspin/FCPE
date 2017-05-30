package fr.imie.fcpe.model;

import java.util.List;

public class AdministrateurBO {

	private Integer id;
	private Boolean archive;
	private String email;
	private Boolean etat;
	private String identifiant;
	private String motdepasse;
	private String nom;
	private String prenom;
	private Boolean statut;
	private List<Integer> etablissements;
	private List<String> roles;
	private List<Integer> formulaires;
	private List<Integer> questions;

	public AdministrateurBO() {
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEtat() {
		return this.etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public String getIdentifiant() {
		return this.identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotdepasse() {
		return this.motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Boolean getStatut() {
		return this.statut;
	}

	public void setStatut(Boolean statut) {
		this.statut = statut;
	}

	public List<Integer> getEtablissements() {
		return this.etablissements;
	}

	public void setEtablissements(List<Integer> etablissements) {
		this.etablissements = etablissements;
	}

	public Integer addEtablissement(Integer etablissement) {
		getEtablissements().add(etablissement);
		return etablissement;
	}

	public Integer removeAdministrateurEtablissement(Integer etablissement) {
		getEtablissements().remove(etablissement);

		return etablissement;
	}

	public List<String> getRoles() {
		return this.roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
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