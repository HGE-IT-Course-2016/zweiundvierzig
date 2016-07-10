package greenfootReplacement;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public abstract class World extends Scene {
	
	AnchorPane layout = null;
	
	public World(int width, int height, int cellSize) {
		super(new AnchorPane(), width * cellSize, height * cellSize);
		
	}
	
	public void act();
	
	
	
}