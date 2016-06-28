import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo.*;
import javax.swing.JOptionPane;

/**
 * Schubst Einheiten umher.
 * 
 * @author MaxiJohl, GruenerWal
 * @version 1.1.0
 */

public class ArmySchubser extends Map_World
{    
    static Province savedProvince = null;

    /**
     * Konstruktor für ArmySchubser.
     * 
     * NICHT BENUTZEN!
     * Sämtliche benötigten Methoden sind static!
     */
    public ArmySchubser(String[] playerList, int[] colorList)
    {
        super(playerList,colorList);
    }

    /**
     * Nimmt zwei Provinzen entgegen, und fragt, wieviele Einheiten vom ersten zum zweiten Eintrag verschoben werden sollen.
     * Überprüft, ob eine Verschiebung möglich ist und führt sie bei Erfolg aus.
     */
    public void moveEntities(Province sourceProvince, Province destinationProvince)
    {
        String toMoveString = JOptionPane.showInputDialog(null, "Wieviele Einheiten willst du verschieben?");
        Integer entitiesToMove = Integer.valueOf(toMoveString);

        if ( entitiesToMove != null )
        {
            if ( (sourceProvince.getEntityCount() - entitiesToMove) > 0)
            {
                sourceProvince.removeFromEntities(entitiesToMove);
                destinationProvince.addToEntities(entitiesToMove);
                JOptionPane.showMessageDialog(null,"Einheiten erfolgreich verschoben, Kommandant " + getPlayerName() + ".");
            }

            else if ( (sourceProvince.getEntityCount() - entitiesToMove) <= 0)
            {
                JOptionPane.showMessageDialog(null,"Du hast nicht genügend Einheiten, um die gewünschte Anzahl von " + sourceProvince.getDisplayName() + " nach " + destinationProvince.getDisplayName() + " zu verschieben, Köhler.");
            }
        }
    }

    /**
     * Speichert ein gegebene Provinz als savedProvince ein, insofern dieser Platz nicht bereits belegt ist.
     * Ist er das, so wird überprüft, ob eine neue, an savedProvince angrenzende Provinz angeklickt wurde.
     * Ist dies der Fall, werden beide Provinzen an moveEntities übergeben.
     */
    public void useProvincesToMove(Province givenProvince)
    {
        if (savedProvince == null)
        {
            savedProvince = givenProvince;
        }

        else if ((savedProvince != null) && (givenProvince != savedProvince) && (savedProvince.getOwner() == givenProvince.getOwner()) && (savedProvince.getOwner() == currentPlayer) )
        {
            if (givenProvince.isProvinceNear(savedProvince.getID()) == true)
            {
                moveEntities(savedProvince,givenProvince);
            }

            savedProvince = null;
        } 
    }

    /**
     * Überprüft, ob eine Provinz angeklickt wurde.
     * Wenn ja, wird diese als clickedProvince eingespeichert und useProvincesToMove aufgerufen.
     * 
     * Kommt nachher in die GeneralMap!
     */
    public void act() 
    {
        Province clickedProvince;

        for ( int i = 1; i <= (provinces.length - 1); i++)
        {
            if (provinces[i].hasClicked() == true)
            {
                clickedProvince = provinces[i];
                useProvincesToMove(clickedProvince);
                break;
            }
        }
    }
}