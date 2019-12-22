package game;

import java.util.ArrayList;


public class HighScore implements Comparable<HighScore>{

	public static ArrayList<HighScore> scores = new ArrayList<>();
	public String name;
	public int score;
	
	
	public HighScore(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public String getName() {
		return name;
	}

	public int getScore() {
		return score;
	}
	@Override
	public int compareTo(HighScore scores) {
		int compareScore = ((HighScore) scores).getScore();
		return compareScore - this.score;
	}
	
	public static ArrayList<HighScore> getScores() {
		return scores;
	}
		
}
