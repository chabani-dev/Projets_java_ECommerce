package fr.doranco.ecommerce.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.doranco.ecommerce.entity.Adresse;
import fr.doranco.ecommerce.entity.User;
import fr.doranco.ecommerce.meties.IUserMetier;
import fr.doranco.ecommerce.meties.UserMetier;

@ManagedBean(name = "userbean")
@SessionScoped

public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(name = "prenom", value = "Michel")
	private String prenom;

	@ManagedProperty(name = "nom", value = "DUPOND")
	private String nom;

	@ManagedProperty(name = "genre", value = "Monsieur")
	private String genre;

	private Date dateNaissance;

	@ManagedProperty(name = "email", value = "camus@doranco.fr")
	private String email;

	private String motDePasse;

	@ManagedProperty(name = "motDePasseConfirmation", value = "12345678")
	private String motDePasseConfirmation;

	@ManagedProperty(name = "numero", value = "16")
	private String numero;

	@ManagedProperty(name = "rue", value = "Rue Lafayette")
	private String rue;

	@ManagedProperty(name = "ville", value = "Paris")
	private String ville;

	@ManagedProperty(name = "codePostal", value = "75000")
	private String codePostal;

	private static String messageSuccess = "";
	private static String messageError = "";

	private Set<Adresse> adressesTemp;

	private final IUserMetier userMetier = new UserMetier();

	private List<String> adressesStr = new ArrayList<String>();

	static {
		messageError = messageSuccess = "";
	}

	public UserBean() {
		this.adressesTemp = new HashSet<Adresse>();
		messageError = messageSuccess = "";
	}

	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();

		try {
			users = userMetier.getUsers();

		} catch (Exception e) {
			messageSuccess = "Utilisateur créé avec succès";

			messageError = " erreur d'inscription !";
			e.printStackTrace();
		}
		return users;
	}

	public String seConnecter() {
		messageSuccess = "";
		try {
			User user = userMetier.seConnecter(email, motDePasse);
			if (user != null && user.getMotDePasse().equals(this.motDePasse)) {
				return "achats.xhtml";
			}
			messageError = "Email et/ou mot de passe incorrect(s) !";
		} catch (Exception e) {
			messageError = "Erreur technique lors de l'identification !\n" + e.getMessage();
			System.out.println(e);
		}
		return "";
	}

	public String inscription() {
		messageError = messageSuccess = "";
		return "inscription.xhtml";
	}
	
	public String addUser() {
		messageError = "";
		messageSuccess = "";

		if (!this.motDePasse.equals(motDePasseConfirmation)) {
			messageError = "Les deux mots de passe ne correspondent pas ! Veuillez réessayer.";
			return "";
		}

		try {
			User user = new User(this.prenom, this.nom, this.genre, this.dateNaissance, this.email, this.motDePasse);
			for (Adresse adresse : adressesTemp) {
				user.getAdresses().add(adresse);
			}

			userMetier.addUser(user);
			adressesTemp.clear();
			return "achats.xhtml";

		} catch (Exception e) {
			messageSuccess = "";
//			this.messageError = "Erreur lors de la création de l'utilisateur !\n"
//					+ e.getMessage();
			messageError = "Erreur d'inscription !\n" + e.getMessage();
			System.out.println(e);
			return "";
		}
	}

	public String deleteUser(User user) {
		messageError = "";
		messageSuccess = "";
		return "";
	}

	public String addAdresse() {
		messageError = "";
		messageSuccess = "";
		Adresse adresse = new Adresse();
		adresse.setNumero(numero);
		adresse.setRue(rue);
		adresse.setVille(ville);
		adresse.setCodePostal(codePostal);
		this.adressesTemp.add(adresse);
		this.numero = "";
		this.rue = "";
		this.ville = "";
		this.codePostal = "";
		return "";
	}

	public List<String> getAllAdresses() {
		adressesStr = new ArrayList<String>();
		byte numLigne = 1;
		for (Adresse adresse : adressesTemp) {
			StringBuilder chaine = new StringBuilder();
			chaine.append("Adresse " + numLigne++ + " : ").append(adresse.getNumero()).append(" ")
					.append(adresse.getRue()).append(" ").append(adresse.getVille()).append(" ")
					.append(adresse.getCodePostal());
			adressesStr.add(chaine.toString());
		}
		return adressesStr;
	}

	public List<String> getListeAdresses(User user) {

		List<String> userAdresses = new ArrayList<String>();
		if (user == null) {
			return userAdresses;
		}
		StringBuilder chaine = new StringBuilder();
		for (Adresse adresse : user.getAdresses()) {
			chaine.append(adresse.getNumero()).append(" ").append(adresse.getRue()).append(" ")
					.append(adresse.getVille()).append(" ").append(adresse.getCodePostal());
			userAdresses.add(chaine.toString());
		}
		return userAdresses;
	}

	public String remiseAzero() {
		this.genre = "";
		this.nom = "";
		this.prenom = "";
		this.email = "";
		return "";
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date datedenaissance) {
		this.dateNaissance = datedenaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getMotDePasseConfirmation() {
		return motDePasseConfirmation;
	}

	public void setMotDePasseConfirmation(String motDePasseConfirmation) {
		this.motDePasseConfirmation = motDePasseConfirmation;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getMessageSuccess() {
		return messageSuccess;
	}

	public void setMessageSuccess(String messageSuccess) {
		UserBean.messageSuccess = messageSuccess;
	}

	public String getMessageError() {
		return messageError;
	}

	public void setMessageError(String messageError) {
		UserBean.messageError = messageError;
	}

}
