package fr.imie.fcpe;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the campagne database table.
 * 
 */
@Entity
@NamedQuery(name="CampagneEntity.findAll", query="SELECT c FROM CampagneEntity c")
@Table(name = "campagne")
public class CampagneEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean archive;

	@Temporal(TemporalType.DATE)
	private Date datecloture;

	@Temporal(TemporalType.DATE)
	private Date dateconseildeclasse;

	@Temporal(TemporalType.DATE)
	private Date dateouverture;

	private String liengenere;

	private String statut;

	private String titre;

	private String trimestre;

	private String type;

	//bi-directional many-to-one association to Administrateur
	@ManyToOne
	@JoinColumn(name="id_administrateur")
	private AdministrateurEntity administrateur;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="id_classe")
	private ClasseEntity classe;

	//bi-directional many-to-one association to Formulaire
	@ManyToOne
	@JoinColumn(name="id_formulaire")
	private FormulaireEntity formulaire;

	//bi-directional many-to-one association to Reponseformulaire
	@OneToMany(mappedBy="campagne")
	private List<ReponseFormulaireEntity> reponseformulaires;

	public CampagneEntity() {
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

	public Date getDatecloture() {
		return this.datecloture;
	}

	public void setDatecloture(Date datecloture) {
		this.datecloture = datecloture;
	}

	public Date getDateconseildeclasse() {
		return this.dateconseildeclasse;
	}

	public void setDateconseildeclasse(Date dateconseildeclasse) {
		this.dateconseildeclasse = dateconseildeclasse;
	}

	public Date getDateouverture() {
		return this.dateouverture;
	}

	public void setDateouverture(Date dateouverture) {
		this.dateouverture = dateouverture;
	}

	public String getLiengenere() {
		return this.liengenere;
	}

	public void setLiengenere(String liengenere) {
		this.liengenere = liengenere;
	}

	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getTrimestre() {
		return this.trimestre;
	}

	public void setTrimestre(String trimestre) {
		this.trimestre = trimestre;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public AdministrateurEntity getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(AdministrateurEntity administrateur) {
		this.administrateur = administrateur;
	}

	public ClasseEntity getClasse() {
		return this.classe;
	}

	public void setClasse(ClasseEntity classe) {
		this.classe = classe;
	}

	public FormulaireEntity getFormulaire() {
		return this.formulaire;
	}

	public void setFormulaire(FormulaireEntity formulaire) {
		this.formulaire = formulaire;
	}

	public List<ReponseFormulaireEntity> getReponseformulaires() {
		return this.reponseformulaires;
	}

	public void setReponseformulaires(List<ReponseFormulaireEntity> reponseformulaires) {
		this.reponseformulaires = reponseformulaires;
	}

	public ReponseFormulaireEntity addReponseformulaire(ReponseFormulaireEntity reponseformulaire) {
		getReponseformulaires().add(reponseformulaire);
		reponseformulaire.setCampagne(this);

		return reponseformulaire;
	}

	public ReponseFormulaireEntity removeReponseformulaire(ReponseFormulaireEntity reponseformulaire) {
		getReponseformulaires().remove(reponseformulaire);
		reponseformulaire.setCampagne(null);

		return reponseformulaire;
	}

}