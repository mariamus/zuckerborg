package game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ZuckGui extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		int fitheight = 300;
		stage.setTitle("ZuckerBorg Extreme 3000!!");
		GridPane pane = new GridPane();
		this.initContent(pane);
		borg.setFitHeight(fitheight);
		borg.setPreserveRatio(true);
		human.setFitHeight(fitheight);
		human.setPreserveRatio(true);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}
	Zuckerborg zb = new Zuckerborg();
	String humanimage = "images/humanplaceholder.jpg";
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

	TextField actionText = new TextField();

	private void initContent(GridPane pane) {
		pane.setGridLinesVisible(true);
		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.add(borg, 0, 0, 3, 1);
		pane.add(human, 3, 0, 3, 1);

		pane.add(actionText, 0, 1, 6, 1);
		actionText.setEditable(false);

		pane.add(smile, 0, 3);
		smile.setText("Smile");
		smile.setOnAction(event -> this.smileText());

		pane.add(cry, 1, 3);
		cry.setText("Cry");
		cry.setOnAction(event -> this.cryText());

		pane.add(wink, 2, 3);
		wink.setText("Wink");
		wink.setOnAction(event -> this.winkText());

		pane.add(grin, 3, 3);
		grin.setText("Grin");
		grin.setOnAction(event -> this.grinText());

		pane.add(pout, 4, 3);
		pout.setText("Pout");
		pout.setOnAction(event -> this.poutText());

		pane.add(frown, 5, 3);
		frown.setText("Frown");
		frown.setOnAction(event -> this.frownText());
		//zb.zuckerborgEmotionsgui();
	}

	private void smileText() {
		actionText.setText(Emotes.smile.getSentence());
		Image emote = new Image("images/smile.png");
		borg.setImage(emote);
		zb.setSelectedEmote("smile");
		zb.zuckerborgEmotionsgui();
		
	}

	private void cryText() {
		actionText.setText(Emotes.cry.getSentence());
		Image emote = new Image("images/cry.png");
		borg.setImage(emote);
		zb.setSelectedEmote("cry");
	}

	private void winkText() {
		actionText.setText(Emotes.wink.getSentence());
		Image emote = new Image("images/wink.png");
		borg.setImage(emote);
		zb.setSelectedEmote("wink");
	}

	private void grinText() {
		actionText.setText(Emotes.grin.getSentence());
		Image emote = new Image("images/grin.png");
		borg.setImage(emote);
		zb.setSelectedEmote("grin");
	}

	private void poutText() {
		actionText.setText(Emotes.pout.getSentence());
		Image emote = new Image("images/pout.png");
		borg.setImage(emote);
		zb.setSelectedEmote("pout");
	}

	private void frownText() {
		actionText.setText(Emotes.frown.getSentence());
		Image emote = new Image("images/frown.png");
		borg.setImage(emote);
		zb.setSelectedEmote("frown");
	}
}
