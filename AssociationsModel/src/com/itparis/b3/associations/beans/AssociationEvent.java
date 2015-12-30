package com.itparis.b3.associations.beans;
/*
 * Classe AssociationEvent est un modele de donnees;
 * Sert a representer l'evenement des associations;
 * Elle a la meme structure que la table "associationevents" dans la BDD;
 * Proprietes de la Classe : 
    - int id;
    - int idAssoc;
    - int nbParticipant;
    - String dateEvent;
    - String libelleEvent;
    - String descEvent;
    + List<ParticipantEvents>lstParticipant;
 * */

import java.util.ArrayList;
import java.util.List;

public class AssociationEvent {
	
	private int    id;
	private int    idAssoc;
    private int    nbParticipant;
    private String dateEvent;
    private String libelleEvent;
    private String descEvent;
    
    public List<ParticipantEvents> lstParticipant;
    
    public AssociationEvent () {
    	lstParticipant = new ArrayList<ParticipantEvents>();
    }
    
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
