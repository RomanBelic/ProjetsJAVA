package com.itparis.b3.associations.beans;
/*
 * Classe Authentification est un modele de donnees;
 * Sert a representer les donnees d'authentification des utilisateurs;
 * Elle a la meme structure que la table "authentification" dans la BDD;
 * Proprietes de la Classe : 
	- String Log;
	- String Pass;
	- int    idUser;
 * */

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
