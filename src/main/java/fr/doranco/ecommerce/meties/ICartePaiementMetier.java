package fr.doranco.ecommerce.meties;

import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;

public interface ICartePaiementMetier {

    Integer addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) throws Exception;

    CartePaiement getCartePaiementByUserId(Integer userId) throws Exception;
}

