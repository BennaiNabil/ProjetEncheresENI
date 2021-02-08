package fr.eni.encheres.bll;


import fr.eni.encheres.bo.Image;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.ImageDAO;


public class ImageManager {
	private static ImageDAO imageDAO;
	
	static {
		imageDAO = DAOFactory.getImageDAO();
	}

	public void insertRetrait(Image image) {
		imageDAO.insert(image);
	}

}
