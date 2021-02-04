package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Categorie;

public interface CategorieDAO extends DAO<Categorie> {

	public Categorie selectCategorieByNom(String libelle);

//	public Categorie selectCategorieById(int idCategorie);
}
