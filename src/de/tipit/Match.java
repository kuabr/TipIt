package de.tipit;

public class Match {

	private String firstTeam;
	private String secondTeam;
	
	public Match(String firstTeam, String secondTeam) {
		this.firstTeam = firstTeam;
		this.secondTeam = secondTeam;
	}
	
	public String getFirstTeam() {
		return firstTeam;
	}
	public void setFirstTeam(String firstTeam) {
		this.firstTeam = firstTeam;
	}
	public String getSecondTeam() {
		return secondTeam;
	}
	public void setSecondTeam(String secondTeam) {
		this.secondTeam = secondTeam;
	}
	
}
