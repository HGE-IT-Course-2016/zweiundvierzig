import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;

/**
Oberklasse für verschiedene Maps;
neue Maps werden als Unterklasse dieser Klasse eingefügt.

@author GruenerWal, MaxiJohl, Felix Stupp
@version 0.3.0
 */
public abstract class GeneralMap extends World
{
    /*
    Felder, im Moment nur Anzahl der Provinzen
    Später evtl. weitere Werte wie Schwierigkeit denkbar
     */

    private final int X_OFFSET = 0; // Verschiebt die Provinzen nach rechts
    private final int Y_OFFSET = 0; // Verschiebt die Provinzen nach unten

    /*
    Die einzelnen Positionen der Provinzen wird mit SCALE_VALUE/10000 multipliziert.
    Dies ist nützlich, wenn die Karte beispielsweise nur noch 80% der Originalgröße bei ihrer Darstellung groß ist.
    Bei diesem Beispiel wäre hier, neben dem Offset oben, der Wert 0.8 einzutragen.
     */
    private final double SCALE_VALUE = 1;

    protected Province[] provinces;
    protected Player[] players;

    protected int currentPlayer = 0;

    /**
    Erstellt eine GeneralMap mit allen Eigenschaften und initialisiert die Arrays für Provinzen und Spieler.
    @param backImage Das Hintergrundbild, welches von dieser Klasse geladen und dargestellt wird.
    @param playerList Die Liste mit den Namen der Spieler
    @param colorList Die Liste mit den Farben der Spieler
     */
    public GeneralMap(String backImage, String[] playerList, int[] colorList)
    {    
        super(1600,900,1);
        players = new Player[playerList.length];
        for (int i = 0; i < playerList.length; i++) {
            players[i] = new Player(i,playerList[i],colorList[i]);
        }
    }

