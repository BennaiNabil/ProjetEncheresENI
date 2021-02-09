package fr.eni.encheres.servlets.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class ServletTestEnchere extends HttpServlet {
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
			EnchereDAO enchereDAO = DAOFactory.getEnchereDAO();
			ArticleVenduDAO articleVenduDAO = DAOFactory.getArticleVenduDAO();

//			// selectArticleByLibCategorie
//			outPrintWriter.println("Test de la méthode selectArticleByLibCategorie()");
//			outPrintWriter.println("-------------------------------" + "\n");
//			outPrintWriter
//					.println("Nombre d'éléments: " + enchereDAO.selectArticleByLibCategorie("Informatique").size());
//			for (ArticleVendu articleVendu : enchereDAO.selectArticleByLibCategorie("Informatique")) {
//				outPrintWriter.println(articleVendu + "\n");
//			}

//			// selectAllCurrent
//			outPrintWriter.println("Test de la méthode selectAllCurrent()");
//			outPrintWriter.println("-------------------------------" + "\n");
//			outPrintWriter.println("Nombre d'éléments: " + enchereDAO.selectAllCurrent().size() + "\n");
//			for (ArticleVendu articleVendu : enchereDAO.selectAllCurrent()) {
//				outPrintWriter.println(articleVendu + "\n");
//			}

			List<ArticleVendu> tousArticlesInformatique = enchereDAO.selectArticleByLibCategorie("Informatique");

			outPrintWriter.println("\n\nListe non triée");
			outPrintWriter.println("-------------------------------" + "\n");

			for (ArticleVendu articleVendu : tousArticlesInformatique) {
				outPrintWriter.println(articleVendu.getAffichageArticle() + "\n");
			}

			outPrintWriter.println("\n\nListe triée par nom d'articles");
			outPrintWriter.println("-------------------------------" + "\n");

			for (ArticleVendu articleVendu : tousArticlesInformatique.stream()
					.sorted(Comparator.comparing(ArticleVendu::getNomArticle)).collect(Collectors.toList())) {
				outPrintWriter.println(articleVendu.getAffichageArticle() + "\n");
			}

			outPrintWriter.println("\n\nListe triée par date");
			outPrintWriter.println("-------------------------------" + "\n");

			for (ArticleVendu articleVendu : tousArticlesInformatique.stream()
					.sorted(Comparator.comparing(ArticleVendu::getDateFinEncheres)).collect(Collectors.toList())) {
				outPrintWriter.println(articleVendu.getAffichageArticle() + "\n");
			}

			// Libère une connexion
			cnx.close();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
