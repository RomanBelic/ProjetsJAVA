package com.iteiffel.ece.b3.dwm.TPGraph.dao;

//import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iteiffel.ece.b3.dwm.TPGraph.bin.Connexion;
import com.iteiffel.ece.b3.dwm.TPGraph.model.*;

import java.sql.Connection;
import java.sql.Statement;

//import java.text.*;

/**
 * @author Roman
 *
 */

public class TeamDAO {

	public HashMap<String, String> getTypeEquipe(){
		
		HashMap<String, String> lstTypes = new HashMap<String, String>();
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;

		String req = "Select t.Libelle as Lib, t.idType as Type From typeequipe t Where 1=1 ";
		try {
			cn = Connexion.getConnection();
			st = cn.createStatement();
			st.executeQuery(req + " Order By t.idType ASC ");
			rs = st.getResultSet();
			while (rs.next()) {
				lstTypes.put(rs.getString("Type"), rs.getString("Lib"));
			}
			rs.close();
			st.close();
			cn.close();
		} 
		catch (SQLException ex){}
		return lstTypes;
	}

	public Equipe getEquipeByIdEquipe(int idEquipe, Object o){
		Equipe e = null;
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;

		String req = " Select t.*  From equipe t Where t.idEquipe = "
				+ idEquipe;

		try {
			cn = Connexion.getConnection();
			st = cn.createStatement();
			st.executeQuery(req);
			rs = st.getResultSet();
			while (rs.next()) {
				if (o instanceof Foot) {

					e = new Foot(rs.getString("nomEquipe"),
							rs.getInt("scoreEquipe"), rs.getString("idEquipe"), 0);
				}
				if (o instanceof Baskett) {
					e = new Baskett(rs.getString("nomEquipe"),
							rs.getInt("scoreEquipe"), rs.getString("idEquipe"), 0);
				}
				if (o instanceof Rugby) {
					e = new Rugby(rs.getString("nomEquipe"),
							rs.getInt("scoreEquipe"), rs.getString("idEquipe"), 0);
				}
			}
			rs.close();
			st.close();
			cn.close();
		} 
		catch (SQLException ex){}
		return e;
	}

	public ArrayList<Equipe> getListEquipeByIdType(int idTypeEquipe, Object o){
		ArrayList<Equipe> lstTeam = new ArrayList<Equipe>();
		ResultSet rs = null;
		Connection cn = null;
		Statement st = null;
		Equipe e = null;

		String req = " Select t.*  From equipe t "
				+ " LEFT JOIN typeequipe te ON t.idTypeEquipe = te.idType "
				+ " Where t.idTypeEquipe = " + idTypeEquipe;

		try {
			cn = Connexion.getConnection();
			st = cn.createStatement();
			st.executeQuery(req + " Order By t.idEquipe ASC ");
			rs = st.getResultSet();
			while (rs.next()) {
				if (o instanceof Foot) {
					e = new Foot(rs.getString("nomEquipe"),
							rs.getInt("scoreEquipe"), rs.getString("idEquipe"), 0 );
				}
				if (o instanceof Baskett) {
					e = new Baskett(rs.getString("nomEquipe"),
							rs.getInt("scoreEquipe"), rs.getString("idEquipe"), 0);
				}
				if (o instanceof Rugby) {
					e = new Rugby(rs.getString("nomEquipe"),
							rs.getInt("scoreEquipe"), rs.getString("idEquipe"), 0);
				}

				lstTeam.add(e);
			}
			rs.close();
			st.close();
			cn.close();
		} 
		catch (SQLException ex){}
		return lstTeam;
	}

	public int UpdateTotalTeamScore(int idEquipe, int score) {
		int count = -1;
		Connection cn = null;
		PreparedStatement st = null;
		String req = "Update equipe SET scoreEquipe = ? Where idEquipe = ? ";
		try {
			cn = Connexion.getConnection();
			st = cn.prepareStatement(req);

			st.setInt(1, score);
			st.setInt(2, idEquipe);

			st.executeUpdate();
			count = st.getUpdateCount();
			
			st.close();
			cn.close();
		} 
		catch (SQLException ex){}
		return count;
	}