    /**
    Fügt alle Provinzen aus dem Array der Welt an der entsprechden Stelle zu.
     */
    protected void initProvinces() {
        for(int i = 1; i < provinces.length; i++) {
            addObject(provinces[i],((int) Math.floor(provinces[i].getXPos() * SCALE_VALUE)) + X_OFFSET,((int) Math.floor(provinces[i].getYPos() * SCALE_VALUE)) + Y_OFFSET);
        }
        /**
    Legt die Startprovincen der Spieler fest.
     */
        if(players.length==3)
        {
            /*Spieler 1 darf beginnen      Hauptstadt: 40
             * Spieler 2 ist als zweites dran   Hauptstadt: 20
             * Spieler 3 ist als drittes dran und bekommt eine Karte    Hauptstadt: 9
             */
            
            provinces[1].setOwner(1);
            provinces[1].setEntityCount(1);
            provinces[1].redrawProvince();
            provinces[2].setOwner(3);
            provinces[2].setEntityCount(2);
            provinces[2].redrawProvince();
            provinces[3].setOwner(2); 
            provinces[3].setEntityCount(2);
            provinces[3].redrawProvince();
            provinces[4].setOwner(2); //Fabrik
            provinces[4].setEntityCount(1);
            provinces[4].redrawProvince();
            provinces[5].setOwner(1);//Fabrik
            provinces[5].setEntityCount(1);
            provinces[5].redrawProvince();
            provinces[6].setOwner(1);//Fabrik
            provinces[6].setEntityCount(1);
            provinces[6].redrawProvince();
            provinces[7].setOwner(3);
            provinces[7].setEntityCount(2);
            provinces[7].redrawProvince();
            provinces[8].setOwner(1);
            provinces[8].setEntityCount(1);
            provinces[8].redrawProvince();
            provinces[9].setOwner(3);
            provinces[9].setEntityCount(4);
            provinces[9].redrawProvince();
            provinces[10].setOwner(3);
            provinces[10].setEntityCount(1);
            provinces[10].redrawProvince();
            provinces[11].setOwner(2);//Fabrik
            provinces[11].setEntityCount(2);
            provinces[11].redrawProvince();
            provinces[12].setOwner(1);
            provinces[12].setEntityCount(2);
            provinces[12].redrawProvince();
            provinces[13].setOwner(1);//Fabrik
            provinces[13].setEntityCount(2);
            provinces[13].redrawProvince();
            provinces[14].setOwner(3);//Fabrik
            provinces[14].setEntityCount(3);
            provinces[14].redrawProvince();
            provinces[15].setOwner(3);//Fabrik
            provinces[15].setEntityCount(3);
            provinces[15].redrawProvince();
            provinces[16].setOwner(3);//Fabrik
            provinces[16].setEntityCount(3);
            provinces[16].redrawProvince();
            provinces[17].setOwner(1);
            provinces[17].setEntityCount(1);
            provinces[17].redrawProvince();
            provinces[18].setOwner(2);
            provinces[18].setEntityCount(2);
            provinces[18].redrawProvince();
            provinces[19].setOwner(2);//Fabrik
            provinces[19].setEntityCount(4);
            provinces[19].redrawProvince();
            provinces[20].setOwner(2);
            provinces[20].setEntityCount(3);
            provinces[20].redrawProvince();
            provinces[21].setOwner(1);
            provinces[21].setEntityCount(1);
            provinces[21].redrawProvince();
            provinces[22].setOwner(3);//Fabrik
            provinces[22].setEntityCount(4);
            provinces[22].redrawProvince();
            provinces[23].setOwner(1);
            provinces[23].setEntityCount(2);
            provinces[23].redrawProvince();
            provinces[24].setOwner(3);
            provinces[24].setEntityCount(4);
            provinces[24].redrawProvince();
            provinces[25].setOwner(2);
            provinces[25].setEntityCount(2);
            provinces[25].redrawProvince();
            provinces[26].setOwner(2);//Fabrik
            provinces[26].setEntityCount(1);
            provinces[26].redrawProvince();
            provinces[27].setOwner(3);
            provinces[27].setEntityCount(1);
            provinces[27].redrawProvince();
            provinces[28].setOwner(1);//Fabrik
            provinces[28].setEntityCount(3);
            provinces[28].redrawProvince();
            provinces[29].setOwner(1);//Fabrik
            provinces[29].setEntityCount(3);
            provinces[29].redrawProvince();
            provinces[30].setOwner(1);
            provinces[30].setEntityCount(4);
            provinces[30].redrawProvince();
            provinces[31].setOwner(3);
            provinces[31].setEntityCount(1);
            provinces[31].redrawProvince();
            provinces[32].setOwner(2);
            provinces[32].setEntityCount(1);
            provinces[32].redrawProvince();
            provinces[33].setOwner(2);
            provinces[33].setEntityCount(1);
            provinces[33].redrawProvince();
            provinces[34].setOwner(1);
            provinces[34].setEntityCount(2);
            provinces[34].redrawProvince();
            provinces[35].setOwner(2);
            provinces[35].setEntityCount(2);
            provinces[35].redrawProvince();
            provinces[36].setOwner(3);
            provinces[36].setEntityCount(1);
            provinces[36].redrawProvince();
            provinces[37].setOwner(2);
            provinces[37].setEntityCount(2);
            provinces[37].redrawProvince();
            provinces[38].setOwner(2);//Fabrik
            provinces[38].setEntityCount(4);
            provinces[38].redrawProvince();
            provinces[39].setOwner(2);
            provinces[39].setEntityCount(3);
            provinces[39].redrawProvince();
            provinces[40].setOwner(1);
            provinces[40].setEntityCount(4);
            provinces[40].redrawProvince();
            provinces[41].setOwner(3);//Fabrik
            provinces[41].setEntityCount(1);
            provinces[41].redrawProvince();
            provinces[42].setOwner(1);
            provinces[42].setEntityCount(2);
            provinces[42].redrawProvince();
        }
        if(players.length==4)
        {
            /*Spieler 1 darf beginnen     Hauptstadt:22
             * Spieler 2 ist als zweites dran      Hauptstadt:20
             * Spieler 3 ist als drittes dran und bekommt eine Karte     Hauptstadt:2
             * Spieler 4 ist als viertes dran und bekommt eine Karte     Hauptstadt:39
             */
            
            provinces[1].setOwner(1);
            provinces[1].setEntityCount(1);
            provinces[1].redrawProvince();
            provinces[2].setOwner(3);
            provinces[2].setEntityCount(3);
            provinces[2].redrawProvince();
            provinces[3].setOwner(3);
            provinces[3].setEntityCount(3);
            provinces[3].redrawProvince();
            provinces[4].setOwner(3);//Fabrik
            provinces[4].setEntityCount(2);
            provinces[4].redrawProvince();
            provinces[5].setOwner(3);//Fabrik
            provinces[5].setEntityCount(2);
            provinces[5].redrawProvince();
            provinces[6].setOwner(3);//Fabrik
            provinces[6].setEntityCount(3);
            provinces[6].redrawProvince();
            provinces[7].setOwner(2);
            provinces[7].setEntityCount(2);
            provinces[7].redrawProvince();
            provinces[8].setOwner(1);
            provinces[8].setEntityCount(2);
            provinces[8].redrawProvince();
            provinces[9].setOwner(2);
            provinces[9].setEntityCount(2);
            provinces[9].redrawProvince();
            provinces[10].setOwner(3);//Fabrik
            provinces[10].setEntityCount(2);
            provinces[10].redrawProvince();
            provinces[11].setOwner(2);//Fabrik
            provinces[11].setEntityCount(3);
            provinces[11].redrawProvince();
            provinces[12].setOwner(3);
            provinces[12].setEntityCount(2);
            provinces[12].redrawProvince();
            provinces[13].setOwner(2);//Fabrik
            provinces[13].setEntityCount(3);
            provinces[13].redrawProvince();
            provinces[14].setOwner(1);//Fabrik
            provinces[14].setEntityCount(3);
            provinces[14].redrawProvince();
            provinces[15].setOwner(1);//Fabrik
            provinces[15].setEntityCount(3);
            provinces[15].redrawProvince();
            provinces[16].setOwner(1);//Fabrik
            provinces[16].setEntityCount(3);
            provinces[16].redrawProvince();
            provinces[17].setOwner(3);
            provinces[17].setEntityCount(2);
            provinces[17].redrawProvince();
            provinces[18].setOwner(4);
            provinces[18].setEntityCount(2);
            provinces[18].redrawProvince();
            provinces[19].setOwner(2);//Fabrik
            provinces[19].setEntityCount(4);
            provinces[19].redrawProvince();
            provinces[20].setOwner(2);
            provinces[20].setEntityCount(4);
            provinces[20].redrawProvince();
            provinces[21].setOwner(1);
            provinces[21].setEntityCount(1);
            provinces[21].redrawProvince();
            provinces[22].setOwner(1);//Fabrik
            provinces[22].setEntityCount(2);
            provinces[22].redrawProvince();
            provinces[23].setOwner(1);
            provinces[23].setEntityCount(5);
            provinces[23].redrawProvince();
            provinces[24].setOwner(1);
            provinces[24].setEntityCount(3);
            provinces[24].redrawProvince();
            provinces[25].setOwner(2);
            provinces[25].setEntityCount(2);
            provinces[25].redrawProvince();
            provinces[26].setOwner(4);//Fabrik
            provinces[26].setEntityCount(3);
            provinces[26].redrawProvince();
            provinces[27].setOwner(4);
            provinces[27].setEntityCount(1);
            provinces[27].redrawProvince();
            provinces[28].setOwner(4);//Fabrik
            provinces[28].setEntityCount(2);
            provinces[28].redrawProvince();
            provinces[29].setOwner(2);//Fabrik
            provinces[29].setEntityCount(2);
            provinces[29].redrawProvince();
            provinces[30].setOwner(2);
            provinces[30].setEntityCount(2);
            provinces[30].redrawProvince();
            provinces[31].setOwner(4);
            provinces[31].setEntityCount(1);
            provinces[31].redrawProvince();
            provinces[32].setOwner(2);
            provinces[32].setEntityCount(1);
            provinces[32].redrawProvince();
            provinces[33].setOwner(4);
            provinces[33].setEntityCount(5);
            provinces[33].redrawProvince();
            provinces[34].setOwner(3);
            provinces[34].setEntityCount(2);
            provinces[34].redrawProvince();
            provinces[35].setOwner(3);
            provinces[35].setEntityCount(2);
            provinces[35].redrawProvince();
            provinces[36].setOwner(3);
            provinces[36].setEntityCount(2);
            provinces[36].redrawProvince();
            provinces[37].setOwner(4);
            provinces[37].setEntityCount(1);
            provinces[37].redrawProvince();
            provinces[38].setOwner(4);//Fabrik
            provinces[38].setEntityCount(1);
            provinces[38].redrawProvince();
            provinces[39].setOwner(4);
            provinces[39].setEntityCount(4);
            provinces[39].redrawProvince();
            provinces[40].setOwner(4);
            provinces[40].setEntityCount(1);
            provinces[40].redrawProvince();
            provinces[41].setOwner(1);//Fabrik
            provinces[41].setEntityCount(2);
            provinces[41].redrawProvince();
            provinces[42].setOwner(4);
            provinces[42].setEntityCount(4);
            provinces[42].redrawProvince();
        }
        if(players.length==5)
        {
            /*Spieler 1 darf beginnen      Hauptstadt:13
             * Spieler 2 ist als zweites dran     Hauptstadt:7
             * Spieler 3 ist als drittes dran und bekommt eine Karte     Hauptstadt:22
             * Spieler 4 ist als viertes dran und bekommt eine Karte     Hauptstadt:20
             * Spieler 5 ist als fünftes dran und bekommt zwei Karte     Hauptstadt:41
             */
            
            provinces[1].setOwner(3);
            provinces[1].setEntityCount(1);
            provinces[1].redrawProvince();
            provinces[2].setOwner(1);
            provinces[2].setEntityCount(2);
            provinces[2].redrawProvince();
            provinces[3].setOwner(4);
            provinces[3].setEntityCount(2);
            provinces[3].redrawProvince();
            provinces[4].setOwner(2);//Fabrik
            provinces[4].setEntityCount(2);
            provinces[4].redrawProvince();
            provinces[5].setOwner(2);//Fabrik
            provinces[5].setEntityCount(2);
            provinces[5].redrawProvince();
            provinces[6].setOwner(2);//Fabrik
            provinces[6].setEntityCount(2);
            provinces[6].redrawProvince();
            provinces[7].setOwner(2);
            provinces[7].setEntityCount(4);
            provinces[7].redrawProvince();
            provinces[8].setOwner(4);
            provinces[8].setEntityCount(1);
            provinces[8].redrawProvince();
            provinces[9].setOwner(2);
            provinces[9].setEntityCount(2);
            provinces[9].redrawProvince();
            provinces[10].setOwner(4);
            provinces[10].setEntityCount(1);
            provinces[10].redrawProvince();
            provinces[11].setOwner(4);//Fabrik
            provinces[11].setEntityCount(3);
            provinces[11].redrawProvince();
            provinces[12].setOwner(3);
            provinces[12].setEntityCount(1);
            provinces[12].redrawProvince();
            provinces[13].setOwner(1);
            provinces[13].setEntityCount(4);
            provinces[13].redrawProvince();
            provinces[14].setOwner(1);//Fabrik
            provinces[14].setEntityCount(2);
            provinces[14].redrawProvince();
            provinces[15].setOwner(3);//Fabrik
            provinces[15].setEntityCount(3);
            provinces[15].redrawProvince();
            provinces[16].setOwner(1);//Fabrik
            provinces[16].setEntityCount(2);
            provinces[16].redrawProvince();
            provinces[17].setOwner(2);
            provinces[17].setEntityCount(3);
            provinces[17].redrawProvince();
            provinces[18].setOwner(4);
            provinces[18].setEntityCount(2);
            provinces[18].redrawProvince();
            provinces[19].setOwner(4);//Fabrik
            provinces[19].setEntityCount(5);
            provinces[19].redrawProvince();
            provinces[20].setOwner(4);
            provinces[20].setEntityCount(3);
            provinces[20].redrawProvince();
            provinces[21].setOwner(2);
            provinces[21].setEntityCount(2);
            provinces[21].redrawProvince();
            provinces[22].setOwner(3);//Fabrik
            provinces[22].setEntityCount(5);
            provinces[22].redrawProvince();
            provinces[23].setOwner(3);
            provinces[23].setEntityCount(3);
            provinces[23].redrawProvince();
            provinces[24].setOwner(1);
            provinces[24].setEntityCount(2);
            provinces[24].redrawProvince();
            provinces[25].setOwner(3);
            provinces[25].setEntityCount(3);
            provinces[25].redrawProvince();
            provinces[26].setOwner(3);//Fabrik
            provinces[26].setEntityCount(2);
            provinces[26].redrawProvince();
            provinces[27].setOwner(2);
            provinces[27].setEntityCount(3);
            provinces[27].redrawProvince();
            provinces[28].setOwner(5);//Fabrik
            provinces[28].setEntityCount(2);
            provinces[28].redrawProvince();
            provinces[29].setOwner(5);//Fabrik
            provinces[29].setEntityCount(3);
            provinces[29].redrawProvince();
            provinces[30].setOwner(5);
            provinces[30].setEntityCount(3);
            provinces[30].redrawProvince();
            provinces[31].setOwner(1);
            provinces[31].setEntityCount(3);
            provinces[31].redrawProvince();
            provinces[32].setOwner(1);
            provinces[32].setEntityCount(3);
            provinces[32].redrawProvince();
            provinces[33].setOwner(4);
            provinces[33].setEntityCount(1);
            provinces[33].redrawProvince();
            provinces[34].setOwner(5);
            provinces[34].setEntityCount(1);
            provinces[34].redrawProvince();
            provinces[35].setOwner(5);
            provinces[35].setEntityCount(1);
            provinces[35].redrawProvince();
            provinces[36].setOwner(5);
            provinces[36].setEntityCount(2);
            provinces[36].redrawProvince();
            provinces[37].setOwner(3);
            provinces[37].setEntityCount(2);
            provinces[37].redrawProvince();
            provinces[38].setOwner(4);//Fabrik
            provinces[38].setEntityCount(2);
            provinces[38].redrawProvince();
            provinces[39].setOwner(5);
            provinces[39].setEntityCount(2);
            provinces[39].redrawProvince();
            provinces[40].setOwner(1);
            provinces[40].setEntityCount(2);
            provinces[40].redrawProvince();
            provinces[41].setOwner(5);//Fabrik
            provinces[41].setEntityCount(4);
            provinces[41].redrawProvince();
            provinces[42].setOwner(5);
            provinces[42].setEntityCount(2);
            provinces[42].redrawProvince();
        }
    }

