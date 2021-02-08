package fr.eni.encheres.servlets;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.w3c.dom.html.HTMLInputElement;

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
//	public static final String CHAMP_DESCRIPTION = "description";
//	public static final String CHAMP_FICHIER = "fichier";
//	public static final String CHEMIN = "chemin";
//	public static final int TAILLE_TAMPON = 10240; // 10 ko

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
		
		
//
//		// récupération de l'image
//		/*
//		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration dans le
//		 * web.xml
//		 */
//		String chemin = this.getServletConfig().getInitParameter(CHEMIN);
//
//		/* Récupération du contenu du champ de description */
//		description = request.getParameter(CHAMP_DESCRIPTION);
//		request.setAttribute(CHAMP_DESCRIPTION, description);
//
//		/*
//		 * Les données reçues sont multipart, on doit donc utiliser la méthode getPart()
//		 * pour traiter le champ d'envoi de fichiers.
//		 */
//		Part part = request.getPart(CHAMP_FICHIER);
//
//		/*
//		 * Il faut déterminer s'il s'agit d'un champ classique ou d'un champ de type
//		 * fichier : on délègue cette opération à la méthode utilitaire getNomFichier().
//		 */
//		String nomFichier = getNomFichier(part);
//
//		/*
//		 * Si la méthode a renvoyé quelque chose, il s'agit donc d'un champ de type
//		 * fichier (input type="file").
//		 */
//		if (nomFichier != null && !nomFichier.isEmpty()) {
//			String nomChamp = part.getName();
//			/*
//			 * Antibug pour Internet Explorer, qui transmet pour une raison mystique le
//			 * chemin du fichier local à la machine du client...
//			 * 
//			 * Ex : C:/dossier/sous-dossier/fichier.ext
//			 * 
//			 * On doit donc faire en sorte de ne sélectionner que le nom et l'extension du
//			 * fichier, et de se débarrasser du superflu.
//			 */
//			nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
//					.substring(nomFichier.lastIndexOf('\\') + 1);
//
//			/* Écriture du fichier sur le disque */
//			ecrireFichier(part, nomFichier, chemin);
//
//			request.setAttribute(nomChamp, nomFichier);
//		}
//
//	/*
//	 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre sur
//	 * le disque, dans le répertoire donné et avec le nom donné.
//	 */
//	private void ecrireFichier(Part part, String nomFichier, String chemin) throws IOException {
//		/* Prépare les flux. */
//		BufferedInputStream entree = null;
//		BufferedOutputStream sortie = null;
//		try {
//			/* Ouvre les flux. */
//			entree = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON);
//			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);
//
//			/*
//			 * Lit le fichier reçu et écrit son contenu dans un fichier sur le disque.
//			 */
//			byte[] tampon = new byte[TAILLE_TAMPON];
//			int longueur;
//			while ((longueur = entree.read(tampon)) > 0) {
//				sortie.write(tampon, 0, longueur);
//			}
//		} finally {
//			try {
//				sortie.close();
//			} catch (IOException ignore) {
//			}
//			try {
//				entree.close();
//			} catch (IOException ignore) {
//			}
//		}
//	}
//
//	/*
//	 * Méthode utilitaire qui a pour unique but d'analyser l'en-tête
//	 * "content-disposition", et de vérifier si le paramètre "filename" y est
//	 * présent. Si oui, alors le champ traité est de type File et la méthode
//	 * retourne son nom, sinon il s'agit d'un champ de formulaire classique et la
//	 * méthode retourne null.
//	 */
//	private static String getNomFichier(Part part) {
//	    /* Boucle sur chacun des paramètres de l'en-tête "content-disposition". */
//	    for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
//	        /* Recherche de l'éventuelle présence du paramètre "filename". */
//	        if ( contentDisposition.trim().startsWith( "filename" ) ) {
//	            /*
//	             * Si "filename" est présent, alors renvoi de sa valeur,
//	             * c'est-à-dire du nom de fichier sans guillemets.
//	             */
//	            return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
//	        }
//	    }
//	    /* Et pour terminer, si rien n'a été trouvé... */
//	    return null;
//	}


	if((request.getAttribute("erreur")==null))

	{
		request.setAttribute("success", CodesResultat.CREATION_ARTICLE_SUCCESS);
	}
	RequestDispatcher rd = request
			.getRequestDispatcher("/WEB-INF/jsp/PageFormulaireVente.jsp");rd.forward(request,response);

}}
