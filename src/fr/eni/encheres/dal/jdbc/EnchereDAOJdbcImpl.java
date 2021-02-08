package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String SELECT_ALL = "Select ARTICLES_VENDUS.nom_article, ARTICLES_VENDUS.description, ARTICLES_VENDUS.date_debut_encheres, ARTICLES_VENDUS.date_fin_encheres, ARTICLES_VENDUS.prix_initial, ARTICLES_VENDUS.no_utilisateur FROM ENCHERES"
			+ " INNER JOIN ARTICLES_VENDUS on ENCHERES.no_article = ARTICLES_VENDUS.no_article;";

	private static final String DELETE = "DELETE FROM ENCHERES WHERE no_utilisateur=?";

	private static final String INSERT = "INSERT INTO ENCHERES VALUES (?,?,?,?)";

	private static final String SELECT_BY_LIBELLE = "select CATEGORIES.libelle, table_Articles.no_article "
			+ "from ARTICLES_VENDUS as table_Articles " + "inner join CATEGORIES on "
			+ "CATEGORIES.no_categorie = table_Articles.no_categorie "
			+ "where CATEGORIES.libelle = ? and table_Articles.date_debut_encheres < getdate() and table_Articles.date_fin_encheres > getdate()";

	@Override
	public List<ArticleVendu> selectArticleByLibCategorie(String libelle) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<ArticleVendu> listeArticles = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(SELECT_BY_LIBELLE);
			preparedStatement.setString(1, libelle);
			resultSet = preparedStatement.executeQuery();
			int noArticle;
			while (resultSet.next()) {
				noArticle = resultSet.getInt(2);
				listeArticles.add(DAOFactory.getArticleVenduDAO().selectById(noArticle));
			}

		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
		return listeArticles;

	}

	@Override
	public void insert(Enchere enchere) {
		PreparedStatement preparedStatement = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, enchere.getEncherisseur().getNoUtilisateur());
			preparedStatement.setInt(2, enchere.getArticleVendu().getNoArticle());
			preparedStatement.setObject(3, enchere.getDateEnchere());
			preparedStatement.setInt(4, enchere.getMontantEnchere());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(preparedStatement, null);
		}
	}

	@Override
	public Enchere selectById(int id) {
		return null;
	}

	@Override
	public List<Enchere> selectAll() {
		return null;
	}

	@Override
	public void update(Enchere object) {

	}

	@Override
	public void delete(Enchere enchere) {
		PreparedStatement preparedStatement = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, enchere.getEncherisseur().getNoUtilisateur());
			preparedStatement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, null);
		}

	}

	private void closeResources(Statement preparedStatement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}
}
