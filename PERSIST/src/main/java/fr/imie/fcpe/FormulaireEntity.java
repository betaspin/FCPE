package fr.imie.fcpe;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formulaire database table.
 * 
 */
@Entity
@NamedQuery(name="FormulaireEntity.findAll", query="SELECT f FROM FormulaireEntity f")
@Table(name = "formulaire")
public class FormulaireEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean archive;

	private Boolean etat;

	@Column(name="id_etablissement")
	private Integer idEtablissement;

	private String nom;

	private Boolean statut;

	private String tag;

	//bi-directional many-to-one association to Campagne
	@OneToMany(mappedBy="formulaire")
	private List<CampagneEntity> campagnes;

	//bi-directional many-to-one association to Administrateur
	@ManyToOne
	@JoinColumn(name="id_administrateur")
	private AdministrateurEntity administrateur;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="formulaire_question",
            joinColumns=@JoinColumn(name="id", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id_question", referencedColumnName="id"))
	private List<QuestionEntity> questions;

	public FormulaireEntity() {
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

	public List<CampagneEntity> getCampagnes() {
		return this.campagnes;
	}

	public void setCampagnes(List<CampagneEntity> campagnes) {
		this.campagnes = campagnes;
	}

	public CampagneEntity addCampagne(CampagneEntity campagne) {
		getCampagnes().add(campagne);
		campagne.setFormulaire(this);

		return campagne;
	}

	public CampagneEntity removeCampagne(CampagneEntity campagne) {
		getCampagnes().remove(campagne);
		campagne.setFormulaire(null);

		return campagne;
	}

	public AdministrateurEntity getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(AdministrateurEntity administrateur) {
		this.administrateur = administrateur;
	}

	public List<QuestionEntity> getQuestions() {
		return this.questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		this.questions = questions;
	}

	public QuestionEntity addQuestion(QuestionEntity question) {
		getQuestions().add(question);
		question.addFormulaire(this);

		return question;
	}

	public QuestionEntity removeQuestion(QuestionEntity question) {
		getQuestions().remove(question);
		question.removeFormulaire(this);

		return question;
	}

}