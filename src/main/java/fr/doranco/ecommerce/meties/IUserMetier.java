package fr.doranco.ecommerce.meties;

import java.util.List;

import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.entity.pojo.User;

public interface IUserMetier {

	
	public int addUser(UserDto userDto) throws Exception;

	public void removeUser(Integer id) throws Exception ;

	public List<User> getUsers() throws Exception;
	
	public UserDto seConnecter(String email, String motDePasse) throws Exception;
	
	/* public UserDto getUserByEmail(String email) throws Exception; */

	public void updatePassword(String password ,  String email) throws Exception ;
	
	public UserDto getUserByEmail(String email) throws Exception ;
	
	
	public UserDto getByProfil(int id) throws Exception;


}
