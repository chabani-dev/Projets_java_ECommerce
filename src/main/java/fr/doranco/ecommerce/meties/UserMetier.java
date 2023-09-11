package fr.doranco.ecommerce.meties;

import java.util.List;


import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.dao.IUserDao;
import fr.doranco.ecommerce.model.dao.UserDao;



public class UserMetier implements IUserMetier{

	private final IUserDao userDao = new UserDao();

	public void  addUser(User user) throws Exception {
		userDao.addUser(user);
	}

	public User seConnecter(String email, String motDePasse) throws Exception {
		User user = userDao.getUserByEmail(email);
		if (user != null && motDePasse.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public void removeUser(Integer id) throws Exception{
		
		userDao.removeUser(id);

	}

	public List<User> getUsers() throws Exception {

		return userDao.getUsers();
	}

	
	public IUserDao getUserDao() {
		return userDao;
	}

	
	public User getUserByEmail(String email) throws Exception{
		
		return userDao.getUserByEmail(email);
	}
	
	public void updatePassword(String password , String email) throws Exception {
		userDao.updatePassword(password ,email);
		
	}

	
	

}
