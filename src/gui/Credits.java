package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Credits extends GridPane {
	
	Label credits = new Label();
	Hyperlink link = new Hyperlink("www.tumblr.com/lumiJessica");

	public Credits() {
		
		credits.setAlignment(Pos.CENTER);
		
		credits.setText("This started out as a really dumb idea inspired by pseudocode on a youtube video."
				+ "\n"
				+ "But since I can't stop myself, I ended up with this abomination of a game."
				+ "\n"
				+ "\n"
				+ "Art by LumiJessica - https://lumijessica.tumblr.com/"
				+ "\n"
				+ "Check out her tumblr for Skyrim-related comics and art."
				+ "\n"
				+ "\n"
				+ "Game by Elisabeth Hansen");
		
		this.setPadding(new Insets(10));
		this.setHgap(10);
		this.setVgap(10);
		
		this.add(credits, 1, 1);
	}
	

}
