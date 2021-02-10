package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.Serial;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;

public class Accueillir extends HttpServlet {
	@Serial
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("doget de accueillir");

		HttpSession session = request.getSession();
		if (session != null) {
			System.out.println("session recuperee sans fermeture navigateur: " + session.getId());
			session.setMaxInactiveInterval(3600);
		}

		// Récupération de la liste des catégories
		CategorieManager categorieManager = new CategorieManager();
		List<Categorie> listeCategories = categorieManager.selectionnerToutesLesCategories();

		if (session != null) {
			session.setAttribute("listeCategories", listeCategories);
		}

		// Affichage des Enchères
		// 1. Recherche des enchères

		EncheresManager encheresManager = new EncheresManager();
		List<Enchere> listeEncheres;

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
