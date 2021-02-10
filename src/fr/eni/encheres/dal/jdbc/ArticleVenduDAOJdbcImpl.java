package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;
import fr.eni.encheres.dal.DAOFactory;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {

	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS VALUES(?,?,?,?,?,?,?,?)";
	private static final String SELECT_BY_ID = "SELECT * FROM ARTICLES_VENDUS WHERE no_article=?";
	private static final String UPDATE_PRIX_VENTE = "UPDATE ARTICLES_VENDUS SET prix_vente = ? WHERE no_article = ?";
	
	@Override
	public void insert(ArticleVendu articleVendu) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, articleVendu.getNomArticle());
			preparedStatement.setString(2, articleVendu.getDescription());
			preparedStatement.setDate(3, java.sql.Date.valueOf(articleVendu.getDateDebutEncheres()));
			preparedStatement.setDate(4, java.sql.Date.valueOf(articleVendu.getDateFinEncheres()));
			preparedStatement.setInt(5, articleVendu.getMiseAPrix());
			preparedStatement.setInt(6, articleVendu.getMiseAPrix());
			Utilisateur vendeur = articleVendu.getVendeur();
			int idVendeur = vendeur.getNoUtilisateur();
			preparedStatement.setInt(7, idVendeur);
			Categorie categorie = articleVendu.getCategorie();
			int idCategorie = categorie.getNoCategorie();
			preparedStatement.setInt(8, idCategorie);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				articleVendu.setNoArticle(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
	}

	@Override
	public ArticleVendu selectById(int id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArticleVendu articleVendu = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(SELECT_BY_ID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				articleVendu = new ArticleVendu(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getDate(4).toLocalDate(), resultSet.getDate(5).toLocalDate(), resultSet.getInt(6),
						resultSet.getInt(7), DAOFactory.getUtilisateurDAO().selectById(resultSet.getInt(8)),
						DAOFactory.getCategorieDAO().selectById(resultSet.getInt(9)));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
		return articleVendu;
	}

	@Override
	public List<ArticleVendu> selectAll() {
		return null;
	}

	@Override
	public void update(ArticleVendu object) {

	}

	@Override
	public void delete(ArticleVendu object) {

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

	@Override
//	Permet de mettre à jour le prix d'un article après une enchère.
	public void updatePrixVente(ArticleVendu article, Enchere enchere) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(UPDATE_PRIX_VENTE);
			preparedStatement.setInt(1, (enchere.getMontantEnchere()));
			preparedStatement.setInt(2, article.getNoArticle());
			preparedStatement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
	}
}
