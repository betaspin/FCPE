package fr.imie.fcpe;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "QuestionEntity.findAll", query = "SELECT e FROM QuestionEntity e WHERE e.archive = false"),
    @NamedQuery(name = "QuestionEntity.findOne", query = ""
    		+ "SELECT DISTINCT q FROM QuestionEntity q, ReponseProposeeEntity rp JOIN rp.question rpquestion WHERE rpquestion.id = q.id AND q.id = :id")
})
@Table(name = "question")
public class QuestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String aideContextuelle;
	private Boolean archive;
	private Boolean etat;
	private String intitule;
	private Boolean obligatoire;
	private Boolean statut;
	private String tag;

	@Column(name="id_etablissement")
	private Integer idEtablissement;
	
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
            name="formulaire_question",
            joinColumns=@JoinColumn(name="id_question", referencedColumnName="id"),
            inverseJoinColumns=@JoinColumn(name="id", referencedColumnName="id"))
	private List<FormulaireEntity> formulaires;

	//bi-directional many-to-one association to Administrateur
	@ManyToOne
	@JoinColumn(name="id_administrateur")
	private AdministrateurEntity administrateur;

	//bi-directional many-to-one association to Typequestion
	@ManyToOne
	@JoinColumn(name="id_typequestion")
	private TypeQuestionEntity typequestion;

	//bi-directional many-to-one association to Reponseproposee
	@OneToMany(mappedBy="question", fetch=FetchType.EAGER)
	private List<ReponseProposeeEntity> reponsesProposees;

	public QuestionEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAideContextuelle() {
		return this.aideContextuelle;
	}

	public void setAideContextuelle(String aideContextuelle) {
		this.aideContextuelle = aideContextuelle;
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

	public String getIntitule() {
		return this.intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Boolean getObligatoire() {
		return this.obligatoire;
	}

	public void setObligatoire(Boolean obligatoire) {
		this.obligatoire = obligatoire;
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

	public List<FormulaireEntity> getFormulaires() {
		return this.formulaires;
	}

	public void setFormulaires(List<FormulaireEntity> formulaires) {
		this.formulaires = formulaires;
	}

	public FormulaireEntity addFormulaire(FormulaireEntity formulaire) {
		getFormulaires().add(formulaire);
		formulaire.addQuestion(this);

		return formulaire;
	}

	public FormulaireEntity removeFormulaire(FormulaireEntity formulaire) {
		getFormulaires().remove(formulaire);
		formulaire.removeQuestion(this);

		return formulaire;
	}

	public AdministrateurEntity getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(AdministrateurEntity administrateur) {
		this.administrateur = administrateur;
	}

	public TypeQuestionEntity getTypequestion() {
		return this.typequestion;
	}

	public void setTypeQuestion(TypeQuestionEntity typequestion) {
		this.typequestion = typequestion;
	}

	public List<ReponseProposeeEntity> getReponsesProposees() {
		return this.reponsesProposees;
	}

	public void setReponseproposees(List<ReponseProposeeEntity> reponseProposees) {
		this.reponsesProposees = reponseProposees;
	}

	public ReponseProposeeEntity addReponseproposee(ReponseProposeeEntity reponseproposee) {
		getReponsesProposees().add(reponseproposee);
		reponseproposee.setQuestion(this);

		return reponseproposee;
	}

	public ReponseProposeeEntity removeReponseproposee(ReponseProposeeEntity reponseproposee) {
		getReponsesProposees().remove(reponseproposee);
		reponseproposee.setQuestion(null);

		return reponseproposee;
	}

}