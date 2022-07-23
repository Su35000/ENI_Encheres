package fr.eni.ecole.projetEnchere.controlers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;
import fr.eni.ecole.projetEnchere.modele.bll.bo.User;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Withdrawal;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ArticleManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.CategorieManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ManagerFactory;
import fr.eni.ecole.projetEnchere.modele.bll.managers.WithdrawalManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sale")
public class SaleController extends HttpServlet {
	private ArticleManager articleManager = ManagerFactory.getArticleManager();
	private CategorieManager categorieManager = ManagerFactory.getCategorieManager();
	private WithdrawalManager withdrawalManager = ManagerFactory.getWithdrawalManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if (req.getParameter("mySale") != null) {
			Integer idArticle = Integer.valueOf(req.getParameter("idMyArticle"));
			Article article = articleManager.selectArticleById(idArticle);
			Withdrawal withdrawal = withdrawalManager.getWithdrawalById(idArticle);
			withdrawal.setArticle(article);
			req.setAttribute("withdrawal", withdrawal);
			req.setAttribute("article", article);
		}  else {
			Article article = new Article();
			req.setAttribute("article", article);
		}

		List<Categorie> lstCategories = categorieManager.findAll();
		req.setAttribute("lstCategories", lstCategories);
		User vendeur = (User) req.getSession().getAttribute("user");
		this.getServletContext().getRequestDispatcher("/jsp/sale.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("mySale") != null) {
			doGet(req, resp);
		} else {
			if (req.getParameter("add") != null) {
				Article article = generateArticle(req, resp);
				Withdrawal withdrawal = generateWithdrawal(article, req, resp);
				article = articleManager.addArticle(article);
				withdrawal = withdrawalManager.addWithdrawal(withdrawal);
				this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
			} else if (req.getParameter("cancel") != null) {
				this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
			} else if (req.getParameter("delete") != null) {
				Integer id = Integer.valueOf(req.getParameter("idArticle"));
				LocalDateTime dtDebut = LocalDateTime.parse(req.getParameter("dateDebut"));
				String erreur = articleManager.checkDate(dtDebut);
				if (!erreur.equals("")) {
					req.setAttribute("erreur", erreur);
					this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
				} else if (!articleManager.deleteArticle(id) && !withdrawalManager.deleteWithdrawal(id)) {
					this.getServletContext().getRequestDispatcher("/jsp/sale.jsp").forward(req, resp);
				} else {
					this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
				}
			} else if (req.getParameter("update") != null) {
				Integer id = Integer.valueOf(req.getParameter("idArticle"));
				LocalDateTime dtDebut = LocalDateTime.parse(req.getParameter("dateDebut"));
				String erreur = articleManager.checkDate(dtDebut);
				if (!erreur.equals("")) {
					req.setAttribute("erreur", erreur);
					this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
				} else {
					Article article = generateArticle(req, resp);

					article.setIdArticle(id);
					Withdrawal withdrawal = generateWithdrawal(article, req, resp);
					article = articleManager.updateArticle(article);
					withdrawal = withdrawalManager.updateWithdrawal(withdrawal);
					this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
				}
			}
		}
	}

	protected Article generateArticle(HttpServletRequest req, HttpServletResponse resp) {
		String nom = req.getParameter("article");
		String description = req.getParameter("description");
		LocalDateTime dtDebut = LocalDateTime.parse(req.getParameter("dateDebut"));
		LocalDateTime dtFin = LocalDateTime.parse(req.getParameter("dateFin"));
		Integer startPrice = Integer.parseInt(req.getParameter("Price"));

		String category = req.getParameter("categorie");
		Integer idCateg = Integer.valueOf(category);
		Categorie categorie = categorieManager.findById(idCateg);

		User vendeur = (User) req.getSession().getAttribute("user");

		Article article = new Article(nom, description, dtDebut, dtFin, startPrice, startPrice, categorie, vendeur);
		return article;
	}

	protected Withdrawal generateWithdrawal(Article article, HttpServletRequest req, HttpServletResponse resp) {
		String street = req.getParameter("rue");
		String postalCode = req.getParameter("codePostal");
		String city = req.getParameter("ville");

		Withdrawal withdrawal = new Withdrawal(article, street, postalCode, city);
		return withdrawal;
	}

}
