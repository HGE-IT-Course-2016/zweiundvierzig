import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Startet neues Spiel.
 * 
 * @author 4ngelica 
 * @version 1.0
 */
public class Start_Button extends Button
{
	public Start_Button() {
		super("New Game", 32);
	}
	
	/**
	 * Erstellt neue Klasse Colors.
	 */
	public void act() 
	{
		setLocation(100,100);
		if (Greenfoot.mouseClicked(this))    
		{    
			Greenfoot.setWorld(new Colors());  
		}
	}    
}
