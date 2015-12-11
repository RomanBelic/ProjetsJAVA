package com.iteiffel.ece.b3.dwm.TPGraph.model;

public class Foot extends Equipe{

	public Foot(String nom, int score, String idTeam, int ScoreMatch) {
		super(nom, score, 90, idTeam, ScoreMatch);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Foot [getNom()=" + getNom() + ", getScore()=" + getScore()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
