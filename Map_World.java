import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Klasse der Standard-Welt
 * (Also die normale Weltkarte mit allen Kontinenten)
 * 
 * @author GruenerWal
 * @version 0.0.1
 */

public class Map_World extends GeneralMap
{
    /**
     * Anzahl der Provinzen
     * Muss später ggf. korrigiert werden!
     */

    int provinzen = 42;

    /** 
     * Konstruktor der Weltkarte
     * Ausdehnung 1280x720 eingetragen
     * Muss später ggf. korrigiert werden!
     */

    public Map_World()
    {
        super(1280,720,1);
        int[] neighbours;

        /**
         * Hier werden später sämtliche Provinzen der Standard-Map erstellt.
         * Dies funktioniert folgendermassen:
         * 
         * nextProvinces = new int[<Anzahl angrenzende Provinzen>];
         * <Zuweisung der angrenzenden Provinzen>
         * Province <Name> = new Province(<Provinz-ID>,<Kontinent-ID>,<Anzahl Sterne>,"<Anzeigename>",nextProvinces);
         * addObject(<Name>,<x-Position>,<y-Position>);
         * 
         * Zwei Provinzen sind bereits als Beispiel erstellt.
         * Muss später auf jeden Fall korrigiert werden!
         */

        neighbours = new int[1];
        neighbours[0] = 2;        
        Province Mongolei = new Province(1,1,1,"Mongolei",neighbours);
        addObject(Mongolei,1000,100);

        neighbours = new int[1];
        neighbours[0] = 1;
        Province China = new Province(2,1,2,"China",neighbours);
        addObject(China,1000,350);
    }
}
