package fr.eni.encheres.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * L'objet métier Utilisateur permet de reproduire les données de la table
 * Utilisateur, et modélise un utilisateur de l'application
 */
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;

	private int noUtilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String codePostal;
	private String ville;
	private String motDePasse;
	private int credit;
	private boolean estAdministrateur;
	private List<ArticleVendu> vente = new ArrayList<>();
	private List<ArticleVendu> listeArticlesAchete = new ArrayList<>();
	private List<Enchere> listeEncheres = new ArrayList<>();

	/**
	 * Constructeur par défaut nécessaire à l'implémentation de l'interface
	 * Serializable
	 */
	public Utilisateur() {
		super();
	}

	/**
	 * Constructeur de la classe Utilisateur avec les paramètres suivants:
	 *
	 * @param noUtilisateur     le numéro de l'utilisateur
	 * @param pseudo            le pseudo de l'utilisateur
	 * @param nom               le nom de l'utilisateur
	 * @param prenom            le prénom de l'utilisateur
	 * @param email             l'adresse mail de l'utilisateur
	 * @param telephone         le numéro de téléphone de l'utilisateur
	 * @param rue               la rue de l'adresse de l'utilisateur
	 * @param codePostal        le code postal de l'adresse de l'utilisateur
	 * @param ville             la ville de l'utilisateur
	 * @param motDePasse        le mot de passe de l'utilisateur
	 * @param credit            le nombre de crédits (points) de l'utilisateur
	 * @param estAdministrateur le caractère administrateur de l'utilisateur
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean estAdministrateur) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.estAdministrateur = estAdministrateur;
	}

	/**
	 * Constructeur complet de la classe Utilisateur avec les paramètres suivants:
	 *
	 * @param noUtilisateur       le numéro de l'utilisateur
	 * @param pseudo              le pseudo de l'utilisateur
	 * @param nom                 le nom de l'utilisateur
	 * @param prenom              le prénom de l'utilisateur
	 * @param email               l'adresse mail de l'utilisateur
	 * @param telephone           le numéro de téléphone de l'utilisateur
	 * @param rue                 la rue de l'adresse de l'utilisateur
	 * @param codePostal          le code postal de l'adresse de l'utilisateur
	 * @param ville               la ville de l'utilisateur
	 * @param motDePasse          le mot de passe de l'utilisateur
	 * @param credit              le nombre de crédits (points) de l'utilisateur
	 * @param estAdministrateur   le caractère administrateur de l'utilisateur
	 * @param vente               la liste des articles vendus par l'utilisateur
	 * @param listeArticlesAchete la liste des articles achetés par l'utilisateur
	 * @param listeEncheres       la liste des enchères auquelles l'utilisateur a
	 *                            participé
	 */
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, int credit, boolean estAdministrateur,
			List<ArticleVendu> vente, List<ArticleVendu> listeArticlesAchete, List<Enchere> listeEncheres) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.estAdministrateur = estAdministrateur;
		this.vente = vente;
		this.listeArticlesAchete = listeArticlesAchete;
		this.listeEncheres = listeEncheres;
	}

	// =================== Getters (Accesseurs) & Setters (Mutateurs)
	// ===================

	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

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

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public boolean isEstAdministrateur() {
		return estAdministrateur;
	}

	public void setEstAdministrateur(boolean estAdministrateur) {
		this.estAdministrateur = estAdministrateur;
	}

	public List<ArticleVendu> getVente() {
		return vente;
	}

	public void setVente(List<ArticleVendu> vente) {
		this.vente = vente;
	}

	public List<ArticleVendu> getListeArticlesAchete() {
		return listeArticlesAchete;
	}

	public void setListeArticlesAchete(List<ArticleVendu> listeArticlesAchete) {
		this.listeArticlesAchete = listeArticlesAchete;
	}

	public List<Enchere> getListeEncheres() {
		return listeEncheres;
	}

	public void setListeEncheres(List<Enchere> listeEncheres) {
		this.listeEncheres = listeEncheres;
	}

	/**
	 * Override de la méthode toString de la superclasse Object pour la classe
	 * Utilisateur
	 *
	 * @return strUtilisateur une représentation textuelle de l'utilisateur
	 */
	@Override
	public String toString() {
		return String.format(
				"Utilisateur{noUtilisateur=%d, pseudo='%s', nom='%s', prenom='%s', email='%s', telephone='%s', "
						+ "rue='%s', codePostal='%s', ville='%s', motDePasse='%s', credit=%d, estAdministrateur=%s, "
						+ "vente=%s, listeArticlesAchete=%s, listeEncheres=%s}",
				noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credit,
				estAdministrateur, vente, listeArticlesAchete, listeEncheres);
	}
}
