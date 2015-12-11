package com.itparis.b3.associations.beans;

public class User {
	
	private int idUser;
	private int    typeUser;
	private String idAssociation;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Telephone;
	private String LibelleUser;
	
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}
	public String getTelephone() {
		return Telephone;
	}
	public void setTelephone(String telephone) {
		Telephone = telephone;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getTypeUser() {
		return typeUser;
	}
	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}
	public String getIdAssociation() {
		return idAssociation;
	}
	public void setIdAssociation(String idAssociation) {
		this.idAssociation = idAssociation;
	}
	public String getLibelleUser() {
		return LibelleUser;
	}
	public void setLibelleUser(String libelleUser) {
		LibelleUser = libelleUser;
	}
	
	
	

}
