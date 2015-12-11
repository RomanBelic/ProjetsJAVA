package com.itparis.b3.associations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itparis.b3.associations.bin.Connexion;

public class AuthDAO {
	
	public boolean checkUserData (String Log, String Pass){
		boolean check = false;	
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		String query = "Select Login, MDP From authentification Where Login = ? and MDP = ? ";
		
		try {
			con = Connexion.getConnection();
			st = con.prepareStatement(query);
			st.setString(1, Log);
			st.setString(2, Pass);
			
		    rs = st.executeQuery();
		    check = rs.next();
		}
		catch (Exception e) {}
	    try {
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
		catch (Exception e){}
		return check;
	}
	
	
	
	
	

}
