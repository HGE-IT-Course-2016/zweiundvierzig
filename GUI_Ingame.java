import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GUI_Ingame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GUI_Ingame extends World
{

    /**
     * Constructor for objects of class GUI_Ingame.
     * 
     */
    public GUI_Ingame()
    {    
        // 
        super(1920, 1080, 1);
        addObject(new Menue_Button(),100,38);
        addObject(new Würfel_Button(),100,1000);
        addObject(new Würfel_Button(),1814,1000);
    }
    
    
    
   
    
    
}
