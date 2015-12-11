package com.itparis.b3.associations.metier;

import com.itparis.b3.associations.dao.AuthDAO;

public class AuthMetier {
	
	public static  boolean CheckAuthentification (String Log, String Pass){
		boolean check = false;
		
		if (Log != "" && Pass != "" ){
			try {
				check = AuthDAO.class.newInstance().checkUserData (Log,Pass);
			} catch (InstantiationException | IllegalAccessException e) {}
		}
		
		return check;
	}
	
	

}
