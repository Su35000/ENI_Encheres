package fr.eni.ecole.projetEnchere.modele.bll.bo;

public class Withdrawal {
	private Article article;
	private String rue;
	private String codePostal;
	private String Ville;

	public Withdrawal() {
	}

	public Withdrawal(Article article, String rue, String codePostal, String ville) {
		super();
		this.article = article;
		this.rue = rue;
		this.codePostal = codePostal;
		this.Ville = ville;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return Ville;
	}

	public void setVille(String ville) {
		Ville = ville;
	}

	@Override
	public String toString() {
		return "Retrait [article=" + article + ", rue=" + rue + ", codePostal=" + codePostal + ", Ville=" + Ville + "]";
	}

}
