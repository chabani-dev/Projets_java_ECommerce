package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.ecommerce.entity.pojo.Commentaire;
import fr.doranco.hibernate.model.connect.HeberniteDataSource;

public class CommentaireDao implements ICommentaireDao {

	@Override
	public void addCommentaire(Commentaire commentaire) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(commentaire);

			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e; // Rejetez l'exception après avoir effectué le rollback
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void removeCommentaire(Integer id) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Commentaire commentaire = session.find(Commentaire.class, id);
			if (commentaire != null) {
				session.remove(commentaire);
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@Override
	public List<Commentaire> getCommentaires() throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		List<Commentaire> commentaires;
		try {
			tx = session.beginTransaction();
			Query<Commentaire> query = session.createQuery("SELECT u FROM Commentaire u", Commentaire.class);
			commentaires = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return commentaires;
	}

	@Override
	public Map<String, Article> getArticle() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commentaire getCommentaires(Integer idArticle) throws Exception {
		
		return null;
	}

	@Override
	public Commentaire getNbCommandesParVille() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
