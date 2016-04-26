import greenfoot.*;

/**
 * Dieses Interface stellt einen Zugriff auf Methoden für die Eventverarbeitung bei Buttons.
 * Jede Klasse, die als Event-Handler dienen will, muss dieses Interface implementieren.
 * 
 * @author Felix Stupp 
 * @version 26.04.2016
 */
public interface ButtonEvent {
	public void buttonClicked(Button obj);
}