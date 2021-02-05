package fr.eni.encheres.servlets.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

@WebServlet("/ServletTestCategorie")
public class ServletTestCategorie extends HttpServlet {
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
			CategorieDAO categorieDAO = DAOFactory.getCategorieDAO();

			// selectAll
			outPrintWriter.println("Test de la méthode selectAll()");
			outPrintWriter.println("-------------------------------" + "\n");
			for (Categorie categorie : categorieDAO.selectAll()) {
				outPrintWriter.println(categorie + "\n");
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
