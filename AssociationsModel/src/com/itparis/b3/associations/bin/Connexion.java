package com.itparis.b3.associations.bin;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Classe Connexion;
 * Contient les methodes et parametres de connexion a la BDD;
 * */
public final class Connexion  {
	
	private static final String host = "localhost";
	private static final String log = "root";
	private static final String pass = "";
	private static final String db = "dbassociations";
	private static final String driver = "jdbc:mysql:";
	private static final String driverClass = "com.mysql.jdbc.Driver";
	private static final String dbparams = "?zeroDateTimeBehavior=convertToNull&autoReconnect=true&"
			                                   + "characterEncoding=UTF-8&characterSetResults=UTF-8"
                                               + "&allowMultiQueries=true";
	
	private static Connexion instance = new Connexion();
 
	private Connexion ()
	{
		try {
			Class.forName(driverClass);
			}
		catch (Exception e){
			e.printStackTrace();
			e.getMessage();
		}
	}

    private Connection CreateConnection () 
	{
    	Connection con = null;
        try {
            con = DriverManager.getConnection(driver + "//" + host + "/" + db + dbparams, log, pass);
        }
        catch (Exception e)
        {
        	e.getMessage();
        	System.out.println("connection could not be opened ");
        }
        return con;
	}
    
    public static Connection getConnection ()
    {
    	return instance.CreateConnection();
    }  
    
}
