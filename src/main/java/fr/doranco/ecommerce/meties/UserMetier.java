package fr.doranco.ecommerce.meties;

import java.util.List;

import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.dao.IUserDao;
import fr.doranco.ecommerce.model.dao.UserDao;



public class UserMetier implements IUserMetier{

	private final IUserDao userDao = new UserDao();

	public int addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	public User seConnecter(String email, String motDePasse) throws Exception {
		return userDao.getUserByEmail(email);
	}

	public void deleteUser(int id) throws Exception {

	}

	public List<User> getUsers() throws Exception {

		return userDao.getUsers();
	}

	
	public IUserDao getUserDao() {
		return userDao;
	}

}
