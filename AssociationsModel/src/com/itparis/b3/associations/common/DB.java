package com.itparis.b3.associations.common;
import com.itparis.b3.associations.common.Table.*;

public class DB {
	
	public static final String DBNULLVALUE = "NULL";
	public static final String DBNAME = "dbassociations";
	
	public static final Table Utilisateurs = new UserTable ("utilisateurs","u");
	public static final Table TypeUtilisateurs = new TypeUserTable ("typeutilisateur","t");
	public static final Table Association = new AssociationTable ("association","a");
	public static final Table AssociationEvents = new AssociationEventsTable ("associationevents","e");
	public static final Table AssociationDesc = new AssociationDescTable ("associationdescription","d");
	public static final Table Authentification= new AuthentificationTable ("authentification","n");
	public static final Table FicheParticipant = new FicheParticipantTable ("ficheparticipant","f");
	public static final Table ParticipantEvents = new ParticipantEventsTable ("participantsevents","p");
	
	public static String MakeJoin (String JoinType, Table Table1, Table Table2, String idKey1, String idKey2) {
		String str = " " + JoinType.toUpperCase() + " JOIN " + Table2 + " " + Table2.alias + " ON " +
			               Table1.alias + "." + idKey1 + "="+Table2.alias + "." + idKey2 + " ";
		return str;
	}
	
	public static class Queries {

		public static final String GetUserQuery = 
				" SELECT "+Utilisateurs.alias+".nomUtilisateur, "+Utilisateurs.alias+".prenomUtilisateur," +
		        " "+Utilisateurs.alias+".adrUtilisateur, "+Utilisateurs.alias+".telUtilisateur," +
				" "+Utilisateurs.alias+".idAssociation, "+Utilisateurs.alias+".idType, "+Utilisateurs.alias+".id," + 
		        " "+TypeUtilisateurs.alias+".Libelle," + 
				" "+Association.alias+".LibelleAssociation" + 
		        " FROM " +Utilisateurs+" "+Utilisateurs.alias +
				" "+MakeJoin("LEFT", Utilisateurs, TypeUtilisateurs, "idType", "id") +
				" "+MakeJoin("LEFT", Utilisateurs, Association, "idAssociation", "id") +
				" Where 1=1 ";
		
		public static final String GetLoginPassQuery = 
				" Select Login, MDP From " + Authentification + " Where Login = ? and MDP = ? ";
		
        public static final String GetAssociationQuery = 
        		" Select "+Association.alias+".id, "+Association.alias+".LibelleAssociation," +
                " "+AssociationDesc.alias+ ".id as idDesc,"+
                " "+AssociationDesc.alias+ ".idPresident,"+AssociationDesc.alias+ ".nomAssoc,"+
                " "+AssociationDesc.alias+ ".nbParticipant,"+AssociationDesc.alias+ ".Description"+
        		" FROM "+Association+" "+Association.alias +
        		" "+MakeJoin("LEFT", Association, AssociationDesc, "id", "idAssociation") +
        		" Where 1=1 " ;
        	
				
				
		
		
		
	}
	

	
	
	
}
