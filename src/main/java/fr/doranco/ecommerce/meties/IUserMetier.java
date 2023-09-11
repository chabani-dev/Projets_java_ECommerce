package fr.doranco.ecommerce.meties;

import java.util.List;


import fr.doranco.ecommerce.entity.User;

public interface IUserMetier {

	
	public void  addUser(User user) throws Exception;

	public void removeUser(Integer id) throws Exception ;

	public List<User> getUsers() throws Exception;
	
	public User getUserByEmail(String email) throws Exception ;
	
	public User seConnecter(String email, String motDePasse) throws Exception;

	
	public void updatePassword(String password ,  String email) throws Exception ;

	

}
