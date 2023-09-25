package fr.doranco.ecommerce.model.dao;

import java.util.List;

import fr.doranco.ecommerce.entity.pojo.Commande;

public interface ICommandeDao {

	public Commande getCommande(Integer id) throws Exception;

	public void addCommande(Commande commande) throws Exception;

	public void removeCommande(Commande commande) throws Exception;

	public List<Commande> getCommandes1() throws Exception;

	public List<Commande> getCommandes2() throws Exception;

	public List<Commande> getCommandes3() throws Exception;

}
