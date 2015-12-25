package com.itparis.b3.associations.metier;

import java.util.ArrayList;

import com.itparis.b3.associations.beans.AssociationEvent;
import com.itparis.b3.associations.beans.ParticipantEvents;
import com.itparis.b3.associations.common.DB;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.dao.EventDAO;

public class EventMetier {
	
	public static ArrayList <AssociationEvent> getListAssociationEvents (int idAssoc, String libEvent, String dateEvent,
			                                                         String OrderBy) {
		ArrayList <AssociationEvent> lstEvents = new ArrayList<AssociationEvent>();
		String filtre = "";
		if (idAssoc > 0){
		 filtre += " AND "+DB.AssociationEvents.alias+".idAssociation = "+idAssoc;
		}
		if (!Utilities.isNullOrEmptyString(libEvent)){
			filtre += " AND " +DB.AssociationEvents.alias+".LibelleEvent LIKE '%"+ libEvent+"%'";
		}
		if (!Utilities.isNullOrEmptyString(dateEvent)){
			filtre += " AND " +DB.AssociationEvents.alias+".dateEvent = '"+ dateEvent+"'";
		}
		if (!Utilities.isNullOrEmptyString(OrderBy)){
			filtre += " ORDER BY "+OrderBy;
		}	
		try {
			lstEvents = EventDAO.class.newInstance().getListAssociationEvents(filtre);
		} catch (InstantiationException | IllegalAccessException e) {}
		
		return lstEvents;	
	}
	
	public static AssociationEvent getAssociationEvent (int id) {
		AssociationEvent ae = new AssociationEvent ();
		String filtre = "";
		if (id > 0) {
			filtre += " AND "+DB.AssociationEvents.alias+".id = "+id;
		}
		try{
			ae = EventDAO.class.newInstance().getAssociationEvent(filtre);
		}
		catch (InstantiationException | IllegalAccessException e) {}
		
		return ae;
	}
	
	public static ArrayList<ParticipantEvents> getListParticipantEvents (int idAssoc, int idEvent, String 
			                                                             UserName,String OrderBy) {
		ArrayList <ParticipantEvents> lstParticipant = new ArrayList<ParticipantEvents>();
		String filtre = "";
		if (idAssoc > 0){
		     filtre += " AND "+DB.ParticipantEvents.alias+".idAssociation = "+idAssoc;
		}
		if (idEvent > 0){
			 filtre += " AND "+DB.ParticipantEvents.alias+".idEvenement = "+idEvent;
			}
		if (!Utilities.isNullOrEmptyString(UserName)){
			filtre += " AND " +DB.Utilisateurs.alias+".nomUtilisateur LIKE '"+ UserName+"'";
		}
		if (!Utilities.isNullOrEmptyString(OrderBy)){
			filtre += " ORDER BY "+OrderBy;
		}	
		try {
			lstParticipant = EventDAO.class.newInstance().getListParticipantEvents(filtre);
		} catch (InstantiationException | IllegalAccessException e) {}
		
		return lstParticipant;
	}

	public static ParticipantEvents getParticipantEvent (int idAssoc, int idUser, int idEvent) {
	    ParticipantEvents pe = new ParticipantEvents();
     	String filtre = "";
		if (idAssoc > 0){
	    	filtre += " AND "+DB.ParticipantEvents.alias+".idAssociation = "+idAssoc;
		}
		if (idUser > 0){
	     	filtre += " AND "+DB.ParticipantEvents.alias+".idUtilisateur = "+idUser;
		}
		if (idEvent > 0){
		    filtre += " AND " +DB.ParticipantEvents.alias+".idEvenement = "+ idEvent+"";
		}	
		try {
		    pe = EventDAO.class.newInstance().getParticipantEvents(filtre);
		} catch (InstantiationException | IllegalAccessException e) {}
	
	    return pe;
	}
	
	

}
