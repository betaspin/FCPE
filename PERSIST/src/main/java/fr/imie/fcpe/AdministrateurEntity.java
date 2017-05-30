package fr.imie.fcpe;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the administrateur database table.
 * 
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "AdministrateurEntity.findAll", query = "SELECT a FROM AdministrateurEntity a"),
        @NamedQuery(name = "AdministrateurEntity.findOneByAuth", query = "SELECT a FROM AdministrateurEntity a WHERE a.identifiant = :identifiant and a.motdepasse = :motdepasse")
})
@Table(name = "administrateur")
public class AdministrateurEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean archive;

	private String email;

	private Boolean etat;

	private String identifiant;

	private String motdepasse;

	private String nom;

	private String prenom;

	private Boolean statut;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="administrateur_etablissement",
            joinColumns=@JoinColumn(name="id_administrateur", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id", referencedColumnName="id"))
	private List<EtablissementEntity> etablissements;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="administrateur_role"
		, joinColumns={
			@JoinColumn(name="id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_role")
			}
		)
	private List<RoleEntity> roles;

	//bi-directional many-to-one association to Campagne
	@OneToMany(mappedBy="administrateur")
	private List<CampagneEntity> campagnes;

	//bi-directional many-to-one association to Formulaire
	@OneToMany(mappedBy="administrateur")
	private List<FormulaireEntity> formulaires;

	//bi-directional many-to-one association to Question
	@OneToMany(mappedBy="administrateur")
	private List<QuestionEntity> questions;

	public AdministrateurEntity() {
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

	public List<EtablissementEntity> getEtablissements() {
		return this.etablissements;
	}

	public void setEtablissements(List<EtablissementEntity> etablissements) {
		this.etablissements = etablissements;
	}

	public EtablissementEntity addEtablissement(EtablissementEntity etablissement) {
		getEtablissements().add(etablissement);
		return etablissement;
	}

	public EtablissementEntity removeAdministrateurEtablissement(EtablissementEntity etablissement) {
		getEtablissements().remove(etablissement);

		return etablissement;
	}

	public List<RoleEntity> getRoles() {
		return this.roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public List<CampagneEntity> getCampagnes() {
		return this.campagnes;
	}

	public void setCampagnes(List<CampagneEntity> campagnes) {
		this.campagnes = campagnes;
	}

	public CampagneEntity addCampagne(CampagneEntity campagne) {
		getCampagnes().add(campagne);
		campagne.setAdministrateur(this);

		return campagne;
	}

	public CampagneEntity removeCampagne(CampagneEntity campagne) {
		getCampagnes().remove(campagne);
		campagne.setAdministrateur(null);

		return campagne;
	}

	public List<FormulaireEntity> getFormulaires() {
		return this.formulaires;
	}

	public void setFormulaires(List<FormulaireEntity> formulaires) {
		this.formulaires = formulaires;
	}

	public FormulaireEntity addFormulaire(FormulaireEntity formulaire) {
		getFormulaires().add(formulaire);
		formulaire.setAdministrateur(this);

		return formulaire;
	}

	public FormulaireEntity removeFormulaire(FormulaireEntity formulaire) {
		getFormulaires().remove(formulaire);
		formulaire.setAdministrateur(null);

		return formulaire;
	}

	public List<QuestionEntity> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}

	public QuestionEntity addQuestion(QuestionEntity question) {
		getQuestions().add(question);
		question.setAdministrateur(this);

		return question;
	}

	public QuestionEntity removeQuestion(QuestionEntity question) {
		getQuestions().remove(question);
		question.setAdministrateur(null);

		return question;
	}




	public static AdministrateurEntity administrateurBouchon(){

		AdministrateurEntity admin = new AdministrateurEntity();



		admin.setId(22);
		admin.setArchive(false);
		admin.setEmail("admin22@boss.com");
		admin.setEtat(true);
		admin.setIdentifiant("admin");
		admin.setMotdepasse("pwd");
		admin.setNom("Name");
		admin.setPrenom("FirstName");
		admin.setStatut(true);
		//	admin.setEtablissements();
		//	admin.setRoles;
		//	admin.setFormulaires;
		//	admin.setQuestions;



		return admin;
	}



}