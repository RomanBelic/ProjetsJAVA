package com.itparis.b3.associations.common;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.itparis.b3.associations.bin.Connexion;

public class ReqMetier {

	public static int ExecuteUpdate (String req) {
		int rows = 0;
		Connection con = null;
		Statement st = null;
        try {
        	con = Connexion.getConnection();
        	st = con.createStatement();
        	rows = st.executeUpdate(req);
        }	
        catch (Exception e) {
        	e.getMessage();
        	e.printStackTrace();
        }		
		try {
			if (st != null) st.close();
			if (con != null)con.close();
    	}
		catch (Exception e){}
		return rows;
	}
	
	public static int ExecutePreparedQuery(String req, HashMap<Integer,String> params) {
		int rows = 0;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = Connexion.getConnection();
		    st = con.prepareStatement(req);
		    if (params.size()>0){
				for (Map.Entry<Integer, String> entry : params.entrySet()) {	
				  st.setString(entry.getKey(), entry.getValue());	
				}
		    }
		    rows = st.executeUpdate();
		}
		catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		try {
			if (st != null) st.close();
			if (con != null) con.close();
    	}
		catch (Exception e){}
		return rows;
	}
	
	public int ExecutePreparedUpdateQuery (String table, HashMap<Integer,String>params){
		int rows = 0;
		String req = "Update " + table + " SET ";
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			con= Connexion.getConnection();
			st = con.prepareStatement(req);
		
		
		for (Map.Entry<Integer, String> entry : params.entrySet()){

			
		}
		
		}
		
		
		return 0;
	}
	
	

	

}
