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
import jakarta.websocket.Session;

@WebServlet("/profile")
public class ProfileControler extends HttpServlet {

	UserManager userManager = ManagerFactory.getUserManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/jsp/profile.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		
		
		if (req.getParameter("delete") != null) {
			Integer id = Integer.valueOf(req.getParameter("userId"));
			Boolean delete = userManager.deleteUser(id);
			if (delete==true) {
				req.getSession().invalidate();
				this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
			}
		} else if (req.getParameter("update") != null) {
			String userName = req.getParameter("userName");
			String firstName = req.getParameter("firstName");
			String phoneNumber = req.getParameter("phoneNumber");
			String PostalCode = req.getParameter("PostalCode");
			String password = req.getParameter("password");
			String newMdp = req.getParameter("newMdp");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String street = req.getParameter("street");
			String city = req.getParameter("city");
			String check = req.getParameter("check");

			User user = new User(userName, name, firstName, email, phoneNumber, street, PostalCode, city, newMdp);
			if (!password.equals(check) || check.equals(null) || newMdp.equals(null)) {
				user.setPassword(password);
			}
			User connectedUser = (User) req.getSession().getAttribute("user");
			user.setId(connectedUser.getId());
			user.setCredit(connectedUser.getCredit());
			user.setAdmin(connectedUser.getAdmin());
			User updatedUser = userManager.updateUser(user);
			req.getSession().setAttribute("user", updatedUser);

			this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);
		}
		
		
		
	}

}
