package fr.eni.ecole.projetEnchere.modele.bll.managers;

import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Article;
import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;

public interface CategorieManager {

	List<Categorie> findAll();
	
	Categorie findById(Integer id);
	
}
