package fr.doranco.ecommerce.entity.pojo;



import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commentaires")
public class Commentaire  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "texte", length = 4, nullable = false)
	private String texte;
	
	@Column(name = "note", length = 4, nullable = false)
	private Number note;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private List<User> users;
	
	@ManyToOne
	@JoinColumn(name = "article_id", nullable = false)
	private Map<String, Article> articles;
	
	
	public Commentaire() {
		
	}


	public Commentaire(Integer id, String texte, Number note, List<User> users, Map<String, Article> articles) {

		this.texte = texte;
		this.note = note;
		this.users = users;
		this.articles = articles;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTexte() {
		return texte;
	}


	public void setTexte(String texte) {
		this.texte = texte;
	}


	public Number getNote() {
		return note;
	}


	public void setNote(Number note) {
		this.note = note;
	}


	public List<User> getUsers() {
		return users;
	}


	public Map<String, Article> getArticles() {
		return articles;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", texte=" + texte + ", note=" + note + ", users=" + users + ", articles="
				+ articles + "]";
	}


	

	

	
	
	
	
	
}
