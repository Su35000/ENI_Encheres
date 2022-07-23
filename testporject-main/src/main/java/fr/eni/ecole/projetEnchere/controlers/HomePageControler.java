package fr.eni.ecole.projetEnchere.controlers;

import java.io.IOException;
import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;
import fr.eni.ecole.projetEnchere.modele.bll.bo.User;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ArticleManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.CategorieManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ManagerFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;

@WebServlet("/homePage")
public class HomePageControler extends HttpServlet {

	private ArticleManager articleManager = ManagerFactory.getArticleManager();
	private CategorieManager categorieManager = ManagerFactory.getCategorieManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("111");
		List<Article> lstArticles = articleManager.findAll();
		req.setAttribute("lstArticlesToShowDisconnect", lstArticles);
		
		

		redirectToHomePage(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("222");
		String userChoice = req.getParameter("userChoice");
		String category = req.getParameter("category");
		if(userChoice == null) {
			List<Article> lstArticles = articleManager.findAll();
			req.setAttribute("lstArticlesToShow", lstArticles);
		}
		if (userChoice != null) {
			String openBid = req.getParameter("openBid");
			String myBid = req.getParameter("myBid");
			String openwonBid = req.getParameter("openwonBid");
			String salesInProgress = req.getParameter("salesInProgress");
			String salesNotBegin = req.getParameter("salesNotBegin");
			String completeSales = req.getParameter("completeSales");

			int idCateg = Integer.valueOf(category);

			User ConnectedUser = (User) req.getSession().getAttribute("user");
			int idUser = ConnectedUser.getId();

			if (userChoice.equals("purchases")) {
				if (category.equals("0")) {
					List<Article> lstArticlesPurchasesAllCateg = articleManager
							.findPurchasablesArticlesAllCateg(idUser);
					req.setAttribute("lstArticlesToShow", lstArticlesPurchasesAllCateg);
				} else {
					List<Article> lstArticlesPurchases = articleManager.findPurchasablesArticles(idUser, idCateg);
					req.setAttribute("lstArticlesToShow", lstArticlesPurchases);
				}
			}
			if (userChoice.equals("sells")) {
				if (category.equals("0")) {
					List<Article> lstArticlesSellsAllCateg = articleManager.findSalesArticlesAllCateg(idUser);
					req.setAttribute("lstArticlesToShow", lstArticlesSellsAllCateg);
				} else {
					List<Article> lstArticlesSells = articleManager.findSalesArticles(idUser, idCateg);
					req.setAttribute("lstArticlesToShow", lstArticlesSells);
				}
				req.setAttribute("radioPurchases", true);
			}
		} else {

			if (category != null) {
				int idCateg = Integer.valueOf(category);

				if (idCateg != 0) {
					List<Article> lstArticlesDisconnectOneCateg = articleManager
							.findArticlesDisconnectOneCateg(idCateg);
					req.setAttribute("lstArticlesToShowDisconnect", lstArticlesDisconnectOneCateg);
				} else {
					List<Article> lstArticlesDisconnectAllCateg = articleManager.findAll();
					req.setAttribute("lstArticlesToShowDisconnect", lstArticlesDisconnectAllCateg);
				}
			}
		}

		redirectToHomePage(req, resp);
	}

	private void redirectToHomePage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("333");
		List<Categorie> lstCategories = categorieManager.findAll();
		req.setAttribute("lstCategories", lstCategories);

		this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
	}
}
