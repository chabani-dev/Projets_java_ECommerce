package fr.doranco.ecommerce.model.dao;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.hibernate.model.connect.HeberniteDataSource;

public class ParamsDao implements IParamsDao {

	@Override
	public void addParams(Params params) throws Exception {
		if (params == null) {
			throw new IllegalArgumentException("L'objet params doit être renseigné !");
		}

		Session session = null;
		Transaction tx = null;

		try {
			session = HeberniteDataSource.getInstance().getSession();
			tx = session.beginTransaction();
			session.save(params);
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

	@Override
	public SecretKey getCleCryptage(String algorithm) throws Exception {

		if (algorithm == null) {
			throw new NullPointerException("L'algorithm ne doit pas être NULL !");
		}

		Session session = HeberniteDataSource.getInstance().getSession();

		try {
			Query<Params> query = session.createQuery("FROM Params p WHERE p.algorithm = ?1", Params.class);
			query.setParameter(1, algorithm);
			Params params = query.uniqueResult();
			if (params != null) {
				return new SecretKeySpec(params.getCleCryptage(), "DES");
			}
			return null;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	@Override
	public void updatePassword(String password, String email) throws Exception {
		// TODO Auto-generated method stub
		
	}

}