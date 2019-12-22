package gui;


import game.HighScore;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;


public class HighScoreGui extends GridPane {
	ObservableList<HighScore> names = FXCollections.observableArrayList(HighScore.getScores());
	TableView<HighScore> highscore;
		
	public HighScoreGui() {
		this.setPadding(new Insets(10));
		this.setHgap(10);
		this.setVgap(10);
		
		highscore = createHighScoreView();
		highscore.setEditable(false);
		this.add(highscore, 0, 2);
	}
	
	public TableView<HighScore> createHighScoreView() {
		//highscore.getItems().setAll(names);
		// populate name column with names
		TableColumn<HighScore, String> nameColumn = new TableColumn<>("Navn:");
		nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
		nameColumn.setStyle("-fx-alignment: CENTER;");
		// populate productcategory column with categorynames.
		TableColumn<HighScore, String> scoreColumn = new TableColumn<>("Score:");
		scoreColumn.setCellValueFactory(cellData -> new SimpleStringProperty(
				cellData.getValue().getScore() + ""));
		scoreColumn.setStyle("-fx-alignment: CENTER;");

		// create tableview and setup style.
		TableView highScoreList = new TableView();
		highScoreList.setItems(names);
		highScoreList.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		highScoreList.getSortOrder().add(scoreColumn);
		highScoreList.getColumns().addAll(nameColumn, scoreColumn);
		return highScoreList;
	}

}
