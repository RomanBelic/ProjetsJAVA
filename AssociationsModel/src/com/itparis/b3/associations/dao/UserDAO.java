package com.itparis.b3.associations.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itparis.b3.associations.beans.*;
import com.itparis.b3.associations.bin.Connexion;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.common.DB.*;

public class UserDAO {
	
	private User RemplirUser (ResultSet rs){
		User u = new User ();
		try {
	        u.setId(rs.getInt("id"));
	        u.setAdresse(rs.getString("adrUtilisateur"));
	        u.setTelephone(rs.getString("telUtilisateur"));
	        u.setNom(rs.getString("nomUtilisateur"));
	        u.setPrenom(rs.getString("prenomUtilisateur"));
	        u.type.setId(rs.getInt("idType"));
	        u.type.setLibelle(rs.getString("Libelle")); 
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		
		return u;
	}
	
	private User RemplirSimpleUser (ResultSet rs){
		User u = new User ();
		try {
	        u.setId(rs.getInt("id"));
	        u.setNom(rs.getString("nomUtilisateur"));
	        u.setPrenom(rs.getString("prenomUtilisateur"));
	        u.setStatut(rs.getInt("Statut"));
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		return u;
	}
	
	private FicheParticipant RemplirFicheParticipant (ResultSet rs){
		FicheParticipant fp = new FicheParticipant ();
		try {
            fp.setIdUser(rs.getInt("idUtilisateur"));
            fp.setId(rs.getInt("id"));
            fp.setIdAssoc(rs.getInt("idAssociation"));
            
            if (rs.getString("dateInscription") != null ){
                String dateInsc = Utilities.ConvertDBDateToFRDate(rs.getString("dateInscription"), '-');
                fp.setDateInscription(dateInsc);
            }
            else
            	 fp.setDateInscription("n/a");
            
            if (rs.getString("dateDesinscription") != null) {
            	String dateDesinsc =  Utilities.ConvertDBDateToFRDate(rs.getString("dateDesinscription"), '-');
            	fp.setDateDesinscription(dateDesinsc);
            }
            else
            	fp.setDateDesinscription("n/a");
            
            fp.setNotes(rs.getString("Notes"));
            fp.setAnciennete(rs.getInt("Anciennete"));
            
            fp.utilisateur.setId(rs.getInt("idUtilisateur"));
            fp.utilisateur.setAdresse(rs.getString("adrUtilisateur"));
            fp.utilisateur.setTelephone(rs.getString("telUtilisateur"));
            fp.utilisateur.setNom(rs.getString("nomUtilisateur"));
            fp.utilisateur.setPrenom(rs.getString("prenomUtilisateur"));
            fp.utilisateur.type.setLibelle(rs.getString("Libelle"));
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		return fp;
	}
	
	public ArrayList <User> getListUser (String filtre)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList <User> lstUser = new  ArrayList<User>();
		
	    String req = Queries.GetUserQuery + filtre;
	    
	    try {
	    	con = Connexion.getConnection();
	    	st = con.createStatement();
	        rs = st.executeQuery(req);
	        while (rs.next()) {
	            User u = RemplirUser (rs);
	            lstUser.add(u);
	        }
	    } 
	    catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			User u = new User();
			Utilities.setError(u);
			lstUser.add(u);
	    }
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return lstUser;
	}
	
	public User getUser (String filtre) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String req = Queries.GetUserQuery + filtre;
		
		User u = new User ();
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		    	u = RemplirUser (rs);
	           	}
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			Utilities.setError(u);
		}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return u;	
	}
	
	public ArrayList <FicheParticipant> getListFicheParticipant (String filtre)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList <FicheParticipant> lstFiche = new  ArrayList<FicheParticipant>();
		
	    String req = Queries.GetFicheParticipant + filtre;
	    
	    try {
	    	con = Connexion.getConnection();
	    	st = con.createStatement();
	        rs = st.executeQuery(req);
	        while (rs.next()) {
	        	FicheParticipant fp = RemplirFicheParticipant (rs);
	            lstFiche.add(fp);
	        }
	    } 
	    catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			FicheParticipant fp = new FicheParticipant();
			Utilities.setError(fp);
			lstFiche.add(fp);
	    }
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return lstFiche;
	}
	
	public FicheParticipant getFicheParticipant (String filtre)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		FicheParticipant fp = new  FicheParticipant();
		
	    String req = Queries.GetFicheParticipant + filtre;
	    
	    try {
	    	con = Connexion.getConnection();
	    	st = con.createStatement();
	        rs = st.executeQuery(req);
	        while (rs.next()) {
	            fp = RemplirFicheParticipant (rs);
	        }
	    } 
	    catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			Utilities.setError(fp);
	    }
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return fp;
	}
	
	
	public ArrayList <User> getListUserByState (String filtre)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList <User> lstUser = new  ArrayList<User>();
		
	    String req = Queries.GetUserByStatusQuery + filtre;
	    
	    try {
	    	con = Connexion.getConnection();
	    	st = con.createStatement();
	        rs = st.executeQuery(req);
	        while (rs.next()) {
	            User u = RemplirSimpleUser (rs);
	            lstUser.add(u);
	        }
	    } 
	    catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			User u = new User();
			Utilities.setError(u);
			lstUser.add(u);
	    }
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return lstUser;
	}
	
	public User getUserSimple (String filtre)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		User u = new User();
		
	    String req = Queries.GetUserByStatusQuery + filtre;
	    
	    try {
	    	con = Connexion.getConnection();
	    	st = con.createStatement();
	        rs = st.executeQuery(req);
	        while (rs.next()) {
	            u = RemplirSimpleUser (rs);
	        }
	    } 
	    catch (Exception e){
			e.getMessage();
			e.printStackTrace();
			Utilities.setError(u);
	    }
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return u;
	}

}
