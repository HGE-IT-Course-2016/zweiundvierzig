import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Klasse der Standard-Welt
 * (Also die normale Weltkarte mit allen Kontinenten)
 * 
 * @author GruenerWal
 * @version 0.0.1
 */

public class DefaultMap extends Map
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

    public DefaultMap()
    {
        super(1280,720,1);

        /**
         * Hier werden später sämtliche Provinzen der Standard-Map erstellt.
         * Dies funktioniert folgendermassen:
         * 
         * Province <Name> = new Province(<Anzahl Sterne>,"<Anzeigename>");
         * addObject(<Name>,<x-Position>,<y-Position>);
         * 
         * Zwei Provinzen sind bereits als Beispiel erstellt.
         * Muss später ggf. korrigiert werden!
         */

        Province Irkutsk = new Province(1,"Irkutsk");
        addObject(Irkutsk,1000,100);

        Province China = new Province(2,"China");
        addObject(China,1000,350);
    }
}
