package fr.doranco.ecommerce.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String genre;
	private String prenom;
	private String nom;
	private Date dateNaissance;
	private String email;
	private String motDePasse;
	private List<Adresse> adresses;

	public User() {
		this.adresses = new ArrayList<Adresse>();
	}

	public User(String prenom, String nom, String genre, Date dateNaissance, String email, String motDePasse
			) {
		this.prenom = prenom;
		this.nom = nom;
		this.genre = genre;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.motDePasse = motDePasse;
		this.adresses = new ArrayList<Adresse>();

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
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

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
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

	public List<Adresse> getAdresses() {
		return adresses;
	}

}
