package com.itparis.b3.associations.beans;
/*
 * Classe User est un modele de donnees;
 * Sert a representer l'utilisateur;
 * Elle a la meme structure que la table "utilisateurs" dans la BDD;
 * Proprietes de la Classe : 
	- int    id;
	- String Nom;
	- String Prenom;
	- String Adresse;
	- String Telephone;
	
	+ List<Association> assoc;
	+ TypeUser type;
 * */

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private int    id;
	private String Nom;
	private String Prenom;
	private String Adresse;
	private String Telephone;
	
	public List<Association> assoc;
	public TypeUser type;
	
	public User () {
		type = new TypeUser ();
		assoc = new ArrayList<Association>();
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
