import greenfoot.*;
import java.awt.Color;
import java.util.Arrays;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
	Erstellt eine gegebene Anzahl an Dices's, welche dann nebeneinander eingereiht werden.

	@author Felix Stupp
	@version 14.06.2016
*/
public abstract class DicesList extends Actor {
	
	private final static int SQUARESIZE = 100; // Anpassbar
	private Dice[] dices;

	public DicesList() {
		setImage(new GreenfootImage(2,2));
	}

    protected void genDices(int count, int max, Color bC, Color fC) {
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
			w.addObject(dices[i],w.getX()+(SQUARESIZE*(6/5)*i),w.getY());
		}
		//w.removeObject(this); // Zeile auskommentieren, wenn die Debug-Phase vorbei ist.
	}

	public int[] getNumbers() {
		int[] n = new int[dices.length];
		for(int i = 0; i < dices.length; i++) {
			n[i] = dices[i].getNumber();
		}
		Arrays.sort(n);
		return n;
	}

	public int[] roll() {
		int[] n = new int[dices.length];
		for(int i = 0; i < dices.length; i++) {
			n[i] = dices[i].roll();
		}
		Arrays.sort(n);
		return n;
	}

}
