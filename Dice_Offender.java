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
public class Dice_Offender
{
	/**
	 * Act - do whatever the Dice_Offender wants to do. This method is called whenever
	 * the 'Act' or 'Run' button gets pressed in the environment.
	 */

	int[] diceEyesOffender = new int[3];
	public void act() 
	{
		// Add your action code here.
	}

	/**
	 * Die Methode für das Würfeln mit bis zu drei Würfeln des Angreifers, es wird ein Array mit den drei Zahlen zurückgegeben, höchster Wert befindet sich immer an dritter Stelle.
	 * @param troupNumberOffender Anzahl der Truppen auf dem ausgewählten Feld
	 */
	public int[] dice_offender(int troupNumberOffender)
	{
		diceEyesOffender = new int[3];
		if(troupNumberOffender == 1)
		{
			System.out.println("Mit einer verbleibenden Truppe auff dem Feld kann man nicht angreifen!");
		}
		if(troupNumberOffender == 2)
		{
			diceEyesOffender[0] = (int) (Math.random()*6+1);
			// System.out.println(diceEyesOffender[0]);
			return diceEyesOffender;

		}
		if(troupNumberOffender == 3)
		{
			diceEyesOffender[0] = (int) (Math.random() * 6 +1);
			diceEyesOffender[1] = (int) (Math.random()* 6 +1);
			// System.out.println(diceEyesOffender[0]);
			// System.out.println(diceEyesOffender[1]);
			return diceEyesOffender;
		}
		if(troupNumberOffender > 3)
		{
			diceEyesOffender[0] = (int) (Math.random() * 6 +1);
			diceEyesOffender[1] = (int) (Math.random()* 6 +1);
			diceEyesOffender[2] = (int) (Math.random()* 6 + 1);
			// System.out.println(diceEyesOffender[0]);
			// System.out.println(diceEyesOffender[1]);
			// System.out.println(diceEyesOffender[2]);
			return diceEyesOffender;
		}
		Arrays.sort(diceEyesOffender);
		return diceEyesOffender;

		
		
	}
}
