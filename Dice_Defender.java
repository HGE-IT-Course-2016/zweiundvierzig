/*
	Hinweis zum Verbleib der Klasse:
	Diese Klasse soll, da sie zurzeit weder vollständig, noch in Verwendung, noch in der Architektur definiert ist, zum Beta-Meilenstein entfernt werden.
	Sollte die Klasse jedoch zuvor noch Verwendung finden, wird sie nach Absprache mit den jeweiligen Autoren/Benutzern in die Architektur aufgenommen.
*/

import greenfoot.*;
import java.util.Arrays;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dice_Offender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dice_Defender
{
	/**
	 * Act - do whatever the Dice_Offender wants to do. This method is called whenever
	 * the 'Act' or 'Run' button gets pressed in the environment.
	 */

	int[] diceEyesDefender = new int[2];
	public void act() 
	{
		// Add your action code here.
	}

	/**
	 * Die Methode für das Würfeln mit bis zu drei Würfeln des Angreifers, es wird ein Array mit den drei Zahlen zurückgegeben, höchster Wert befindet sich immer an dritter Stelle.
	 * @param troupNumberDefender Anzahl der Truppen auf dem ausgewählten Feld
	 */
	public int[] dice_defender(int troupNumberDefender)
	{
		diceEyesDefender = new int[2];
		if(troupNumberDefender == 1)
		{
			diceEyesDefender[0] = (int) (Math.random() * 6 +1);
			return diceEyesDefender;
		}
		if(troupNumberDefender >=2 )
		{
			diceEyesDefender[0] = (int) (Math.random() * 6 +1);
			diceEyesDefender[1] = (int) (Math.random()* 6 +1);
			// System.out.println(diceEyesDefender[0]);
			// System.out.println(diceEyesDefender[1]);
			return diceEyesDefender;
		}
		Arrays.sort(diceEyesDefender);
		return diceEyesDefender;

		
		
	}
}
