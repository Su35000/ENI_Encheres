package fr.eni.ecole.projetEnchere.modele.bll.managers;

import java.time.LocalDateTime;
import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;

public interface ArticleManager {

	Article addArticle(Article article);

	List<Article> findAll();

	List<Article> findPurchasablesArticles(int idUser, int category);

	List<Article> findSalesArticles(int idUser, int category);

	List<Article> findPurchasablesArticlesAllCateg(int idUser);

	List<Article> findSalesArticlesAllCateg(int idUser);

	Article selectArticleById(Integer idArticle);

	List<Article> findArticlesDisconnectOneCateg(int idCateg);

	Article updateArticle(Article article);

	boolean deleteArticle(Integer id);

	String checkDate(LocalDateTime dtDebut);

}
