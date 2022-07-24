package fr.eni.ecole.projetEnchere.modele.bll.managers;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Bid;
import fr.eni.ecole.projetEnchere.modele.dal.dao.BidDao;
import fr.eni.ecole.projetEnchere.modele.dal.dao.DaoFactory;

public class BidManagerImpl implements BidManager{
	
	private BidDao bidDao = DaoFactory.getBidDao();


	@Override
	public Bid addNewBid(Bid bid) {
	
		return bidDao.addNewBid(bid);
	}


	@Override
	public Integer getMaxBid(Integer idArticle) {
		return bidDao.getMaxBid(idArticle);
	}

	
}
