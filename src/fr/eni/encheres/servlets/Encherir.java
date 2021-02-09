package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleManager;
import fr.eni.encheres.bo.ArticleVendu;

public class Encherir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupération des informations de l'article concerné
		int idArticle = Integer.parseInt(request.getParameter("idArticle"));
		ArticleManager articleManager = new ArticleManager();
		ArticleVendu article = articleManager.selectArticlebyId(idArticle);

		String montantActuel = Integer.toString(article.getPrixVente());
		request.setAttribute("montantActuel", montantActuel);
		System.out.println(montantActuel);
		//Forward vers la page Encherir
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/PageEncherir.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupérer la nouvelle enchère.
		
	}
}
