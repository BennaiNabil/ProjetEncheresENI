package fr.eni.encheres.bll;

import java.time.LocalDate;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {
	private ArticleVenduDAO articleDAO;

	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleVenduDAO();
	}

	public void insertArticle(ArticleVendu article) throws BLLException {
		if (validerArticleDate(article) && validerArticlePrix(article)) {
			articleDAO.insert(article);
		} else {
			throw new BLLException();
		}
	}

	public boolean validerArticleDate(ArticleVendu article) {
		if (article.getDateDebutEncheres().isBefore(LocalDate.now())
				|| article.getDateFinEncheres().isBefore(article.getDateDebutEncheres()))
			;
		return false;
	}

	public boolean validerArticlePrix(ArticleVendu article) {
		if (article.getMiseAPrix() <= 0)
			;
		return false;
	}
}
