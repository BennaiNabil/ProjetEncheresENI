package fr.eni.encheres.dal.jdbc;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.CategorieDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CategorieDAOJdbcImpl implements CategorieDAO {
	
	private static final String SELECT_BY_NOM_CATE = "SELECT * FROM CATEGORIES WHERE libelle = ?";
	
	@Override
	public void insert(Categorie object) {

	}

	@Override
	public Categorie selectById(int id) {
		return null;
	}

	@Override
	public List<Categorie> selectAll() {
		return null;
	}

	@Override
	public void update(Categorie object) {

	}

	@Override
	public void delete(Categorie object) {

	}

	public Categorie selectCategorieByNom(String libelle) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Categorie categorie = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(SELECT_BY_NOM_CATE);
			preparedStatement.setString(1, libelle);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				categorie = new Categorie(resultSet.getInt("no_categorie"), resultSet.getString("libelle"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
		return categorie;
	}
	
//	
//	@Override
//	public Categorie selectCategorieById(int idCategorie) {
//		PreparedStatement preparedStatement = null;
//		ResultSet resultSet = null;
//		Categorie categorie = null;
//		try (Connection connection = ConnectionProvider.getConnection()) {
//			preparedStatement = connection.prepareStatement(SELECT_BY_NOM_CATE);
//			preparedStatement.setInt(1, idCategorie);
//			resultSet = preparedStatement.executeQuery();
//
//			if (resultSet.next()) {
//				categorie = new Categorie(resultSet.getInt("no_categorie"), resultSet.getString("libelle"));
//			}
//		} catch (SQLException throwables) {
//			throwables.printStackTrace();
//		} finally {
//			closeResources(preparedStatement, resultSet);
//		}
//		return categorie;
//	}

	
	
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
/*

libelle : String
CategorieDAOJdbcImpl.selectCategorieByNom(libelle) -> Categorie
Categorie.getId()

*/

