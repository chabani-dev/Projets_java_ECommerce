package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Commentaire;


public interface ICommentaireDao {
	
	
	public void addCommentaire(Commentaire commentaire) throws Exception;
	
	public Commentaire getCommentaires(Integer idArticle) throws Exception;

	public void removeCommentaire(Integer id) throws Exception ;

	public  List<Commentaire> getCommentaires() throws Exception;
	
	public  Map<String , Article> getArticle() throws Exception;
	
	public Commentaire getNbCommandesParVille() throws Exception ;

}
