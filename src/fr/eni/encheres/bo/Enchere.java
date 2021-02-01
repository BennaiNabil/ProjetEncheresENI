package fr.eni.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * L'objet métier Enchere permet de reproduire les données de la table Enchere,
 * et modélise un enchère
 */
public class Enchere implements Serializable {

	private static final long serialVersionUID = 1L;

	private LocalDate dateEnchere;
	private int montantEnchere;
	private Utilisateur encherisseur;
	private ArticleVendu articleVendu;

	/**
	 * Constructeur par défaut nécessaire à l'implémentation de l'interface
	 * Serializable
	 */
	public Enchere() {
		super();
	}

	/**
	 * Constructeur complet de la classe Enchere avec les paramètres suivants:
	 *
	 * @param dateEnchere    la date de l'enchère
	 * @param montantEnchere le montant de l'enchère
	 * @param encherisseur   l'utilisateur correspondant à l'encherisseur
	 * @param articleVendu   l'article vendu lors de l'enchère
	 */
	public Enchere(LocalDate dateEnchere, int montantEnchere, Utilisateur encherisseur, ArticleVendu articleVendu) {
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.encherisseur = encherisseur;
		this.articleVendu = articleVendu;
	}

	// Getters (Accesseurs) & Setters (Mutateurs)

	public LocalDate getDateEnchere() {
		return dateEnchere;
	}

	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}

	public int getMontantEnchere() {
		return montantEnchere;
	}

	public void setMontantEnchere(int montantEnchere) {
		this.montantEnchere = montantEnchere;
	}

	public Utilisateur getEncherisseur() {
		return encherisseur;
	}

	public void setEncherisseur(Utilisateur encherisseur) {
		this.encherisseur = encherisseur;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	/**
	 * Override de la méthode toString de la superclasse Object pour la classe
	 * Enchere
	 *
	 * @return strEnchere une represéntation textuelle de l'enchère
	 */
	@Override
	public String toString() {
		String strEnchere = String.format(
				"Enchere{dateEnchere=%s, montantEnchere=%d, encherisseur=%s, articleVendu=%s}", dateEnchere,
				montantEnchere, encherisseur, articleVendu);
		return strEnchere;
	}
}
