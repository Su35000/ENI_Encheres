package fr.eni.ecole.projetEnchere.modele.bll.managers;

public abstract class ManagerFactory {

	public static UserManager getUserManager() {
		return new UserManagerImpl();
	}
	
	public static ArticleManager getArticleManager() {
		return new ArticleManagerImpl();
	}
	
	public static CategorieManager getCategorieManager() {
		return new CategorieManagerImpl();
	}
	
	public static WithdrawalManager getWithdrawalManager() {
		return new WithdrawalManagerImpl();
	}
	
	public static BidManager getBidManager() {
		return new BidManagerImpl();
	}
}
