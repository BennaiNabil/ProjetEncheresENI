package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.EncheresManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.CodesResultat;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.messages.LecteurMessage;

public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des informations de l'article concerné
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		ArticleManager articleManager = new ArticleManager();
		ArticleVendu article = articleManager.selectArticlebyId(idArticle);
		String idArticleTransfert = String.valueOf(idArticle);
		System.out.println("idTranferé = " + idArticleTransfert);
		request.setAttribute("idArticle", idArticleTransfert);

		// Vérifie si il y a déjà eu des enchères de faites.
		List<Enchere> enchere;
		EncheresManager enchereManager = new EncheresManager();
		enchere = enchereManager.selectByIdArticle(idArticle);
		if (enchere.isEmpty()) {
			// Si non : affiche le montant Initial de vente de l'article.
			String montantActuel = Integer.toString(article.getPrixVente());
			request.setAttribute("montantActuel", montantActuel);
			System.out.println("montant initial : " + montantActuel);
		}
		// Si oui : affiche le montant de la dernière Enchère.
		else {
			Enchere derniereEnchere = enchere.get(enchere.size() - 1);
			System.out.println("dernière enchère = " + derniereEnchere);
			String montantActuel = Integer.toString(derniereEnchere.getMontantEnchere());
			request.setAttribute("montantActuel", montantActuel);
		}

		// Dans tous les cas : Forward vers la page Encherir
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageEncherir.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Récupérer les données à intégrer [idUtilisateur, noarticle, date
		// d'enchère,
		// montant enchenre].
		HttpSession session = request.getSession();
		ArticleManager articleManager = new ArticleManager();
		int idArticlePOST;
		Utilisateur encherisseur = (Utilisateur) session.getAttribute("utilisateur");

		String idArticlestring = request.getParameter("idArticle");
		System.out.println("test id article 2 : " + idArticlestring);

		idArticlePOST = Integer.parseInt(idArticlestring);
		System.out.println("int id Article 3 : " + idArticlePOST);

		ArticleVendu article = articleManager.selectArticlebyId(idArticlePOST);
		LocalDate dateEnchere = LocalDate.now();
		int montantEnchere = Integer.parseInt(request.getParameter("enchereNew"));

		// Création de l'objet Enchere
		Enchere enchere = new Enchere(dateEnchere, montantEnchere, encherisseur, article);

		// Ajout à la base de données de l'enchere
		EncheresManager enchereManager = new EncheresManager();
		try {
			enchereManager.insert(enchere);
		} catch (BLLException e) {
			List<String> erreurs = new ArrayList<>();
			erreurs.add(LecteurMessage.getMessageErreur(CodesResultat.CREATION_ENCHERE_ERREUR));
			request.setAttribute("erreurs", erreurs);
			e.printStackTrace();
		}

		// renvoi vers la page d'accueil.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
		rd.forward(request, response);

	}
}
