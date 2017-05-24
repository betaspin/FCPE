package fr.imie.fcpe.model;

public class ReponseProposeeBO {

	private Integer id;
	private String label;
	private Integer question;

	public ReponseProposeeBO() {
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

	public Integer getQuestion() {
		return this.question;
	}

	public void setQuestion(Integer question) {
		this.question = question;
	}

}