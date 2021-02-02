package fr.eni.encheres.servlets.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class ServletTestsUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter outPrintWriter = response.getWriter();

		try {
			Context context = new InitialContext();
			// Recherche de la DataSource
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
			// Demande une connexion
			Connection cnx = dataSource.getConnection();

			// Test de la connexion (ouverte ou fermée)
			outPrintWriter.println("Test de l'état de la connexion");
			outPrintWriter.println("-------------------------------" + "\n");
			outPrintWriter.println("La connexion est " + (cnx.isClosed() ? "fermée" : "ouverte") + ".\n\n\n");

			// TESTS
			UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

			// Tests de UtilisateurDAOJdbcImpl

			// selectAll
			outPrintWriter.println("Test de la méthode selectAll()");
			outPrintWriter.println("-------------------------------" + "\n");
			for (Utilisateur utilisateur : utilisateurDAO.selectAll()) {
				outPrintWriter.println(utilisateur + "\n");
			}
			outPrintWriter.println("\n\n\n");

			// selectById
			outPrintWriter.println("Test de la méthode selectById()");
			outPrintWriter.println("-------------------------------" + "\n");
			outPrintWriter.println(utilisateurDAO.selectById(4));
			outPrintWriter.println("\n\n\n");

			// selectByPseudo
			outPrintWriter.println("Test de la méthode selectByPseudo()");
			outPrintWriter.println("-----------------------------------" + "\n");
			outPrintWriter.println("pseudo: felix");
			outPrintWriter.print("Utilisateur associé: " + utilisateurDAO.selectByPseudo("felix"));
			outPrintWriter.println("\n\n\n");

			// sontBonsIdentifiantsDeConnexion
			outPrintWriter.println("Test de la méthode sontBonsIdentifiantsDeConnexion()");
			outPrintWriter.println("----------------------------------------------------" + "\n");
			outPrintWriter.println("test #1: bons identifiants");
			outPrintWriter.println("pseudo: felix");
			outPrintWriter.println("mot de passe: Pa$$w0rd");
			outPrintWriter.print("Bon couple d'identifiants? --> "
					+ utilisateurDAO.sontBonsIdentifiantsDeConnexion("felix", "Pa$$w0rd"));
			outPrintWriter.println("\n\ntest #2: mauvais identifiants");
			outPrintWriter.println("pseudo: felix");
			outPrintWriter.println("mot de passe: badmdp");
			outPrintWriter.print("Bon couple d'identifiants? --> "
					+ utilisateurDAO.sontBonsIdentifiantsDeConnexion("felix", "badmdp"));
			outPrintWriter.println("\n\n\n");

			// insert
			outPrintWriter.println("Test de la méthode insert()");
			outPrintWriter.println("-----------------------------------" + "\n");
			Utilisateur userInsert = utilisateurDAO.selectById(2);
			userInsert.setNom("Nouveau nom utilisateur");
			utilisateurDAO.insert(userInsert);
			for (Utilisateur utilisateur : utilisateurDAO.selectAll()) {
				outPrintWriter.println(utilisateur + "\n");
			}
			outPrintWriter.println("\n\n\n");

			// Libère une connexion
			cnx.close();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
