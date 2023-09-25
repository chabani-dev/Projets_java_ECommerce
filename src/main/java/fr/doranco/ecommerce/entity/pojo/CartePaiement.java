package fr.doranco.ecommerce.entity.pojo;

import java.io.Serializable;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CartePaiement")
public class CartePaiement implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "numeroCarte", length = 4, nullable = false)
	private byte[] numeroCarte;
	
	@Column(name = "dateValidation", length = 4, nullable = false)
	private String dateValidation;
	
	@Column(name = "user",  nullable = false)
	private User user;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Column(name = "crytogramme", length = 4, nullable = false)
	private byte[] crytogramme;
	
	
	public CartePaiement() {
		
	}


	public CartePaiement(Integer id, byte[] numeroCarte, String dateValidation, byte[] crytogramme) {
		this.numeroCarte = numeroCarte;
		this.dateValidation = dateValidation;
		this.crytogramme = crytogramme;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public byte[] getNumeroCarte() {
		return numeroCarte;
	}


	public void setNumeroCarte(byte[] numeroCarte) {
		this.numeroCarte = numeroCarte;
	}


	public String getDateValidation() {
		return dateValidation;
	}


	public void setDateValidation(String dateValidation) {
		this.dateValidation = dateValidation;
	}


	public byte[] getCrytogramme() {
		return crytogramme;
	}





	public void setCrytogramme(byte[] crytogramme) {
		this.crytogramme = crytogramme;
	}


	@Override
	public String toString() {
		return "CartePaiement [id=" + id + ", numeroCarte=" + Arrays.toString(numeroCarte) + ", dateValidation="
				+ dateValidation + ", crytogramme=" + Arrays.toString(crytogramme) + "]";
	}


	
	

	
	
	

}
