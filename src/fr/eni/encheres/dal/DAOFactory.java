package fr.eni.encheres.dal;

import fr.eni.encheres.dal.jdbc.*;

public class DAOFactory {

    // Attributs statiques xxxDAO initialisés à null pour l'intégration dans le Design Pattern Singleton
    private static ArticleVenduDAO instanceArticleVenduDAO = null;
    private static CategorieDAO instanceCategorieDAO = null;
    private static EnchereDAO instanceEnchereDAO = null;
    private static RetraitDAO instanceRetraitDAO = null;
    private static UtilisateurDAO instanceUtilisateurDAO = null;
    private static ImageDAO instanceImageDAO = null;

    /**
     * Méthode statique qui renvoie une instance unique de ArticleVenduDAO
     *
     * @return instanceArticleVenduDAO une instance de ArticleVenduDAO
     */
    public static ArticleVenduDAO getArticleVenduDAO() {
        if (instanceArticleVenduDAO == null) {
            instanceArticleVenduDAO = new ArticleVenduDAOJdbcImpl();
        }
        return instanceArticleVenduDAO;
    }

    /**
     * Méthode statique qui renvoie une instance unique de CategorieDAO
     *
     * @return instanceCategorieDAO une une instance de CategorieDAO
     */
    public static CategorieDAO getCategorieDAO() {
        if (instanceCategorieDAO == null) {
            instanceCategorieDAO = new CategorieDAOJdbcImpl();
        }
        return instanceCategorieDAO;
    }

    /**
     * Méthode statique qui renvoie une instance unique de EnchereDAO
     *
     * @return instanceEnchereDAO une une instance de EnchereDAO
     */
    public static EnchereDAO getEnchereDAO() {
        if (instanceEnchereDAO == null) {
            instanceEnchereDAO = new EnchereDAOJdbcImpl();
        }
        return instanceEnchereDAO;
    }

    /**
     * Méthode statique qui renvoie une instance unique de RetraitDAO
     *
     * @return instanceRetraitDAO une une instance de RetraitDAO
     */
    public static RetraitDAO getRetraitDAO() {
        if (instanceRetraitDAO == null) {
            instanceRetraitDAO = new RetraitDAOJdbcImpl();
        }
        return instanceRetraitDAO;
    }

    /**
     * Méthode statique qui renvoie une instance unique de UtilisateurDAO
     *
     * @return instanceUtilisateurDAO une une instance de UtilisateurDAO
     */
    public static UtilisateurDAO getUtilisateurDAO() {
        if (instanceUtilisateurDAO == null) {
            instanceUtilisateurDAO = new UtilisateurDAOJdbcImpl();
        }
        return instanceUtilisateurDAO;
    }
    
    /**
     * Méthode statique qui renvoie une instance unique de ImageDAO
     *
     * @return instanceCategorieDAO une une instance de ImageDAO
     */
    public static ImageDAO getImageDAO() {
        if (instanceImageDAO == null) {
            instanceImageDAO = new ImageDAOJdbcImpl();
        }
        return instanceImageDAO;
    }
}
