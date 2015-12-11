package com.itparis.b3.associations.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.bin.Connexion;
import com.itparis.b3.associations.common.CustomError;


public class UserDAO {
	
	public ArrayList <User> getListUser (String filtre)
	{
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList <User> lstUser = new  ArrayList<User>();
		
	    String req = " Select u.nomUtilisateur as Nom, u.prenomUtilisateur as Prenom, " +
	    		     " u.adrUtilisateur as Adresse, u.telUtilisateur as Telephone, " + 
	    		     " u.idAssociation as idAssoc, u.typeUtilisateur as TypeUser, " +
	    		     " u.idUtilisateur as idUser, " + 
	    		     " t.Libelle as UserLibelle " +
	                 " From utilisateurs u " +
	                 " LEFT JOIN typeutilisateur t ON u.typeUtilisateur = t.idType " +
	    		     " Where 1=1 " + filtre;
	    req += " Order By nomUtilisateur ASC ";
	    try {
	    	con = Connexion.getConnection();
	    	st = con.createStatement();
	        rs = st.executeQuery(req);
	        while (rs.next()) {
	            User u = new User ();
	            
	            u.setIdUser(rs.getString("idUser"));
	            u.setTypeUser(rs.getInt("TypeUser"));
	            u.setLibelleUser(rs.getString("UserLibelle"));
	            u.setIdAssociation(rs.getString("idAssoc"));
	            u.setAdresse(rs.getString("Adresse"));
	            u.setTelephone(rs.getString("Telephone"));
	            u.setNom(rs.getString("Nom"));
	            u.setPrenom(rs.getString("Prenom"));
 
	            lstUser.add(u);
	        }
	    } 
	    catch (Exception e){}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return lstUser;
	}
	
	public User getUserByID (String id) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		String req = " Select u.nomUtilisateur as Nom, u.prenomUtilisateur as Prenom, " +
		   		     " u.adrUtilisateur as Adresse, u.telUtilisateur as Telephone, " + 
		   		     " u.idAssociation as idAssoc, u.typeUtilisateur as TypeUser, " +
		   		     " u.idUtilisateur as idUser, " + 
		   		     " t.Libelle as UserLibelle " +
		             " From utilisateurs u " +
		             " LEFT JOIN typeutilisateur t ON u.typeUtilisateur = t.idType " +
		   		     " Where 1=1 AND u.idUtilisateur = '" + id + "'";
		System.out.println(req);
		User u = new User ();
		try {
		    con = Connexion.getConnection();
		    st = con.createStatement();
		    rs = st.executeQuery(req);
		    while (rs.next()) {		            
		            u.setIdUser(rs.getString("idUser"));
		            u.setTypeUser(rs.getInt("TypeUser"));
		            u.setLibelleUser(rs.getString("UserLibelle"));
		            u.setIdAssociation(rs.getString("idAssoc"));
		            u.setAdresse(rs.getString("Adresse"));
		            u.setTelephone(rs.getString("Telephone"));
		            u.setNom(rs.getString("Nom"));
		            u.setPrenom(rs.getString("Prenom"));
	           	}
		}
		catch (Exception e){}
	    try {
	    	if (rs != null) rs.close();
	    	if (st != null) st.close();
	    	if (con != null) con.close();
	    }
	    catch (Exception e){}
		return u;	
	}

}
