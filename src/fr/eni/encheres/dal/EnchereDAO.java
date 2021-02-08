package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;

public interface EnchereDAO extends DAO<Enchere> {

	public List<ArticleVendu> selectArticleByLibCategorie(String libelle);

}
