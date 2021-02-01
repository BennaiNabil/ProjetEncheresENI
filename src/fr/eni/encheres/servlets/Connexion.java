package fr.eni.encheres.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Revoie vers la page de connexion.
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageConnexion.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupère les données de connexion de l'utilisateur (Nom et Mot de Passe).
		
		String identifiant;
		String mdp;
		
		identifiant = request.getParameter("identifiant");
		mdp = request.getParameter("mdp");
		
		System.out.println("Identifiant : " + identifiant + " - Mot de passe : " + mdp);
		
		
		//Vérifie leur conformité à la base de données.
		// ???
		
			//Si oui : Redirection vers la page d'accueil Connecte. 
		
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilConnecte.jsp");
			rd.forward(request, response);
		
			//Si non : Affiche un message d'erreur. 
			// ???
		

	}

}
