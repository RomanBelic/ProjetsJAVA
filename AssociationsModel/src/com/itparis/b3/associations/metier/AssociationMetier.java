package com.itparis.b3.associations.metier;

import java.util.ArrayList;

import com.itparis.b3.associations.beans.Association;
import com.itparis.b3.associations.common.Utilities;
import com.itparis.b3.associations.common.DB;
import com.itparis.b3.associations.dao.AssociationDAO;

public class AssociationMetier {
	
	public static ArrayList<Association> getListAssociations (String nomAssoc, String OrderBy){
		ArrayList<Association>lstAssoc = new ArrayList <Association> ();
		String filtre = "";
		if (!Utilities.isNullOrEmptyString(nomAssoc))
		{
			filtre += " AND " +DB.AssociationDesc.alias+".nomAssoc LIKE '%"+ nomAssoc+"%'";
		}
		if (!Utilities.isNullOrEmptyString(OrderBy)){
			filtre += " ORDER BY "+OrderBy;
		}
		
		try {
			lstAssoc = AssociationDAO.class.newInstance().getListAssociation(filtre);
		} catch (InstantiationException | IllegalAccessException e) {}
		
		return lstAssoc;
	}
	
	public static Association getAssociation (int id) {
		Association a = new Association ();
		String filtre = "";
		if (id > 0){
			filtre += " AND " +DB.Association.alias+".id ="+ id;
		}
		try {
			a = AssociationDAO.class.newInstance().getAssociation(filtre);
		} 
		catch (InstantiationException  | IllegalAccessException e) {}
        return a;
	}
	
	
	
	
	

}
