package fr.doranco.ecommerce.model.dao;



import fr.doranco.ecommerce.entity.pojo.Adresse;

public interface IAdresseDao {

	  Adresse getById(int id);
	    void save(Adresse adresse);
	    void update(Adresse adresse);
	    void delete(Adresse adresse);
}
