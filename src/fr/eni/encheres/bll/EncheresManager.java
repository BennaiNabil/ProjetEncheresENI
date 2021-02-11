package fr.eni.encheres.bll;

import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EncheresManager {
	private final EnchereDAO enchereDAO;

	public EncheresManager() {
		this.enchereDAO = DAOFactory.getEnchereDAO();
	}

	public List<Enchere> selectAll() {
		return this.enchereDAO.selectAll();
	}

	public List<ArticleVendu> recupererEncheresEnCoursParCategorie(String cate) {
		return this.enchereDAO.selectArticleByLibCategorie(cate);
	}

	public List<ArticleVendu> recupererEncheresCourantes() {
		return this.enchereDAO.selectAllCurrent();
	}

	public List<Enchere> selectByIdArticle(int id) {
		return this.enchereDAO.selectByIdArticle(id);
	}

	public void insert(Enchere enchere) throws BLLException {
		if (montantEnchereEstValide(enchere) && montantCreditEstValide(enchere)) {
			enchereDAO.insert(enchere);
		} else {
			throw new BLLException();
		}
	}

	public Enchere derniereEnchere(Enchere enchere) {
		int idArticle = enchere.getArticleVendu().getNoArticle();
		EncheresManager enchereManager = new EncheresManager();
		List<Enchere> listeEnchere;
		listeEnchere = enchereManager.selectByIdArticle(idArticle);
		if (listeEnchere.isEmpty()) {
			return enchere;
		} else {
			return listeEnchere.get(listeEnchere.size() - 1);
		}
	}

	public boolean montantEnchereEstValide(Enchere enchere) {
		/*
		 * Permet de vérifier que le montant proposé par le nouvel enchérisseur est
		 * bien supérieur au montant actuel de l'article
		 */

		// 1. Récupérer le montant précédent
		int idArticle = enchere.getArticleVendu().getNoArticle();
		EncheresManager enchereManager = new EncheresManager();
		List<Enchere> listeEnchere;
		listeEnchere = enchereManager.selectByIdArticle(idArticle);

		// 2.a. Si aucune enchère n'a été réalisée - comparer les deux montants
		if (listeEnchere.isEmpty()) {
			int montantPrecedent = enchere.getArticleVendu().getMiseAPrix();
			return (!(enchere.getMontantEnchere() <= montantPrecedent));
		}

		// 2.b. Si il y a déjà eu des enchères - comparer les deux montants
		else {
			Enchere encherePrecedente = listeEnchere.get(listeEnchere.size() - 1);
			int montantPrecedent = encherePrecedente.getMontantEnchere();
			return (!(enchere.getMontantEnchere() <= montantPrecedent));
		}
	}

	public boolean montantCreditEstValide(Enchere enchere) {
		/*
		 * Récupére le montant de l'enchere et le crédit de l'utilisateur et vérifie
		 * que l'utilisateur a le crédit suffisant pour enchérir
		 */
		return (!(enchere.getMontantEnchere() > (enchere.getEncherisseur().getCredit())));
	}

}