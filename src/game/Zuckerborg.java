package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

import storage.Storage;

/**
 * @author Elisabeth
 *
 */
public class Zuckerborg {

	public static String playerName;
	private static int panic;
	private static int winlosevariable = 5;
	private static int numOfEmotes;
	private static String selectedEmote;
	

	public String getPlayerName() {
		return playerName;
	}
	
	public void setPlayerName(String name) {
		playerName = name;
	}

	public int getPanic() {
		return panic;
	}

	public int getNumOfEmotes() {
		return numOfEmotes;
	}

	public void setSelectedEmote(String selectedEmote) {
		Zuckerborg.selectedEmote = selectedEmote;
	}

	// welcome screen
	public void start() {
		
		System.out.println();
		System.out.println("***********************************************************************************");
		System.out.println("You are ZuckerBorg, a semi-sophisticated lizard robot who has come to conquer earth!");
		System.out.println("A human has become suspicious of your behavior.");
		System.out.println("Your goal is to use facial mimicry to calm the human down.");
		System.out.println("***********************************************************************************");
		System.out.println();
		System.out.println("Would you like to play? Please type yes or no.");

	}

	// starts the game.
	public void run() {
		System.out.println();
		System.out.println(playerName + ". The human is suspicious! \n");
		System.out.println("Hurry! Pick an emote!");
		zuckerborgEmotionsgui();
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
			List<Emotes> list = Arrays.asList(array);
			if (!list.toString().contains(emotive.toString())) {
			array[i] = emotive;
			}
			else {
				i--;
			}
		}
		return array;
	}

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

	public void zuckerborgEmotionsgui() {
		Emotes[] emotes = emotions(3);
		boolean found = false;
		System.out.println(Arrays.toString(emotes));
		while (selectedEmote != null) {
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
					selectedEmote = null;
					yay();
					break;
				}
				if (!found) {
					System.out.println();
					Emotes emotive = Emotes.valueOf(selectedEmote);
					String insert = emotive.getSentence();
					System.out.println(insert);
					selectedEmote = null;
					oops();
					break;
				}
			}

			if (panic < winlosevariable && panic > -winlosevariable) {
				selectedEmote = null;
				//zuckerborgEmotionsgui();
			}
			if (panic >= winlosevariable) {
				selectedEmote = null;
				lose();
			}
			if (panic <= -winlosevariable) {
				selectedEmote = null;
				win();
			}
		}
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
		//for testing. when done change to ++
		panic--;
		System.out.println();
		System.out.println("You are creeping out the human!");
		System.out.println("Human's panic level is: " + panic);
		System.out.println();
	}

	/*
	 * posts a losing screen with emotes managed and panic level reached.
	 */
	public void lose() {
		System.out.println();
		System.out.println("***********************************************************************************");
		System.out.println("You have lost! The Human alerted authorities!");
		System.out.println("You have been taken away to be studied by the authorities.");
		System.out.println("You managed " + getNumOfEmotes() + " successful emotes.");
		System.out.println("The Human's panic level reached: " + getPanic());
		System.out.println("***********************************************************************************");
		System.out.println();
		tryAgain();

	}

	/*
	 * posts a winning screen with emotes managed and penic level reached. then runs
	 * setHighScore method.
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
		System.out.println(getPlayerName());
		
	}

	/*
	 * Adds the high score with player name and number of emotes. Then runs tryAgain
	 * method.
	 */
	public void setHighScore() {
		Storage.getInstance().addHighScore(new HighScore(playerName, numOfEmotes));
		tryAgain();
	}

	public void tryAgain() {
		panic = 0;
		numOfEmotes = 0;
	}

//	/*
//	 * String builder to show high score list.
//	 */
//	public String getHighscoreString() {
//		StringBuilder bld = new StringBuilder();
//		final int topThree = 3;
//		highScore = getHighScore();
//
//		int i = 0;
//		int x = highScore.size();
//		if (x > topThree) {
//			x = topThree;
//		}
//		while (i < x) {
//			bld.append((i + 1) + ". " + highScore.get(i).getName() + " - " + highScore.get(i).getScore() + "\n");
//			i++;
//		}
//		System.out.println("***********************************************************************************\n");
//		String str = bld.toString();
//		return str + "\n***********************************************************************************\n";
//
//	}

}
