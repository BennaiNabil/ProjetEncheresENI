package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManager {
	private final CategorieDAO categorieDAO;

	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}

	public Categorie selectCategorieByNom(String libelle) {
		return categorieDAO.selectCategorieByNom(libelle);
	}

	public List<Categorie> selectionnerToutesLesCategories() {
		return categorieDAO.selectAll();
	}

	public Categorie selectCategorieById(int idCategorie) {
		return categorieDAO.selectCategorieById(idCategorie);
	}

}
