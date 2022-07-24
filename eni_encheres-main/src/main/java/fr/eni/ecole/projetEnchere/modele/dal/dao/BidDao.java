package fr.eni.ecole.projetEnchere.modele.dal.dao;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Bid;

public interface BidDao {

	Bid addNewBid(Bid bid);

	Integer getMaxBid(Integer idArticle);

}
