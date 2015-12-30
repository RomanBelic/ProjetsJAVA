package com.itparis.b3.associations.beans;

/*
 * Classe Association est un modele de donnees;
 * Sert a representer les associations;
 * Elle a la meme structure que la table "association" dans la BDD;
 * Proprietes de la classe : 
     - int id;
     - String Libelle;
     + AssociationDesc desc;
 */
public class Association {
	
	private int    id;
	private String Libelle;
	
	public AssociationDesc desc;
	
	public Association () {
		desc = new AssociationDesc();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
}
