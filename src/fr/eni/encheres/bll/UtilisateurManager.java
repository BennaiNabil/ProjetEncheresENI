package fr.eni.encheres.bll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static UtilisateurDAO daoUtilisateur;

	static {
		daoUtilisateur = DAOFactory.getUtilisateurDAO();
	}

	/**
	 * Méthode qui va venir vérifier et inscrire un utilisateur
	 * 
	 * @param utilisateur
	 * @throws BLLException
	 */
	public void nouvelUtilisateur(Utilisateur utilisateur) throws BLLException {
		if (daoUtilisateur.checkUnicity(utilisateur.getPseudo(), utilisateur.getEmail())) {
			daoUtilisateur.insert(utilisateur);
		} else {
			throw new BLLException();
		}
	}

	/**
	 * Méthode pour valdier la connexion de l'utilisateur
	 * 
	 * @param pseudo
	 * @param mdp
	 * @return
	 */
	public boolean validerConnexion(String pseudo, String mdp) {
		return daoUtilisateur.sontBonsIdentifiantsDeConnexion(pseudo, mdp) != null;

	}

}
