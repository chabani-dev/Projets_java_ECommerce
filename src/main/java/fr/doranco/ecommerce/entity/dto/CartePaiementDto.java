package fr.doranco.ecommerce.entity.dto;

import fr.doranco.ecommerce.entity.pojo.User;

public class CartePaiementDto {
	
	private Integer id;
	private String numeroCarte;
	private String dateValidation;
	private String crytogramme;
	private User user;
	
	
	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public CartePaiementDto() {
		
	}
	
	
	public CartePaiementDto(String numeroCarte, String dateValidation, String crytogramme, User user) {
		super();
		this.numeroCarte = numeroCarte;
		this.dateValidation = dateValidation;
		this.crytogramme = crytogramme;
		this.user = user;
	}




	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumeroCarte() {
		return numeroCarte;
	}


	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}


	public String getDateValidation() {
		return dateValidation;
	}


	public void setDateValidation(String dateValidation) {
		this.dateValidation = dateValidation;
	}


	public String getCrytogramme() {
		return crytogramme;
	}


	public void setCrytogramme(String crytogramme) {
		this.crytogramme = crytogramme;
	}




	
	

	
	
	

}

