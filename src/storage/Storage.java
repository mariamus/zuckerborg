package storage;

import java.util.Collections;

import game.HighScore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Storage {
	
	private static Storage storage = new Storage();
	private ObservableList<HighScore> names = FXCollections.observableArrayList();
	private Storage() {
		
	}
	
	public static Storage getInstance() {
		return storage;
	}

	public ObservableList<HighScore> getNames() {
		return names;
	}

	public void addHighScore(final HighScore score) {
		names.add(score);
		Collections.sort(names);
		
	}

}
