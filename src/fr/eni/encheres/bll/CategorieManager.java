package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;
import fr.eni.encheres.dal.DAOFactory;

public class CategorieManager {
	private CategorieDAO categorieDAO;
	
	public CategorieManager() {
		this.categorieDAO = DAOFactory.getCategorieDAO();
	}
	
	public Categorie selectCategorieByNom(String libelle) {
		return categorieDAO.selectCategorieByNom(libelle);
	}
	
//	public Categorie selectCategorieById(int idCategorie) {
//		return categorieDAO.selectCategorieById(idCategorie);
//	}

}
