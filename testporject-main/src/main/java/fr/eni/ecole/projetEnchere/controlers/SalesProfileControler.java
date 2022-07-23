package fr.eni.ecole.projetEnchere.controlers;

import java.io.IOException;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ArticleManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.CategorieManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ManagerFactory;
import fr.eni.ecole.projetEnchere.modele.bll.managers.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/salesProfile")
public class SalesProfileControler extends HttpServlet{

	UserManager userManager = ManagerFactory.getUserManager();
	ArticleManager articleManager = ManagerFactory.getArticleManager();
	CategorieManager categorieManager = ManagerFactory.getCategorieManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String idUser = req.getParameter("idUser");
		String usernameUser = req.getParameter("usernameUser");
		String nameUser = req.getParameter("nameUser");
		String firstNameUser = req.getParameter("firstNameUser");
		String emailUser = req.getParameter("emailUser");
		String phoneNumberUser = req.getParameter("phoneNumberUser");
		String streetUser = req.getParameter("streetUser");
		String cityUser = req.getParameter("cityUser");
		
		System.out.println("----------");
		System.out.println(idUser + usernameUser + nameUser);

		req.setAttribute("idUser", idUser);
		req.setAttribute("usernameUser", usernameUser);
		req.setAttribute("nameUser", nameUser);
		req.setAttribute("firstNameUser", firstNameUser);
		req.setAttribute("emailUser", emailUser);
		req.setAttribute("phoneNumberUser", phoneNumberUser);
		req.setAttribute("streetUser", streetUser);
		req.setAttribute("cityUser", cityUser);
		this.getServletContext().getRequestDispatcher("/jsp/salesProfile.jsp").forward(req, resp);
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
