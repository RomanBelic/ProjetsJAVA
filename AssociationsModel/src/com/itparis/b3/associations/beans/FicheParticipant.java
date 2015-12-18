package com.itparis.b3.associations.beans;

public class FicheParticipant {
	
	private int    id;
	private int    idUser;
	private int    idAssoc;
	private int    anciennete;
	private String dateInscription;
	private String dateDesinscription;
	private String notes;
	
	public User utilisateur;
	
	public FicheParticipant () {
		utilisateur = new User ();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdAssoc() {
		return idAssoc;
	}
	public void setIdAssoc(int idAssoc) {
		this.idAssoc = idAssoc;
	}
	public int getAnciennete() {
		return anciennete;
	}
	public void setAnciennete(int anciennete) {
		this.anciennete = anciennete;
	}
	public String getDateInscription() {
		return dateInscription;
	}
	public void setDateInscription(String dateInscription) {
		this.dateInscription = dateInscription;
	}
	public String getDateDesinscription() {
		return dateDesinscription;
	}
	public void setDateDesinscription(String dateDesinscription) {
		this.dateDesinscription = dateDesinscription;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}	
}
