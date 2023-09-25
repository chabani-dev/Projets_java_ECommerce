package fr.doranco.ecommerce.model.dao;


import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;

public interface ICartePaiementDao {
	
	
	
	public CartePaiement getCartePaiementByUserId(Integer userId) throws Exception;
	
	
	public Integer addCartePaiement (CartePaiementDto cartePaiementDto , Integer userId) throws Exception;
}
