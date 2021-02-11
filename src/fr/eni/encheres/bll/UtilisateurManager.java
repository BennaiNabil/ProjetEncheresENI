package fr.eni.encheres.bll;

import java.util.List;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private static final UtilisateurDAO daoUtilisateur;

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
		if (daoUtilisateur.checkUnicity(utilisateur.getPseudo(), utilisateur.getEmail())
				&& validerUtilisateur(utilisateur)) {
			System.out.println(utilisateur);
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
	 * Méthode pour récupérer les informations d'un utilisateur lors de sa
	 * connexion avec son pseudo
	 *
	 * @param pseudo
	 * @return
	 */
	public Utilisateur recupererUtilisateurParPseudo(String pseudo) {
		Utilisateur utilisateur = daoUtilisateur.selectByPseudo(pseudo);
		return utilisateur;
	}

	/**
	 * Méthode qui permet de valider les champs entrés lors de l'inscription de
	 * l'utilisateur Longueurs compatibles avec celles fixées par la base de
	 * données, et regex pour éviter toto comme adresse mail
	 *
	 * @param utilisateur
	 * @return
	 */
	public boolean validerUtilisateur(Utilisateur utilisateur) {

		// Définition des expressions régulières
		String pseudoRgx = "[A-Za-z0-9]+";
		String emailRgx = "^(.+)@(.+)$";
		String telephoneRgx = "^\\d{10}$";

		// Vérification des longueurs de champ
		if (!(utilisateur.getPseudo().length() <= 30 && utilisateur.getNom().length() <= 30
				&& utilisateur.getPrenom().length() <= 30 && utilisateur.getEmail().length() <= 20
				&& utilisateur.getTelephone().length() <= 15 && utilisateur.getRue().length() <= 30
				&& utilisateur.getCodePostal().length() <= 10 && utilisateur.getVille().length() <= 30
				&& utilisateur.getMotDePasse().length() <= 30)) {
			return false;
		}

		// Vérification
		return Pattern.matches(emailRgx, utilisateur.getEmail()) && Pattern.matches(pseudoRgx, utilisateur.getPseudo())
				&& Pattern.matches(telephoneRgx, utilisateur.getTelephone());
	}

	/**
	 * Méthode qui vérifie l'unicité du pseudo et de l'email
	 *
	 * @param pseudo
	 * @param email
	 * @return
	 */
	public boolean verifierUnicitePseudoEmail(String pseudo, String email) {
		return daoUtilisateur.checkUnicity(pseudo, email);
	}

	/**
	 * Méthode qui selectionne un utilisateur par son id
	 *
	 * @param id
	 * @return
	 */
	public Utilisateur selectionnerUtilisateurParID(int id) {
		return daoUtilisateur.selectById(id);
	}

	/**
	 * Méthode qui sélectionne un utilisateur par son pseudo
	 *
	 * @param pseudo
	 * @return
	 */
	public Utilisateur selectionnerUtilisateurParPseudo(String pseudo) {
		return daoUtilisateur.selectByPseudo(pseudo);
	}

	/**
	 * Méthode qui sélectionne tous les utilisateurs
	 *
	 * @return
	 */
	public List<Utilisateur> selectionnerTousLesUtilisateurs() {
		return daoUtilisateur.selectAll();
	}

	/**
	 * Méthode qui modifie un utilisateur
	 *
	 * @param utilisateur
	 */
	public void modifierUtilisateur(Utilisateur utilisateur) {
		daoUtilisateur.update(utilisateur);
	}

	/**
	 * Méthode qui supprime un utilisateur
	 *
	 * @param utilisateur
	 */
	public void supprimerUtilisateur(Utilisateur utilisateur) {
		daoUtilisateur.delete(utilisateur);
	}

	public void updateCreditDown(Utilisateur encherisseurNew, Enchere enchere) {
		daoUtilisateur.updateCreditDown(encherisseurNew, enchere);
	}

	public void updateCreditUp(Utilisateur encherisseurOld, Enchere enchere) {
		daoUtilisateur.updateCreditUp(encherisseurOld, enchere);
	}

}