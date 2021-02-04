package fr.eni.encheres.bll;

import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitManager {
	private static RetraitDAO retraitDAO;
	
	static {
		retraitDAO = DAOFactory.getRetraitDAO();
	}

}
