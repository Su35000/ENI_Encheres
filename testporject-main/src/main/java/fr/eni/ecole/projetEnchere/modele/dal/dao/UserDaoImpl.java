package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.ecole.projetEnchere.modele.bll.bo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User checkUser(String pseudo, String password) {
		User user = new User();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM utilisateurs WHERE pseudo=? AND mdp=?";

			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setString(1, pseudo);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("noUtilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstName(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("codePostal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mdp"));
				user.setCredit(rs.getInt("credit"));
				user.setAdmin(rs.getBoolean("administrateur"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User registerUser(User user) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "INSERT INTO Utilisateurs (pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

			PreparedStatement pstmt = cnx.prepareStatement(QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhoneNumber());
			pstmt.setString(6, user.getStreet());
			pstmt.setString(7, user.getPostalCode());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getPassword());
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			while(rs.next()) {
				user.setId(rs.getInt(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User updateUser(User user) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "UPDATE Utilisateurs SET pseudo=?, nom=?, prenom=?, email=?, telephone=?, rue=?, codePostal=?, ville=?, mdp=? WHERE noUtilisateur=?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getFirstName());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getPhoneNumber());
			pstmt.setString(6, user.getStreet());
			pstmt.setString(7, user.getPostalCode());
			pstmt.setString(8, user.getCity());
			pstmt.setString(9, user.getPassword());
			pstmt.setInt(10, user.getId());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	
	public Boolean deleteUser(Integer userId) {
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "DELETE FROM Utilisateurs WHERE"
					+ " noUtilisateur = ?";
			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public User addCredits(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User bid(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findById(int id) {
		User user = new User();
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT * FROM utilisateurs WHERE noUtilisateur=?";

			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setInt(1, id);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				user.setId(rs.getInt("noUtilisateur"));
				user.setUsername(rs.getString("pseudo"));
				user.setName(rs.getString("nom"));
				user.setFirstName(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setPhoneNumber(rs.getString("telephone"));
				user.setStreet(rs.getString("rue"));
				user.setPostalCode(rs.getString("codePostal"));
				user.setCity(rs.getString("ville"));
				user.setPassword(rs.getString("mdp"));
				user.setCredit(rs.getInt("credit"));
				user.setAdmin(rs.getBoolean("administrateur"));
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return user;
	}

	@Override
	public String findByUsername(String username) {
		String userName = null;
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT pseudo FROM utilisateurs WHERE pseudo=?";

			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setString(1, username);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				userName = rs.getString("pseudo");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return userName;
	}

	@Override
	public String findByEmail(String email) {
		String userEmail = null;
		try (Connection cnx = PoolConnexion.getConnexion("Encheres_ENI")) {
			final String QUERY = "SELECT email FROM utilisateurs WHERE email=?";

			PreparedStatement pstmt = cnx.prepareStatement(QUERY);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				userEmail = rs.getString("email");
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return userEmail;
	}
	
}
