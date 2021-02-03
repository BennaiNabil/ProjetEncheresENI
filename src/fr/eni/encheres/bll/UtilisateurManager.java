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

	/**
	 * Méthode pour récupérer les informations d'un utilisateur lors de sa connexion
	 * avec son pseudo
	 * 
	 * @param pseudo
	 * @return
	 */
	public Utilisateur recupererUtilisateurParPseudo(String pseudo) {

		Utilisateur utilisateur = daoUtilisateur.selectByPseudo(pseudo);

		return utilisateur;
	}

}
