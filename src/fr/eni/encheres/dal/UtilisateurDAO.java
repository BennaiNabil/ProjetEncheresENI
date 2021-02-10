package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;

public interface UtilisateurDAO extends DAO<Utilisateur> {

	Utilisateur sontBonsIdentifiantsDeConnexion(String pseudoUtilisateur, String motDePasse);

	Utilisateur selectByPseudo(String pseudo);

	boolean checkUnicity(String pseudo, String email);

	void updateCreditDown (Utilisateur encherisseurNew, Enchere enchere);
	
	void updateCreditUp (Utilisateur encherisseurOld, Enchere enchere);
}
