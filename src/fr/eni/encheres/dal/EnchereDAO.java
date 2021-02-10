package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;

public interface EnchereDAO extends DAO<Enchere> {

	List<ArticleVendu> selectArticleByLibCategorie(String libelle);

	List<ArticleVendu> selectArticleByLibCategorieEtNomArticle(String libelle, String nomArticle);

	List<ArticleVendu> selectAllCurrent();

	List<Enchere> selectByIdArticle(int id);

}
