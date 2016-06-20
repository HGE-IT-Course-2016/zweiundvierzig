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
        if(offenderProvince == null)
        {
            OffenderProvince();
        }
        else
        {
            defenderProvince();
        }
    }

    private void OffenderProvince()
    {
        for ( int i = 1; i <= provinceCount; i++)
        {
            if (provinces[i].hasClicked() == true)
            {   
                offenderProvince = provinces[i];
                System.out.println("1");                
            }
        }
    }

    private void defenderProvince()
    {
        {
            for (int i = 1; i <= provinceCount; i++)
            {
                if (provinces[i].hasClicked() == true)//&& defenderProvince != offenderProvince)
                {
                    defenderProvince = provinces[i];
                    System.out.println("2");
                    chooser();                
                    break;
                } 
            }
        }
    }

    private void chooser()
    {
        Dice_Offender diceOffender = new Dice_Offender();        
        int[] maxDiceOffender = diceOffender.max_offender(offenderProvince.getEntityCount());
        Dice_Defender diceDefender = new Dice_Defender();
        int[] maxDiceDefender = diceDefender.max_defender(defenderProvince.getEntityCount());
        Arrays.sort(maxDiceOffender);
        Arrays.sort(maxDiceDefender); 
        decider(maxDiceOffender, maxDiceDefender);
    }

    private void decider(int[] maxDiceOffender, int [] maxDiceDefender)
    {
        
        int maxDefender = maxDiceDefender[1];
        int maxOffender = maxDiceOffender[2];
        if (maxOffender>maxDefender && defenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            defenderProvince.setEntityCount(EntitiesDefender - 1);   
        }

        if (maxOffender<maxDefender && offenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            offenderProvince.setEntityCount(EntitiesOffender - 1);   
        }

        if (maxOffender>maxDefender && defenderProvince.getEntityCount()==1)
        {
            defenderProvince.setOwner(offenderProvince.getOwner());
            defenderProvince.setEntityCount(0);
        }

        if (maxOffender>maxDefender && offenderProvince.getEntityCount()==1)
        {
            offenderProvince.setOwner(defenderProvince.getOwner());
            offenderProvince.setEntityCount(0);
        }
        System.out.println("3");
        offenderProvince = null;
        defenderProvince = null;
    }
}

//Ein <3 für Felix (von Aaron)(geschrieben von Samuel)(aber Aaron wollte das ich des schreib)
