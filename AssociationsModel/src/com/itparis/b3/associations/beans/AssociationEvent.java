package com.itparis.b3.associations.beans;

public class AssociationEvent {
	
	private int    id;
	private int    idAssoc;
    private int    nbParticipant;
    private String dateEvent;
    private String libelleEvent;
    private String descEvent;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAssoc() {
		return idAssoc;
	}
	public void setIdAssoc(int idAssoc) {
		this.idAssoc = idAssoc;
	}
	public int getNbParticipant() {
		return nbParticipant;
	}
	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}
	public String getDateEvent() {
		return dateEvent;
	}
	public void setDateEvent(String dateEvent) {
		this.dateEvent = dateEvent;
	}
	public String getLibelleEvent() {
		return libelleEvent;
	}
	public void setLibelleEvent(String libelleEvent) {
		this.libelleEvent = libelleEvent;
	}
	public String getDescEvent() {
		return descEvent;
	}
	public void setDescEvent(String descEvent) {
		this.descEvent = descEvent;
	}
    
    
}