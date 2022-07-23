package fr.eni.ecole.projetEnchere.modele.dal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnexion {

	// copier le driver sql dans le dossier libs
	// clic droit sur le jar / build path / add to build path
	public static Connection getConnexion(String database) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // charger le driver
		String connectionUrl = "jdbc:sqlserver://10.50.101.3:1433;database=" + database + ";";
		Connection con = DriverManager.getConnection(connectionUrl, "sa", "Pa$$w0rd");
		return con;
	}
}
