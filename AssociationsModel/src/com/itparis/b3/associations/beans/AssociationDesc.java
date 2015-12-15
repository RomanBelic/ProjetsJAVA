package com.itparis.b3.associations.beans;

public class AssociationDesc {

	private int    id;
	private int    idAssociation;
	private int    idPresident;
	private int    nbParticipant;
	private String nomAssoc;
	private String description;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAssociation() {
		return idAssociation;
	}
	public void setIdAssociation(int idAssociation) {
		this.idAssociation = idAssociation;
	}
	public int getIdPresident() {
		return idPresident;
	}
	public void setIdPresident(int idPresident) {
		this.idPresident = idPresident;
	}
	public String getNomAssoc() {
		return nomAssoc;
	}
	public void setNomAssoc(String nomAssoc) {
		this.nomAssoc = nomAssoc;
	}
	public int getNbParticipant() {
		return nbParticipant;
	}
	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
