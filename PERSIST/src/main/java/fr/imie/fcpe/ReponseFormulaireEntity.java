package fr.imie.fcpe;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the reponseformulaire database table.
 * 
 */
@Entity
@NamedQuery(name="ReponseFormulaireEntity.findAll", query="SELECT r FROM ReponseFormulaireEntity r")
@Table(name = "reponseformulaire")
public class ReponseFormulaireEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date datereponse;

	private String email;

	private String lienpourmodification;

	@Column(name="nom_eleve")
	private String nomEleve;

	@Column(name="prenom_eleve")
	private String prenomEleve;

	//bi-directional many-to-one association to Campagne
	@ManyToOne
	@JoinColumn(name="id_campagne")
	private CampagneEntity campagne;

	//bi-directional many-to-one association to Eleve
	@ManyToOne
	@JoinColumn(name="id_eleve")
	private EleveEntity eleve;

	public ReponseFormulaireEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatereponse() {
		return this.datereponse;
	}

	public void setDatereponse(Date datereponse) {
		this.datereponse = datereponse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLienpourmodification() {
		return this.lienpourmodification;
	}

	public void setLienpourmodification(String lienpourmodification) {
		this.lienpourmodification = lienpourmodification;
	}

	public String getNomEleve() {
		return this.nomEleve;
	}

	public void setNomEleve(String nomEleve) {
		this.nomEleve = nomEleve;
	}

	public String getPrenomEleve() {
		return this.prenomEleve;
	}

	public void setPrenomEleve(String prenomEleve) {
		this.prenomEleve = prenomEleve;
	}

	public CampagneEntity getCampagne() {
		return this.campagne;
	}

	public void setCampagne(CampagneEntity campagne) {
		this.campagne = campagne;
	}

	public EleveEntity getEleve() {
		return this.eleve;
	}

	public void setEleve(EleveEntity eleve) {
		this.eleve = eleve;
	}

}