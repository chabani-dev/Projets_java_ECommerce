package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.User;

public interface IUserDao {

	public int addUser(User user) throws Exception;

	public User getUserByEmail(String email) throws Exception;

	public void deleteUser(int id) throws Exception;

	public List<User> getUsers() throws Exception;
}
