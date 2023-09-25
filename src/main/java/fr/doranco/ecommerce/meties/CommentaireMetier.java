package fr.doranco.ecommerce.meties;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Commentaire;
import fr.doranco.ecommerce.model.dao.CommentaireDao;
import fr.doranco.ecommerce.model.dao.ICommentaireDao;

public class CommentaireMetier  implements ICommentaireMetier{
	
	private final ICommentaireDao  commentaireDao = new CommentaireDao();


	@Override
	public Commentaire getCommentaires(Integer idArticle) throws Exception {
		
		return commentaireDao.getCommentaires(idArticle);
	}

	@Override
	public Commentaire getNbCommandesParVille() throws Exception {
		
		return commentaireDao.getNbCommandesParVille();
	}

	@Override
	public List<Commentaire> getCommentaires() throws Exception {
		
		return commentaireDao.getCommentaires();
	}

	@Override
	public Map<String, Article> getArticles() throws Exception {
		
		return commentaireDao.getArticle();
	}

	
	

	



	

}
