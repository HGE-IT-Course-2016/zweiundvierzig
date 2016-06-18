/*
    Hinweis zum Verbleib der Klasse:
    Diese Klasse wird nach ihrer Fertigstellung in die GeneralMap integriert.
    Dabei wird der Code der act()-Methode innerhalb einer If-Abfrage bei bestimmten States ausgeführt.
    Sonstige Methoden werden im Original belassen, sofern keine Überschneidungen bei den Bezeichnern vorhanden sind.
*/

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo.*;
import javax.swing.JOptionPane;

/**
 * Schubst Einheiten umher.
 * 
 * @author MaxiJohl, GruenerWal
 * @version 0.3.0
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
        // Hi.
    }

    /**
     * Nimmt zwei Provinzen entgegen, und fragt, wieviele Einheiten vom ersten zum zweiten Eintrag verschoben werden sollen.
     * Überprüft, ob eine Verschiebung möglich ist und führt sie bei Erfolg aus.
     */
    public static void moveEntities(Province sourceProvince, Province destinationProvince)
    {
        String toMoveString = JOptionPane.showInputDialog(null, "Wieviele Einheiten willst du verschieben?");
        Integer entitiesToMove = Integer.valueOf(toMoveString);

        if ( (sourceProvince.getEntityCount() - entitiesToMove) > 0)
        {
            sourceProvince.removeFromEntities(entitiesToMove);
            destinationProvince.addToEntities(entitiesToMove);
        }

        if ( (sourceProvince.getEntityCount() - entitiesToMove) <= 0 )
        {
            JOptionPane.showMessageDialog(null,"Du hast nicht genügend Einheiten, um die gewünschte Anzahl von " + sourceProvince.getDisplayName() + " nach " + destinationProvince.getDisplayName() + " zu verschieben, Köhler.");
        }
    }

    /**
     * Speichert ein gegebene Provinz als savedProvince ein, insofern dieser Platz nicht bereits belegt ist.
     * Ist er das, so wird überprüft, ob eine neue, an savedProvince angrenzende Provinz angeklickt wurde.
     * Ist dies der Fall, werden beide Provinzen an moveEntities übergeben.
     */
    public static void useProvincesToMove(Province givenProvince)
    {
        if (savedProvince == null)
        {
            savedProvince = givenProvince;
        }

        if (savedProvince != null && givenProvince != savedProvince)
        {
            if (givenProvince.isProvinceNear(savedProvince.getID()) == true)
            {
                moveEntities(savedProvince,givenProvince);
            }
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
        Province clickedProvince = null;
        
        for ( int i = 1; i <= provinceCount; i++)
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

