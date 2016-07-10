import greenfoot.*;
import java.awt.Color;

/**
	Erzeugt ein Eingabefeld, über welches man Strings vom Benutzer abfragen kann.
	Die beim Erzeugen übergebene Welt wird nach dem "Schließen" des Eingabefelds wieder geladen.
	
	@author Felix Stupp
	@version 07/10/2016
*/
public class InputDialogWorld extends World implements ButtonEvent {
	
	String PREINPUT = null;
	
	Label msgL = new Label("",20);
	Button okay = new Button("Weiter",20,this);
	Button abort = new Button("Abbrechen",20,this);
	
	Label inputL = new Label("",20);
	String inputS = "";
	Boolean closed = false;
	
	/**
		Erzeugt eine Instanz dieser Klasse, übergibt dieser die Parameter und wartet auf das Schließen des Dialogs.
		@param msg Die für den Beutzer anzuzeigende Aufforderung.
		@param preIn Ein Schattentext, welcher für den Benutzer in dem Textfeld sichtbar sein soll.
		@param w Die Welt, die nach dem Beenden wieder eingesetzt werden soll.
	*/
	public static String showDialog(String msg, String preIn, World w) {
		InputDialogWorld dialog = new InputDialogWorld(msg,preIn);
		Greenfoot.setWorld(dialog);
		// Unvollständig!
		Greenfoot.setWorld(w);
		return dialog.getInput();
	}
	
	/**
		Erzeugt ein Eingabefeld, welches nach dem Laden dargestellt wird.
		@param msg Die für den Beutzer anzuzeigende Aufforderung.
		@param preIn Ein Schattentext, welcher für den Benutzer in dem Textfeld sichtbar sein soll.
	*/
	private InputDialogWorld(String msg, String preIn) {
		super(500,200,1);
		setBackground("backgroundLight.png");
		PREINPUT = preIn;
		addObject(msgL,10,10);
		addObject(inputL,10,40);
		addObject(abort,10,70);
		addObject(okay,390,70);
		msgL.setText(msg);
		abort.setSize(100,30);
		okay.setSize(100,30);
		redraw();
		Greenfoot.getKey();
	}
	
	public void act() {
		String s = Greenfoot.getKey();
		if(s == null) return;
		if(s == "backspace" && inputS.length() > 0) {
			inputS = inputS.substring(0,inputS.length() - 2);
		} else if(s == "enter") {
			buttonClicked(okay);
		} else if(s.length() == 1) {
			inputS += s;
		}
	}
	
	public void buttonClicked(Button b) {
		if(b == abort) {
			inputS = null;
		} else if(b == okay) {
			inputS = null;
			closed = true;
		}
	}
	
	public Boolean ended() {
		return closed;
	}
	
	public String getInput() {
		return closed ? inputS : null;
	}
	
	private void redraw() {
		inputL.setForeColor((inputS == "") ? Color.gray : Color.black );
		inputL.setText((inputS == "") ? PREINPUT : inputS);
	}
	
}