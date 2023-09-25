package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	@Column(name = "description", length = 50, nullable = false)
	private String description ;
	
	@Column(name = "prix", length = 25, nullable = false)
	private Float prix;
	
	@Column(name = "remise", length = 25, nullable = true)
	private Integer remise;
	
	@Column(name = "stock", length = 25, nullable = false)
	private Integer stock;
	
	@Column(name = "isVendable", nullable = false)
	private Boolean isVendable;
	
	/*
	 * @Column(name = "photos", nullable = true) private String photos;
	 * 
	 * @Column(name = "videos", nullable = true) private String videos;
	 */
	
	
	@OneToMany
	@JoinColumn(name = "commentaires_id", nullable = false)
	private List<Commentaire> commentaires;

	
	public Article() {
		
	}


	public Article(Integer id, String nom, String description, Float prix, Integer remise, Integer stock,
			Boolean isVendable, String photos, String videos, List<Commentaire> commentaires) {
	
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.remise = remise;
		this.stock = stock;
		this.isVendable = isVendable;
		this.commentaires = commentaires;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Float getPrix() {
		return prix;
	}


	public void setPrix(Float prix) {
		this.prix = prix;
	}


	public Integer getRemise() {
		return remise;
	}


	public void setRemise(Integer remise) {
		this.remise = remise;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public Boolean getIsVendable() {
		return isVendable;
	}


	public void setIsVendable(Boolean isVendable) {
		this.isVendable = isVendable;
	}


	public List<Commentaire> getCommentaires() {
		return commentaires;
	}


	
	
	
	
	
	
	
	

}
