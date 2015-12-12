package com.itparis.b3.associations.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.bin.Connexion;
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
	        u.assoc.setId(rs.getInt("idAssociation")); 
	        u.assoc.setLibelle(rs.getString("LibelleAssociation")); 
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		
		return u;
	}
	
	public ArrayList <User> getListUser (String filtre)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList <User> lstUser = new  ArrayList<User>();
		
	    String req = Queries.GetUserQuery + filtre;
	    req += " Order By nomUtilisateur ASC ";
	    
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
