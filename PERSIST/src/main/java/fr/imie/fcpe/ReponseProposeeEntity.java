package fr.imie.fcpe;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the reponseproposee database table.
 * 
 */
@Entity
@NamedQueries({
	@NamedQuery(name="ReponseProposeeEntity.findAll", query="SELECT r FROM ReponseProposeeEntity r"),
    @NamedQuery(name="ReponseProposeeEntity.findAllWithQuestionId", query = ""
    		+ "SELECT DISTINCT rp FROM QuestionEntity q, ReponseProposeeEntity rp JOIN rp.question rpquestion WHERE rpquestion.id = :id")
})

@Table(name = "reponseproposee")
public class ReponseProposeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String label;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="id_question")
	private QuestionEntity question;

	public ReponseProposeeEntity() {
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

	public QuestionEntity getQuestion() {
		return this.question;
	}

	public void setQuestion(QuestionEntity question) {
		this.question = question;
	}

}