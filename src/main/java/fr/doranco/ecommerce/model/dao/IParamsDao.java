package fr.doranco.ecommerce.model.dao;





import javax.crypto.SecretKey;

import fr.doranco.ecommerce.entity.pojo.Params;


public interface IParamsDao {

	

	
	public void addParams(Params params) throws Exception ;
	
	public SecretKey getCleCryptage(String algorithm) throws Exception;
	
	  public void updatePassword(String password, String email) throws Exception;
	
	
	
}
