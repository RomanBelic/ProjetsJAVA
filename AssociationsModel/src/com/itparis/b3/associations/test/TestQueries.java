package com.itparis.b3.associations.test;

import java.sql.SQLException;
import java.util.HashMap;

import com.itparis.b3.associations.common.DATABASE;
import com.itparis.b3.associations.common.ReqMetier;

public class TestQueries {
	
	public static void main (String[] args) throws SQLException{

		HashMap<String,String> paramsTable = new HashMap<String,String>();
		paramsTable.put("nomUtilisateur", "'idUser3'");
		paramsTable.put("typeUtilisateur", "3");
		
		
		HashMap<String,String> paramsWhere = new HashMap<String,String>();
		paramsWhere.put("AND", "idUtilisateur='idUser1'");
		
	    ReqMetier.ExecuteParameteredUpdate(DATABASE.Tables.Utilisateurs, paramsTable, paramsWhere);
        //System.out.println(test);
        
       // ReqMetier.ExecuteUpdate("Update "+DATABASE.Tables.Utilisateurs+" SET nomUtilisateur = 'nomUtilisateur'");
		
	}
}
