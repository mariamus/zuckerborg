package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Zuckerborger {
	private static String playerName;
	private static int panic;
	private static int winlosevariable = 5;
	private static int numOfEmotes;
	private static ArrayList<HighScore> highScore = new ArrayList<>();
	
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getPanic() {
		return panic;
	}

	public int getNumOfEmotes() {
		return numOfEmotes;
	}

	public ArrayList<HighScore> getHighScore() {
		return highScore;
	}
	
	//welcome screen
	public void start() {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.println("***********************************************************************************");
		System.out.println("You are ZuckerBorg, a semi-sophisticated lizard robot who has come to conquer earth!");
		System.out.println("A human has become suspicious of your behavior.");
		System.out.println("Your goal is to use facial mimicry to calm the human down.");
		System.out.println("***********************************************************************************");
		System.out.println();
		System.out.println("Would you like to play? Please type yes or no.");
		String goOn = scan.nextLine();
		if (goOn.equalsIgnoreCase("no")) {
			scan.close();
		} 
		if (goOn.equalsIgnoreCase("yes")) {
			System.out.println("Welcome! Please enter your name!");
			setPlayer();
		}
	}
		
	// starts the game.
	public void run() {
		System.out.println();
		System.out.println("The human is suspicious! \n");
		System.out.println("Zuckerborg tries to use emotions!");
		zuckerborgEmotions();
	}
	
	
	// Uses input to record Player name for the high score list.
	public void setPlayer() {
		Scanner scan = new Scanner(System.in);
		playerName = scan.next();
		run();
		scan.close();
	}
	
	
	//Creates a boolean array and posts an emote from the enum if true value is recorded.
	public boolean[] emotions(int number) {
		Random emotions = new Random();
		boolean[] array = new boolean[number];
		for (int i = 0; i < array.length; i++) {
			boolean emotive = emotions.nextBoolean();
			array[i] = emotive;
		}
		return array;
	}
	
	/*runs the boolean array method and posts an emote for every true value. 
	 * Also subtracts a panic point per true value.
	 * if false value, panic point is added.
	 * runs recursively as long as the winlose variable is within the parameters set. (-30 to 30, default.)
	 * if panic reached the upper limit of the  winlosevariable, the game is lost. (lose())
	 * if it reaches the lowerlimit, thegame is won. (win())
	*/
	public void zuckerborgEmotions() {
		boolean[] emotes = emotions(7);
		for (int i = 0; i < emotes.length; i++) {
			if (emotes[i]) {
				panic--;
				numOfEmotes++;
				System.out.println("Zuckerberg " + Emotion.values()[new Random().nextInt(Emotion.values().length)]);
				System.out.println("Human's panic level is: " + panic);
			} else if (!emotes[i]){
				panic++;
				System.out.println("You are creeping out the human!");
				System.out.println("Human's panic level is: " + panic);
			}

		}
		if (panic < winlosevariable && panic > -winlosevariable) {
			zuckerborgEmotions();
		} 
		if (panic >= winlosevariable) {
			lose();
		}
		if (panic <= -winlosevariable) {
			win();
		}

	}
	
	
	/* posts a losing screen with emotes managed and panic level reached.
	 */
	public void lose() {
		System.out.println();
		System.out.println("***********************************************************************************");
		System.out.println("You have lost! The Human alerted authorities!");
		System.out.println("You have been taken away to be studied by the authorities.");
		System.out.println("You managed " + getNumOfEmotes() + " emotes.");
		System.out.println("The Human's panic level reached: " + getPanic());
		System.out.println("***********************************************************************************");
		System.out.println();
		tryAgain();

	}
	/* posts a winning screen with emotes managed and penic level reached.
	 * then runs setHighScore method.
	 */
	public void win() {
		System.out.println();
		System.out.println("***********************************************************************************");
		System.out.println("You have Won! The Humans never suspected a thing!");
		System.out.println("The Earth and all its data now belongs to the Zuckerborgs.");
		System.out.println("You managed " + getNumOfEmotes() + " emotes.");
		System.out.println("The Human's panic level reached: " + getPanic());
		System.out.println("***********************************************************************************");
		System.out.println();
		setHighScore();	
	}
	/* Adds the high score with player name and number of emotes.
	 * Then runs tryAgain method.
	 */
	public void setHighScore() {
		highScore.add(new HighScore(playerName, numOfEmotes));
		Collections.sort(highScore);
		System.out.println(getHighscoreString());
		tryAgain();
	}
	
	/* resets panic and numOfEmotes variables.
	 * Asks use if they would like to play again.
	 * If no, game bids you farewell and closes.
	 * if yes, run method is started.
	 * if anything else, asks for clarification.
	 */
	public void tryAgain() {
		panic = 0;
		numOfEmotes = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to try again? Yes/No?");
		String tryagain = scan.nextLine();
		if (tryagain.equalsIgnoreCase("no")) {
			scan.close();
			System.out.println("Goodbye");
			System.exit(0);
		} 
		if (tryagain.equalsIgnoreCase("yes")) {
			run();
		} else if(!tryagain.equalsIgnoreCase("yes") || !tryagain.equalsIgnoreCase("no")) {
			System.out.println();
			TryAgainComments sentence = TryAgainComments.values()[new Random().nextInt(TryAgainComments.values().length)];
			System.out.println(sentence + "\n");
			tryAgain();
		}
	}
	
	/*
	 * String builder to show high score list.
	 */
	public String getHighscoreString() {
		StringBuilder bld = new StringBuilder();
		final int topThree = 3;
		highScore = getHighScore();

		int i = 0;
		int x = highScore.size();
		if (x > topThree) {
			x = topThree;
		}
		while (i < x) {
			bld.append((i + 1) + ". " + highScore.get(i).getName() + " - " + highScore.get(i).getScore() + "\n");
			i++;
		}
		System.out.println("***********************************************************************************\n");
		String str = bld.toString();
		return str + "\n***********************************************************************************\n";
		
	}

}
