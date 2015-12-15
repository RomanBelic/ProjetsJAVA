package com.itparis.b3.associations.common;

public abstract class Table {
	
	private final String name;
	public final String alias;
	
	public  Table (String name, String alias) {
		this.name = name;
		this.alias = alias;
	}

	@Override 
	public String toString () {
		return name;
	}
	
	public static class UserTable extends Table {
		
		public UserTable(String name, String alias) {
			super(name, alias);
		}

	}
	
	public static class TypeUserTable extends Table {
		
		public TypeUserTable(String name, String alias) {
			super(name, alias);
		}

	}
	
	public static class AssociationTable extends Table {
		
		public AssociationTable(String name, String alias) {
			super(name, alias);
		}

	}
	
	public static class AssociationEventsTable extends Table {
		
		public AssociationEventsTable(String name, String alias) {
			super(name, alias);
		}

	}
	
	public static class AssociationDescTable extends Table {
		
		public AssociationDescTable(String name, String alias) {
			super(name, alias);
		}

	}
	
	public static class AuthentificationTable extends Table {
		
		public AuthentificationTable(String name, String alias) {
			super(name, alias);
		}

	}
	
	public static class FicheParticipantTable extends Table {
		
		public FicheParticipantTable(String name, String alias) {
			super(name, alias);
		}

	}
	
	public static class ParticipantEventsTable extends Table {
		
		public ParticipantEventsTable(String name, String alias) {
			super(name, alias);
		}

	}
	
}
