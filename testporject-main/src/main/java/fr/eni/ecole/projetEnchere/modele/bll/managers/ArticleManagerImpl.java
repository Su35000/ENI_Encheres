package fr.eni.ecole.projetEnchere.modele.bll.managers;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.dal.dao.ArticleDao;
import fr.eni.ecole.projetEnchere.modele.dal.dao.DaoFactory;

public class ArticleManagerImpl implements ArticleManager {

	private ArticleDao articleDao = DaoFactory.getArticleDao();

	@Override
	public Article addArticle(Article article) {
		return articleDao.addArticle(article);
	}

	@Override
	public List<Article> findAll() {
		return articleDao.findAll();
	}

	@Override
	public List<Article> findPurchasablesArticles(int idUser, int idCategory) {
		return articleDao.findPurchasablesArticles(idUser, idCategory);
	}

	@Override
	public List<Article> findSalesArticles(int idUser, int idCategory) {
		return articleDao.findSalesArticles(idUser, idCategory);
	}

	@Override
	public List<Article> findPurchasablesArticlesAllCateg(int idUser) {
		return articleDao.findPurchasablesArticlesAllCateg(idUser);
	}

	@Override
	public List<Article> findSalesArticlesAllCateg(int idUser) {
		return articleDao.findSalesArticlesAllCateg(idUser);
	}

//	@Override
//
//	public Article selectArticleById(Integer idArticle) {
//	
//		return articleDao.selectArticleById(idArticle);
//	}


	

	public List<Article> findArticlesDisconnectOneCateg(int idCateg) {
		return articleDao.findSalesArticlesAllCateg(idCateg);

	}

	@Override
	public Article selectArticleById(Integer idArticle) {
	
		return articleDao.selectArticleById(idArticle);
	}

	@Override
	public Article updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}

	@Override
	public boolean deleteArticle(Integer id) {
		return articleDao.deleteArticle(id);
	}

	@Override
	public String checkDate(LocalDateTime dtDebut) {
		String erreur = "";
		if (!dtDebut.isAfter(LocalDateTime.now())) {
			 erreur = "Erreur : vous ne pouvez pas modifier ou supprimer votre article après le début de l'enchère";
		} 
		return erreur;
	}



}
