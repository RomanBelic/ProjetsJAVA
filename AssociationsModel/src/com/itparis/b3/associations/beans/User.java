package com.itparis.b3.associations.beans;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int    id;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Telephone;
	
	public List<Association> lstAssoc;
	public TypeUser type;
	
	public User () {
		type = new TypeUser ();
		lstAssoc = new ArrayList<Association>();
	}
	
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
	public int getId() {
		return id;
	}
	public void setId(int idUser) {
		this.id = idUser;
	}
	
}
