import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
	Stellt einen Würfel (von 1-6) dar, welcher in der Welt sichtbar dargestellt werden soll.

	@author Felix Stupp
	@version 13.06.2016
 */
public class Dice extends GUI_Interface {

	private int number = 0;

	/**
		Erstellt einen Würfel mit dem Startwert 0 (für noch nicht verwendet).
	*/
	public Dice() {
		redraw();
	}

	/**
		Erstellt einen Würfel mit einem bestimmten Startwert, welcher sofort sichtbar ist.
	*/
	public Dice(int startNumber) {
		number = startNumber;
		redraw();
	}

	/**
		Gibt die aktuelle Zahl, die der Würfel anzeigt, aus. Gibt die Methode 0 zurück, heißt dies, dass der Würfel noch nicht gewürfelt wurde.
		@return Die aktuelle Augenzahl oder 0
	*/
	public int getNumber() {
		return number;
	}

	/**
		Legt die Größe des Würfels als Quadrat fest.
	*/
	public void setSizeAsSquare(int l) {
		setSize(l,l);
	}

	/**
		Würfelt den Würfel, erneuert die Darstellung und gibt die neue Augenzahl zurück.
	*/
	public int roll() {
		number = (int) (Math.floor(Math.random()*6)+1)
		redraw();
		return number;
	}

	/**
		Erneuert die Darstellung des Würfels.
	*/
	public void redraw() {
		// einheitliche Größe X und Y
		int eX = (int) Math.Round(sx/7);
		int eY = (int) Math.Round(sy/7);
		// Punktgröße X und Y
		int pX = eX*2;
		int pY = eY*2;
		GreenfootImage i = new GreenfootImage(sx,sy);
		
	}

}