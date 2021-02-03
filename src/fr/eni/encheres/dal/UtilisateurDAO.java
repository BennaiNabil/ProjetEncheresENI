package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO extends DAO<Utilisateur> {

	Utilisateur sontBonsIdentifiantsDeConnexion(String pseudoUtilisateur, String motDePasse);

	Utilisateur selectByPseudo(String pseudo);

	boolean checkUnicity(String pseudo, String email);

}
