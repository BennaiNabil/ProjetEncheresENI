package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.Serial;
import java.util.Comparator;
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
	@Serial
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
		int noCategorieFiltre = 0;
		String nomArticleFiltre = null;

		CategorieManager categorieManager = new CategorieManager();
		EncheresManager encheresManager = new EncheresManager();

		Categorie categorieChoisie;
		String choixTri = request.getParameter("tri");

		aUnArticle = veutFiltrerParNomDArticle(request);
		aUneCategorie = veutFiltrerParCategorie(request);

		List<List<String>> listeInfosEncheres;
		List<ArticleVendu> listeEncheresBrute = encheresManager.recupererEncheresCourantes();
		List<ArticleVendu> listeEncheresEnCours;

		if (aUneCategorie) {
			noCategorieFiltre = Integer.parseInt(request.getParameter("categorie"));
			categorieChoisie = categorieManager.selectCategorieById(noCategorieFiltre);
			listeEncheresBrute = filtrerParCategorie(listeEncheresBrute, categorieChoisie.getLibelle());
		}

		if (aUnArticle) {
			nomArticleFiltre = request.getParameter("nomArticle");
			listeEncheresBrute = filtrerParNomArticle(listeEncheresBrute, nomArticleFiltre);
		}

		if (choixTri.equals("triDate")) {
			listeEncheresEnCours = trierParDateFinEnchere(listeEncheresBrute);
		} else if (choixTri.equals("triNom")) {
			listeEncheresEnCours = trierParNomArticle(listeEncheresBrute);
		} else {
			listeEncheresEnCours = listeEncheresBrute;
		}

		listeInfosEncheres = listeEncheresEnCours.stream().map(ArticleVendu::getAffichageArticle)
				.collect(Collectors.toList());

		request.setAttribute("listeInfosEncheres", listeInfosEncheres);
		request.setAttribute("entetes", ArticleVendu.entetesInfos());
		request.setAttribute("nomArticleChoisi", aUnArticle ? nomArticleFiltre : null);
		request.setAttribute("categorieChoisie", aUneCategorie ? noCategorieFiltre : null);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
		rd.forward(request, response);
	}

	private List<ArticleVendu> filtrerParCategorie(List<ArticleVendu> l, String lib) {
		return l.stream().filter(unArticle -> unArticle.getCategorie().getLibelle().equalsIgnoreCase(lib))
				.collect(Collectors.toList());
	}

	private List<ArticleVendu> filtrerParNomArticle(List<ArticleVendu> l, String nom) {
		return l.stream().filter(unArticle -> unArticle.getNomArticle().toLowerCase().contains(nom.toLowerCase()))
				.collect(Collectors.toList());
	}

	private List<ArticleVendu> trierParNomArticle(List<ArticleVendu> l) {
		return l.stream().sorted(Comparator.comparing(ArticleVendu::getNomArticle)).collect(Collectors.toList());
	}

	private List<ArticleVendu> trierParDateFinEnchere(List<ArticleVendu> l) {
		return l.stream().sorted(Comparator.comparing(ArticleVendu::getDateFinEncheres)).collect(Collectors.toList());
	}

}
