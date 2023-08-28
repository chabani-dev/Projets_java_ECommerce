package fr.doranco.ecommerce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.ECommerceDataSource;
import fr.doranco.utils.Dates;

	public class UserDao implements IUserDao {

		public int addUser(User user) throws Exception {
			if (user == null) {
				throw new NullPointerException("Le user ne doit pas être null !");
			}
			if (user.getNom() == null || user.getNom().trim().isEmpty() || user.getPrenom() == null
			// verifie que le champs n'est pas remplis avec des espaces

					|| user.getPrenom().trim().isEmpty()) {
				throw new IllegalArgumentException("Des paramètres du User sont manquants");
			}
			Connection connection = ECommerceDataSource.getInstance().getConnection();
			String requete = "INSERT INTO user(nom, prenom, email, password, date_naissance ,genre) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getMotDePasse());
			ps.setDate(5, Dates.convertDateUtilToDateSql(user.getDateNaissance()));
			ps.setString(6, user.getGenre());
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			if (rs != null && rs.next()) {
				user.setId(rs.getInt(1));
			}
			IAdresseDao adresseDao = new AdresseDao();
			if (user.getAdresses() != null && !user.getAdresses().isEmpty()) {
				for (Adresse adresse : user.getAdresses()) {
					int id = adresseDao.addAdresse(adresse, user.getId());
					adresse.setId(id);
				}
			}
			return user.getId();
		}

		public User getUserByEmail(String email) throws Exception {
			if (email == null || email.trim().isEmpty()) {
				throw new IllegalArgumentException("L'id doit être null ");
			}
			Connection connection = ECommerceDataSource.getInstance().getConnection();
			String requete = "SELECT * FROM user WHERE email = ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			User user = null;
			if (rs != null && rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setNom(rs.getString("nom"));
				user.setPrenom(rs.getString("prenom"));
				user.setEmail(rs.getString("email"));
				user.setMotDePasse(rs.getString("password"));

			}
			return user;
		}

		public void deleteUser(int id) throws Exception {
		
			if (id <= 0) {
				throw new IllegalArgumentException("L'id doit être >0");
			}
			Connection connection = ECommerceDataSource.getInstance().getConnection();
			String requete = "DELETE FROM user WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setInt(1, id);
			ps.executeUpdate();
		}

		public List<User> getUsers() throws Exception {

			Connection connection = ECommerceDataSource.getInstance().getConnection();
			String requete = "SELECT * FROM user";
			PreparedStatement ps = connection.prepareStatement(requete);
			ResultSet rs = ps.executeQuery();
			List<User> users = new ArrayList<User>();
			if (rs != null) {
				while (rs.next()) {
					User user = new User();
					user.setId(rs.getInt("id"));
					user.setNom(rs.getString("nom"));
					user.setPrenom(rs.getString("prenom"));
					user.setEmail(rs.getString("email"));
					user.setMotDePasse(rs.getString("password"));
					user.setDateNaissance(Dates.convertDateUtilToDateSql(user.getDateNaissance()));
					user.setGenre(rs.getString("genre"));
					users.add(user);
				}
			}
			return users;
		}

		@Override
		public User seConnecter(String email, String motDePasse) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

}