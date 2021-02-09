package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.CategorieManager;
import fr.eni.encheres.bll.RetraitManager;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.CodesResultat;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;

public class MiseEnVente extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Envoi de la liste des catégories
		CategorieManager manager = new CategorieManager();
		request.setAttribute("listeCategories", manager.selectionnerToutesLesCategories());
		// Forward vers le formulaire de vente
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageFormulaireVente.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Déclaration des paramètres
		String nomArticle, description, libelle, pseudo, rue, codePostal, ville;
		int prixDepart, idVendeur, idCategorie;
		LocalDate debut, fin;
		Categorie categorie;
		Utilisateur vendeur;

		// Récupération "simple"
		nomArticle = request.getParameter("nomArticle");
		description = request.getParameter("description");
		prixDepart = Integer.parseInt(request.getParameter("prix"));
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		debut = LocalDate.parse(request.getParameter("debut"), dtf);
		fin = LocalDate.parse(request.getParameter("fin"), dtf);
		rue = request.getParameter("rue");
		codePostal = request.getParameter("codePostal");
		ville = request.getParameter("ville");
		// Récupération "complexe"
		// Id Categorie
		idCategorie = Integer.parseInt(request.getParameter("categorie"));
		CategorieManager categorieManager = new CategorieManager();
		categorie = categorieManager.selectCategorieById(idCategorie);

		// Id Utilisateur
		HttpSession session = request.getSession();
		vendeur = (Utilisateur) session.getAttribute("utilisateur");

		// Retrait
		rue = request.getParameter("rue");
		codePostal = request.getParameter("codePostal");
		ville = request.getParameter("ville");

		// Création de l'article
		ArticleVendu article = new ArticleVendu(nomArticle, description, debut, fin, prixDepart, categorie, vendeur);

		// Ajout à la base de données de l'article
		ArticleManager articleManager = new ArticleManager();
		try {
			articleManager.insertArticle(article);
		} catch (BLLException e) {
			request.setAttribute("erreur", CodesResultat.CREATION_ARTICLE_ERREUR);
			e.printStackTrace();
		}

		// Création du retrait
		Retrait retrait = new Retrait(rue, codePostal, ville, article);

		// Ajout du retrait à la base de données.
		RetraitManager retraitManager = new RetraitManager();
		retraitManager.insertRetrait(retrait);
		

	if((request.getAttribute("erreur")==null))

	{
		request.setAttribute("success", CodesResultat.CREATION_ARTICLE_SUCCESS);
	}
	RequestDispatcher rd = request
			.getRequestDispatcher("/WEB-INF/jsp/PageFormulaireVente.jsp");rd.forward(request,response);

}}
