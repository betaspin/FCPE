package fr.imie.fcpe;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the typequestion database table.
 * 
 */
@Entity
@NamedQuery(name="TypeQuestionEntity.findAll", query="SELECT t FROM TypeQuestionEntity t")
@Table(name = "typequestion")
public class TypeQuestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String label;

	public TypeQuestionEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}