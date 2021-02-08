package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.Enchere;

public class Accueillir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session2 = request.getSession();
		if (session2 != null) {
			System.out.println("session recuperee sans fermeture navigateur: " + session2.getId());
			session2.setMaxInactiveInterval(3600);
		}

		// Affichage des Enchères
		// 1. Recherche des enchères

		EncheresManager encheresManager = new EncheresManager();
		List<Enchere> listeEncheres = null;

		listeEncheres = encheresManager.selectAll();
		request.setAttribute("listeEncheres", listeEncheres);

		// Renvoi vers la page d'accueil
		request.setAttribute("erreur", null);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
