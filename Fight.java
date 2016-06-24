import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Arrays;
import javax.swing.JOptionPane;

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
    String maxDiceOffender = "";
    String maxDiceDefender = "";

    public Fight(String[] playerList, int[] colorList)
    {
        super(playerList,colorList);

    }

    public void test()
    {
        provinces[1].setEntityCount(10);
        provinces[2].setEntityCount(20);
        provinces[1].setOwner(1);
        provinces[2].setOwner(2);
        provinces[1].redrawProvince();
        provinces[2].redrawProvince();

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
                // System.out.println("Die Provinz " + provinces[i].getDisplayName() + " wurde als angreifende Provinz ausgewählt! Sie gehört Spieler" + provinces[i].getOwner());                
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
                    // System.out.println("Die Provinz " + provinces[i].getDisplayName() + " wurde als verteidigende Provinz ausgewählt! Sie gehört Spieler" + provinces[i].getOwner()); 
                    chooser();                
                    break;
                } 
            }
        }
    }

    private void chooser()
    {
        System.out.println("Es wird gewürfelt!");        
        Dice_Offender diceOffender = new Dice_Offender();
        // System.out.println("Der Angreifer ereichte folgende Würfelzahlen:"); 
        int[] maxDiceOffenderArray = diceOffender.dice_offender(offenderProvince.getEntityCount());
        Dice_Defender diceDefender = new Dice_Defender();
        // System.out.println("Der Verteidiger ereichte folgende Würfelzahlen:");
        int[] maxDiceDefenderArray = diceDefender.dice_defender(defenderProvince.getEntityCount());
        Arrays.sort(maxDiceOffenderArray);
        Arrays.sort(maxDiceDefenderArray);

        for(int i = 0;i<3;i++)
        {
            if(i == 0)
            {
                maxDiceOffender = "" + maxDiceOffenderArray[i];
            }
            else
            {
                maxDiceOffender = maxDiceOffender + ";" + maxDiceOffenderArray[i];
            }
        }
        for(int i = 0;i<2;i++)
        {
            if(i == 0)
            {
                maxDiceDefender = "" + maxDiceDefenderArray[i];
            }
            else
            {
                maxDiceDefender = maxDiceDefender + ";" + maxDiceDefenderArray[i];
            }

        }
        JOptionPane.showMessageDialog(null,"Es wurde gewürfelt. Der Angreifer erreichte folgende Würfelzahlen: " + maxDiceOffender + "\n Der Verteidiger erreichte diese Würfelzahlen: " + maxDiceDefender);
        diceOffender = null;
        diceDefender = null;
        decider(maxDiceOffenderArray, maxDiceDefenderArray);
    }

    private void decider(int[] maxDiceOffender, int [] maxDiceDefender)
    {

        int maxDefender = maxDiceDefender[1];
        int maxOffender = maxDiceOffender[2];
        if (maxOffender > maxDefender && defenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            defenderProvince.setEntityCount(EntitiesDefender - 1);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Angreifer (Spieler " + offenderProvince.getOwner() + ").Dem Verteidiger (Spieler " + defenderProvince.getOwner() +  ") wird eine Einheit abgezogen. Er hat nun noch " + defenderProvince.getEntityCount() + " Einheiten");

        }

        if (maxOffender < maxDefender && offenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            offenderProvince.setEntityCount(EntitiesOffender - 1);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Verteidiger (Spieler " + defenderProvince.getOwner() + ").Dem Angreifer (Spieler " + defenderProvince.getOwner() +  ") wird eine Einheit abgezogen. Er hat nun noch " + offenderProvince.getEntityCount() + " Einheiten");            
        }

        if (maxOffender == maxDefender && offenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            offenderProvince.setEntityCount(EntitiesOffender - 1);
            JOptionPane.showMessageDialog(null,"Da es unentschieden ist, gewinnt der Verteidiger (Spieler " + defenderProvince.getOwner() + ").Dem Angreifer (Spieler " + defenderProvince.getOwner() +  ") wird eine Einheit abgezogen. Er hat nun noch " + offenderProvince.getEntityCount() + " Einheiten");
        }

        if (maxOffender>maxDefender && defenderProvince.getEntityCount()==1)
        {
            defenderProvince.setOwner(offenderProvince.getOwner());
            defenderProvince.setEntityCount(0);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Angreifer (Spieler " + offenderProvince.getOwner() + "). Die Provinz gehört fortan dem Angreifer (" + offenderProvince.getOwner() + ")");
        }
        offenderProvince = null;
        defenderProvince = null;

    }
}

//Ein <3 für Felix (von Aaron)(geschrieben von Samuel)(aber Aaron wollte das ich des schreib)
