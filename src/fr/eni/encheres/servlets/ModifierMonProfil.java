package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

public class ModifierMonProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/PageModificationProfil.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pseudo, nom, prenom, email, tel, rue, codePostal, ville, mdp, conf;
		UtilisateurManager manager = new UtilisateurManager();

		HttpSession session = request.getSession();
		Utilisateur utilisateurAModifier = (Utilisateur) session.getAttribute("utilisateur");

		pseudo = request.getParameter("pseudo");
		nom = request.getParameter("nom");
		prenom = request.getParameter("prenom");
		email = request.getParameter("email");
		tel = request.getParameter("telephone");
		rue = request.getParameter("rue");
		codePostal = request.getParameter("codepostal");
		ville = request.getParameter("ville");

		Utilisateur utilisateurModifie = new Utilisateur(utilisateurAModifier.getNoUtilisateur(), pseudo, nom, prenom,
				email, tel, rue, codePostal, ville, utilisateurAModifier.getMotDePasse(),
				utilisateurAModifier.getCredit(), utilisateurAModifier.isEstAdministrateur());
		System.out.println(utilisateurModifie);

		if (manager.validerUtilisateur(utilisateurModifie)) {
			manager.modifierUtilisateur(utilisateurModifie);
		}
		session.setAttribute("utilisateur", utilisateurModifie);

		request.getRequestDispatcher("/WEB-INF/jsp/PageAfficherUnProfil.jsp").forward(request, response);

	}

}
