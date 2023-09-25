package fr.doranco.ecommerce.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Article;
import fr.doranco.hibernate.model.connect.HeberniteDataSource;

public class ArticleDao implements IArticleDao {
	
	
	@Override
	public void addArticle(Article article) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();

			session.save(article);

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
	public Article getArticle(int idArticle) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		try {
			Article article = session.find(Article.class, idArticle);

			return article;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void removeArticle(Integer id) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			Article article = session.find(Article.class, id);
			if (article != null) {
				session.remove(article);
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
	public List<Article> getArticle() throws Exception {
	
		    Session session = HeberniteDataSource.getInstance().getSession();
		    Transaction tx = null;
		    List<Article> articles = new ArrayList<>(); // Créer une nouvelle carte

		    try {
		        tx = session.beginTransaction();
		        Query<Article> query = session.createQuery("SELECT a FROM Article a", Article.class);
		        List<Article> resultList = query.getResultList();

		        for (Article article : resultList) {
		            // Convertissez l'ID entier en chaîne et utilisez-le comme clé
		            String articleId = String.valueOf(article.getId());
		            articles.add(articleId, article);
		        }

		        tx.commit();
		    } catch (Exception e) {
		        if (tx != null) {
		            tx.rollback();
		        }
		        throw e;
		    } finally {
		        session.close();
		    }

		    return articles;
		}

	}

	
	
