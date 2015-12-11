package com.itparis.b3.associations.test;

import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.common.CustomError;
import com.itparis.b3.associations.common.ReqMetier;
import com.itparis.b3.associations.metier.AuthMetier;
import com.itparis.b3.associations.metier.UserMetier;

public class TestQueries {
	
	public static void main (String[] args) throws SQLException{

		String code = "test chain";
		code = ""+code.hashCode();
		System.out.println(code);
		
		boolean  bool =  AuthMetier.CheckAuthentification("test", "test");
		System.out.println(bool);
	     
		int test = ReqMetier.ExecuteParameteredUpdate("utilisateurs", paramsTable, paramsWhere);
   
	}
}
