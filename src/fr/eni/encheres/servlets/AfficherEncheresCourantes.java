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

	private boolean veutFiltrerParCategorie(HttpServletRequest req) {
		return req.getParameter("categorie").length() > 0;
	}

	private boolean veutFiltrerParNomDArticle(HttpServletRequest req) {
		return req.getParameter("nomArticle").length() > 0;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		boolean aUnArticle, aUneCategorie;

		int noCategorieFiltre;
		String nomArticleFiltre;

		CategorieManager categorieManager = new CategorieManager();
		EncheresManager encheresManager = new EncheresManager();

		List<List<String>> listeInfosEncheres = new ArrayList<>();

		Categorie categorieChoisie;

		aUnArticle = veutFiltrerParNomDArticle(request);
		aUneCategorie = veutFiltrerParCategorie(request);

		List<ArticleVendu> listeEncheresBrute = encheresManager.recupererEncheresCourantes();

		if (aUneCategorie) {
			noCategorieFiltre = Integer.parseInt(request.getParameter("categorie"));
			categorieChoisie = categorieManager.selectCategorieById(noCategorieFiltre);
			listeEncheresBrute = filtrerParCategorie(listeEncheresBrute, categorieChoisie.getLibelle());
		}

		if (aUnArticle) {
			nomArticleFiltre = request.getParameter("nomArticle");
			listeEncheresBrute = filtrerParNomArticle(listeEncheresBrute, nomArticleFiltre);
		}

		List<ArticleVendu> listeEncheresEnCours = listeEncheresBrute;

		listeInfosEncheres = listeEncheresEnCours.stream().map(ArticleVendu::getAffichageArticle)
				.collect(Collectors.toList());

		request.setAttribute("listeInfosEncheres", listeInfosEncheres);
		request.setAttribute("entetes", ArticleVendu.entetesInfos());

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
		rd.forward(request, response);
	}

	private List<ArticleVendu> filtrerParCategorie(List<ArticleVendu> l, String lib) {
		List<ArticleVendu> listeFiltree = new ArrayList<>();
		for (ArticleVendu articleVendu : l) {
			if (articleVendu.getCategorie().getLibelle().equals(lib)) {
				listeFiltree.add(articleVendu);
			}
		}
		return listeFiltree;
	}

	private List<ArticleVendu> filtrerParNomArticle(List<ArticleVendu> l, String nom) {
		List<ArticleVendu> listeFiltree = new ArrayList<>();
		for (ArticleVendu articleVendu : l) {
			if (articleVendu.getNomArticle().toLowerCase().indexOf(nom.toLowerCase()) != -1) {
				listeFiltree.add(articleVendu);
			}
		}
		return listeFiltree;
	}

}
