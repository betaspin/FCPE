package fr.imie.fcpe;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the academie database table.
 * 
 */
@Entity
@NamedQuery(name="AcademieEntity.findAll", query="SELECT a FROM AcademieEntity a")
@Table(name = "academie")
public class AcademieEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String nom;

	public AcademieEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}