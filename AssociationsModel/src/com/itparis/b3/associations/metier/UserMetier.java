package com.itparis.b3.associations.metier;

import java.util.ArrayList;

import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.dao.UserDAO;

public class UserMetier {
	
	public static ArrayList <User> getUserByIdAssoc (int idAssoc) {	
		ArrayList<User> lstUser = new ArrayList<User>();
		String filtre = "";
		if (idAssoc > 0){
			try {
				filtre = " AND u.idAssociation = "+ idAssoc +" ";
				lstUser = UserDAO.class.newInstance().getListUser(filtre);
			} catch (InstantiationException | IllegalAccessException e) {}
		}
		return lstUser;
	}
	
	public static User getUserByIdUser (int id) {
		User u = new User ();
		try {
			u = UserDAO.class.newInstance().getUserByID(id);
		} catch (InstantiationException  | IllegalAccessException e) {}
        return u;
	}
	

}
