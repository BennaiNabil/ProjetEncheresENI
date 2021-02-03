package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.EnchereDAO;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String SELECT_ALL = "Select ARTICLES_VENDUS.nom_article, ARTICLES_VENDUS.description, ARTICLES_VENDUS.date_debut_encheres, ARTICLES_VENDUS.date_fin_encheres, ARTICLES_VENDUS.prix_initial, ARTICLES_VENDUS.no_utilisateur FROM ENCHERES"
			+ " INNER JOIN ARTICLES_VENDUS on ENCHERES.no_article = ARTICLES_VENDUS.no_article;";
	private static final String DELETE = "DELETE FROM ENCHERES WHERE no_utilisateur=?";

	@Override
	public void insert(Enchere object) {

	}

	@Override
	public Enchere selectById(int id) {
		return null;
	}

	@Override
	public List<Enchere> selectAll() {
		Statement statement = null;
		ResultSet resultSet = null;
		List<Enchere> listeEncheres = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL);

//			while (resultSet.next()) {
//				listeEncheres.add(new Enchere(resultSet.getDate("date_debut_encheres").toLocalDate(),
//						resultSet.getInt("prix_initial"), (Utilisateur) resultSet.getObject("no_utilisateur"),
//						(ArticleVendu) resultSet.getObject("no_article")));
//			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(statement, resultSet);
		}
		return listeEncheres;
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
