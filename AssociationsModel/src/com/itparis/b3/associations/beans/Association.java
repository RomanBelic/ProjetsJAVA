package com.itparis.b3.associations.beans;

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
