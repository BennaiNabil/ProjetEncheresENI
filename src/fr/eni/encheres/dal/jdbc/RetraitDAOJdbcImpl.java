package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.dal.RetraitDAO;

public class RetraitDAOJdbcImpl implements RetraitDAO {
	private static final String INSERT = "INSERT INTO RETRAITS VALUES(?,?,?,?)";

	@Override
	public void insert(Retrait retrait) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, retrait.getArticleVendu().getNoArticle());
			preparedStatement.setString(2, retrait.getRue());
			preparedStatement.setString(3, retrait.getCodePostal());
			preparedStatement.setString(4, retrait.getVille());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
	}

	@Override
	public Retrait selectById(int id) {
		return null;
	}

	@Override
	public List<Retrait> selectAll() {
		return null;
	}

	@Override
	public void update(Retrait object) {

	}

	@Override
	public void delete(Retrait object) {

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
