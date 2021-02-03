package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.EnchereDAO;

public class EncheresManager {
	private EnchereDAO enchereDAO;
	
	public EncheresManager() {
		this.enchereDAO = fr.eni.encheres.dal.DAOFactory.getEnchereDAO();
	}
	
	public List<Enchere> selectAll(){
		return this.enchereDAO.selectAll();
	}

}
