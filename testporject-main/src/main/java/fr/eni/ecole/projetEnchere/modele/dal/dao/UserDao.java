package fr.eni.ecole.projetEnchere.modele.dal.dao;

import fr.eni.ecole.projetEnchere.modele.bll.bo.User;

public interface UserDao {

	User checkUser(String pseudo, String password);

	User registerUser(User user);
	
	User updateUser(User user);
	
	Boolean deleteUser(Integer userId);
	
	User addCredits(User user);
	
	User bid(User user);

	User findById(int id);
	
	String findByUsername(String username);
	
	String findByEmail(String email);
}
