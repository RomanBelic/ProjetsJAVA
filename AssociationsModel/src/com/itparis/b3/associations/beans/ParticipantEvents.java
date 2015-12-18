package com.itparis.b3.associations.beans;

public class ParticipantEvents {
	
	private int idAssoc;
    private int idUser;
    private int presence;
    private int idEvent;
    private String presenceString;

    public User utilisateur;
    public TypeUser userType;
    
    public ParticipantEvents () {
    	utilisateur = new User ();
    	userType = new TypeUser();
    }
    
	public int getIdAssoc() {
		return idAssoc;
	}
	public void setIdAssoc(int idAssoc) {
		this.idAssoc = idAssoc;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getPresence() {
		return presence;
	}
	public void setPresence(int presence) {
		this.presence = presence;
	}
	
	public String getPresenceString (){
		if (presence == 1)
			presenceString = "Present(e)";
		if (presence == 0)
			presenceString = "Absent(e)";
		if (presence == 2) 
			presenceString = "n/a";
       	return presenceString;
	}

	public int getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(int idEvent) {
		this.idEvent = idEvent;
	}
	
	
    
    
    
}
