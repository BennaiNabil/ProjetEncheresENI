package fr.eni.encheres.bo;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultat {

	public static final int CONNEXION_BDD_ERREUR = 10000;

	public static final int CONNEXION_ERREUR = 18000;

	public static final int CREATION_USER_ERREUR = 18001;
	
	public static final int CREATION_ARTICLE_ERREUR = 18002;
	
	public static final int CREATION_ARTICLE_SUCCESS = 18003;

	public static final int CORE_ERREUR = 19999;

}
