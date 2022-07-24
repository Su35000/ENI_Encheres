package fr.eni.ecole.projetEnchere.modele.dal.dao;

public abstract class DaoFactory {

	public static UserDao getUserDao() {
		return new UserDaoImpl();
	}

	public static ArticleDao getArticleDao() {
		return new ArticleDaoImpl();
	}
	
	public static CategorieDao getCategorieDao() {
		return new CategorieDaoImpl();
	}
	
	public static WithdrawalDao getWithdrawalDao() {
		return new WithdrawalDaoImpl();
	}
	
	public static BidDao getBidDao() {
		return new BidDaoImpl();
	}
}
