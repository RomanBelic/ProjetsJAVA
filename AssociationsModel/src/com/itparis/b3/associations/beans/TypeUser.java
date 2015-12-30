package com.itparis.b3.associations.beans;
/*
 * Classe TypeUser est un modele de donnees;
 * Sert a representer le type d'utilisateur;
 * Elle a la meme structure que la table "typeutilisateur" dans la BDD;
 * Proprietes de la Classe : 
	- int    id;
	- String Libelle;
 * */

public class TypeUser {
	
	private int    id;
	private String Libelle;
	
	public int getId() {
		return id;
	}
	public void setId(int idType) {
		this.id = idType;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
}
