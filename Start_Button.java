import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Startet neues Spiel.
 * 
 * @author 4ngelica 
 * @version 1.0
 */
public class Start_Button extends Button
{
    private int textSize = 32; 
	private String text = "New Game";
    
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
