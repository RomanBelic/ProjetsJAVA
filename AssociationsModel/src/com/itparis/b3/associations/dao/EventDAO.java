package com.itparis.b3.associations.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itparis.b3.associations.beans.AssociationEvent;
import com.itparis.b3.associations.beans.ParticipantEvents;
import com.itparis.b3.associations.bin.Connexion;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.common.DB.Queries;

public class EventDAO {
	
	private AssociationEvent RemplirEvent (ResultSet rs) {
		AssociationEvent ae = new AssociationEvent ();
		try {
			ae.setId(rs.getInt("id"));
			ae.setIdAssoc(rs.getInt("idAssociation"));
			ae.setLibelleEvent(rs.getString("LibelleEvent"));
			ae.setDescEvent(rs.getString("descriptionEvent"));
			ae.setNbParticipant(rs.getInt("nbParticipant"));

			if (rs.getString("dateEvent") != null ) {
				String frdate = Utilities.ConvertDBDateToFRDate(rs.getString("dateEvent"), '-');
				ae.setDateEvent(frdate);
			}	
			else ae.setDateEvent("n/a");
			
		} catch (SQLException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return ae;
	}
	
	private ParticipantEvents RemplirParticipant (ResultSet rs) {
		ParticipantEvents pe = new ParticipantEvents ();
		
		try {
			pe.setIdEvent(rs.getInt("idEvenement"));
			pe.setIdAssoc(rs.getInt("idAssociation"));
			pe.setIdUser(rs.getInt("idUtilisateur"));
		    pe.setPresence(rs.getInt("Presence"));
	        pe.utilisateur.setId(rs.getInt("idUtilisateur"));
	        pe.utilisateur.setNom(rs.getString("nomUtilisateur"));
	        pe.utilisateur.setPrenom(rs.getString("prenomUtilisateur"));
	        pe.userType.setLibelle(rs.getString("Libelle"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return pe;
	}
	
	public ArrayList<ParticipantEvents> getListParticipantEvents (String filtre) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String req = Queries.GetEventParticipant + filtre;
		
		ArrayList <ParticipantEvents> lstParticipant = new  ArrayList<ParticipantEvents>();
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		    	ParticipantEvents pe = RemplirParticipant (rs);
		    	lstParticipant.add(pe);
	           	}
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			ParticipantEvents pe = new ParticipantEvents();
			Utilities.setError(pe);
			lstParticipant.add(pe);
		}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return lstParticipant;
	}
	
public ParticipantEvents getParticipantEvents (String filtre) {
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String req = Queries.GetEventParticipant + filtre;
		
		ParticipantEvents pe = new ParticipantEvents ();
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		    	pe = RemplirParticipant (rs);
	           	}
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			Utilities.setError(pe);
		}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return pe;
	}
	
	public ArrayList <AssociationEvent> getListAssociationEvents (String filtre){
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String req = Queries.GetEvent + filtre;
		
		ArrayList <AssociationEvent> lstEvent = new  ArrayList<AssociationEvent>();
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		    	AssociationEvent ae = RemplirEvent (rs);
		    	lstEvent.add(ae);
	           	}
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			AssociationEvent ae = new AssociationEvent();
			Utilities.setError(ae);
			lstEvent.add(ae);
		}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return lstEvent;
		
	}
	
	public AssociationEvent getAssociationEvent (String filtre){
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String req = Queries.GetEvent + filtre;
		
		AssociationEvent ae = new AssociationEvent ();
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		    	   ae = RemplirEvent (rs);
	           	}
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			Utilities.setError(ae);
		}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return ae;
		
	}
}
