package com.itparis.b3.associations.test;

import java.sql.SQLException;
import java.util.HashMap;

import com.itparis.b3.associations.common.DB;
import com.itparis.b3.associations.common.ReqMetier;
import com.itparis.b3.associations.common.Utilities;

public class TestQueries {
	
	public static void main (String[] args) throws SQLException{
		
	String req ="Select * from "+DB.Tables.Utilisateurs+"";
        ReqMetier.ExecuteSelect(req);
	}
}
