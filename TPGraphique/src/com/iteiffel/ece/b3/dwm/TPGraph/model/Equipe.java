package com.iteiffel.ece.b3.dwm.TPGraph.model;

public abstract class Equipe {

	private String nom;
	private int score;
    private int mTime; 
    private String idTeam;
    private int scoreMatch;
	
	/**
	 * @param nom
	 * @param score
	 * @param mTime
	 */
	public Equipe (String nom, int score, int mTime, String idTeam, int scoreMatch)
	{
		this.nom = nom;
		this.score = score;
		this.mTime = mTime;
		this.idTeam = idTeam;
		this.scoreMatch = scoreMatch;
	}

	public String getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(String idTeam) {
		this.idTeam = idTeam;
	}

	public int getmTime() {
		return mTime;
	}

	public void setmTime(int mTime) {
		this.mTime = mTime;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScoreMatch() {
		return scoreMatch;
	}

	public void setScoreMatch(int scoreMatch) {
		this.scoreMatch = scoreMatch;
	}

	public void showStats ()
	{
		System.out.println ("Nom de l'equipe est : " + this.nom +"\n" +
				            "Score de l'equipe est : " + this.score +"\n" +
				            "Temps du match est : " + this.mTime 
				);
	}
	
	public void addScore (int addP)
	{
		this.score +=  addP;
	}
	
	public void addScoreMatch (int addP)
	{
		this.scoreMatch +=  addP;
	}

	@Override
	public String toString() {
		return "Equipe [nom=" + nom + ", score=" + score + ", getNom()="
				+ getNom() + ", getScore()=" + getScore() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
