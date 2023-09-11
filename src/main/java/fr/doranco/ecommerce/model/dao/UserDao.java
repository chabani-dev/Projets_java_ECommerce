package fr.doranco.ecommerce.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.hibernate.model.connect.HeberniteDataSource;

public class UserDao implements IUserDao {

	public void addUser(User user) throws Exception {

		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.save(user);
			user.getAdresses().forEach(a -> session.save(a));
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	public User getUser(int userId) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		try {
			User user = session.find(User.class, userId);

			return user;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void updateUser(User user) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {

			tx = session.beginTransaction();
			session.update(user.getAdresses());
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public void removeUser(Integer id) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			User user = session.find(User.class, id);
			if (user != null) {
				session.remove(user);
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

	public List<User> getUsers() throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		List<User> users;
		try {
			tx = session.beginTransaction();
			Query<User> query = session.createQuery("SELECT u FROM User u", User.class);
			users = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		return users;
	}

	public User getUserByEmail(String email) throws Exception {
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("L'email doit être renseigné !");
		}
		Session session = null;
		User user = null;
		try {
			session = HeberniteDataSource.getInstance().getSession();
			Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
			query.setParameter("email", email);
			user = query.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}

	public List<User> getUsersOfVille(String ville) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		List<User> users;

		try {
			tx = session.beginTransaction();
			String jpql = "SELECT u FROM User u JOIN FETCH u.adresse a WHERE a.ville = :ville";
			Query<User> query = session.createQuery(jpql, User.class);
			query.setParameter("ville", ville);
			users = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}

		return users;
	}

	@Override
	public Map<String, List<User>> getUsersByVille(String ville) throws Exception {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();
			Query<User> query = session.createQuery("SELECT u FROM User u WHERE u.ville = :ville", User.class);
			query.setParameter("ville", ville);
			List<User> users = query.list();
			tx.commit();

			Map<String, List<User>> usersByVille = new HashMap<>();
			usersByVille.put(ville, users);

			return usersByVille;
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
	}

	public void updatePassword(String password, String email) {
		Session session = HeberniteDataSource.getInstance().getSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			 String jpql = "UPDATE User u SET u.password = :newPassword WHERE u.id = :userId";
	            int updatedCount = session.createQuery(jpql)
	                    .setParameter("password", password)
	                    .setParameter("email", email)
	                    .executeUpdate();
	            if(updatedCount> 0) {
	            	tx.commit();
	            }
			
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {
			session.close();
		}
		
	}

}