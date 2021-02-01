package fr.eni.encheres.bo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * L'objet métier ArticleVendu permet de reproduire les données de la table
 * ArticleVendu, et modélise un article vendu
 */
public class ArticleVendu implements Serializable {

	private static final long serialVersionUID = 1L;

	private int noArticle;
	private String nomArticle;
	private String description;
	private LocalDate dateDebutEncheres;
	private LocalDate dateFinEncheres;
	private int miseAPrix;
	private int prixVente;
	private String etatVente;
	private Categorie categorie;
	private List<Enchere> listeEncheres;
	private Utilisateur vendeur;
	private Utilisateur acheteur;
	private Retrait retrait;

	/**
	 * Constructeur par défaut nécessaire à l'implémentation de l'interface
	 * Serializable
	 */
	public ArticleVendu() {
		super();
	}

	/**
	 * Constructeur complet de la classe ArticleVendu avec les paramètres suivants:
	 *
	 * @param noArticle         le numéro de l'article
	 * @param nomArticle        le nom de l'article
	 * @param description       la description de l'article
	 * @param dateDebutEncheres la date du début des enchères de l'article
	 * @param dateFinEncheres   la date de fin des enchères de l'article
	 * @param miseAPrix         la mise à prix de l'article
	 * @param prixVente         le prix de vente de l'article
	 * @param etatVente         l'état de vente de l'article
	 * @param categorie         la catégorie de l'article
	 * @param listeEncheres     la liste des enchères concernant l'article
	 * @param vendeur           le vendeur de l'article
	 * @param acheteur          l'acheteur de l'article
	 * @param retrait           le retrait correspondant à l'article
	 */
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate dateDebutEncheres,
			LocalDate dateFinEncheres, int miseAPrix, int prixVente, String etatVente, Categorie categorie,
			List<Enchere> listeEncheres, Utilisateur vendeur, Utilisateur acheteur, Retrait retrait) {
		this.setNoArticle(noArticle);
		this.setNomArticle(nomArticle);
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.listeEncheres = listeEncheres;
		this.vendeur = vendeur;
		this.acheteur = acheteur;
		this.retrait = retrait;
	}

	// Getters (Accesseurs) & Setters (Mutateurs)

	public int getNoArticle() {
		return noArticle;
	}

	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDateDebutEncheres() {
		return dateDebutEncheres;
	}

	public void setDateDebutEncheres(LocalDate dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}

	public LocalDate getDateFinEncheres() {
		return dateFinEncheres;
	}

	public void setDateFinEncheres(LocalDate dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}

	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}

	public Utilisateur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}

	public Utilisateur getAcheteur() {
		return acheteur;
	}

	public void setAcheteur(Utilisateur acheteur) {
		this.acheteur = acheteur;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}

	/**
	 * Override de la méthode toString de la superclasse Object pour la classe
	 * ArticleVendu
	 *
	 * @return strArticleVendu une represéntation textuelle de l'article vendu
	 */
	@Override
	public String toString() {
		String strArticleVendu = String.format(
				"ArticleVendu{noArticle=%d, nomArticle='%s', description='%s', dateDebutEncheres=%s, "
						+ "dateFinEncheres=%s, miseAPrix=%d, prixVente=%d, etatVente='%s', categorie=%s, "
						+ "listeEncheres=%s, vendeur=%s, acheteur=%s, retrait=%s}",
				getNoArticle(), getNomArticle(), description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente,
				etatVente, categorie, listeEncheres, vendeur, acheteur, retrait);
		return strArticleVendu;
	}
}
