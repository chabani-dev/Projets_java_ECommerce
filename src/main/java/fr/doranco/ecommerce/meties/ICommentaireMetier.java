package fr.doranco.ecommerce.meties;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Commentaire;


public interface ICommentaireMetier {
	
	
	public Commentaire getCommentaires(Integer idArticle) throws Exception ;
	
	
	public Commentaire getNbCommandesParVille() throws Exception ;
	
	
	public List<Commentaire> getCommentaires() throws Exception;
	
	public Map< String , Article> getArticles() throws Exception;
	

	
}
