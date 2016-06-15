import greenfoot.*;

/**
	Erstellt eine gegebene Anzahl an Dices's, welche dann nebeneinander eingereiht werden.

	@author Felix Stupp
	@version 15.06.2016
*/
public abstract class DicesList extends Actor {
	
	private final static int SQUARESIZE = 100; // Anpassbar
	private Dice[] dices;

	public DicesList(int count, int max, java.awt.Color bC, java.awt.Color fC) {
		setImage(new GreenfootImage(2,2));
		if(count < 1) {
			count = 1;
		} else if (count > max) {
			count = max;
		}
		for(int i = 1; i < count; i++) {
			Dice d = new Dice();
			d.setBackColor(bC);
			d.setForeColor(fC);
			d.setSizeAsSquare(SQUARESIZE);
			dices[i] = d;
		}
	}

	protected void addedToWorld(World w) {
		for(int i = 0; i < dices.length; i++) {
			w.addObject(dices[i],getX()+(SQUARESIZE*(6/5)*i),getY());
		}
		//w.removeObject(this); // Zeile auskommentieren, wenn die Debug-Phase vorbei ist.
	}

	public int[] getNumbers() {
		int[] n = new int[dices.length];
		for(int i = 0; i < dices.length; i++) {
			n[i] = dices[i].getNumber();
		}
		Utils.sortDesc(n);
		return n;
	}

	public int[] roll() {
		int[] n = new int[dices.length];
		for(int i = 0; i < dices.length; i++) {
			n[i] = dices[i].roll();
		}
		Utils.sortDesc(n);
		return n;
	}

	public void removeAll() {
		for(int i = 0; i < dices.length; i++) {
			dices[i].getWorld().removeObject(dices[i]);
		}
		getWorld().removeObject(this);
		dices = new Dice[0];
	}

}
