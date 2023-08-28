package fr.doranco.ecommerce.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.model.ECommerceDataSource;

public class AdresseDao implements IAdresseDao {
	
		public Set<Adresse> getAdresseByUserId(int userId) throws Exception {
		
			
			if (userId <= 0) {
				throw new IllegalArgumentException("L'id doit être > 0");
			}
			Connection connection = ECommerceDataSource.getInstance().getConnection();
			String requete = "SELECT * FROM adresse WHERE user_id = ?";
		    PreparedStatement ps = connection.prepareStatement(requete);
		    ps.setInt(1, userId);
		    ResultSet rs = ps.executeQuery();
		    
		    Set<Adresse> adresses = new HashSet<>();
		    if (rs != null) {
				  while (rs.next()) {
		        Adresse adresse = new Adresse();
		        adresse.setId(rs.getInt("id"));
		        adresse.setNumero(rs.getString("numero"));
		        adresse.setVille(rs.getString("ville"));
		        adresse.setRue(rs.getString("rue"));
		        adresse.setCodePostal(rs.getString("code_postal"));;
		        adresses.add(adresse);
		    }
		    	}
				return adresses;
			}
			
		public int addAdresse(Adresse adresse, int userId) throws Exception {
		    if (userId <= 0) {
		        throw new NullPointerException("Le User ne doit pas être NULL !");
		    }
		    if (adresse == null) {
		        throw new IllegalArgumentException("Des paramètres du adresse sont manquants !");
		    }

		    Connection connection =ECommerceDataSource.getInstance().getConnection();
		    String requete = "INSERT INTO adresse (user_id , numero, rue, ville, code_postal) VALUES (?,?,?,?,?)";
		    PreparedStatement ps = connection.prepareStatement(requete, Statement.RETURN_GENERATED_KEYS);
		    ps.setInt(1, userId);
		    ps.setString(2,adresse.getNumero());
		    ps.setString(3,adresse.getRue());
		    ps.setString(4, adresse.getVille());
		    ps.setString(5, adresse.getCodePostal());
		    ps.executeUpdate();
		    ResultSet rs =  ps.getGeneratedKeys();
		    if (rs != null && rs.next()) {
				rs.getInt(1);
			}
		
		
		return 0;
		

	}
		
		
		public void deleteAdresse(int id) throws Exception {
			
			if (id <= 0) {
				throw new IllegalArgumentException("L'id doit être >0");
			}
			Connection connection = ECommerceDataSource.getInstance().getConnection();
			String requete = "DELETE FROM user WHERE id= ?";
			PreparedStatement ps = connection.prepareStatement(requete);
			ps.setInt(1, id);
			ps.executeUpdate();
		}

}
