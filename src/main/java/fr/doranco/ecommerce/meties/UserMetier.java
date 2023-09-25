package fr.doranco.ecommerce.meties;


import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import fr.doranco.cryptage.keys.GenerateKey;
import fr.doranco.crypto.algo.AlgorithmeCryptage;
import fr.doranco.ecommerce.entity.dto.UserDto;
import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.entity.pojo.Commentaire;
import fr.doranco.ecommerce.entity.pojo.Params;
import fr.doranco.ecommerce.entity.pojo.User;
import fr.doranco.ecommerce.model.dao.IParamsDao;
import fr.doranco.ecommerce.model.dao.IUserDao;
import fr.doranco.ecommerce.model.dao.ParamsDao;
import fr.doranco.ecommerce.model.dao.UserDao;
import fr.doranco.security.enums.CryptageEnum;


public class UserMetier implements IUserMetier {

	private final IUserDao userDao = new UserDao();
   

    public int addUser(UserDto userDto) throws Exception {
    	
        IParamsDao paramsDao = new ParamsDao();
              
		SecretKey cleCryptage = paramsDao.getCleCryptage(CryptageEnum.DES.getValue());

        if (cleCryptage == null) {
        	cleCryptage = GenerateKey.getKeyCryptage(CryptageEnum.DES.getValue(), 56);

            Params params = new Params();
            params.setAlgorithm(CryptageEnum.DES.getValue());
            params.setCleCryptage(cleCryptage.getEncoded());
            paramsDao.addParams(params);
        }

        // Chiffrer le mot de passe
        byte[] cryptedPassword = AlgorithmeCryptage.encrypt(userDto.getPassword() , cleCryptage, CryptageEnum.DES.getValue());

        // Créer un utilisateur avec le mot de passe chiffré
        User user = new User();
        user.setNom(userDto.getNom());
        user.setPrenom(userDto.getPrenom());
        user.setEmail(userDto.getEmail());
        user.setDateNaissance(userDto.getDateNaissance());
        user.setActive(userDto.isActive());
        user.setGenre(userDto.getGenre());
        user.setPassword(cryptedPassword);

        // Remplir les adresses de l'utilisateur si nécessaire
        if (userDto.getAdresses() != null) {
	        for (Adresse adresse : userDto.getAdresses()) {
	        	adresse.setUser(user);
	            user.getAdresses().add(adresse);
	        }
        }

        // Ajouter l'utilisateur à la base de données
        userDao.addUser(user);
        return user.getId();
    }

    public UserDto seConnecter(String email, String motDePasse) throws Exception {
        User user = userDao.getUserByEmail(email);

        if (user != null) {
            IParamsDao paramsDao = new ParamsDao();
            SecretKey key = paramsDao.getCleCryptage("DES");
 
            if (key == null) {
                key = GenerateKey.getKeyCryptage("DES", 56);
                Params params = new Params();
                params.setAlgorithm("DES");
                params.setCleCryptage(key.getEncoded());
                paramsDao.addParams(params);
            }

            // Vérifiez le mot de passe en utilisant la clé de cryptage
            String decryptedPassword = AlgorithmeCryptage.decrypt(user.getPassword(), key, "DES");

            if (motDePasse.equals(decryptedPassword)) {
                UserDto userDto = new UserDto();
                userDto.setId(user.getId());
                userDto.setNom(user.getNom());
                userDto.setPrenom(user.getPrenom());
                userDto.setEmail(user.getEmail());
                userDto.setActive(user.isActive());
                userDto.setGenre(user.getGenre());
                userDto.setTelephone(user.getTelephone());
        

           
                List<Adresse> adresses = user.getAdresses();
                for (Adresse adresse : adresses) {
                    userDto.getAdresses().add(adresse);
                }
                
                List<Commande> commandes = user.getCommandes();
                for(Commande commande: commandes) {
                	userDto.getCommandes().add(commande);
                }
                
                List<Commentaire>commentaires= user.getCommentaires();
                for(Commentaire commentaire: commentaires) {
                	userDto.getCommentaires().add(commentaire);
                }
                
                return userDto;
            }
        }

        return null;
    }

   public void updatePassword(String password, String email) throws Exception {
        IParamsDao paramsDao = new ParamsDao();
        SecretKey cleCryptage = paramsDao.getCleCryptage(CryptageEnum.DES.getValue());

        SecretKey key = null;
        if (cleCryptage == null) {
            key = GenerateKey.getKeyCryptage(CryptageEnum.DES.getValue(), 56);
            cleCryptage = key;

            Params params = new Params();
            params.setAlgorithm(CryptageEnum.DES.getValue());
            params.setCleCryptage(cleCryptage.getEncoded()); 
            paramsDao.addParams(params);

        } else {
            key = new SecretKeySpec(cleCryptage.getEncoded(), CryptageEnum.DES.getValue());
        }
        AlgorithmeCryptage.encrypt(password, key, CryptageEnum.DES.getValue());
        userDao.updatePassword(password, email);
        
    }


	public UserDto getUserByEmail(String email) throws Exception {
		
		User user = userDao.getUserByEmail(email);
		if (user == null) {
			return null;
		}
		
	    IParamsDao paramsDao = new ParamsDao();
	    SecretKey cleCryptage = paramsDao.getCleCryptage(CryptageEnum.DES.getValue());

	    if (cleCryptage == null) {
	        throw new NullPointerException("La clé de cryptage est introuvable !");
	    } else {
	    }
	    
	    // convertir le user en userDto 
	    UserDto userDto = new UserDto();
	  

	    return userDto;
	}
	
	
	
	public void removeUser(Integer id) throws Exception {

		userDao.removeUser(id);

	}

	public List<User> getUsers() throws Exception {

		return userDao.getUsers();
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	@Override
	public UserDto getByProfil(int id) throws Exception {
	    User user = userDao.getByProfil(id);
	    
	    if (user == null) {
	        return null; 
	    }
	    UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setNom(user.getNom());
        userDto.setPrenom(user.getPrenom());
        userDto.setEmail(user.getEmail());
        userDto.setActive(user.isActive());
        userDto.setGenre(user.getGenre());
        userDto.setTelephone(user.getTelephone());
        userDto.setProfil(user.getProfil());
	  	    
	    return userDto;
	}

}