package fr.eni.ecole.projetEnchere.controlers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.awt.*;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Bid;
import fr.eni.ecole.projetEnchere.modele.bll.bo.User;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ArticleManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.BidManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.CategorieManager;
import fr.eni.ecole.projetEnchere.modele.bll.managers.ManagerFactory;
import fr.eni.ecole.projetEnchere.modele.bll.managers.UserManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/retailSale")
public class RetailSaleControler extends HttpServlet {

	UserManager userManager = ManagerFactory.getUserManager();
	ArticleManager articleManager = ManagerFactory.getArticleManager();
	CategorieManager categorieManager = ManagerFactory.getCategorieManager();
	BidManager bidManager = ManagerFactory.getBidManager();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/jsp/retailSale.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		doGet(req, resp);

		
		Integer idArticle = Integer.parseInt(req.getParameter("idArticle"));
		
//		Timestamp timestamp = Timestamp.valueOf(getDate);
		
		Article articleDateEndBid= articleManager.selectArticleById(idArticle);
		
		LocalDateTime getDate = LocalDateTime.now();
		LocalDateTime dateBidEnd = articleDateEndBid.getDtBidEnd();
		
		System.out.println(getDate + "///" + dateBidEnd);
		
		boolean isBidNotFinish = getDate.isBefore(dateBidEnd);	//false
		req.setAttribute("isBidNotFinish", isBidNotFinish);
		
		Integer maxBid = bidManager.getMaxBid(idArticle);
		req.setAttribute("maxSale", maxBid);
		Article ArticleId = articleManager.selectArticleById(idArticle);

		String priceString = req.getParameter("price");

		if (priceString != null) {

			// LocalDateTime to Timestamp
			LocalDateTime dateBid = LocalDateTime.now();
			Timestamp timestamp = Timestamp.valueOf(dateBid);
//
//			String dateBid = new SimpleDateFormat("dd-MMM-yyyyHH:mm:ss").format(Calendar.getInstance().getTime());
//			 
//			LocalDateTime dateTime = LocalDateTime.now().parse(dateBid);
			// LocalDateTime.parse(dateBid);

			Integer amountBid = Integer.parseInt(priceString);

			User ConnectedUser = (User) req.getSession().getAttribute("user");

			Bid bid = new Bid(dateBid, amountBid, ArticleId, ConnectedUser);

			Bid newBid = bidManager.addNewBid(bid);
			
			
			

		}
		if (req.getParameter("bid") != null) {
			this.getServletContext().getRequestDispatcher("/jsp/homePage.jsp").forward(req, resp);

		} else {
			req.setAttribute("ArticleId", ArticleId);
			this.getServletContext().getRequestDispatcher("/jsp/retailSale.jsp").forward(req, resp);
		}

	}

}
