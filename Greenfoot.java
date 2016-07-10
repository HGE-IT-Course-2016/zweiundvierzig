package greenfootReplacement;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
	Ersetzt die Greenfoot Klasse von Greenfoot und hält das Programm am Laufen.
*/
public class Greenfoot extends Application {
	
	private Stage mainStage = null;
	
	private World currentWorld = null;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override public void start(Stage primaryStage) throws Exception {
		mainStage = primaryStage;
		mainStage.setTitle("Zweiundvierzig - Greenfoot as JavaFX");
		setWorld(new Start_Load());
		mainStage.show();
	}
	
	public static void setWorld(World w) {
		currentWorld = w;
		mainStage.setScene(currentWorld);
	}
	
}