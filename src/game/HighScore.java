package game;

public class HighScore implements Comparable<HighScore>{

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
		
}
