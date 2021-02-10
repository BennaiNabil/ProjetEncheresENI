package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;

public interface ArticleVenduDAO extends DAO<ArticleVendu> {
	
	public void updatePrixVente (ArticleVendu article, Enchere enchere);

}
