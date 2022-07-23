package fr.eni.ecole.projetEnchere.modele.bll.managers;

import java.util.Map;

import fr.eni.ecole.projetEnchere.modele.bll.bo.User;

public interface UserManager {
	

	User checkUser(String pseudo, String password);
	
	User registerUser(User user);
	
	Boolean confirmPassword(String mdp, String verifMdp);
	
	User updateUser(User user);
	
	Boolean deleteUser(Integer id);
	
	User addCredits (User user);
	
	User bid (User user);

	Map<String, String> checkConnexionRegister(String username, String name, String firstname, String email, String phone,
			String street, String postalCode, String city, String password, String check);




}
