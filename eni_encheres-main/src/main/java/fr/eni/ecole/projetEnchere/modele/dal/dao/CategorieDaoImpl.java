package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;

public class CategorieDaoImpl implements CategorieDao{

	@Override
	public List<Categorie> findAll() {
		List<Categorie> lstCategories = new ArrayList<>();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM Categories";

			PreparedStatement pstmt = cnx.prepareStatement(QUERY);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setIdCategorie(rs.getInt("noCategorie"));
				categorie.setLabel(rs.getString("libelle"));
				
				lstCategories.add(categorie);
			}
			
			cnx.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstCategories;
	}

	@Override
	public Categorie findById(Integer id) {
		Categorie categorie = new Categorie();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM Categories WHERE noCategorie=?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				categorie.setIdCategorie(rs.getInt("noCategorie"));
				categorie.setLabel(rs.getString("libelle"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categorie;
	}

}