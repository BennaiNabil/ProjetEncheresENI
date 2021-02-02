package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurDAO daoUtilisateur;

	static {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}

	public void nouvelUtilisateur(Utilisateur utilisateur) throws BLLException {
		if (daoUtilisateur.selectByPseudo(utilisateur.getPseudo()) == null) {
			daoUtilisateur.insert(utilisateur);
		} else {
			throw new BLLException();
		}
	}

}
