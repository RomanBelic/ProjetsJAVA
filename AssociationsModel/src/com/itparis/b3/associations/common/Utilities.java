package com.itparis.b3.associations.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	
	

}
