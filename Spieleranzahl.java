import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Spieleranzahl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spieleranzahl extends Spieloptionen
{

    /**
     * Constructor for objects of class Spieleranzahl.
     * 
     */
    public Spieleranzahl()
    {
        addObject (new Button(), 100, 300);
    } 
    
    public void act()
    {
        if (handler.buttonClicked(this));
        {
            int s;
            if (s > 3)
            {
                int s = Spieleranzahl;
            }
        }
    }
}
