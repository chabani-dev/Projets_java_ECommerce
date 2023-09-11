package fr.doranco.ecommerce.main;

import fr.doranco.ecommerce.entity.Commande;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.model.dao.CommandeDao;
import fr.doranco.ecommerce.model.dao.UserDao;

public class Main {

	public static void main(String[] args) {
		 try {
	            UserDao UserDao = new UserDao();
	            CommandeDao commandeDao = new CommandeDao();

	       
	            User user = UserDao.getUser(1);
	            Commande commande1 = new Commande(3);
	            Commande commande2 = new Commande(5);

	      
	            commande1.setUser(user);
	            commande2.setUser(user);
	            
	            commandeDao.addCommande(commande1);
	            commandeDao.addCommande(commande2);

	            System.out.println(commande1);
	            System.out.println(commande2);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        System.exit(0);
	    }

	}


