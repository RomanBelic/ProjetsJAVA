package com.iteiffel.ece.b3.dwm.TPGraph.bin;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Roman
 *
 */
public final class Connexion {

	private static final String host = "localhost";
	private static final String log = "root";
	private static final String pass = "";
	private static final String db = "rencontres";
	private static final String driver = "jdbc:mysql:";
	private static String driverClass = "com.mysql.jdbc.Driver";

	private static Connexion instance = new Connexion();

	private Connexion() {
		try {
			Class.forName(driverClass);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	private Connection CreateConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(driver + "//" + host + "/" + db,
					log, pass);
		} catch (Exception e) {
			e.getMessage();
			System.out.println("connection could not be opened ");
		}
		return con;
	}

	public static Connection getConnection() {
		return instance.CreateConnection();
	}

	@Override
	protected void finalize() {
		instance.finalize();
	}

	public static void main(String[] args) {
		Connexion.getConnection();
	}

}
