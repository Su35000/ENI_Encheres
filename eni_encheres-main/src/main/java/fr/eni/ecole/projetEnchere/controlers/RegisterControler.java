package fr.eni.ecole.projetEnchere.controlers;

import java.io.IOException;
import java.util.Map;

import fr.eni.ecole.projetEnchere.modele.bll.bo.User;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ManagerFactory;
import fr.eni.ecole.projetEnchere.modele.bll.managers.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterControler extends HttpServlet {

	UserManager userManager = ManagerFactory.getUserManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("userName");
		String firstName = req.getParameter("firstName");
		String phoneNumber = req.getParameter("phoneNumber");
		String PostalCode = req.getParameter("PostalCode");
		String password = req.getParameter("password");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String street = req.getParameter("street");
		String city = req.getParameter("city");
		String check = req.getParameter("check");

		Map<String, String> error = userManager.checkConnexionRegister(userName, name, firstName, email, phoneNumber,
				street, PostalCode, city, password, check);
		

		if (error.isEmpty()) {
			User user = new User(userName, name, firstName, email, phoneNumber, street, PostalCode, city, password);

			user = userManager.registerUser(user);

			req.getSession().setAttribute("connecte", true);
			req.getSession().setAttribute("user", user);
			this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);

		} else {
			req.setAttribute("error", error);
			this.getServletContext().getRequestDispatcher("/jsp/register.jsp").forward(req, resp);

		}

	}
}
