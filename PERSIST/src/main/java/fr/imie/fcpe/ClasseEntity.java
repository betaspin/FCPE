package fr.imie.fcpe;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the classe database table.
 * 
 */
@Entity
@NamedQuery(name="ClasseEntity.findAll", query="SELECT c FROM ClasseEntity c")
@Table(name = "classe")
public class ClasseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean archive;

	private Boolean complete;

	@Column(name="id_etablissement")
	private Integer idEtablissement;

	private String niveau;

	private String nom;

	private String parentreferent;

	private String professeurprincipal;

	private String serie;

	//bi-directional many-to-one association to Campagne
	@OneToMany(mappedBy="classe")
	private List<CampagneEntity> campagnes;

	//bi-directional many-to-one association to Eleve
	@OneToMany(mappedBy="classe")
	private List<EleveEntity> eleves;

	public ClasseEntity() {
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

	public Boolean getComplete() {
		return this.complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public Integer getIdEtablissement() {
		return this.idEtablissement;
	}

	public void setIdEtablissement(Integer idEtablissement) {
		this.idEtablissement = idEtablissement;
	}

	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getParentreferent() {
		return this.parentreferent;
	}

	public void setParentreferent(String parentreferent) {
		this.parentreferent = parentreferent;
	}

	public String getProfesseurprincipal() {
		return this.professeurprincipal;
	}

	public void setProfesseurprincipal(String professeurprincipal) {
		this.professeurprincipal = professeurprincipal;
	}

	public String getSerie() {
		return this.serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public List<CampagneEntity> getCampagnes() {
		return this.campagnes;
	}

	public void setCampagnes(List<CampagneEntity> campagnes) {
		this.campagnes = campagnes;
	}

	public CampagneEntity addCampagne(CampagneEntity campagne) {
		getCampagnes().add(campagne);
		campagne.setClasse(this);

		return campagne;
	}

	public CampagneEntity removeCampagne(CampagneEntity campagne) {
		getCampagnes().remove(campagne);
		campagne.setClasse(null);

		return campagne;
	}

	public List<EleveEntity> getEleves() {
		return this.eleves;
	}

	public void setEleves(List<EleveEntity> eleves) {
		this.eleves = eleves;
	}

	public EleveEntity addEleve(EleveEntity eleve) {
		getEleves().add(eleve);
		eleve.setClasse(this);

		return eleve;
	}

	public EleveEntity removeEleve(EleveEntity eleve) {
		getEleves().remove(eleve);
		eleve.setClasse(null);

		return eleve;
	}

}