package fr.eni.ecole.projetEnchere.modele.bll.bo;

import java.time.LocalDateTime;

public class Bid {
	private Integer idBid;
	private LocalDateTime dateBid;
	private Integer amountBid;
	private Article article;
	private User user;

	public Bid() {
	}

	public Bid(LocalDateTime dateBid, Integer amountBid, Article article, User user) {
		super();
		this.dateBid = dateBid;
		this.amountBid = amountBid;
		this.article = article;
		this.user = user;
	}

	public Integer getIdBid() {
		return idBid;
	}

	public void setIdBid(Integer idBid) {
		this.idBid = idBid;
	}

	public LocalDateTime getDateBid() {
		return dateBid;
	}

	public void setDateBid(LocalDateTime dateBid) {
		this.dateBid = dateBid;
	}

	public Integer getAmountBid() {
		return amountBid;
	}

	public void setAmountBid(Integer amountBid) {
		this.amountBid = amountBid;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Enchere [idBid=" + idBid + ", dateBid=" + dateBid + ", amountBid=" + amountBid + ", article=" + article
				+ ", user=" + user + "]";
	}

}
