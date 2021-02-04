package fr.eni.encheres.bll;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {
	private ArticleVenduDAO articleDAO;

	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleVenduDAO();
	}

	public void insertArticle(ArticleVendu article) {
	}

}
