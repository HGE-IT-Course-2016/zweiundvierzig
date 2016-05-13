import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Klasse der Standard-Welt
 * (Also die normale Weltkarte mit allen Kontinenten)
 * 
 * @author GruenerWal, MaxiJohl
 * @version 0.3.0
 */

public class Map_World extends GeneralMap
{
    /**
     * Anzahl der Provinzen.
     */

    int provinceCount = 42;

    /** 
     * Konstruktor der Weltkarte;
     * konstruiert eine GeneralMap mit den Ausmassen 1600 auf 900 Pixel.
     */

    public Map_World()
    {
        super(1600,900,1);
        Province[] provinces;  
        int[] neighbours;

        /**
         * Hier werden später sämtliche Provinzen der Standard-Map erstellt.
         * Dies funktioniert folgendermassen:
         * =================================================================
         * 
         * Im Folgenden wird nun jede Provinz einzeln erstellt:
         * |---
         * nextProvinces = new int[<Anzahl angrenzende Provinzen>];
         * <Zuweisung der angrenzenden Provinzen>
         * provinces[<Provinz-ID>] = new Province(<Provinz-ID>,<Kontinent-ID>,<X-Position>,<Y-Position>,<Anzahl Sterne>,"<Anzeigename>",nextProvinces);
         * addObject(provinces[<Provinz-ID>],<x-Position>,<y-Position>);
         * ---|
         * 
         * =================================================================
         * Der Speicherplatz für provinces[0] bleibt leer, da es keine Provinz mit der ID 0 gibt!
         * 
         * Und ja, ich weiss, dass das scheisse viel Schreibarbeit ist.
         * Aber da muss man durch, wir habens auch hinbekommen :P
         * 
         * ~GruenerWal
         */

        // Festlegung der Provinz-Anzahl
    
        provinces = new Province[provinceCount + 1];

        // Implementierung sämtlicher Provinzen
        // ACHTUNG! Gaaaaanz viel Code!


        // cID 1 - Nordamerika

        neighbours = new int[3];
        neighbours[0] = 2;
        neighbours[1] = 3;
        neighbours[2] = 36;
        provinces[1] = new Province(1,1,64,106,1,"Alaska",neighbours);

        neighbours = new int[4];
        neighbours[0] = 1;  
        neighbours[1] = 3;  
        neighbours[2] = 4;
        neighbours[3] = 9;
        provinces[2] = new Province(2,1,162,106,1,"NW-Territorien",neighbours);

        neighbours = new int[4];
        neighbours[0] = 1;
        neighbours[1] = 2;
        neighbours[2] = 4;
        neighbours[3] = 5;
        provinces[3] = new Province(3,1,53,170,1,"Alberta",neighbours);

        neighbours = new int[6];
        neighbours[0] = 2;
        neighbours[1] = 3;
        neighbours[2] = 5;
        neighbours[3] = 6;
        neighbours[4] = 7;
        neighbours[5] = 9;
        provinces[4] = new Province(4,1,223,177,2,"Ontario",neighbours);

        neighbours = new int[4];
        neighbours[0] = 3;
        neighbours[1] = 4;
        neighbours[2] = 6;
        neighbours[3] = 8;
        provinces[5] = new Province(5,1,160,236,2,"Weststaaten",neighbours);

        neighbours = new int[4];
        neighbours[0] = 4;  
        neighbours[1] = 5;
        neighbours[2] = 7;
        neighbours[3] = 8;
        provinces[6] = new Province(6,1,232,273,2,"Oststaaten",neighbours);

        neighbours = new int[3];
        neighbours[0] = 4; 
        neighbours[1] = 6;
        neighbours[2] = 9;
        provinces[7] = new Province(7,1,300,180,2,"Quebec",neighbours);

        neighbours = new int[3];
        neighbours[0] = 5;
        neighbours[1] = 6;
        neighbours[2] = 17;
        provinces[8] = new Province(8,1,181,347,1,"Mittelamerika",neighbours);

        neighbours = new int[4];
        neighbours[0] = 2;
        neighbours[1] = 4;
        neighbours[2] = 7;
        neighbours[3] = 10;
        provinces[9] = new Province(9,1,365,55,1,"Groenland",neighbours);

        // cID 2 - Europa

        neighbours = new int[3];
        neighbours[0] = 9;
        neighbours[1] = 11;
        neighbours[2] = 12;
        provinces[10] = new Province(10,2,454,142,1,"Island",neighbours);

        neighbours = new int[4];
        neighbours[0] = 10;    
        neighbours[1] = 12;
        neighbours[2] = 14;
        neighbours[3] = 15;
        provinces[11] = new Province(11,2,424,221,2,"Grossbritannien",neighbours);

        neighbours = new int[4];
        neighbours[0] = 10; 
        neighbours[1] = 11;
        neighbours[2] = 13;
        neighbours[3] = 14;
        provinces[12] = new Province(12,2,520,153,1,"Skandinavien",neighbours);

        neighbours = new int[6];
        neighbours[0] = 12;
        neighbours[1] = 14;
        neighbours[2] = 16;
        neighbours[3] = 27;
        neighbours[4] = 31;
        neighbours[5] = 32;
        provinces[13] = new Province(13,2,636,180,2,"Russland",neighbours);

        neighbours = new int[5];
        neighbours[0] = 11;
        neighbours[1] = 12;
        neighbours[2] = 13;
        neighbours[3] = 15;
        neighbours[4] = 16;
        provinces[14] = new Province(14,2,528,232,2,"Nordeuropa",neighbours);

        neighbours = new int[4];
        neighbours[0] = 11;
        neighbours[1] = 14;
        neighbours[2] = 16;
        neighbours[3] = 25;
        provinces[15] = new Province(15,2,449,335,2,"Westeuropa",neighbours);

        neighbours = new int[6];
        neighbours[0] = 13;
        neighbours[1] = 14;
        neighbours[2] = 15;
        neighbours[3] = 25;
        neighbours[4] = 26;
        neighbours[5] = 27;
        provinces[16] = new Province(16,2,537,296,2,"Suedeuropa",neighbours);

        // cID 3 - Suedamerika

        neighbours = new int[3];
        neighbours[0] = 8;   
        neighbours[1] = 18;
        neighbours[2] = 19;
        provinces[17] = new Province(17,3,245,396,1,"Venezuela",neighbours);

        neighbours = new int[3];
        neighbours[0] = 17;
        neighbours[1] = 19;
        neighbours[2] = 20;
        provinces[18] = new Province(18,3,255,498,1,"Peru",neighbours);

        neighbours = new int[4];
        neighbours[0] = 17;
        neighbours[1] = 18;
        neighbours[2] = 20;
        neighbours[3] = 25;
        provinces[19] = new Province(19,3,327,467,2,"Brasilien",neighbours);

        neighbours = new int[2];
        neighbours[0] = 18;
        neighbours[1] = 19;
        provinces[20] = new Province(20,3,274,572,1,"Argentinien",neighbours);
        
        for (int c = 1; c <= provinceCount; c++)
        {
        addObject(provinces[c],provinces[c].getXPos(),provinces[c].getYPos());
        }
    }
}
