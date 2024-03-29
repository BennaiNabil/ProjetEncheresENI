package fr.eni.encheres.bo;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;

public class Image implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;

	private ArticleVendu article;
	private File image;

	public Image() {

	}

	public Image(ArticleVendu article, File image) {
		this.article = article;
		this.image = image;
	}

	public ArticleVendu getArticle() {
		return article;
	}

	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

}
