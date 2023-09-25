package fr.doranco.ecommerce.main;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.model.dao.ArticleDao;


public class MainArticle {

	public static void main(String[] args) {
	    try {
	        ArticleDao articleDao = new ArticleDao();

	        Article article1 = new Article();
	        article1.setNom("nom");
	        article1.setDescription("java cours");
	        article1.setIsVendable(true);
	        article1.setPhotos("image.png");
	        article1.setVideos("image.jpg");
	        article1.setPrix(25F);
	        article1.setRemise(20);
	        article1.setStock(33);

	        articleDao.addArticle(article1); // Save article1 to the database

	        Article retrievedArticle = articleDao.getArticle(1); // Assuming 1 is the ID of the article you want to retrieve

	        System.out.println("Retrieved Article:");
	        System.out.println(retrievedArticle);

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    System.exit(0);
	}


}
