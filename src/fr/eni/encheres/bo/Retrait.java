package fr.eni.encheres.bo;

import java.io.Serializable;

/**
 * L'objet métier Retrait permet de reproduire les données de la table
 * Retrait, et modélise le retrait d'un article
 */

public class Retrait implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rue;
	private String codePostal;
	private String ville;
	private ArticleVendu articleVendu;

	/**
	 * Constructeur par défaut nécessaire à l'implémentation de l'interface
	 * Serializable
	 */
	public Retrait() {
		super();
	}

	/**
	 * Constructeur complet de la classe Retrait avec les paramètres suivants:
	 *
	 * @param rue          la rue du retrait
	 * @param codePostal   le code postal du retrait
	 * @param ville        la ville du retrait
	 * @param articleVendu l'article retiré
	 */
	public Retrait(String rue, String codePostal, String ville, ArticleVendu articleVendu) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}

	// Getters (Accesseurs) & Setters (Mutateurs)

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	/**
	 * Override de la méthode toString de la superclasse Object pour la classe
	 * Retrait
	 *
	 * @return strRetrait une represéntation textuelle du retrait
	 */
	@Override
	public String toString() {
		return String.format("Retrait{rue='%s', codePostal='%s', ville='%s', articleVendu=%s}", rue, codePostal, ville,
				articleVendu);
	}
}
