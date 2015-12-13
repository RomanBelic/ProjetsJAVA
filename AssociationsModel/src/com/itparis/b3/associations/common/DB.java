package com.itparis.b3.associations.common;
import com.itparis.b3.associations.common.Table.*;

public class DB {
	
	public static final String DBNULLVALUE = "NULL";
	public static final String DBNAME = "dbassociations";
	
	//a tester
	public static final Table Utilisateurs = new UserTable ("utilisateurs","u");
	public static final Table TypeUtilisateurs = new TypeUserTable ("typeutilisateur","t");
	public static final Table Association = new UserTable ("association","a");
	public static final Table AssociationEvents = new UserTable ("associationevents","e");
	public static final Table AssociationDesc = new UserTable ("associationdescription","d");
	public static final Table Authentification= new UserTable ("authentification","n");
	public static final Table FicheParticipant = new UserTable ("ficheparticipant","f");
	public static final Table ParticipantEvents = new UserTable ("participantsevents","p");
	
	public static String MakeJoin (String JoinType, Table Table1, Table Table2, String idKey1, String idKey2) {
		String str = " " + JoinType.toUpperCase() + " JOIN " + Table2 + " " + Table2.alias + " ON " +
			               Table1.alias + "." + idKey1 + "="+Table2.alias + "." + idKey2;
		
		return str;
	}
	//
	
	public static class Tables {
		
		public static final String Utilisateurs = "utilisateurs";
		public static final String TypeUtilisateur = "typeutilisateur";
		public static final String ParticipantsEvents = "participantsevents";
		public static final String FicheParticipant = "ficheparticipant";
		public static final String Authentification = "authentification";
		public static final String AssocEvents = "associationevents";
		public static final String Association = "association";
		public static final String AssocDesc = "associationdescription";
	}
	
	public static class Queries {
		
		public static final String GetUserQuery =
				   " Select u.nomUtilisateur, u.prenomUtilisateur, " +
				   " u.adrUtilisateur, u.telUtilisateur, " + 
				   " u.idAssociation, u.idType, u.id, " + 
				   " t.id, t.Libelle, " +
				   " a.LibelleAssociation " +
			       " From " + Tables.Utilisateurs + " u " + 
			       " LEFT JOIN " + Tables.TypeUtilisateur + " t ON u.idType = t.id " +
			       " LEFT JOIN " + Tables.Association + " a ON u.idAssociation = a.id " + 
				   " Where 1=1 ";
		
		public static final String GetLoginPassQuery = 
			       "Select Login, MDP From " + Tables.Authentification + " Where Login = ? and MDP = ? ";
	}
	

	
	
	
}
