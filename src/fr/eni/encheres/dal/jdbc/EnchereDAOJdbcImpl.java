package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.EnchereDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnchereDAOJdbcImpl implements EnchereDAO {
	private static final String SELECT_ALL = "Select ARTICLES_VENDUS.nom_article, ARTICLES_VENDUS.description, ARTICLES_VENDUS.date_debut_encheres, ARTICLES_VENDUS.date_fin_encheres, ARTICLES_VENDUS.prix_initial, ARTICLES_VENDUS.no_utilisateur FROM ENCHERES"
			+ " INNER JOIN ARTICLES_VENDUS on ENCHERES.no_article = ARTICLES_VENDUS.no_article;";

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
	public void delete(Enchere object) {

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
