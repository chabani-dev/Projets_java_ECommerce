package fr.doranco.ecommerce.meties;

import javax.crypto.SecretKey;

import fr.doranco.cryptage.keys.GenerateKey;
import fr.doranco.crypto.algo.AlgorithmeCryptage;
import fr.doranco.ecommerce.entity.dto.CartePaiementDto;
import fr.doranco.ecommerce.entity.pojo.CartePaiement;
import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.model.dao.CartePaiementDao;
import fr.doranco.ecommerce.model.dao.IParamsDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.security.enums.CryptageEnum;




public class CartePaiementMetier implements ICartePaiementMetier{
	
	private final CartePaiementDao cpd= new CartePaiementDao();

@Override
	public Integer addCartePaiement(CartePaiementDto cartePaiementDto, Integer userId) throws Exception {
	
	    CartePaiementDao cpd = new CartePaiementDao();
	    	
	        IParamsDao paramsDao = new ParamsDao();
	              
			SecretKey cleCryptage = paramsDao.getCleCryptage(CryptageEnum.DES.getValue());

	        if (cleCryptage == null) {
	        	cleCryptage = GenerateKey.getKeyCryptage(CryptageEnum.DES.getValue(), 56);

	            Params params = new Params();
	            params.setAlgorithm(CryptageEnum.DES.getValue());
	            params.setCleCryptage(cleCryptage.getEncoded());
	            paramsDao.addParams(params);
	        }

	      
	        byte[] cryptedCrypto = AlgorithmeCryptage.encrypt(cartePaiementDto.getCrytogramme() , cleCryptage, CryptageEnum.DES.getValue());
	        byte[] cryptedNumCarte = AlgorithmeCryptage.encrypt(cartePaiementDto.getNumeroCarte() , cleCryptage, CryptageEnum.DES.getValue());
	       
	        CartePaiement cp = new CartePaiement();
	        cp.setCrytogramme(cryptedCrypto);
	        cp.setNumeroCarte(cryptedNumCarte);
	        cp.setDateValidation(cartePaiementDto.getDateValidation());
	       

	     // Ajouter la carte de paiement à la base de données
	        cpd.addCartePaiement(cp, userId);

	        // Retourner l'ID de la carte de paiement ajoutée
	        return cp.getId();
}

	@Override
	public CartePaiement getCartePaiementByUserId(Integer userId) throws Exception {
	
		return null;
	}
}
