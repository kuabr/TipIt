package de.tipit;

import java.util.List;

public class MatchDay {

	private List<Match> matches;
	private int day;
	
	public MatchDay(int day, List<Match> matches) {
		this.day = day;
		this.matches = matches;
	}
	
	public List<Match> getMatches() {
		return matches;
	}

	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
}
