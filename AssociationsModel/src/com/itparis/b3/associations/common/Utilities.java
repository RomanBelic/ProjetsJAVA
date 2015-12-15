package com.itparis.b3.associations.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	
	
	

}