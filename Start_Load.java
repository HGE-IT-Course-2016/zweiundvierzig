import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Beginnt neues Spiel/ lädt altes Spiel.
 * 
 * @author 4ngelica 
 * @version 1.0
 */
public class Start_Load extends World
{
    
    /**
     * Constructor for objects of class Start_Load.
     * 
     */
    public Start_Load()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
	}
	
	public void NewGame()
	{
	    addObject (new Start_Button());
	}
	
	public void Load()
	{
	    
	}
}

