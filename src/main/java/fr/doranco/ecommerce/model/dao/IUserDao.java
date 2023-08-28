package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.User;

public interface IUserDao {

	
	 public static int addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	    public User seConnecter(String email, String motDePasse)throws Exception;
	    public void deleteUser(int id) throws Exception;
	    public List<User> getUsers() throws Exception;
}
