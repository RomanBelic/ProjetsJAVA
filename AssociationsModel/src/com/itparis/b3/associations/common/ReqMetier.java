package com.itparis.b3.associations.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import com.itparis.b3.associations.bin.Connexion;

/*
 * Classe ReqMetier;
 * Contient des methdoes DAO parametrees;
 * */

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
			if (st != null) st.close();
			if (con != null)con.close();
		} catch (Exception e) {
		}
		return rows;
	}

	public static int ExecutePreparedQuery(String req, HashMap<Integer, String> params) {
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
			if (st != null) st.close();
			if (con != null)con.close();
		} catch (Exception e) {
		}
		return rows;
	}

	public static int ExecuteParameteredUpdate(String table,HashMap<String, String> paramsTable, String paramWhere) {
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

			req += " Where 1=1 " + paramWhere;

			rows = st.executeUpdate(req);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		try {
			if (st != null) st.close();
			if (con != null)con.close();
		} catch (Exception e) {
		}
		return rows;
	}

	public static int ExecuteParameteredDelete(String table, String paramWhere) {
		int rows = 0;
		String req = "Delete From " + table + " Where 1=1 ";
		Connection con = null;
		Statement st = null;
		try {
			con = Connexion.getConnection();
			st = con.createStatement();
            req += paramWhere;
			
			rows = st.executeUpdate(req);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		try {
			if (st != null) st.close();
			if (con != null)con.close();
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
			if (st != null) st.close();
			if (con != null)con.close();
		} catch (Exception e) {}
		return rows;
	}
	
	public static int ExecuteBatch (List<String>lstQueries) {
		Connection con = null;
		Statement st = null;
		int[] rowsArray = {0};
		int rows = 0;
		try {
			if (lstQueries.size() > 0){
				con = Connexion.getConnection();
				st = con.createStatement();
			    for (String s : lstQueries){
			    	st.addBatch(s);
			    }
				rowsArray = st.executeBatch();
				
				for (int i : rowsArray) {
					rows += rowsArray [i];
				}
			}
		}
		catch (Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		try {
			if (st != null) st.close();
			if (con != null)con.close();
		} catch (Exception e) {}	
		return rows;
	}

}
