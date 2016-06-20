import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;

/**
 * Write a description of class Fight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fight extends Map_World
{

    /**
     * Constructor for objects of class Fight.
     * 
     */
    Province offenderProvince;
    Province defenderProvince;    

    public Fight(String[] playerList, int[] colorList)
    {
        super(playerList,colorList);
    }

    public void act()
    {
        for ( int i = 0; i <= provinceCount; i++)
        {
            if (provinces[i].hasClicked() == true)
            {
                provinces[i] = offenderProvince;
                chooser(provinces[i], i);
                break;
            }
        }  
    }

    private void chooser(Province offenderProvince, int k)
    {
        int EntitiesOffender = provinces[k].getEntityCount(); 
        int i = 0;
        for (i = 0; i <= provinceCount; i++)
        {
            if (provinces[i].hasClicked() == true && provinces[i] != offenderProvince)
            {
                provinces[i] = defenderProvince;
                int EntitiesDefender = provinces[i].getEntityCount();
                chooser(offenderProvince,defenderProvince,EntitiesOffender,EntitiesDefender, k , i);                
                break;
            }
        }
    }

    private void chooser(Province offenderProvince, Province defenderProvince, int EntitiesOffender, int EntitiesDefender, int k , int i)
    {
        Dice_Offender diceOffender = new Dice_Offender();        
        int[] maxDiceOffender = diceOffender.max_offender(EntitiesOffender);
        Dice_Defender diceDefender = new Dice_Defender();
        int[] maxDiceDefender = diceDefender.max_defender(EntitiesDefender);
        Arrays.sort(maxDiceOffender);
        Arrays.sort(maxDiceDefender); 
    }

    private void decider(Province offenderProvince, Province defenderProvince,int[] maxDiceOffender, int [] maxDiceDefender, int k, int i)
    {
        int maxDefender = maxDiceDefender[2];
        int maxOffender = maxDiceOffender[3];
        if (maxOffender>maxDefender && provinces[i].getEntityCount()>1)
        {
            int EntitiesOffender = provinces[k].getEntityCount();
            int EntitiesDefender = provinces[i].getEntityCount();
            provinces[i].setEntityCount(EntitiesDefender - 1);   
        }

        if (maxOffender<maxDefender && provinces[k].getEntityCount()>1)
        {
            int EntitiesOffender = provinces[k].getEntityCount();
            int EntitiesDefender = provinces[i].getEntityCount();
            provinces[k].setEntityCount(EntitiesOffender - 1);   
        }

        if (maxOffender>maxDefender && provinces[i].getEntityCount()==1)
        {
            provinces[i].setOwner(provinces[k].getOwner());
            provinces[i].setEntityCount(0);
        }

        if (maxOffender>maxDefender && provinces[k].getEntityCount()==1)
        {
            provinces[k].setOwner(provinces[i].getOwner());
            provinces[k].setEntityCount(0);
        }
    }

}

//Ein <3 für Felix (von Aaron)(geschrieben von Samuel)(aber Aaron wollte das ich des schreib)
