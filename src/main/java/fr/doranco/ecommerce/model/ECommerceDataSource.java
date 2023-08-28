package fr.doranco.ecommerce.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ECommerceDataSource {
	
		
	
	 private static ECommerceDataSource instance;
	    
	    private ECommerceDataSource() {

	    }

	    public static ECommerceDataSource getInstance() {
	        if (instance == null) {
	            instance = new ECommerceDataSource();
	        }
	        return instance;
	    }
	    
	    public Connection getConnection() throws SQLException, Exception {
	      
	    	ResourceBundle rb = ResourceBundle.getBundle("fr.doranco.ecommerce.model.database_file");
	    	String user = rb.getString("user");
	    	String password = rb.getString("password");
	    	String url = rb.getString("url");
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	
	    	Connection connection = DriverManager.getConnection(url, user, password);
	        return connection;
	    }

}
