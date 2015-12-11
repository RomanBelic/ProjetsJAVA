package com.itparis.b3.associations.common;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itparis.b3.associations.bin.Connexion;

public class ReqMetier {

	public static int ExecuteUpdate(String req) {
		int rows = 0;
		Connection con = null;
		Statement st = null;
		try {
			con = Connexion.getConnection();
			st = con.createStatement();
			rows = st.executeUpdate(req);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
		return rows;
	}

	public static int ExecutePreparedUpdate(String req,
			HashMap<Integer, String> params) {
		int rows = 0;
		Connection con = null;
		PreparedStatement st = null;
		try {
			con = Connexion.getConnection();
			st = con.prepareStatement(req);
			if (params.size() > 0) {
				for (Map.Entry<Integer, String> entry : params.entrySet()) {
					st.setString(entry.getKey(), entry.getValue());
				}
			}
			rows = st.executeUpdate();
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
		}
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
		return rows;
	}

	public static int ExecuteParameteredUpdate(String table,HashMap<String, String> paramsTable,
			                                   HashMap<String, String> paramsWhere) {
		int rows = 0;
		String req = "Update " + table + " SET ";
		Connection con = null;
		Statement st = null;
		try {
			con = Connexion.getConnection();
			st = con.createStatement();

			if (paramsTable.size() > 0) {
				for (Map.Entry<String, String> entry : paramsTable.entrySet()) {
					req += entry.getKey() + " = " + entry.getValue() + ", ";
				}
				int index = req.lastIndexOf(",");
				req = req.substring(0, index);
			}

			req += " Where 1=1 ";

			if (paramsWhere.size() > 0) {
				for (Map.Entry<String, String> entry : paramsWhere.entrySet()) {
					req += entry.getKey() + " " + entry.getValue() + " ";
				}
			}
			rows = st.executeUpdate(req);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
		}
		return rows;
	}

	public static int ExecuteParameteredDelete(String table, HashMap<String, String> paramsWhere) {
		int rows = 0;
		String req = "Delete From " + table + " Where 1=1 ";
		Connection con = null;
		Statement st = null;
		try {
			con = Connexion.getConnection();
			st = con.createStatement();

			if (paramsWhere.size() > 0) {
				for (Map.Entry<String, String> entry : paramsWhere.entrySet()) {
					req += entry.getKey() + " " + entry.getValue() + " ";
				}
			}
			rows = st.executeUpdate(req);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {	
		}
		return rows;
	}
	
	public static int ExecuteParameteredInsert(String table, HashMap<String,String>paramsTable) {
		int rows = 0;
		Connection con = null;
		Statement st = null;
		String req = "Insert Into "+ table +" (";
		try {
			con = Connexion.getConnection();
			st = con.createStatement();
			
			if (paramsTable.size() > 0) {
				for (Map.Entry<String, String> entry : paramsTable.entrySet()) {
					req += entry.getKey()+ ", ";
				}
				int index = req.lastIndexOf(",");
				req = req.substring(0, index);
			}
			
			req +=") Values (";
			
			if (paramsTable.size() > 0) {
				for (Map.Entry<String, String> entry : paramsTable.entrySet()) {
					req += entry.getValue()+ ", ";
				}
				int index = req.lastIndexOf(",");
				req = req.substring(0, index);
			}
			req += ")";
			
			rows = st.executeUpdate(req);
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {	
		}
		return rows;
	}
	
	//TODO
	public static void ExecuteSelect (String req) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		List <String> lst;
		int i = 0;
		try {
			lst = new ArrayList<String> ();
			con = Connexion.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(req);
				while (rs.next()){
				i++;	
				String s = rs.getString(1);
				lst.add(s);
				}
				
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		try {
			if (rs != null) rs.close();
			if (st != null) st.close();
			if (con != null)con.close();
		} catch (Exception e) {
		}
	}
	
	

}
