import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Beginnt neues Spiel/ lädt altes Spiel.
 * 
 * @author 4ngelica 
 * @version 1.0
 */
public class Start_Load extends World implements ButtonEvent 
{
     Button chulien = new Button("Neues Spiel", 16 , this);
     
    /**
     * Constructor for objects of class Start_Load.
     * 
     */
    public Start_Load()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 900, 1); 
        addObject (chulien, (1600-chulien.getWidth())/2, (900-chulien.getHeight())/2);
	}
	public void buttonClicked ( Button b)
	{
	    
	   if ( b  == chulien)
	   {
	       World chean = new Colours (1600, 900, 1);
	       Greenfoot.setWorld(chean);
	       
	   }
	}
	
	
	public void Load()
	{
	    
	}
}

