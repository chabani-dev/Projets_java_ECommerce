package fr.doranco.ecommerce.model.dao;


import java.util.List;


import fr.doranco.ecommerce.entity.pojo.Article;



public interface IArticleDao {
	
	
	
	public void addArticle(Article article) throws Exception;
	
	
	public Article getArticle(int idArticle) throws Exception ;
	
	

	public void removeArticle(Integer id) throws Exception ;


	public  List<Article> getArticle() throws Exception;
	
	

}
