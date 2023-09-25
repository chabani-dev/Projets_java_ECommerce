package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorie")
public class Categorie implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	
	@Column(name= "remise" , nullable = false)
	private int remise;
	
	
	@Column(name= "isRemiseCumulable" , nullable = false)
	private int isRemiseCumulable;
	
	
	@Column(name = "photos", nullable = true)
	private String photos;
	
	
	@OneToMany(mappedBy="categorie")
	 private List<Article> articles;


	public Categorie() {
		
	}


	public Categorie(int id, String nom, int remise, int isRemiseCumulable, String photos, List<Article> articles) {
	
		this.nom = nom;
		this.remise = remise;
		this.isRemiseCumulable = isRemiseCumulable;
		this.photos = photos;
		this.articles = articles;
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


	public int getRemise() {
		return remise;
	}


	public void setRemise(int remise) {
		this.remise = remise;
	}


	public int getIsRemiseCumulable() {
		return isRemiseCumulable;
	}


	public void setIsRemiseCumulable(int isRemiseCumulable) {
		this.isRemiseCumulable = isRemiseCumulable;
	}


	public String getPhotos() {
		return photos;
	}


	public void setPhotos(String photos) {
		this.photos = photos;
	}


	public List<Article> getArticles() {
		return articles;
	}


	@Override
	public String toString() {
		return "Categorie [id=" + id + ", nom=" + nom + ", remise=" + remise + ", isRemiseCumulable="
				+ isRemiseCumulable + ", photos=" + photos + ", articles=" + articles + "]";
	}

}
