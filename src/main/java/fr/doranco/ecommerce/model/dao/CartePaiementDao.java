package fr.doranco.ecommerce.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.entity.pojo.User;
import fr.doranco.hibernate.model.connect.HeberniteDataSource;

public class CartePaiementDao implements ICartePaiementDao {

    @Override
    public CartePaiement getCartePaiementByUserId(Integer userId) throws Exception {
        Session session = HeberniteDataSource.getInstance().getSession();
        try {
            return session.find(CartePaiement.class, userId);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Integer  addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) throws Exception {
    	
    	
    	return null;
       
    }


}
