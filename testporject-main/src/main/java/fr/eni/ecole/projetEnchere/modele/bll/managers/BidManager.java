package fr.eni.ecole.projetEnchere.modele.bll.managers;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Bid;

public interface BidManager {

	Bid addNewBid(Bid bid);

	Integer getMaxBid(Integer idArticle);

}
