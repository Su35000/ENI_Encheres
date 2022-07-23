package fr.eni.ecole.projetEnchere.modele.bll.bo;

import java.time.LocalDateTime;

public class Article {
	private Integer idArticle;
	private String nom;
	private String description;
	private LocalDateTime dtBidStart;
	private LocalDateTime dtBidEnd;
	private Integer startPrice;
	private Integer salePrice;
	private Categorie categorie;
	private User vendeur;

	public Article() {
	}

	

	public Article(String nom, String description, LocalDateTime dtBidStart, LocalDateTime dtBidEnd, Integer startPrice,
			Integer salePrice, Categorie categorie, User vendeur) {
		super();
		this.nom = nom;
		this.description = description;
		this.dtBidStart = dtBidStart;
		this.dtBidEnd = dtBidEnd;
		this.startPrice = startPrice;
		this.salePrice = salePrice;
		this.categorie = categorie;
		this.vendeur = vendeur;
	}



	public Integer getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(Integer idArticle) {
		this.idArticle = idArticle;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDtBidStart() {
		return dtBidStart;
	}

	public void setDtBidStart(LocalDateTime dtBidStart) {
		this.dtBidStart = dtBidStart;
	}

	public LocalDateTime getDtBidEnd() {
		return dtBidEnd;
	}

	public void setDtBidEnd(LocalDateTime dtBidEnd) {
		this.dtBidEnd = dtBidEnd;
	}

	public Integer getStartPrice() {
		return startPrice;
	}

	public void setStartPrice(Integer startPrice) {
		this.startPrice = startPrice;
	}

	public Integer getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Integer salePrice) {
		this.salePrice = salePrice;
	}
	
	

	public Categorie getCategorie() {
		return categorie;
	}



	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}



	public User getVendeur() {
		return vendeur;
	}



	public void setVendeur(User vendeur) {
		this.vendeur = vendeur;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", nom=" + nom + ", description=" + description + ", dtBidStart="
				+ dtBidStart + ", dtBidEnd=" + dtBidEnd + ", startPrice=" + startPrice + ", salePrice=" + salePrice
				+ ", categorie=" + categorie + ", vendeur=" + vendeur + "]";
	}

}
