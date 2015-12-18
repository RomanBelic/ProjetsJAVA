package com.itparis.b3.associations.metier;

import com.itparis.b3.associations.beans.Authentification;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.dao.AuthDAO;

public class AuthMetier {
	
	public static boolean CheckAuthentification (String Log, String Pass){
		boolean check = false;
		
		if (!Utilities.isNullOrEmptyString(Log) && !Utilities.isNullOrEmptyString(Pass)){
			try {
				check = AuthDAO.class.newInstance().checkUserData (Log,Pass);
			} 
			catch (InstantiationException | IllegalAccessException e) {}
		}
		return check;
	}
	
	public static Authentification getUserAuthData (String Log, String Pass) {
		Authentification auth = new Authentification();
		
		if (!Utilities.isNullOrEmptyString(Log) && !Utilities.isNullOrEmptyString(Pass)){
			try {
				auth = AuthDAO.class.newInstance().getUserAuthData (Log,Pass);
			} 
			catch (InstantiationException | IllegalAccessException e) {}
		}
		return auth;
	}
	
	
	

}
