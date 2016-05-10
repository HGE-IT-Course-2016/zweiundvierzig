import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Klasse der Standard-Welt
 * (Also die normale Weltkarte mit allen Kontinenten)
 * 
 * @author GruenerWal, MaxiJohl
 * @version 0.2.0
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
         * Province <Name> = new Province(<Provinz-ID>,<Kontinent-ID>,<X-Position>,<Y-Position>,<Anzahl Sterne>,"<Anzeigename>",nextProvinces);
         * addObject(<Name>,<x-Position>,<y-Position>);
         * 
         * Zwei Provinzen sind bereits als Beispiel erstellt.
         * Muss später auf jeden Fall korrigiert werden!
         */

        // Implementierung sämtlicher Provinzen
        // ACHTUNG! Gaaaaanz viel Code!

        // cID 1 - Nordamerika
        
        neighbours = new int[3];
        neighbours[0] = 2;
        neighbours[1] = 3;
        neighbours[2] = 36;
        Province Alaska = new Province(1,1,64,106,1,"Alaska",neighbours);
        addObject(Alaska,64,106);

        neighbours = new int[4];
        neighbours[0] = 1;  
        neighbours[1] = 3;  
        neighbours[2] = 4;
        neighbours[3] = 9;
        Province NWTerritorien = new Province(2,1,162,106,1,"NW-Territorien",neighbours);
        addObject(Alaska,162,106);

        neighbours = new int[4];
        neighbours[0] = 1;
        neighbours[1] = 2;
        neighbours[2] = 4;
        neighbours[3] = 5;
        Province Alberta = new Province(3,1,53,170,1,"Alberta",neighbours);
        addObject(Alberta,53,170);

        neighbours = new int[6];
        neighbours[0] = 2;
        neighbours[1] = 3;
        neighbours[2] = 5;
        neighbours[3] = 6;
        neighbours[4] = 7;
        neighbours[5] = 9;
        Province Ontario = new Province(4,1,223,177,1,"Ontario",neighbours);
        addObject(Ontario,223,177);

        neighbours = new int[4];
        neighbours[0] = 3;
        neighbours[1] = 4;
        neighbours[2] = 6;
        neighbours[3] = 8;
        Province Weststaaten = new Province(5,1,160,236,1,"Weststaaten",neighbours);
        addObject(Weststaaten,160,236);

        neighbours = new int[4];
        neighbours[0] = 4;  
        neighbours[1] = 5;
        neighbours[2] = 7;
        neighbours[3] = 8;
        Province Oststaaten = new Province(6,1,232,273,1,"Oststaaten",neighbours);
        addObject(Oststaaten,232,273);

        neighbours = new int[3];
        neighbours[0] = ; 
        neighbours[1] = ;
        neighbours[2] = ;
        Province Quebec = new Province(7,1,300,180,1,"Quebec",neighbours);
        addObject(Quebec,300,180);

        neighbours = new int[1];
        neighbours[] = ; 
        Province Mittelamerika = new Province(8,1,181,347,1,"Mittelamerika",neighbours);
        addObject(Mittelamerika,181,347);

        neighbours = new int[1];
        neighbours[] = ;       
        Province Groenland = new Province(9,1,365,55,1,"Groenland",neighbours);
        addObject(Groenland,365,55);

        // cID 2 - Europa

        neighbours = new int[1];
        neighbours[] = ;        
        Province Island = new Province(10,2,454,142,1,"Island",neighbours);
        addObject(Island,454,142);

        neighbours = new int[1];
        neighbours[] = ;    
        Province Grossbritannien = new Province(11,2,424,221,1,"Grossbritannien",neighbours);
        addObject(Grossbritannien,442,221);

        neighbours = new int[1];
        neighbours[] = ;  
        Province Skandinavien = new Province(12,2,520,153,1,"Skandinavien",neighbours);
        addObject(Skandinavien,520,153);

        neighbours = new int[1];
        neighbours[] = ;
        Province Russland = new Province(13,2,636,180,1,"Russland",neighbours);
        addObject(Russland,636,180);

        neighbours = new int[1];
        neighbours[] = ;
        Province Nordeuropa = new Province(14,2,,,1,"Nordeuropa",neighbours);
        addObject(Nordeuropa,,);

        neighbours = new int[1];
        neighbours[] = ;
        Province Westeuropa = new Province(15,2,528,232,1,"Westeuropa",neighbours);
        addObject(Westeuropa,528,232);

        neighbours = new int[1];
        neighbours[] = ;
        Province Suedeuropa = new Province(16,2,449,335,1,"Suedeuropa",neighbours);
        addObject(Suedeuropa,449,335);

        // cID 3 - Suedamerika

        neighbours = new int[1];
        neighbours[] = ;      
        Province Venezuela = new Province(17,3,245,396,1,"Venezuela",neighbours);
        addObject(Venezuela,245,396);

        neighbours = new int[1];
        neighbours[] = ;
        Province Peru = new Province(18,3,255,498,1,"Peru",neighbours);
        addObject(Peru,255,498);
        
        

        neighbours = new int[1];
        neighbours[] = ;
        Province Brasilien = new Province(19,3,327,467,1,"Brasilien",neighbours);
        addObject(Brasilien,327,467);

        neighbours = new int[1];
        neighbours[] = ;
        Province Argentinien = new Province(20,3,274,572,1,"Argentinien",neighbours);
        addObject(Argentinien,274,572);
    }
}
