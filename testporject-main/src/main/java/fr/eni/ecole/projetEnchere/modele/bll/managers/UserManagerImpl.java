package fr.eni.ecole.projetEnchere.modele.bll.managers;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import fr.eni.ecole.projetEnchere.modele.bll.bo.User;
import fr.eni.ecole.projetEnchere.modele.dal.dao.DaoFactory;
import fr.eni.ecole.projetEnchere.modele.dal.dao.UserDao;

public class UserManagerImpl implements UserManager {
	private UserDao userDao = DaoFactory.getUserDao();

	@Override
	public User checkUser(String pseudo, String password) {
		return userDao.checkUser(pseudo, password);
	}

	@Override
	public User registerUser(User user) {
		return userDao.registerUser(user);
	}

	@Override
	public Boolean confirmPassword(String mdp, String verifMdp) {
		if (!mdp.equals(verifMdp)) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public User addCredits(User user) {
		return userDao.addCredits(user);
	}

	@Override
	public User bid(User user) {
		return userDao.bid(user);
	}

	@Override
	public User updateUser(User user) {
		return userDao.updateUser(user);
	}

//	"/^\\+?[1-9][0-9]{7,14}$/";
	@Override
	public Boolean deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

	private Map<String, String> error = new HashMap<>();

	@Override
	public Map<String, String> checkConnexionRegister(String username, String name, String firstname, String email,
			String phone, String street, String postalCode, String city, String password, String check) {

		String regex = "^[a-zA-Z0-9_]*$";
		String regexEmail = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
		String phoneRegex =  "^\\d{10}$";
		
		Pattern pattern3 = Pattern.compile(phoneRegex, Pattern.MULTILINE);
		Pattern pattern2 = Pattern.compile(regexEmail, Pattern.MULTILINE);
		Pattern pattern1 = Pattern.compile(regex, Pattern.MULTILINE);
	
		error.clear();
		
		if (username != "" && name != ""  && firstname != ""  &&
				email != "" && phone != ""  && street != ""  && postalCode != ""  &&
				city != ""  && password != ""  && check != "") {
			
				if (!pattern1.matcher(username).matches()) {
					error.put("username", "Le pseudo n'accepte que les caract�res alphanumériques");
				}
				if (!pattern2.matcher(email).matches()) {
					error.put("email", "L'email n'est pas valide");
				}
				if (!pattern3.matcher(phone).matches()) {
					error.put("phone", "Le num�ro de téléphone n'est pas valide");
				}
				if (!password.equals(check)) {
					error.put("password", "Votre confirmation ne correspond pas au mot de passe");
				}
				if(username.equals(userDao.findByUsername(username))) {
					error.put("existingUsername", "Ce nom d'utilisateur existe déjà");
				}
				if(email.equals(userDao.findByEmail(email))) {
					error.put("existingEmail", "Cet email existe d�j�");
				}
				} else {
					error.put("emptyField", "Tous les champs sont requis");
				}
				return error;
	
	}

}
