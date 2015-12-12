package com.itparis.b3.associations.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.common.DB;
import com.itparis.b3.associations.common.ReqMetier;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.metier.UserMetier;

public class TestQueries {
	
	public static void main (String[] args) throws SQLException{
		
		ArrayList<User> lstU = UserMetier.getUsers(0, 2);
		System.out.println(lstU.toString());
		
		User u = UserMetier.getUser(1);
		System.out.println(u.toString());

	}
}
