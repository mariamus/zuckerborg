package game;

import java.util.ArrayList;
import java.util.Arrays;
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
		//zuckerborgEmotions();
	}
	
	
	// Uses input to record Player name for the high score list.
	public void setPlayer() {
		Scanner scan = new Scanner(System.in);
		playerName = scan.next();
		run();
		scan.close();
	}
	
	
	public Emotes[] emotions(int number) {
		Emotes[] array = new Emotes[number];
		for (int i = 0; i < array.length; i++) {
			Emotes emotive = Emotes.values()[new Random().nextInt(Emotes.values().length)];
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
//	public void zuckerborgEmotions() {
//		boolean[] emotes = emotions(7);
//		for (int i = 0; i < emotes.length; i++) {
//			if (emotes[i]) {
//				panic--;
//				numOfEmotes++;
//				System.out.println("Zuckerberg " + Emotion.values()[new Random().nextInt(Emotion.values().length)]);
//				System.out.println("Human's panic level is: " + panic);
//			} else if (!emotes[i]){
//				panic++;
//				System.out.println("You are creeping out the human!");
//				System.out.println("Human's panic level is: " + panic);
//			}
//
//		}
//		if (panic < winlosevariable && panic > -winlosevariable) {
//			zuckerborgEmotions();
//		} 
//		if (panic >= winlosevariable) {
//			lose();
//		}
//		if (panic <= -winlosevariable) {
//			win();
//		}
//
//	}
	public Emotes[] emotionsList() {
		Emotes[] array = new Emotes[6];
		System.out.println("Your available Emotes:");
		for (int i = 0; i < array.length; i++) {
			for (Emotes em : Emotes.values()) {
				array[i] = em;
				i++;
			}
		}
		return array;
	}
	
	public void zuckerborgEmotionslong() {
		Emotes[] emotes = emotions(3);
		Scanner scanner = new Scanner(System.in);
		System.out.println(Arrays.toString(emotionsList()));
		System.out.println();
		System.out.println("Please type your choice.");
		// delete the following line for final game.
		System.out.println(Arrays.toString(emotes));
		String selectedEmote = scanner.nextLine().toLowerCase();
		boolean found = false;
		for (int i = 0; i < emotes.length; i++) {
			if (Arrays.toString(emotes).contains(selectedEmote)) {
				found = true;
			} else {
				found = false;
			}
			if (found) {
				Emotes emotive = Emotes.valueOf(selectedEmote);
				String insert = emotive.getSentence();
				System.out.println(insert);
				yay();
				break;
			}
			if (!found) {
				System.out.println();
				Emotes emotive = Emotes.valueOf(selectedEmote);
				String insert = emotive.getSentence();
				System.out.println(insert);
				oops();
				break;
			}
		}
		if (panic < winlosevariable && panic > -winlosevariable) {
			//zuckerborgEmotions();
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
	
	/*
	 * Methods to use if the human is calmed or creeped out.
	 */
	public void yay() {
		panic--;
		numOfEmotes++;
		System.out.println("The human is calmed.");
		System.out.println("Human's panic level is: " + panic);
		System.out.println();
	}

	public void oops() {
		panic++;
		System.out.println();
		System.out.println("You are creeping out the human!");
		System.out.println("Human's panic level is: " + panic);
		System.out.println();
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
