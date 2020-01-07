package gui;

import javax.swing.JTabbedPane;

import game.Emotes;
import game.Zuckerborg;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.Mnemonic;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;


public class ZuckGui extends GridPane {

	Zuckerborg zb = new Zuckerborg();
	String humanimage = "images/suspicious.png";
	String borgimage = "images/blank.png";
	Image imageBorg = new Image(borgimage);
	Image imageHuman = new Image(humanimage);
	ImageView borg = new ImageView(imageBorg);
	ImageView human = new ImageView(imageHuman);
	Button smile = new Button();
	Button cry = new Button();
	Button wink = new Button();
	Button grin = new Button();
	Button pout = new Button();
	Button frown = new Button();
	HBox buttons = new HBox(10);
	TextField actionText = new TextField();
	
	
	public ZuckGui() {
		
		int fitheight = 400;
		borg.setFitHeight(fitheight);
		borg.setPreserveRatio(true);
		human.setFitHeight(fitheight);
		human.setPreserveRatio(true);
	
		this.setPadding(new Insets(10));
		this.setHgap(10);
		this.setVgap(10);

		this.add(borg, 0, 0, 1, 1);
		this.add(human, 1, 0, 1, 1);
	
		actionText.setText(zb.getPlayerName() + " The Human is suspicious! Quick! Calm them down with an emotion!");
		actionText.setFocusTraversable(false);
		this.add(actionText, 0, 1, 2, 1);
		actionText.setEditable(false);
		actionText.setAlignment(Pos.CENTER);

		buttons.getChildren().addAll(smile, cry, wink, grin, pout, frown);
		
		buttons.setAlignment(Pos.CENTER);
		this.add(buttons, 0, 2, 2, 1);
		
		smile.setText("Smile");
		KeyCombination kc = new KeyCodeCombination(KeyCode.DIGIT1);
		Mnemonic mn = new Mnemonic(smile, kc);
		
		cry.setText("Cry");
		wink.setText("Wink");
		grin.setText("Grin");
		pout.setText("Pout");
		frown.setText("Frown");
		
		smile.setOnAction(event -> this.smileAction());
		cry.setOnAction(event -> this.cryAction());
		wink.setOnAction(event -> this.winkAction());
		grin.setOnAction(event -> this.grinAction());
		pout.setOnAction(event -> this.poutAction());
		frown.setOnAction(event -> this.frownAction());
		
		

	}

	public void dialoginit() {

	}

	private void smileAction() {
		Image emote = new Image("images/smile.png");
		borg.setImage(emote);
		zb.setSelectedEmote("smile");
		zb.zuckerborgEmotionsgui();
		actionText.setText(Emotes.smile.getSentence() + " panic: " + zb.getPanic());
		
		
	}

	private void cryAction() {
		Image emote = new Image("images/cry.png");
		borg.setImage(emote);
		zb.setSelectedEmote("cry");
		zb.zuckerborgEmotionsgui();
		actionText.setText(Emotes.cry.getSentence() + " panic: " + zb.getPanic());
		
	}

	private void winkAction() {
		Image emote = new Image("images/wink.png");
		borg.setImage(emote);
		zb.setSelectedEmote("wink");
		zb.zuckerborgEmotionsgui();
		actionText.setText(Emotes.wink.getSentence() + " panic: " + zb.getPanic());
	}

	private void grinAction() {
		Image emote = new Image("images/grin.png");
		borg.setImage(emote);
		zb.setSelectedEmote("grin");
		zb.zuckerborgEmotionsgui();
		actionText.setText(Emotes.grin.getSentence() + " panic: " + zb.getPanic());
	}

	private void poutAction() {
		Image emote = new Image("images/pout.png");
		borg.setImage(emote);
		zb.setSelectedEmote("pout");
		zb.zuckerborgEmotionsgui();
		actionText.setText(Emotes.pout.getSentence() + " panic: " + zb.getPanic());
	}

	private void frownAction() {
		Image emote = new Image("images/frown.png");
		borg.setImage(emote);
		zb.setSelectedEmote("frown");
		zb.zuckerborgEmotionsgui();
		actionText.setText(Emotes.frown.getSentence() + " panic: " + zb.getPanic() );
	}

}
