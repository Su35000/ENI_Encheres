package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;

public interface ArticleDao {
	List<Article> findAll();

	List<Article> findPurchasablesArticles(int idUser, int idCategory);

	List<Article> findSalesArticles(int idUser, Integer idCategory);

	List<Article> findPurchasablesArticlesAllCateg(int idUser);
	
	List<Article> findSalesArticlesAllCateg(int idUser);
	
	Article addArticle(Article article);

	Article selectArticleById(Integer idArticle);
	
	List<Article> findArticlesDisconnectOneCateg(Integer idCateg);

	Article updateArticle(Article article);

	boolean deleteArticle(Integer id);
	
}
