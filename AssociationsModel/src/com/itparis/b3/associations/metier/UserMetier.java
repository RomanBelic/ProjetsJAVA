package com.itparis.b3.associations.metier;

import java.util.ArrayList;

import com.itparis.b3.associations.beans.FicheParticipant;
import com.itparis.b3.associations.beans.User;
import com.itparis.b3.associations.dao.UserDAO;
import com.itparis.b3.associations.common.DB;
import com.itparis.b3.associations.common.Utilities;

public class UserMetier {
	
	public static ArrayList <User> getListUsers (int idAssoc, int idType, String OrderBy) {	
		ArrayList<User> lstUser = new ArrayList<User>();
		String filtre = "";
		if (idAssoc > 0){
			filtre += " AND "+DB.Utilisateurs.alias+".id IN (Select "+DB.FicheParticipant.alias+".idUtilisateur "+
					  " From "+DB.FicheParticipant+" "+DB.FicheParticipant.alias +
					  " Where "+DB.FicheParticipant.alias+".idAssociation = "+idAssoc+")";
		}
		if (idType > 0) {
			filtre += " AND "+DB.Utilisateurs.alias+".idType = "+ idType;
		}
		if (!Utilities.isNullOrEmptyString(OrderBy)){
			filtre += " ORDER BY "+OrderBy;
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
	
	public static ArrayList <FicheParticipant> getListFicheParticipant (int idAssoc, int idUser, int typeUser,
			                                                            String userName, String OrderBy) {	
		ArrayList<FicheParticipant> lstFiche = new ArrayList<FicheParticipant>();
		String filtre = "";
		if (idAssoc > 0){
			filtre += " AND "+DB.FicheParticipant.alias+".idAssociation = "+ idAssoc;
		}
		if (idUser > 0) {
			filtre += " AND "+DB.FicheParticipant.alias+".idUtilisateur = "+ idUser;
		}
		if (typeUser > 0) {
			filtre += " AND "+DB.TypeUtilisateurs.alias+".id = "+ typeUser;
		}
		if (!Utilities.isNullOrEmptyString(userName)){
			filtre += " AND "+DB.Utilisateurs.alias+".nomUtilisateur LIKE '"+userName+"'";
		}
		if (!Utilities.isNullOrEmptyString(OrderBy)){
			filtre += " ORDER BY "+OrderBy;
		}
		try {
			lstFiche = UserDAO.class.newInstance().getListFicheParticipant(filtre);
		} 
		catch (InstantiationException | IllegalAccessException e) {}
		return lstFiche;
	}
	public static FicheParticipant getFicheParticipant (int idFiche) {	
		FicheParticipant fp = new FicheParticipant();
		String filtre = "";
		if (idFiche > 0){
	    	filtre += " AND "+DB.FicheParticipant.alias+".id = "+ idFiche;
		}
		try {
			fp = UserDAO.class.newInstance().getFicheParticipant(filtre);
		} 
		catch (InstantiationException | IllegalAccessException e) {}
		return fp;
		}
	
	public static ArrayList<User> getListUsersByStatus (int status, String userName, String OrderBy) {
		ArrayList <User> lstUser = new ArrayList<User> ();
		String filtre = "";
        filtre += " AND " +DB.Utilisateurs.alias+".Statut ="+ status;
		if (!Utilities.isNullOrEmptyString(userName)){
			filtre += " AND "+DB.Utilisateurs.alias+".nomUtilisateur LIKE '"+userName+"'";
		}
        if (!Utilities.isNullOrEmptyString(OrderBy)){
        	filtre += " ORDER BY "+OrderBy;
        }
		try {
			lstUser = UserDAO.class.newInstance().getListUserByState(filtre);
		}
		catch (InstantiationException | IllegalAccessException e) {}
		
		return lstUser;
	}
	
	public static User getUserForAdmin (int id) {
		User u = new User ();
		String filtre = "";
		if (id > 0){
			filtre += " AND "+DB.Utilisateurs.alias+".id = "+id;
		}
		try {
			u = UserDAO.class.newInstance().getUserSimple(filtre);
		} 
		catch (InstantiationException  | IllegalAccessException e) {}
        return u;
	}
	
	
	

}
