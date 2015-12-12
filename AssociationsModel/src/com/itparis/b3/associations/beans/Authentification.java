package com.itparis.b3.associations.beans;

public class Authentification {
	
	private String Log;
	private String Pass;
	private int    idUser;
	
	public String getLog() {
		return Log;
	}
	public void setLog(String log) {
		Log = log;
	}
	public String getPass() {
		return Pass;
	}
	public void setPass(String pass) {
		Pass = pass;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}	
}
