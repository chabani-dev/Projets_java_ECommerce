package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commande")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "numero", length = 4, nullable = false)
	private String numero;

	@Column(name = "date_Commande", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateCommande;

	@Column(name = "date_livraison", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dateLivraison;
	
	
	@Column(name = "totalRemise", nullable = false)
	private int totalRemise;
	
	
	@Column(name = "fraisExpedition", nullable = false)
	private int fraisExpedition;
	
	
	@Column(name = "adresseFacturation", nullable = false)
	private String adresseFacturation;
	
	
	@Column(name = "adresseLivraison", nullable = false)
	private String  adresseLivraison ;
	
	
	@Column(name = "cartePaiementDefaut", nullable = false)
	private byte[] cartePaiementDefaut;
	
	
	@OneToMany(mappedBy = "commande_id", cascade = CascadeType.ALL)
	private List<LigneCommande> ligneCommandes ;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	
	public Commande() {
		
	}
	
	public Commande(Integer id, String numero, Date dateCommande, Date dateLivraison, int totalRemise,
			int fraisExpedition, String adresseFacturation, String adresseLivraison, byte[] cartePaiementDefaut,
			List<LigneCommande> ligneCommandes, User user) {
		this.numero = numero;
		this.dateCommande = dateCommande;
		this.dateLivraison = dateLivraison;
		this.totalRemise = totalRemise;
		this.fraisExpedition = fraisExpedition;
		this.adresseFacturation = adresseFacturation;
		this.adresseLivraison = adresseLivraison;
		this.cartePaiementDefaut = cartePaiementDefaut;
		this.ligneCommandes = ligneCommandes;
		this.user = user;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTotalRemise() {
		return totalRemise;
	}

	public void setTotalRemise(int totalRemise) {
		this.totalRemise = totalRemise;
	}

	public int getFraisExpedition() {
		return fraisExpedition;
	}

	public void setFraisExpedition(int fraisExpedition) {
		this.fraisExpedition = fraisExpedition;
	}

	public String getAdresseFacturation() {
		return adresseFacturation;
	}

	public void setAdresseFacturation(String adresseFacturation) {
		this.adresseFacturation = adresseFacturation;
	}

	public String getAdresseLivraison() {
		return adresseLivraison;
	}

	public void setAdresseLivraison(String adresseLivraison) {
		this.adresseLivraison = adresseLivraison;
	}

	public byte[] getCartePaiementDefaut() {
		return cartePaiementDefaut;
	}

	public void setCartePaiementDefaut(byte[] cartePaiementDefaut) {
		this.cartePaiementDefaut = cartePaiementDefaut;
	}

	public List<LigneCommande> getLigneCommandes() {
		return ligneCommandes;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", numero=" + numero + ", dateCommande=" + dateCommande + ", dateLivraison="
				+ dateLivraison + ", totalRemise=" + totalRemise + ", fraisExpedition=" + fraisExpedition
				+ ", adresseFacturation=" + adresseFacturation + ", adresseLivraison=" + adresseLivraison
				+ ", cartePaiementDefaut=" + Arrays.toString(cartePaiementDefaut) + ", ligneCommandes=" + ligneCommandes
				+ ", user=" + user + "]";
	}

	
	
	

}
