package com.iteiffel.ece.b3.dwm.TPGraph.model;

public class Baskett extends Equipe  {
	
	public Baskett(String nom, int score, String idTeam, int ScoreMatch) {
		super(nom, score, 40, idTeam, ScoreMatch );
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Baskett [getNom()=" + getNom() + ", getScore()=" + getScore()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
