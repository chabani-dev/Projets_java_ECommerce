package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.User;

public interface IUserDao {

	public int addUser(User user) throws Exception;

	public User seConnecter(String email, String motDePasse) throws Exception;

	public void deleteUser(int id) throws Exception;

	public List<User> getUsers() throws Exception;
}
