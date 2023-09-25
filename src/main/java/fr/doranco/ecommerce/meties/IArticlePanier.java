package fr.doranco.ecommerce.meties;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.User;

public interface IArticlePanier {
	
	
	
	public void  AddArticlePanier (User user ,int id) throws Exception;
	
	public List<Article> getArticle() throws Exception;
	
	
	

}