	public int UpdateTotalTeamScoreAll(HashMap <Integer,Integer> mapT) {
		int count = 0;
		Connection cn = null;
		PreparedStatement st = null;
		String req = "Update equipe SET scoreEquipe = ? Where idEquipe = ? ";
		try {
			cn = Connexion.getConnection();
			st = cn.prepareStatement(req);
			
			for (Map.Entry<Integer, Integer> m : mapT.entrySet()) {
				st.setInt (1, m.getValue());
				st.setInt (2, m.getKey());
				st.executeUpdate();
				count += st.getUpdateCount();
			}
			
			st.close();
			cn.close();
		} 
		catch (SQLException ex){}
		return count;
	}
	
	public int UpdateMatchTeamScore(String dateMatch, int TeamNb, int idTeam, int Score){
		int count = -1;
		String scoreField = "";
		String idTeamField = "";

		if (TeamNb == 1) {
			scoreField = "scoreEquipe1";
			idTeamField = "idEquipe1";
		}
		if (TeamNb == 2) {
			scoreField = "scoreEquipe2";
			idTeamField = "idEquipe2";
		}
		Connection cn = null;
		PreparedStatement st = null;
		String req = " Update rencontre SET " + scoreField + " = ? "
				+ " Where dateMatch = ? AND " + idTeamField + " = ? ";
		try {
			cn = Connexion.getConnection();
			st = cn.prepareStatement(req);

			st.setInt(1, Score);
			st.setString(2, dateMatch);
			st.setInt(3, idTeam);

			st.executeUpdate();
			count = st.getUpdateCount();
			
			st.close();
			cn.close();
		} 
		catch (SQLException ex){}
		return count;
	}

	public int UpdateMatchAllTeam (String dateMatch,int idTeam1, int Score1, int idTeam2, int Score2, int idWinner) 
    {
		int count = -1;
		
		Connection cn = null;
		PreparedStatement st = null;
		String req = " Update rencontre SET scoreEquipe1 = ?, scoreEquipe2 = ?, idGagnant = ? "
				+ " Where dateMatch = ? AND idEquipe1 = ? AND idEquipe2 = ? ";
		try {
			cn = Connexion.getConnection();
			st = cn.prepareStatement(req);

			st.setInt(1, Score1);
			st.setInt(2, Score2);
			st.setInt(3, idWinner);
			st.setString(4, dateMatch);
			st.setInt(5, idTeam1);
			st.setInt(6, idTeam2);

			st.executeUpdate();
			count = st.getUpdateCount();
			
			st.close();
			cn.close();
		} 
		catch (SQLException ex){}
		return count;
	}

	
	public int InsertNewMatch(int idEq1, int idEq2, String date){
		int count = -1;
		Connection cn = null;
		PreparedStatement st = null;
		String req = " INSERT INTO rencontre ( idEquipe1, idEquipe2, dateMatch )"
				+ " VALUES (?, ?, ?)";
		try {
			cn = Connexion.getConnection();
			st = cn.prepareStatement(req);

			st.setInt(1, idEq1);
			st.setInt(2, idEq2);
			st.setString(3, date);
			st.executeUpdate();

			count = st.getUpdateCount();
			
			st.close();
			cn.close();
		}
		catch (SQLException ex){}
		return count;
	}

	public static void main(String[] args) throws InstantiationException,
	    IllegalAccessException, SQLException {

		// ArrayList <String> Test = TeamDAO.class.newInstance().getTypeEquipe()
		// ;
		// System.out.println(Test);

		// ArrayList <Equipe> Test2 =
		// TeamDAO.class.newInstance().getEquipeByIdType(1, new Foot ("",0));
		// System.out.println(Test2);

		// int rows = TeamDAO.class.newInstance().UpdateTotalTeamScore(1, 5);
		// System.out.println(rows);

		// int rows2 = TeamDAO.class.newInstance().UpdateMatchTeamScore(1, 2, 2,
		// 5);
		// System.out.println(rows2);

		// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		// Date date = new Date();
		// String fdate = dateFormat.format(date);
		// System.out.println(fdate);

		// int rows3 = TeamDAO.class.newInstance().InsertNewMatch(2, 3, fdate);
		// System.out.println(rows3);

	}

}
