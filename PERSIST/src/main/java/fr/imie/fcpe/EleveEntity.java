package fr.imie.fcpe;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the eleve database table.
 * 
 */
@Entity
@NamedQuery(name="EleveEntity.findAll", query="SELECT e FROM EleveEntity e")
@Table(name = "eleve")
public class EleveEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private Boolean archive;

	private String emailparent1;

	private String emailparent2;

	private String nom;

	private String parent1;

	private String parent2;

	private String prenom;

	private Boolean valide;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="id_classe")
	private ClasseEntity classe;

	//bi-directional many-to-one association to Reponseformulaire
	@OneToMany(mappedBy="eleve")
	private List<ReponseFormulaireEntity> reponseformulaires;

	public EleveEntity() {
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

	public String getEmailparent1() {
		return this.emailparent1;
	}

	public void setEmailparent1(String emailparent1) {
		this.emailparent1 = emailparent1;
	}

	public String getEmailparent2() {
		return this.emailparent2;
	}

	public void setEmailparent2(String emailparent2) {
		this.emailparent2 = emailparent2;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getParent1() {
		return this.parent1;
	}

	public void setParent1(String parent1) {
		this.parent1 = parent1;
	}

	public String getParent2() {
		return this.parent2;
	}

	public void setParent2(String parent2) {
		this.parent2 = parent2;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Boolean getValide() {
		return this.valide;
	}

	public void setValide(Boolean valide) {
		this.valide = valide;
	}

	public ClasseEntity getClasse() {
		return this.classe;
	}

	public void setClasse(ClasseEntity classe) {
		this.classe = classe;
	}

	public List<ReponseFormulaireEntity> getReponseformulaires() {
		return this.reponseformulaires;
	}

	public void setReponseformulaires(List<ReponseFormulaireEntity> reponseformulaires) {
		this.reponseformulaires = reponseformulaires;
	}

	public ReponseFormulaireEntity addReponseformulaire(ReponseFormulaireEntity reponseformulaire) {
		getReponseformulaires().add(reponseformulaire);
		reponseformulaire.setEleve(this);

		return reponseformulaire;
	}

	public ReponseFormulaireEntity removeReponseformulaire(ReponseFormulaireEntity reponseformulaire) {
		getReponseformulaires().remove(reponseformulaire);
		reponseformulaire.setEleve(null);

		return reponseformulaire;
	}

}