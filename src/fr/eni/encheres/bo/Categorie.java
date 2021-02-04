package fr.eni.encheres.bo;

import java.io.Serializable;
import java.util.List;

/**
 * L'objet métier Categorie permet de reproduire les données de la table
 * Categorie, et modélise une catégorie d'articles
 */
public class Categorie implements Serializable {

	private static final long serialVersionUID = 1L;

	private int noCategorie;
	private String libelle;
	private List<ArticleVendu> articlesVendus;

	/**
	 * Constructeur par défaut nécessaire à l'implémentation de l'interface
	 * Serializable
	 */
	public Categorie() {
		super();
	}

	/**
	 * Constructeur complet de la classe Catagorie avec les paramètres suivants:
	 *
	 * @param noCategorie    le numéro de la catégorie
	 * @param libelle        le libellé de la catégorie
	 * @param articlesVendus la liste des articles appartenant à la catégorie
	 */
	public Categorie(int noCategorie, String libelle, List<ArticleVendu> articlesVendus) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articlesVendus = articlesVendus;
	}
	
	/**
	 * Constructeur complet de la classe Catagorie avec les paramètres suivants:
	 *
	 * @param noCategorie    le numéro de la catégorie
	 * @param libelle        le libellé de la catégorie
	 */
	public Categorie(int noCategorie, String libelle) {
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}

	// Getters (Accesseurs) & Setters (Mutateurs)

	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<ArticleVendu> getArticlesVendus() {
		return articlesVendus;
	}

	public void setArticlesVendus(List<ArticleVendu> articlesVendus) {
		this.articlesVendus = articlesVendus;
	}

	/**
	 * Override de la méthode toString de la superclasse Object pour la classe
	 * Categorie
	 *
	 * @return strCategorie une represéntation textuelle de la catégorie
	 */

	@Override
	public String toString() {
		String strCategorie = String.format("Categorie{noCategorie=%d, libelle='%s', articlesVendus=%s}", noCategorie,
				libelle, articlesVendus);
		return strCategorie;
	}
}
