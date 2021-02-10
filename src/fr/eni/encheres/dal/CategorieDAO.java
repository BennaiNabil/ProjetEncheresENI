package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Categorie;

public interface CategorieDAO extends DAO<Categorie> {

	Categorie selectCategorieByNom(String libelle);

	Categorie selectCategorieById(int idCategorie);
}
