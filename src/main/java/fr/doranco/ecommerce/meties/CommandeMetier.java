package fr.doranco.ecommerce.meties;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.model.dao.CommandeDao;
import fr.doranco.ecommerce.model.dao.ICommandeDao;


public class CommandeMetier implements ICommandeMetier {
	
	
	private final ICommandeDao CommandeDao = new CommandeDao();

	@Override
	public Commande getCommande(Integer id) throws Exception {
		
		return CommandeDao.getCommande(id);
	}

	@Override
	public void addCommande(Commande commande) throws Exception {
		
		CommandeDao.addCommande(commande);
	}

	@Override
	public void removeCommande(Commande commande) throws Exception {
		CommandeDao.removeCommande(commande);
		
	}

	@Override
	public List<Commande> getCommandes1() throws Exception {
	
		return CommandeDao.getCommandes1();
	}

}
