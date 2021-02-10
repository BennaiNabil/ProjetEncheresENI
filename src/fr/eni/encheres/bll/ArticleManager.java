package fr.eni.encheres.bll;

import java.time.LocalDate;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleManager {
	private final ArticleVenduDAO articleDAO;

	public ArticleManager() {
		this.articleDAO = DAOFactory.getArticleVenduDAO();
	}

	public void insertArticle(ArticleVendu article) throws BLLException {
		if (dateArticleEstValide(article) && prixArticleEstValide(article)) {
			articleDAO.insert(article);
		} else {
			throw new BLLException();
		}
	}

	public ArticleVendu selectArticlebyId(int idArticle) {
		return this.articleDAO.selectById(idArticle);
	}

	public boolean dateArticleEstValide(ArticleVendu article) {
		return (!(article.getDateDebutEncheres().isBefore(LocalDate.now())
				|| article.getDateFinEncheres().isBefore(article.getDateDebutEncheres())));
	}

	public boolean prixArticleEstValide(ArticleVendu article) {
		return (!(article.getMiseAPrix() <= 0));
	}
}
