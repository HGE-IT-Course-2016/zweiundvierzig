import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo.*;
import javax.swing.JOptionPane;

/**
 * Schubst Einheiten umher.
 * 
 * @author MaxiJohl, GruenerWal
 * @version 0.1.0
 */
public class ArmySchubser extends Map_World
{

    /**
     * Constructor for objects of class ArmySchubser.
     * 
     */
    public ArmySchubser()
    {
        // Hi.
    }

    /*
    public void act()
    {
    MouseInfo m = Greenfoot.getMouseInfo();
    Actor mouseActor = m.getActor();

    if (mouseActor.getClass().equals(Province.class))
    {
    Actor firstProvince = mouseActor;    
    }
    }
     */

    public void act() {
        Province firstProvince = null;
        Province secondProvince = null;

        for ( int i = 0; i <= provinceCount; i++)
        {
            if (provinces[i].hasClicked() == true)
            {
                provinces[i] = firstProvince;
                break;
            }
        }

        for ( int i = 0; i <= provinceCount; i++)
        {
            if (provinces[i].hasClicked() == true && provinces[i] != firstProvince)
            {
                provinces[i] = secondProvince;
                break;
            }
        }

        String toMove = JOptionPane.showInputDialog(null, "Wieviele Einheiten willst du verschieben?");
        Integer entitiesToMove = Integer.valueOf(toMove);

        if ( (firstProvince.getEntityCount() - entitiesToMove) > 0 && firstProvince.isProvinceNear(secondProvince.getID()) == true )
        {
            firstProvince.removeFromEntities(entitiesToMove);
            secondProvince.addToEntities(entitiesToMove);
        }

        else
        {
            System.out.println("Du hast nicht genügend Einheiten, um die gewünschte Anzahl von " + firstProvince.getDisplayName() + " nach " + secondProvince.getDisplayName() + " zu verschieben, Köhler.");
        }
    }
}
