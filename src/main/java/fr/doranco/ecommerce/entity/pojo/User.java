package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nom", length = 25, nullable = false)
	private String nom;

	@Column(name = "prenom", length = 25, nullable = false)
	private String prenom;

	@Column(name = "date_naissance", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Column(name = "genre", length = 25, nullable = false)
	private String genre;

	@Column(name = "isActive", nullable = false)
	private boolean isActive;

	@Column(name = "email", nullable = false)
	private String email;
	
	
	@Column(name = "telephone", nullable = false)
	private String telephone;

	@Column(name = "password", nullable = false)
	private byte[] password;
	
	
	
	@Column(name = "CartePaiement", nullable = false)
	private byte[] CartePaiement;
	
	@Column(name = "profil", nullable = false)
	private String profil;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<ArticlePanier>  articlePaniers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user", fetch = FetchType.EAGER)
	private List<Adresse> adresses;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Commande> commandes;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Commentaire > commentaires;
	
	
	
	
	public User() {
		this.adresses = new ArrayList<Adresse>();
	}

	public byte[] getCartePaiement() {
		return CartePaiement;
	}

	public void setCartePaiement(byte[] cartePaiement) {
		CartePaiement = cartePaiement;
	}

	public List<ArticlePanier> getArticlePaniers() {
		return articlePaniers;
	}

	public void setArticlePaniers(List<ArticlePanier> articlePaniers) {
		this.articlePaniers = articlePaniers;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public byte[] getPassword() {
		return password;
	}

	public void setPassword(byte[] password) {
		this.password = password;
	}

	public List<Adresse> getAdresses() {
		return adresses;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", genre=" + genre + ", isActive=" + isActive + ", email=" + email + ", telephone=" + telephone
				+ ", password=" + Arrays.toString(password) + ", CartePaiement=" + Arrays.toString(CartePaiement)
				+ ", profil=" + profil + ", articlePaniers=" + articlePaniers + ", adresses=" + adresses
				+ ", commandes=" + commandes + ", commentaires=" + commentaires + "]";
	}
	
	

}
