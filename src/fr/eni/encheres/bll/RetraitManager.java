package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitManager {
	private static final RetraitDAO retraitDAO;

	static {
		retraitDAO = DAOFactory.getRetraitDAO();
	}

	public void insertRetrait(Retrait retrait) {
		retraitDAO.insert(retrait);
	}

}
