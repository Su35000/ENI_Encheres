package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Withdrawal;
import fr.eni.ecole.projetEnchere.modele.bll.managers.WithdrawalManager;

public class WithdrawalDaoImpl implements WithdrawalDao {

	@Override
	public Withdrawal addWithdrawal(Withdrawal withdrawal) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "INSERT INTO retraits VALUES(?, ?, ?, ?)";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);

			pstmt.setInt(1, withdrawal.getArticle().getIdArticle());
			pstmt.setString(2, withdrawal.getRue());
			pstmt.setString(3, withdrawal.getCodePostal());
			pstmt.setString(4, withdrawal.getVille());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return withdrawal;
	}

	@Override
	public Withdrawal updateWithdrawal(Withdrawal withdrawal) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "UPDATE retraits SET rue=?, codePostal=?, ville=? WHERE noArticle=?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);

			pstmt.setString(1, withdrawal.getRue());
			pstmt.setString(2, withdrawal.getCodePostal());
			pstmt.setString(3, withdrawal.getVille());
			pstmt.setInt(4, withdrawal.getArticle().getIdArticle());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return withdrawal;
	}

	@Override
	public boolean deleteWithdrawal(Integer id) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "delete retraits WHERE noArticle=?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, id);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Withdrawal getWithdrawalById(Integer idArticle) {
		Withdrawal withdrawal = new Withdrawal();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "select * from retraits where noArticle=?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, idArticle);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				withdrawal.setRue(rs.getString("rue"));
				withdrawal.setCodePostal(rs.getString("codePostal"));
				withdrawal.setVille(rs.getString("ville"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return withdrawal;
	}

}
