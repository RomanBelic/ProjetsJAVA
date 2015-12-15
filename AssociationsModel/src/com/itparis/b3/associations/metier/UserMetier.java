package com.itparis.b3.associations.metier;

import java.util.ArrayList;

import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.dao.UserDAO;
import com.itparis.b3.associations.common.DB;
import com.itparis.b3.associations.common.Utilities;

public class UserMetier {
	
	public static ArrayList <User> getUsers (int idAssoc, int idType, String OrderBy) {	
		ArrayList<User> lstUser = new ArrayList<User>();
		String filtre = "";
		if (idAssoc > 0){
			filtre += " AND "+DB.Utilisateurs.alias+".idAssociation = "+ idAssoc;
			
		}
		if (idType > 0) {
			filtre += " AND "+DB.Utilisateurs.alias+".idType = "+ idType;
		}
		if (Utilities.isNullOrEmptyString(OrderBy)){
			filtre += OrderBy;
		}

		try {
			lstUser = UserDAO.class.newInstance().getListUser(filtre);
		} 
		catch (InstantiationException | IllegalAccessException e) {}
		return lstUser;
	}
	
	public static User getUser (int id) {
		User u = new User ();
		String filtre = "";
		if (id > 0){
			filtre += " AND "+DB.Utilisateurs.alias+".id = "+id;
		}
		
		try {
			u = UserDAO.class.newInstance().getUser(filtre);
		} 
		catch (InstantiationException  | IllegalAccessException e) {}
        return u;
	}
	

}
