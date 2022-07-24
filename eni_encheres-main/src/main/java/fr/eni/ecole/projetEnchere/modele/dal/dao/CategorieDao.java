package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;

public interface CategorieDao {
	List<Categorie> findAll();
	
	Categorie findById(Integer id);
}
