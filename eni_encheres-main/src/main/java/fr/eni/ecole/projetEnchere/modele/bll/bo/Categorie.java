package fr.eni.ecole.projetEnchere.modele.bll.bo;

public class Categorie {
	private Integer idCategorie;
	private String label;

	public Categorie() {
	}

	public Categorie(String label) {
		super();
		this.label = label;
	}

	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Categorie [idCategorie=" + idCategorie + ", label=" + label + "]";
	}

}
