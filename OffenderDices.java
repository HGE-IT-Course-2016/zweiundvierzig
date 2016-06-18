import greenfoot.*;
import java.util.Arrays;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
	Erstellt eine gegebene Anzahl an OffenderDice's, welche dann nebeneinander eingereiht werden.

	@author Felix Stupp
	@version 15.06.2016
*/
public class OffenderDices extends DicesList {

	public OffenderDices(int count) {
        super(count, 3, new Color(255,0,0), (new Color(255,255,255)));
	}

}
