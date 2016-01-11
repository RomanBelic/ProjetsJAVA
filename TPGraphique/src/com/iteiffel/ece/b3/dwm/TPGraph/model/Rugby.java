package com.iteiffel.ece.b3.dwm.TPGraph.model;


public class Rugby extends Equipe {

	public Rugby(String nom, int score, String idTeam, int ScoreMatch) {
		super(nom, score, 80, idTeam, ScoreMatch);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Rugby [getNom()=" + getNom() + ", getScore()=" + getScore()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
