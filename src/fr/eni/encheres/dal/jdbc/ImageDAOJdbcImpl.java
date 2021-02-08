package fr.eni.encheres.dal.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.eni.encheres.bo.Image;
import fr.eni.encheres.dal.ImageDAO;

public class ImageDAOJdbcImpl implements ImageDAO{
	private static final String INSERT = "INSERT INTO IMAGES VALUES(?,?)";

	@Override
	public void insert(Image image) {
		PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	FileInputStream fis = null;
    	try (Connection connection = ConnectionProvider.getConnection()) {

    		
    		
    	} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Image selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Image> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Image object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Image object) {
		// TODO Auto-generated method stub
		
	}

}
