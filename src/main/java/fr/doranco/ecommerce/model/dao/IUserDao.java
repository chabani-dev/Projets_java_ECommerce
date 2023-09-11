package fr.doranco.ecommerce.model.dao;

import java.util.List;
import java.util.Map;

import fr.doranco.ecommerce.entity.User;

public interface IUserDao {

	public void addUser(User user) throws Exception;

	public User getUserByEmail(String email) throws Exception;

	public void removeUser(Integer id) throws Exception ;

	public List<User> getUsers() throws Exception;
	
	public Map<String, List<User>> getUsersByVille(String ville) throws Exception;
	 
	void updatePassword(String newPassword, String user)throws Exception;


}
