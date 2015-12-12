package com.itparis.b3.associations.metier;

import java.util.ArrayList;

import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.dao.UserDAO;

public class UserMetier {
	
	public static ArrayList <User> getUsers (int idAssoc, int idType) {	
		ArrayList<User> lstUser = new ArrayList<User>();
		String filtre = "";
		if (idAssoc > 0){
			filtre += " AND u.idAssociation = "+ idAssoc +" ";
		}
		if (idType > 0) {
			filtre += " AND u.idType = "+ idType +" ";
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
			filtre += " AND u.id = "+id+" ";
		}
		
		try {
			u = UserDAO.class.newInstance().getUser(filtre);
		} 
		catch (InstantiationException  | IllegalAccessException e) {}
        return u;
	}
	

}
