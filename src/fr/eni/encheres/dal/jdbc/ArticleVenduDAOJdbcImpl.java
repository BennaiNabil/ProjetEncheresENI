package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleVenduDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ArticleVenduDAOJdbcImpl implements ArticleVenduDAO {
	
	private static final String INSERT = "INSERT INTO ARTICLES_VENDUS VALUES(?,?,?,?,?,?,?,?)";
	
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
			preparedStatement.setInt(6, articleVendu.getPrixVente());
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
        return null;
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
}
