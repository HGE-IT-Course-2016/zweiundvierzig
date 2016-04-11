import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CurrentPlayerArrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CurrentPlayerArrow extends GUI_Interface
{
    /**
     * Act - do whatever the CurrentPlayerArrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }

    public void CurrentPlayerArrow(int currentPlayer, int playerNumber)
    {
        switch (currentPlayer) {
            case 1 : 
            setLocation(120,100);
            break;
            case 2 : 
            setLocation(120,100 + (825 / playerNumber));
            break;
            case 3 :
            setLocation(120,100 + (825 / playerNumber)*2);            
            break;
            case 4 : 
            setLocation(120,100 + (825 / playerNumber)*3);
            break;

        }
    }
}
