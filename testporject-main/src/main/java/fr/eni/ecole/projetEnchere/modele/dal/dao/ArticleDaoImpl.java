package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;
import fr.eni.ecole.projetEnchere.modele.bll.bo.User;

public class ArticleDaoImpl implements ArticleDao {
	private CategorieDao categorieDao = DaoFactory.getCategorieDao();
	private UserDao userDao = DaoFactory.getUserDao();

	@Override
	public List<Article> findAll() {
		List<Article> lstArticles = new ArrayList<>();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM Articles";

			PreparedStatement pstmt = cnx.prepareStatement(QUERY);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
				User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
				article.setIdArticle(rs.getInt("noArticle"));
				article.setNom(rs.getString("nomArticle"));
				article.setDescription(rs.getString("description"));
				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
				article.setStartPrice(rs.getInt("prixInitial"));
				article.setSalePrice(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(vendeur);
				lstArticles.add(article);

			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstArticles;
	}

	@Override
	public List<Article> findPurchasablesArticles(int idUser, int idCategory) {
		List<Article> lstArticlesPurchases = new ArrayList<>();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM articles where noUtilisateur != ? AND noCategorie = ?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idUser);
			pstmt.setInt(2, idCategory);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
				User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
				article.setIdArticle(rs.getInt("noArticle"));
				article.setNom(rs.getString("nomArticle"));
				article.setDescription(rs.getString("description"));
				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
				article.setStartPrice(rs.getInt("prixInitial"));
				article.setSalePrice(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(vendeur);
				lstArticlesPurchases.add(article);
			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstArticlesPurchases;
	}

	@Override
	public List<Article> findSalesArticles(int idUser, Integer idCategory) {
		List<Article> lstArticlesSales = new ArrayList<>();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM articles where noUtilisateur = ? AND noCategorie = ?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idUser);
			pstmt.setInt(2, idCategory);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
				User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
				article.setIdArticle(rs.getInt("noArticle"));
				article.setNom(rs.getString("nomArticle"));
				article.setDescription(rs.getString("description"));
				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
				article.setStartPrice(rs.getInt("prixInitial"));
				article.setSalePrice(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(vendeur);
				lstArticlesSales.add(article);
			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstArticlesSales;
	}

	@Override
	public List<Article> findPurchasablesArticlesAllCateg(int idUser) {
		List<Article> lstArticlesPurchasablesAllCateg = new ArrayList<>();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM articles where noUtilisateur != ?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idUser);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
				User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
				article.setIdArticle(rs.getInt("noArticle"));
				article.setNom(rs.getString("nomArticle"));
				article.setDescription(rs.getString("description"));
				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
				article.setStartPrice(rs.getInt("prixInitial"));
				article.setSalePrice(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(vendeur);
				lstArticlesPurchasablesAllCateg.add(article);
			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstArticlesPurchasablesAllCateg;
	}

	@Override
	public List<Article> findSalesArticlesAllCateg(int idUser) {
		List<Article> lstArticlesSalesAllCateg = new ArrayList<>();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM articles where noUtilisateur = ?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idUser);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
				User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
				article.setIdArticle(rs.getInt("noArticle"));
				article.setNom(rs.getString("nomArticle"));
				article.setDescription(rs.getString("description"));
				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
				article.setStartPrice(rs.getInt("prixInitial"));
				article.setSalePrice(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(vendeur);
				lstArticlesSalesAllCateg.add(article);
			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstArticlesSalesAllCateg;
	}

	@Override
	public List<Article> findArticlesDisconnectOneCateg(Integer idCateg) {
		List<Article> lstArticlesOneCateg = new ArrayList<>();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM articles where noCategorie = ?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idCateg);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Article article = new Article();
				Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
				User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
				article.setIdArticle(rs.getInt("noArticle"));
				article.setNom(rs.getString("nomArticle"));
				article.setDescription(rs.getString("description"));
				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
				article.setStartPrice(rs.getInt("prixInitial"));
				article.setSalePrice(rs.getInt("prixVente"));
				article.setCategorie(categorie);
				article.setVendeur(vendeur);
				lstArticlesOneCateg.add(article);
			}

			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstArticlesOneCateg;
	}

	@Override
	public Article addArticle(Article article) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "INSERT INTO articles  VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(article.getDtBidStart()));
			pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(article.getDtBidEnd()));
			pstmt.setInt(5, article.getStartPrice());
			pstmt.setInt(6, article.getSalePrice());
			pstmt.setInt(7, article.getVendeur().getId());
			pstmt.setInt(8, article.getCategorie().getIdCategorie());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();

			if (rs.next()) {
				article.setIdArticle(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return article;
	}

//	@Override
//	public List<Article> selectArticleById(Integer idArticle) {
//		
//		List<Article> lstArticleId = new ArrayList<>();
//		
//		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
//			final String QUERY = "SELECT * FROM articles INNER JOIN categories ON articles.noCategorie = categories.noCategorie";
//			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
//			ResultSet rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//
//				Article article = new Article();
//				Categorie categorie = new Categorie();
//				User vendeur = new User();
//
////				Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
////				User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
//				article.setIdArticle(rs.getInt("noArticle"));
//				article.setNom(rs.getString("nomArticle"));
//				article.setDescription(rs.getString("description"));
//				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
//				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
//				article.setStartPrice(rs.getInt("prixInitial"));
//				article.setSalePrice(rs.getInt("prixVente"));
//				vendeur.setId(rs.getInt("noUtilisateur"));
//				categorie.setIdCategorie(rs.getInt("noCategorie"));
//				article.setCategorie(categorie);
//				article.setVendeur(vendeur);
//				lstArticleId.add(article);
//				
//			}
//			System.out.println(lstArticleId);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return lstArticleId;
//		
//	
//	}

	@Override
	public Article selectArticleById(Integer idArticle) {

		Article article = new Article();

		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY ="SELECT * FROM articles INNER JOIN categories ON articles.noCategorie = categories.noCategorie "
					+ "INNER JOIN utilisateurs ON utilisateurs.noUtilisateur = articles.noUtilisateur"
					+ " WHERE noArticle = ?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idArticle);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
			
				Categorie categorie = new Categorie();
				User vendeur = new User();
			
				//Categorie categorie = categorieDao.findById(rs.getInt("noCategorie"));
				//User vendeur = userDao.findById(rs.getInt("noUtilisateur"));
				
				article.setIdArticle(rs.getInt("noArticle"));
				article.setNom(rs.getString("nomArticle"));
				article.setDescription(rs.getString("description"));
				article.setDtBidStart(rs.getTimestamp("dateDebutEncheres").toLocalDateTime());
				article.setDtBidEnd(rs.getTimestamp("dateFinEncheres").toLocalDateTime());
				article.setStartPrice(rs.getInt("prixInitial"));
				article.setSalePrice(rs.getInt("prixVente"));
				
				categorie.setIdCategorie(rs.getInt("noCategorie"));
				categorie.setLabel(rs.getString("libelle"));
				article.setCategorie(categorie);
				
				vendeur.setId(rs.getInt("noUtilisateur"));
				vendeur.setUsername(rs.getString("Pseudo"));
				vendeur.setStreet(rs.getString("rue"));
				vendeur.setPostalCode(rs.getString("codePostal"));
				vendeur.setCity(rs.getString("ville"));;
				article.setVendeur(vendeur);
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public Article updateArticle(Article article) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "UPDATE articles SET nomArticle=?, description=?, dateDebutEncheres=?, dateFinEncheres=?, prixInitial=?, prixVente=?, noUtilisateur=?, noCategorie=? WHERE noArticle=?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setString(1, article.getNom());
			pstmt.setString(2, article.getDescription());
			pstmt.setTimestamp(3, java.sql.Timestamp.valueOf(article.getDtBidStart()));
			pstmt.setTimestamp(4, java.sql.Timestamp.valueOf(article.getDtBidEnd()));
			pstmt.setInt(5, article.getStartPrice());
			pstmt.setInt(6, article.getSalePrice());
			pstmt.setInt(7, article.getVendeur().getId());
			pstmt.setInt(8, article.getCategorie().getIdCategorie());
			pstmt.setInt(9, article.getIdArticle());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return article;
	}

	@Override
	public boolean deleteArticle(Integer id) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "delete articles WHERE noArticle=?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

}
