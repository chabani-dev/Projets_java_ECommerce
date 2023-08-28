package fr.doranco.ecommerce.model.dao;

import java.util.Set;

import fr.doranco.ecommerce.entity.Adresse;

public interface IAdresseDao {

	Set<Adresse> getAdresseByUserId(int userId) throws Exception;
	int addAdresse(Adresse adresse, int userId) throws Exception;
	int  deleteAdresse(int id ) throws  Exception;
}
