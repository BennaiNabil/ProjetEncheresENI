package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EncheresManager {
	private EnchereDAO enchereDAO;

	public EncheresManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}

	public List<Enchere> selectAll() {
		return this.enchereDAO.selectAll();
	}

	public List<ArticleVendu> recupererEncheresEnCoursParCategorie(String cate) {
		return this.enchereDAO.selectArticleByLibCategorie(cate);
	}

	public List<ArticleVendu> recupererEncheresCourantes() {
		return this.enchereDAO.selectAllCurrent();
	}

}