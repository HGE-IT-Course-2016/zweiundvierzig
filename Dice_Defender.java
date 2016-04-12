import greenfoot.*;
import java.util.Arrays;   // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dice_Offender here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dice_Defender extends Dice
{
    /**
     * Act - do whatever the Dice_Offender wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int[] diceEyesDefender = new int[2];
    public void act() 
    {
        // Add your action code here.
    }

    /**
     * Die Methode für das Würfeln mit bis zu drei Würfeln des Angreifers, es wird ein Array mit den drei Zahlen zurückgegeben, höchster Wert befindet sich immer an dritter Stelle.
     * @param troupNumberDefender Anzahl der Truppen auf dem ausgewählten Feld
     */
    public int[] dice_offender(int troupNumberDefender)
    {
        if(troupNumberDefender == 1)
        {
            diceEyesDefender[0] = (int) (Math.random() * 6 +1);
            return diceEyesDefender;
        }
        if(troupNumberDefender >=2 )
        {
            diceEyesDefender[0] = (int) (Math.random() * 6 +1);
            diceEyesDefender[1] = (int) (Math.random()* 6 +1);
            System.out.println(diceEyesDefender[0]);
            System.out.println(diceEyesDefender[1]);
            return diceEyesDefender;
        }
        Arrays.sort(diceEyesDefender);
        return diceEyesDefender;

        
        
    }
    
    public int[] max(int troupNumberDefender)
    {
       if(troupNumberDefender == 1)
        {
            diceEyesDefender[0] = (int) (Math.random() * 2 +4);
            return diceEyesDefender;
        }
        if(troupNumberDefender >=2 )
        {
            diceEyesDefender[0] = (int) (Math.random() * 2 +4);
            diceEyesDefender[1] = (int) (Math.random()* 2 +4);
            System.out.println(diceEyesDefender[0]);
            System.out.println(diceEyesDefender[1]);
            return diceEyesDefender;
        }
        Arrays.sort(diceEyesDefender);
        return diceEyesDefender;
        
       
        
        
    }
    
}
