import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo.*;
import javax.swing.JOptionPane;

/**
 * Schubst Einheiten umher.
 * 
 * @author MaxiJohl, GruenerWal
 * @version 0.2.0
 */

public class ArmySchubser extends Map_World
{
    Province firstProvince = null;
    Province secondProvince = null;

    /**
     * Constructor for objects of class ArmySchubser.
     * 
     */
    public ArmySchubser()
    {
        // Hi.
    }

    public void act() 
    {
        if (firstProvince == null)
        {
            for ( int i = 1; i <= provinceCount; i++)
            {
                if (provinces[i].hasClicked() == true)
                {
                    provinces[i] = firstProvince;
                    break;
                }
            }
        }

        if (firstProvince != null)
        {
            for ( int i = 0; i <= provinceCount; i++)
            {
                if (provinces[i].hasClicked() == true && provinces[i] != firstProvince)
                {
                    provinces[i] = secondProvince;
                    break;
                }
            }

            String toMoveString = JOptionPane.showInputDialog(null, "Wieviele Einheiten willst du verschieben?");
            Integer entitiesToMove = Integer.valueOf(toMoveString);

            if ( (firstProvince.getEntityCount() - entitiesToMove) > 0 && firstProvince.isProvinceNear(secondProvince.getID()) == true )
            {
                firstProvince.removeFromEntities(entitiesToMove);
                secondProvince.addToEntities(entitiesToMove);
            }

            if ( (firstProvince.getEntityCount() - entitiesToMove) <= 0 )
            {
                JOptionPane.showMessageDialog(null,"Du hast nicht genügend Einheiten, um die gewünschte Anzahl von " + firstProvince.getDisplayName() + " nach " + secondProvince.getDisplayName() + " zu verschieben, Köhler.");
            }
            
            if ( firstProvince.isProvinceNear(secondProvince.getID()) == false )
            {
                JOptionPane.showMessageDialog(null,"Die Provinzen müssen nebeneinander liegen, wenn du Einheiten verschieben willst.");
            }
        }
    }
}
