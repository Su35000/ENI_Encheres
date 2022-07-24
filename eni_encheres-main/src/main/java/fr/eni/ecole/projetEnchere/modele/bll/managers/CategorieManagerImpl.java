package fr.eni.ecole.projetEnchere.modele.bll.managers;

import java.util.List;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Categorie;
import fr.eni.ecole.projetEnchere.modele.dal.dao.CategorieDao;
import fr.eni.ecole.projetEnchere.modele.dal.dao.DaoFactory;

public class CategorieManagerImpl implements CategorieManager{

	private CategorieDao categorieDao = DaoFactory.getCategorieDao();

	public List<Categorie> findAll() {
		return categorieDao.findAll();
	}

	@Override
	public Categorie findById(Integer id) {
		return categorieDao.findById(id);
	}
}
