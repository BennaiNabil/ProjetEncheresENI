package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

abstract class ConnectionProvider {
	private static DataSource dataSource;

	/*
	 * Portion de code statique qui sera exécutée une seule fois: au moment de
	 * l'import de la classe Elle a pour but de faire le lien avec la BD.
	 */
	static {
		Context context;
		try {
			context = new InitialContext();
			ConnectionProvider.dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}
	}

	/**
	 * Cette méthode retourne une connection opérationnelle issue du pool de
	 * connexion vers la base de données
	 *
	 * @return connection un objet de type Connection utilisé pour se connecter au
	 *         SGBDR
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}
}