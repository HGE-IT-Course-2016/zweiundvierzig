/*
	Hinweis zum Verbleib der Klasse:
	Diese Klasse soll, da sie zurzeit weder vollständig, noch in Verwendung, noch in der Architektur definiert ist, zum Beta-Meilenstein entfernt werden.
	Sollte die Klasse jedoch zuvor noch Verwendung finden, wird sie nach Absprache mit den jeweiligen Autoren/Benutzern in die Architektur aufgenommen.
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Menue_Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menue_Button extends Button
{
	public Menue_Button(ButtonEvent h) {
		super(h);
	}
	
	/**
	 * Act - do whatever the Menue_Button wants to do. This method is called whenever
	 * the 'Act' or 'Run' button gets pressed in the environment.
	 */
	public void act() 
	{
		setLocation(100,38);// Add your action code here.
	}    
}