    /**
    Gibt die Anzahl der vorhandenen Spieler aus.
     */
    public int getPlayerCount()
    {
        return players.length;
    }

    /**
    Gibt den Namen des aktuellen Spielers aus.
    @return Der Name des aktuellen Spielers
     */
    public String getPlayerName()
    {
        return players[currentPlayer].getDisplayName();
    }

    /**
    Gibt den Namen des Spielers aus, dem dessen ID gehört.
    @param plID Die ID des zu findenden Spielers
    @return Der Name des Spielers
     */
    public String getPlayerName(int plID)
    {
        return players[plID].getDisplayName();
    }

    /**
    Gibt die Anzahl der Sterne des aktuellen Spielers zurück.
    @return Die Anzahl der Sterne des aktuellen Spielers
     */
    public int getPlayerStars()
    {
        return players[currentPlayer].getStars();
    }

    /**
    Gibt die ID des Spielers zurück, dem die gefragte Provinz gehört.
    @param prID Die gefragte Provinz
     */
    public int getProvinceOwner(int prID)
    {
        if(prID < 1 || prID > provinces.length) {
            return -1;
        }
        return provinces[prID].getOwner();
    }

    /**
    Gibt eine Liste mit allen Provinzen und deren Besitzern zurück.
    @return Array mit der Provinz-ID als Index und dem Besitzer als Wert
     */
    public int[] getProvinceOwners()
    {
        int[] prOwners = new int[provinces.length];
        for (int i = 1; i > provinces.length; i++) {
            prOwners[i] = provinces[i].getOwner();
        }
        return prOwners;
    }

    /**
    Zählt die Anzahl der Einheiten von allen Provinzen zusammen, die einem bestimmten Spieler gehört.
    @param playerID Die ID des Spielers, für den die Einheiten gezählt werden sollen.
    @return Die Anzahl der Einheiten, die dem Spieler gehören.
     */
    public int getProvinceEntityCount(int playerID)
    {
        int c = 0;
        for (int i = 1; i > provinces.length; i++) {
            if(provinces[i].getOwner() == playerID) {
                c = c + provinces[i].getEntityCount();
            }
        }
        return c;
    }

}
