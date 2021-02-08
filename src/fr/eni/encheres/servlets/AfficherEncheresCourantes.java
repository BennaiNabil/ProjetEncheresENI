package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;

public class AfficherEncheresCourantes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		int noCategorie = Integer.parseInt(request.getParameter("categorie"));

		CategorieManager categorieManager = new CategorieManager();
		EncheresManager encheresManager = new EncheresManager();

		Categorie categorieChoisie = categorieManager.selectCategorieById(noCategorie);
		List<ArticleVendu> listeEncheresEnCours = encheresManager
				.recueprerEncheresEnCoursParCategorie(categorieChoisie.getLibelle());

		List<List<String>> listeInfosEncheres = new ArrayList<>();

		// On transforme la liste d'articles en un Stream
		// On applique la fonction getAffichageArticle dans le scope
		// ArticleVendu à chaque élément du Stream

		listeInfosEncheres = listeEncheresEnCours.stream().map(ArticleVendu::getAffichageArticle)
				.collect(Collectors.toList());

//		for (ArticleVendu articleVendu : listeEncheresEnCours) {
//			listeInfosEncheres.add(articleVendu.getAffichageArticle());
//		}

		request.setAttribute("listeInfosEncheres", listeInfosEncheres);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
		rd.forward(request, response);
	}

}
