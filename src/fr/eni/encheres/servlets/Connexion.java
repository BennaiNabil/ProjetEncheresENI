package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Revoie vers la page de connexion.

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageConnexion.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String identifiant;
		String mdp;

		identifiant = request.getParameter("identifiant");
		mdp = request.getParameter("mdp");

		System.out.println("Identifiant : " + identifiant + " - Mot de passe : " + mdp);

		/*
		 * [NABIL]
		 * 
		 * On utilise la méthode sontBonsIdentifiantsDeConnexion pour vérifier si le
		 * couple d'identifiant est correct
		 */

		UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();
		// Vérifie leur conformité à la base de données.
		if (utilisateurDAO.sontBonsIdentifiantsDeConnexion(identifiant, mdp)) {
			// Si oui : Redirection vers la page d'accueil Connecte.
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilConnecte.jsp");
			rd.forward(request, response);
		} else {
			// Si non : Affiche un message d'erreur.
			request.getRequestDispatcher("/WEB-INF/jsp/PageErreurConnexion.jsp").forward(request, response);

		}

	}

}
