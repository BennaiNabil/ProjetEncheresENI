package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BLLException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageInscription.jsp");
		rd.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pseudo, nom, prenom, email, tel, rue, codePostal, ville, mdp, conf;

		pseudo = request.getParameter("pseudo");
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		tel = request.getParameter("tel");
		rue = request.getParameter("rue");
		codePostal = request.getParameter("codePostal");
		ville = request.getParameter("ville");
		mdp = request.getParameter("mdp");
		conf = request.getParameter("conf");

		// Si les mots de passe correspondent et que le pseudo est unique, on ajoute
		// l'utilisateur
		if (mdp.equals(conf)) {
			Utilisateur utilisateur = new Utilisateur(-1, pseudo, nom, prenom, email, tel, rue, codePostal, ville, mdp,
					0, false);
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			try {
				utilisateurManager.nouvelUtilisateur(utilisateur);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
			rd.forward(request, response);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageErreurInscription.jsp");
		rd.forward(request, response);

	}
}