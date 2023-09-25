package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.hibernate.model.connect.HeberniteDataSource;

public class AdresseDao implements IAdresseDao {

    private HeberniteDataSource dataSource;

    public AdresseDao() {
        dataSource = HeberniteDataSource.getInstance();
    }

    @Override
    public Adresse getById(int id) {
        Session session = dataSource.getSession();
        Adresse adresse = session.get(Adresse.class, id);
        session.close();
        return adresse;
    }

    @Override
    public void save(Adresse adresse) {
        Session session = dataSource.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(adresse);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void update(Adresse adresse) {
        Session session = dataSource.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(adresse);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Adresse adresse) {
        Session session = dataSource.getSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(adresse);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
