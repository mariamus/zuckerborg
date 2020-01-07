package gui;

import java.util.Optional;

import game.Zuckerborg;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void init() {
		
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("ZuckerBorg Extreme 3000!!");
		BorderPane pane = new BorderPane();
		this.initContent(pane);
		Scene scene = new Scene(pane);

		
		stage.setScene(scene);
		stage.show();
		stage.setResizable(false);
	}

	// -------------------------------------------------------------------------
	private void initContent(BorderPane pane) {
		Zuckerborg zb = new Zuckerborg();
		TextInputDialog dialog = new TextInputDialog("ZuckerBorg");
		dialog.setTitle("Text Input Dialog");
		dialog.setHeaderText("You are ZuckerBorg, a semi-sophisticated lizard robot who has come to conquer earth!"
				+ "\nA human has become suspicious of your behavior."
				+ "\nYour goal is to use facial mimicry to calm the human down.");
		dialog.setContentText("Please enter player name:");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
			zb.setPlayerName(result.get());
		}
		TabPane tabPane = new TabPane();
		this.initTabPane(tabPane);
		pane.setCenter(tabPane);
	}
	
	

	private void initTabPane(TabPane tabPane) {
		tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		Tab tabGame = new Tab("Game");
		tabPane.getTabs().add(tabGame);

		Tab tabHighScore = new Tab("High Score");
		tabPane.getTabs().add(tabHighScore);
		
		Tab credits = new Tab("Credits");
		tabPane.getTabs().add(credits);

		ZuckGui game = new ZuckGui();
		tabGame.setContent(game);

		
		HighScoreGui highscore = new HighScoreGui();
		tabHighScore.setContent(highscore);
		tabHighScore.setOnSelectionChanged(event -> highscore.createHighScoreView());
		
		Credits creds = new Credits();
		credits.setContent(creds);

	}
}