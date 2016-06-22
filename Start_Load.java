import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Beginnt neues Spiel/ lädt altes Spiel.
 * 
 * @author 4ngelica 
 * @version 1.0
 */
public class Start_Load extends World implements ButtonEvent
{
    Button start = new Button ("new game", 16, this);
    /**
     * Constructor for objects of class Start_Load.
     * 
     */
    public Start_Load()
    {    
        super(1600, 900, 1); 
        addObject (start, 800, 450);
        
	}
	
	public void buttonClicked (Button b)
	{
	    if (Greenfoot.mouseClicked(this))    
		{    
			Greenfoot.setWorld(new Colours());  
		}
	}
	
	public void Load() //hat noch keine Funktion
	{
	    
	}
}

