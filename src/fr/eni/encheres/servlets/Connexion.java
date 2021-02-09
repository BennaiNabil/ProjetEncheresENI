package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.CodesResultat;
import fr.eni.encheres.messages.LecteurMessage;

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

		// Création d'une session
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(800);

		String identifiant;
		String mdp;
		List<String> erreurs = new ArrayList<String>();

		identifiant = request.getParameter("identifiant");
		mdp = request.getParameter("mdp");

		if (request.getParameter("memo") != null) {
			Cookie cookie = new Cookie("MemoId", identifiant);
			cookie.setMaxAge(3600);
			response.addCookie(cookie);
		}

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		if (utilisateurManager.validerConnexion(identifiant, mdp)) {
			session.setAttribute("utilisateur", utilisateurManager.recupererUtilisateurParPseudo(identifiant));
			session.setAttribute("connected", "oui");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
			rd.forward(request, response);
		} else {
			erreurs.add(LecteurMessage.getMessageErreur(CodesResultat.CONNEXION_ERREUR));
			request.setAttribute("erreurs", erreurs);
			session.setAttribute("connected", "non");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp");
			rd.forward(request, response);
		}
	}
}
