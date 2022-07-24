package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Bid;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;
import fr.eni.ecole.projetEnchere.modele.bll.bo.User;

public class BidDaoImpl implements BidDao {

	@Override
	public Bid addNewBid(Bid bid) {
		
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "INSERT INTO encheres VALUES(?, ?, ?, ? )";
			System.out.println(QUERY);
			PreparedStatement pstmt = cnx.prepareStatement(QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setTimestamp(1, Timestamp.valueOf(bid.getDateBid()));
			pstmt.setInt(2, bid.getAmountBid());
			pstmt.setInt(3, bid.getArticle().getIdArticle());
			pstmt.setInt(4, bid.getUser().getId());

			pstmt.executeUpdate();

			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				bid.setIdBid(rs.getInt(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return bid;
	}

	@Override
	public Integer getMaxBid(Integer idArticle) {
		var total = 0;

		try (var cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT MAX(montantEnchere) as max FROM encheres WHERE noArticle = ? ";
			var pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idArticle);
			var rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				total = rs.getInt("max");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return total;
	}

}
