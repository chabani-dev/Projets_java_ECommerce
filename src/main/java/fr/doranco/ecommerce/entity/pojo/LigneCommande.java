package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "ligneCommande")
public class LigneCommande implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id ;
	
	@Column(name = "titreArticle" , length = 25, nullable= false)
	private String titreArticle ;
	
	
	@Column(name = "prixArticle" , length = 25, nullable = false)
	private Float prixArticle;
	
	
	@Column(name= "quantite" , nullable = false)
	private int quantite;
	
	@Column(name= "remiseArticle" , nullable = false)
	private int remiseArticle ;
	
	
	 @ManyToOne
	 @JoinColumn(name = "commande_id") 
	 private Commande commande;
	 
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "article_id") 
	 private Article article;
	 
	 
	public LigneCommande() {
		
	}

	public LigneCommande(int id, String titreArticle, Float prixArticle, int quantite, int remiseArticle,
			Commande commande, Article article) {
		this.titreArticle = titreArticle;
		this.prixArticle = prixArticle;
		this.quantite = quantite;
		this.remiseArticle = remiseArticle;
		this.commande = commande;
		this.article = article;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitreArticle() {
		return titreArticle;
	}


	public void setTitreArticle(String titreArticle) {
		this.titreArticle = titreArticle;
	}


	public Float getPrixArticle() {
		return prixArticle;
	}


	public void setPrixArticle(Float prixArticle) {
		this.prixArticle = prixArticle;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getRemiseArticle() {
		return remiseArticle;
	}

	public void setRemiseArticle(int remiseArticle) {
		this.remiseArticle = remiseArticle;
	}

	public Commande getCommande() {
		return commande;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "LigneCommande [id=" + id + ", titreArticle=" + titreArticle + ", prixArticle=" + prixArticle
				+ ", quantite=" + quantite + ", remiseArticle=" + remiseArticle + ", commande=" + commande
				+ ", article=" + article + "]";
	}


	
	

}
