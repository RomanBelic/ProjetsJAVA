package com.itparis.b3.associations.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import com.itparis.b3.associations.beans.Association;
import com.itparis.b3.associations.beans.AssociationDesc;
import com.itparis.b3.associations.beans.AssociationEvent;
import com.itparis.b3.associations.beans.Authentification;
import com.itparis.b3.associations.beans.FicheParticipant;
import com.itparis.b3.associations.beans.ParticipantEvents;
import com.itparis.b3.associations.beans.TypeUser;
import com.itparis.b3.associations.beans.User;

public class Utilities {
	
	public static String ConvertDBDateToFRDate (String dateString, char delimiter) {
		String formattedDate = "";
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    try {
			Date date = formatter.parse(dateString);
			formatter = new SimpleDateFormat("dd"+delimiter+"MM"+delimiter+"yyyy");
		    formattedDate = formatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return formattedDate;
	}
	
	public static String ConvertFRDateToDBDate (String dateString, char delimiter) {
		String formattedDate = "";
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd"+delimiter+"MM"+delimiter+"yyyy");
	    try {
			Date date = formatter.parse(dateString);
			formatter = new SimpleDateFormat("yyyy-MM-dd");
			formattedDate = formatter.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	    return formattedDate;
	}
	
	public static boolean isNullOrEmptyList (List<?> lstObj) {
		if (lstObj == null){
			return true;
		}
		if (lstObj != null) {
			if (lstObj.size() <= 0) {
		     	return true;
			}
		}
		return false;
	}
	
	public static boolean isNullOrEmptyString (String str) {
		if (str == null){
			return true;
		}
		if (str != null) {
			str = str.trim();
			if (str.equals("")) {
		     	return true;
			}
		}
		return false;
	}
	
	public static String encodeStringTo64Base (String str) {
		byte[] bytesEncoded = Base64.getEncoder().encode(str.getBytes());
        return new String(bytesEncoded);
	}
	
	public static String decodeStringFrom64Base (String str) {
		byte[] valueDecoded = Base64.getDecoder().decode(str);
		return new String (valueDecoded);
	}
	
	public static void setError (Object o) {
		int errCode = -1;
		
		if (o instanceof Association){
		    ((Association) o).setId(errCode);
		}
		if (o instanceof User){
            ((User) o).setId(errCode);
		}
		if (o instanceof AssociationEvent){
		    ((AssociationEvent) o).setId(errCode);
		}
		if (o instanceof Authentification){
			((Authentification)o).setLog(errCode+"");
			((Authentification)o).setIdUser(errCode);
		}
		if (o instanceof FicheParticipant){
			((FicheParticipant)o).setId(errCode);
		}
		if (o instanceof ParticipantEvents){
			((ParticipantEvents)o).setIdUser(errCode);
		}
		if (o instanceof TypeUser){
			((TypeUser)o).setId(errCode);
		}
		if (o instanceof AssociationDesc){
			((AssociationDesc)o).setId(errCode);
		}
		
	}
	
	

}
