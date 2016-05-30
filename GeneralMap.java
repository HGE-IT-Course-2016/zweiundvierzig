import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Oberklasse für verschiedene Maps;
 * neue Maps werden als Unterklasse dieser Klasse eingefügt.
 * 
 * @author GruenerWal, MaxiJohl
 * @version 0.2.0
 */
public class GeneralMap extends World
{
    /**
     *  Felder, im Moment nur Anzahl der Provinzen
     *  Später evtl. weitere Werte wie Schwierigkeit denkbar
     */

    protected int provinzen;    

    /** Konstruktor für nicht weiter definierte Map, sollte im Moment nicht benutzt werden.
     * Später als Konstruktor für Default-Map denkbar.
     */
    public GeneralMap(int x, int y, int p)
    {    
        /**
         * Erstellt eine leere Karte mit den übergebenen Eigenschaften
         * @param x X-Ausdehnung der Welt
         * @param y Y-Ausdehnung
         * @param p Kantenlänge der Felder in Pixeln
         */
        super(1600, 900, 1);
        //addObject(new Menue_Button(),100,38);
        //addObject(new Roll_Button(),84,835);
        //addObject(new Roll_Button(),1513,835);
    }

    static GeneralMap generateMap(int mapID)
    {
        //Platzhalter
        return null;
    }

    int getPlayerCount()
    {
        //Platzhalter
        return 4;
    }

    String getPlayerName()
    {
        //Platzhalter
        return null;
    }

    String getPlayerName(int plID)
    {
        //Platzhalter
        return null;
    }

    int getPlayerStars()
    {
        //Platzhalter
        return 0;
    }

    int getProvinceOwner(int prID)
    {
        //Platzhalter
        return 0;
    }

    int[] getProvinceOwners()
    {
        //Platzhalter; viel Arbeit :3
        int[] provinceOwners = new int[1];
        provinceOwners[0] = 0;
        return provinceOwners;
    }

    int getProvinceEntityCount(int prID)
    {
        //Platzhalter
        return 0;
    }

    int getProvincesEntityCounts(int[] prArr)
    {
        //Platzhalter
        return 0;
    }

    int getProvincesEntityCounts(boolean[] prArr)
    {
        //Platzhalter
        return 0;
    }

    int getProvincesEntityCounts(int plID)
    {
        //Platzhalter
        return 0;
    }

}
