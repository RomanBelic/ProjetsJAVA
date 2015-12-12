package com.itparis.b3.associations.common;

public class DB {
	
	public static final String DBNULLVALUE = "NULL";
	public static final String DBNAME = "dbassociations";
		
	public static class Tables {
		
		public static final String Utilisateurs = "utilisateurs";
		public static final String TypeUtilisateur = "typeutilisateur";
		public static final String ParticipantsEvents = "participantsevents";
		public static final String FicheParticipant = "ficheparticipant";
		public static final String Authentification = "authentification";
		public static final String Events = "associationevents";
		public static final String Association = "association";
		public static final String DescriptionAssoc = "assocdesc";
	}
	
	public static class Queries {
		
		public static final String GetUserQuery =
				   " Select u.nomUtilisateur, u.prenomUtilisateur, " +
				   " u.adrUtilisateur, u.telUtilisateur, " + 
				   " u.idAssociation, u.idType, u.id, " + 
				   " t.id, t.Libelle, " +
				   " a.LibelleAssociation "+
			       " From "+Tables.Utilisateurs+" u " +
			       " LEFT JOIN "+Tables.TypeUtilisateur+" t ON u.idType = t.id " +
			       " LEFT JOIN "+Tables.Association+" a ON u.idAssociation = a.id " +
				   " Where 1=1 ";
		
		public static final String GetLoginPassQuery = 
			       "Select Login, MDP From "+Tables.Authentification+" Where Login = ? and MDP = ? ";
		

	}
	

	
	
	
}
