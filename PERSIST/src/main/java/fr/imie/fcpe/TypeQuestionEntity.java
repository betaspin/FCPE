package fr.imie.fcpe;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the typequestion database table.
 * 
 */
@Entity


@NamedQueries({
	@NamedQuery(name="TypeQuestionEntity.findAll", query="SELECT t FROM TypeQuestionEntity t"),
	@NamedQuery(name="TypeQuestionEntity.findOneByLabel", query="SELECT t FROM TypeQuestionEntity t where t.label = :label")
})

@Table(name = "typequestion")
public class TypeQuestionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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