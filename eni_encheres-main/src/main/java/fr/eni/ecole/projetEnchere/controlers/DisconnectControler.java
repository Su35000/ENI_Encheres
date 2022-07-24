package fr.eni.ecole.projetEnchere.controlers;

import java.io.IOException;

import fr.eni.ecole.projetEnchere.modele.bll.bo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/disconnect")
public class DisconnectControler extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getSession().invalidate();
		
		this.getServletContext()
		.getRequestDispatcher("/homePage")
		.forward(req, resp);
	}
	
	

}
