package com.itparis.b3.associations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itparis.b3.associations.beans.Authentification;
import com.itparis.b3.associations.bin.Connexion;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.common.DB.*;

public class AuthDAO {
	
	public boolean checkUserData (String Log, String Pass){
		boolean check = false;	
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
        String query = Queries.GetLoginPassQuery;
        
		try {
			con = Connexion.getConnection();
			st = con.prepareStatement(query);
			st.setString(1, Log);
			st.setString(2, Pass);
			
		    rs = st.executeQuery();
		    check = rs.next();
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
	    try {
	     	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
		catch (Exception e){}
		return check;
	}
	
	public Authentification getUserAuthData (String Log, String Pass){
		Authentification auth = new Authentification ();	
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
        String query = Queries.GetUserData;
        
		try {
			con = Connexion.getConnection();
			st = con.prepareStatement(query);
			st.setString(1, Log);
			st.setString(2, Pass);
			
		    rs = st.executeQuery();
		    
		    while (rs.next()) {
		    	auth.setIdUser(rs.getInt("idUtilisateur"));
		    	auth.setLog(rs.getString("Login"));
		    	auth.setPass(rs.getString("MDP"));
		    }
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			Utilities.setError(auth);
		}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
		catch (Exception e){}
		return auth;
	}
	
	
	
	
	
	

}
