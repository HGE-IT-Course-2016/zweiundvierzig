import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public Fight()
    {
        
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
    
    private void chooser(Province offenderProvince, int i)
    {
        int EntitiesOffender = provinces[i].getEntityCount(); 
        i = 0;
        for (i = 0; i <= provinceCount; i++)
        {
            if (provinces[i].hasClicked() == true && provinces[i] != offenderProvince)
            {
                provinces[i] = defenderProvince;
                int EntitiesDefender = provinces[i].getEntityCount();
                chooser(offenderProvince,defenderProvince,EntitiesOffender,EntitiesDefender);                
                break;
            }
        }
    }
    
    private void chooser(Province offenderProvince, Province defenderProvince, int EntitiesOffender, int EntitiesDefender)
    {
        int diceDefender = Dice_Defender.dice_defender(EntitiesDefender);
    }
    
}
