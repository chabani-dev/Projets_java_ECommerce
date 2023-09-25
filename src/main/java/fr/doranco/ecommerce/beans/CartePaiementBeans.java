package fr.doranco.ecommerce.beans;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "userbean")
@SessionScoped

public class CartePaiementBeans implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(name = "numeroCarte", value = "")
	private byte[] numeroCarte;
	
	@ManagedProperty(name = "dateValidation", value = "")
	private String dateValidation;
	
	
	@ManagedProperty(name = "crytogramme", value = "")
	private byte[] crytogramme; 
	
	
	private static String messageSuccess = "";
	private static String messageError = "";
	
	
	
	public CartePaiementBeans() {
	
	}



	public CartePaiementBeans(byte[] numeroCarte, String dateValidation, byte[] crytogramme) {
	
		this.numeroCarte = numeroCarte;
		this.dateValidation = dateValidation;
		this.crytogramme = crytogramme;
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



	public static String getMessageSuccess() {
		return messageSuccess;
	}



	public static void setMessageSuccess(String messageSuccess) {
		CartePaiementBeans.messageSuccess = messageSuccess;
	}



	public static String getMessageError() {
		return messageError;
	}



	public static void setMessageError(String messageError) {
		CartePaiementBeans.messageError = messageError;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}





}
