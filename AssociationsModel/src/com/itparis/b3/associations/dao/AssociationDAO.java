package com.itparis.b3.associations.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.itparis.b3.associations.beans.Association;
import com.itparis.b3.associations.beans.AssociationDesc;
import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.bin.Connexion;
import com.itparis.b3.associations.common.DB.Queries;

public class AssociationDAO {
	
	private Association RemplirAssociation (ResultSet rs){
		
		Association a = new Association ();
		try {
            a.setId(rs.getInt("id"));
            a.setLibelle(rs.getString("LibelleAssociation"));
	        a.desc.setId(rs.getInt("idDesc"));
	        a.desc.setIdAssociation(rs.getInt("idAssociation"));
	        a.desc.setIdPresident(rs.getInt("idPresident"));
	        a.desc.setNbParticipant(rs.getInt("nbParticipant"));;
	        a.desc.setNomAssoc(rs.getString("nomAssoc"));
	        a.desc.setDescription(rs.getString("Description"));  
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		return a;
	}

	public ArrayList<Association> getListAssociation (String filtre) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String req = Queries.GetAssociationQuery + filtre;
		
		ArrayList <Association> lstAssoc = new  ArrayList<Association>();
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		    	Association a = RemplirAssociation (rs);
		    	lstAssoc.add(a);
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
		return lstAssoc;

	}
	
	public Association getAssociation (String filtre) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		String req = Queries.GetAssociationQuery + filtre;
		
		Association a = new Association ();
		
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		    	a = RemplirAssociation (rs);
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
		return a;
	}
	

}