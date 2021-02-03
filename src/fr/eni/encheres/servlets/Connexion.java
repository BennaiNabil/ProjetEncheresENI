package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.UtilisateurManager;

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

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		if (utilisateurManager.validerConnexion(identifiant, mdp)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilConnecte.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("erreurConnexion", "true");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageConnexion.jsp");
			rd.forward(request, response);
		}

	}

}
