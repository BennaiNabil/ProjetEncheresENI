package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.CategorieManager;

public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.removeAttribute("connected");
		session.removeAttribute("utilisateur");
		session.invalidate();

		HttpSession session2 = request.getSession();

		session2.setAttribute("listeCategories", new CategorieManager().selectionnerToutesLesCategories());

		request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.removeAttribute("connected");
		session.removeAttribute("utilisateur");
		session.invalidate();
		HttpSession session2 = request.getSession();

		session2.setAttribute("listeCategories", new CategorieManager().selectionnerToutesLesCategories());

		request.getRequestDispatcher("/WEB-INF/jsp/PageAccueilAnonyme.jsp").forward(request, response);

	}

}
