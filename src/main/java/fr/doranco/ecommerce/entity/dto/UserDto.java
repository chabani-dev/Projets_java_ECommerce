package fr.doranco.ecommerce.entity.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import fr.doranco.ecommerce.entity.pojo.Adresse;
import fr.doranco.ecommerce.entity.pojo.ArticlePanier;
import fr.doranco.ecommerce.entity.pojo.Commande;
import fr.doranco.ecommerce.entity.pojo.Commentaire;

public class UserDto {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String genre;
    private boolean isActive;
    private String email;
    private String password;
	private String CartePaiement;
	private String telephone;
    private List<Adresse> adresses;
    private String profil;
    private List<ArticlePanier>  articlePaniers;
    private List<Commande> commandes; 
    
    
    
    
    
    
	public String getCartePaiement() {
		return CartePaiement;
	}

	public void setCartePaiement(String cartePaiement) {
		CartePaiement = cartePaiement;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getProfil() {
		return profil;
	}

	public void setProfil(String profil) {
		this.profil = profil;
	}

	public List<ArticlePanier> getArticlePaniers() {
		return articlePaniers;
	}

	public void setArticlePaniers(List<ArticlePanier> articlePaniers) {
		this.articlePaniers = articlePaniers;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	private List<Commentaire > commentaires;

    // Constructeur par défaut
    public UserDto() {
    	adresses = new ArrayList<Adresse>();
    }

    // Ajoutez des getters et des setters pour chaque attribut

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


    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Adresse> getAdresses() {
        return adresses;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

  
    
  
	
	
	
}
