package fr.eni.ecole.projetEnchere.controlers;

import java.io.IOException;

import fr.eni.ecole.projetEnchere.modele.bll.bo.User;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ManagerFactory;
import fr.eni.ecole.projetEnchere.modele.bll.managers.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/connexion")
public class ConnexionControler extends HttpServlet{
	
	
	UserManager userManager = ManagerFactory.getUserManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext()
		.getRequestDispatcher("/jsp/connexion.jsp")
		.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pseudo = req.getParameter("pseudo");
		String password = req.getParameter("password");
			
	
		User user = userManager.checkUser(pseudo, password);
		
		if(user.getId() > 0) {
			req.getSession().setAttribute("connecte", true);
			req.getSession().setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/homePage")
			.forward(req, resp);
		} else {
			req.setAttribute("erreur", "Email ou mot de passe incorrect");
			this.getServletContext()
			.getRequestDispatcher("/jsp/connexion.jsp")
			.forward(req, resp);
		}
		
		
			
	}

}
