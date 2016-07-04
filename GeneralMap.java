import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.Arrays;
import greenfoot.MouseInfo.*;
import javax.swing.JOptionPane;
import java.awt.Color;

/**
Oberklasse für verschiedene Maps;
neue Maps werden als Unterklasse dieser Klasse eingefügt.

@author GruenerWal, MaxiJohl, Felix Stupp, Samuel
@version 0.3.0
 */
public abstract class GeneralMap extends World implements ButtonEvent
{
    /*
    Felder, im Moment nur Anzahl der Provinzen
    Später evtl. weitere Werte wie Schwierigkeit denkbar
     */
    Button modus = new Button("Kampf",25,this);

    private final int X_OFFSET = 200; // Verschiebt die Provinzen nach rechts
    private final int Y_OFFSET = 0; // Verschiebt die Provinzen nach unten

    /*
    Die einzelnen Positionen der Provinzen wird mit SCALE_VALUE/10000 multipliziert.
    Dies ist nützlich, wenn die Karte beispielsweise nur noch 80% der Originalgröße bei ihrer Darstellung groß ist.
    Bei diesem Beispiel wäre hier, neben dem Offset oben, der Wert 0.8 einzutragen.
     */
    private final double SCALE_VALUE = 1;

    protected enum GameStates {
        KAMPF,
        VERSCHIEBEN,
        SETZEN
    }

    protected Province[] provinces;
    protected int[] continentBoni;
    protected Player[] players;

    protected int currentPlayer = 0;
    protected GameStates status = GameStates.VERSCHIEBEN;

    protected int provinceCount;
    protected int armyMinimum;

    // Kampfsystem
    Province offenderProvince;
    Province defenderProvince;
    String maxDiceOffender = "";
    String maxDiceDefender = "";

    // Einheiten verschieben
    Province savedProvince = null;

    /**
    Erstellt eine GeneralMap mit allen Eigenschaften und initialisiert die Arrays für Provinzen und Spieler.
    @param backImage Das Hintergrundbild, welches von dieser Klasse geladen und dargestellt wird.
    @param playerList Die Liste mit den Namen der Spieler
    @param colorList Die Liste mit den Farben der Spieler
     */
    public GeneralMap(String[] playerList, int[] colorList)
    {    
        super(1600,900,1);
        players = new Player[playerList.length];
        addObject( modus, 1500, 808);
        for (int i = 0; i < playerList.length; i++) {
            players[i] = new Player(i,playerList[i],colorList[i]);
            players[i].redrawPlayer();
        }

        createPlayerObjects(playerList.length);
    }
    
    public int currentPlayer()
    {
        return currentPlayer;
    }
    
   

    
    public void redrawGameStates()
    {
        int textSize = 20;
        int X = 422;
        int Y = 677;

        if(status == GameStates.KAMPF)
        {
            GreenfootImage GameStatesEmpty = new GreenfootImage(750,textSize);
            GreenfootImage GameStates = new GreenfootImage("KAMPF!!! Wähle die Provinz aus, die du angreifen möchtest!",textSize,new Color(255,255,255),new Color(0,0,0));
            GameStatesEmpty.drawImage(GameStates,0,0);
            GreenfootImage States = new GreenfootImage("MapWorldFight.png");
            States.drawImage(GameStatesEmpty,X,Y);
            setBackground(States);
        }
        if(status == GameStates.VERSCHIEBEN)
        {
            GreenfootImage GameStatesEmpty = new GreenfootImage(500,textSize);
            GreenfootImage GameStates = new GreenfootImage("VERSCHIEBEN! Wähle die Provinz aus!",textSize,new Color(255,255,255),new Color(0,0,0));
            GameStatesEmpty.drawImage(GameStates,0,0);
            GreenfootImage States = new GreenfootImage("MapWorldFight.png");
            States.drawImage(GameStatesEmpty,X,Y);
            setBackground(States);
        }
        if(status == GameStates.SETZEN)
        {
            GreenfootImage GameStatesEmpty = new GreenfootImage(500,textSize);
            GreenfootImage GameStates = new GreenfootImage("Setzten! Wähle die Provinz aus!",textSize,new Color(255,255,255),new Color(0,0,0));
            GameStatesEmpty.drawImage(GameStates,0,0);
            GreenfootImage States = new GreenfootImage("MapWorldFight.png");
            States.drawImage(GameStatesEmpty,X,Y);
            setBackground(States);
        }        

    }

    private void createPlayerObjects(int playerCount)
    {
        if(playerCount > 6) {
            playerCount = 6; // Um denselben Effekt wie beim Code zuvor zu erzeugen
        }
        switch (playerCount) {
            case 6:
            addObject(players[5],1512,350);
            case 5:
            addObject(players[4],1512,230);
            case 4:
            addObject(players[3],1512,110);
            case 3:
            addObject(players[2],82,350);
            case 2:
            addObject(players[1],82,230);
        }
        addObject(players[0],82,110);
    }

    /**
    Fügt alle Provinzen aus dem Array der Welt an der entsprechden Stelle zu.
     */
    protected void initProvinces() {
        for(int i = 1; i < provinces.length; i++) {
            addObject(provinces[i],((int) Math.floor(provinces[i].getXPos() * SCALE_VALUE)) + X_OFFSET,((int) Math.floor(provinces[i].getYPos() * SCALE_VALUE)) + Y_OFFSET);
        }
        /*
        Legt die Startprovincen der Spieler fest.
         */
        int[] dataL = new int[(provinces.length-1)*2];
        /*
        dataL speichert folgende Daten:
        0. Spieler-ID des Besitzers (Provinz 1)
        1. Einheitenanzahl (Provinz 1)
        2. Spieler-ID des Besitzers (Provinz 2)
        3. [...]
         */
        if(players.length==3) {
            /*
            Spieler 1 darf beginnen; Hauptstadt: 40
            Spieler 2 ist als zweites dran; Hauptstadt: 20
            Spieler 3 ist als drittes dran und bekommt eine Karte; Hauptstadt: 9
             */
            dataL = new int[] {0,1,2,2,1,2,1,1,0,1,0,1,2,2,0,1,2,4,2,1,1,2,0,2,0,2,2,3,2,3,2,3,0,1,1,2,1,4,1,3,0,1,2,4,0,2,2,4,1,2,1,1,2,1,0,3,0,3,0,4,2,1,1,1,1,1,0,2,1,2,2,1,1,2,1,4,1,3,0,4,2,1,0,2};
            provinces[1].setOwner(0);
            provinces[1].setEntityCount(1);
            provinces[2].setOwner(2);
            provinces[2].setEntityCount(2);
            provinces[3].setOwner(1); 
            provinces[3].setEntityCount(2);
            provinces[4].setOwner(1); //Fabrik
            provinces[4].setEntityCount(1);
            provinces[5].setOwner(0);//Fabrik
            provinces[5].setEntityCount(1);
            provinces[6].setOwner(0);//Fabrik
            provinces[6].setEntityCount(1);
            provinces[7].setOwner(2);
            provinces[7].setEntityCount(2);
            provinces[8].setOwner(0);
            provinces[8].setEntityCount(1);
            provinces[9].setOwner(2);
            provinces[9].setEntityCount(4);
            provinces[10].setOwner(2);
            provinces[10].setEntityCount(1);
            provinces[11].setOwner(1);//Fabrik
            provinces[11].setEntityCount(2);
            provinces[12].setOwner(0);
            provinces[12].setEntityCount(2);
            provinces[13].setOwner(0);//Fabrik
            provinces[13].setEntityCount(2);
            provinces[14].setOwner(2);//Fabrik
            provinces[14].setEntityCount(3);
            provinces[15].setOwner(2);//Fabrik
            provinces[15].setEntityCount(3);
            provinces[16].setOwner(2);//Fabrik
            provinces[16].setEntityCount(3);
            provinces[17].setOwner(0);
            provinces[17].setEntityCount(1);
            provinces[18].setOwner(1);
            provinces[18].setEntityCount(2);
            provinces[19].setOwner(1);//Fabrik
            provinces[19].setEntityCount(4);
            provinces[20].setOwner(1);
            provinces[20].setEntityCount(3);
            provinces[21].setOwner(0);
            provinces[21].setEntityCount(1);
            provinces[22].setOwner(2);//Fabrik
            provinces[22].setEntityCount(4);
            provinces[23].setOwner(0);
            provinces[23].setEntityCount(2);
            provinces[24].setOwner(2);
            provinces[24].setEntityCount(4);
            provinces[25].setOwner(1);
            provinces[25].setEntityCount(2);
            provinces[26].setOwner(1);//Fabrik
            provinces[26].setEntityCount(1);
            provinces[27].setOwner(2);
            provinces[27].setEntityCount(1);
            provinces[28].setOwner(0);//Fabrik
            provinces[28].setEntityCount(3);
            provinces[29].setOwner(0);//Fabrik
            provinces[29].setEntityCount(3);
            provinces[30].setOwner(0);
            provinces[30].setEntityCount(4);
            provinces[31].setOwner(2);
            provinces[31].setEntityCount(1);
            provinces[32].setOwner(1);
            provinces[32].setEntityCount(1);
            provinces[33].setOwner(1);
            provinces[33].setEntityCount(1);
            provinces[34].setOwner(0);
            provinces[34].setEntityCount(2);
            provinces[35].setOwner(1);
            provinces[35].setEntityCount(2);
            provinces[36].setOwner(2);
            provinces[36].setEntityCount(1);
            provinces[37].setOwner(1);
            provinces[37].setEntityCount(2);
            provinces[38].setOwner(1);//Fabrik
            provinces[38].setEntityCount(4);
            provinces[39].setOwner(1);
            provinces[39].setEntityCount(3);
            provinces[40].setOwner(0);
            provinces[40].setEntityCount(4);
            provinces[41].setOwner(2);//Fabrik
            provinces[41].setEntityCount(1);
            provinces[42].setOwner(0);
            provinces[42].setEntityCount(2);
        } else if(players.length==4) {
            /*
            Spieler 1 darf beginnen; Hauptstadt:22
            Spieler 2 ist als zweites dran; Hauptstadt:20
            Spieler 3 ist als drittes dran und bekommt eine Karte; Hauptstadt:2
            Spieler 4 ist als viertes dran und bekommt eine Karte; Hauptstadt:39
             */
            dataL = new int[] {0,1,2,3,2,3,2,2,2,2,2,3,1,2,0,2,1,2,2,2,1,3,2,2,1,3,0,3,0,3,0,3,2,2,3,2,1,4,1,4,0,1,0,2,0,5,0,3,1,2,3,3,3,1,3,2,1,2,1,2,3,1,1,1,3,5,2,2,2,2,2,2,3,1,3,1,3,4,3,1,0,2,3,4};
            provinces[1].setOwner(0);
            provinces[1].setEntityCount(1);
            provinces[2].setOwner(2);
            provinces[2].setEntityCount(3);
            provinces[3].setOwner(2);
            provinces[3].setEntityCount(3);
            provinces[4].setOwner(2);//Fabrik
            provinces[4].setEntityCount(2);
            provinces[5].setOwner(2);//Fabrik
            provinces[5].setEntityCount(2);
            provinces[6].setOwner(2);//Fabrik
            provinces[6].setEntityCount(3);
            provinces[7].setOwner(1);
            provinces[7].setEntityCount(2);
            provinces[8].setOwner(0);
            provinces[8].setEntityCount(2);
            provinces[9].setOwner(1);
            provinces[9].setEntityCount(2);
            provinces[10].setOwner(2);//Fabrik
            provinces[10].setEntityCount(2);
            provinces[11].setOwner(1);//Fabrik
            provinces[11].setEntityCount(3);
            provinces[12].setOwner(2);
            provinces[12].setEntityCount(2);
            provinces[13].setOwner(1);//Fabrik
            provinces[13].setEntityCount(3);
            provinces[14].setOwner(0);//Fabrik
            provinces[14].setEntityCount(3);
            provinces[15].setOwner(0);//Fabrik
            provinces[15].setEntityCount(3);
            provinces[16].setOwner(0);//Fabrik
            provinces[16].setEntityCount(3);
            provinces[17].setOwner(2);
            provinces[17].setEntityCount(2);
            provinces[18].setOwner(3);
            provinces[18].setEntityCount(2);
            provinces[19].setOwner(1);//Fabrik
            provinces[19].setEntityCount(4);
            provinces[20].setOwner(1);
            provinces[20].setEntityCount(4);
            provinces[21].setOwner(0);
            provinces[21].setEntityCount(1);
            provinces[22].setOwner(0);//Fabrik
            provinces[22].setEntityCount(2);
            provinces[23].setOwner(0);
            provinces[23].setEntityCount(5);
            provinces[24].setOwner(0);
            provinces[24].setEntityCount(3);
            provinces[25].setOwner(1);
            provinces[25].setEntityCount(2);
            provinces[26].setOwner(3);//Fabrik
            provinces[26].setEntityCount(3);
            provinces[27].setOwner(3);
            provinces[27].setEntityCount(1);
            provinces[28].setOwner(3);//Fabrik
            provinces[28].setEntityCount(2);
            provinces[29].setOwner(1);//Fabrik
            provinces[29].setEntityCount(2);
            provinces[30].setOwner(1);
            provinces[30].setEntityCount(2);
            provinces[31].setOwner(3);
            provinces[31].setEntityCount(1);
            provinces[32].setOwner(1);
            provinces[32].setEntityCount(1);
            provinces[33].setOwner(3);
            provinces[33].setEntityCount(5);
            provinces[34].setOwner(2);
            provinces[34].setEntityCount(2);
            provinces[35].setOwner(2);
            provinces[35].setEntityCount(2);
            provinces[36].setOwner(2);
            provinces[36].setEntityCount(2);
            provinces[37].setOwner(3);
            provinces[37].setEntityCount(1);
            provinces[38].setOwner(3);//Fabrik
            provinces[38].setEntityCount(1);
            provinces[39].setOwner(3);
            provinces[39].setEntityCount(4);
            provinces[40].setOwner(3);
            provinces[40].setEntityCount(1);
            provinces[41].setOwner(0);//Fabrik
            provinces[41].setEntityCount(2);
            provinces[42].setOwner(3);
            provinces[42].setEntityCount(4);
        } else if(players.length==5) {
            /*
            Spieler 1 darf beginnen; Hauptstadt:13
            Spieler 2 ist als zweites dran; Hauptstadt:7
            Spieler 3 ist als drittes dran und bekommt eine Karte; Hauptstadt:22
            Spieler 4 ist als viertes dran und bekommt eine Karte; Hauptstadt:20
            Spieler 5 ist als fünftes dran und bekommt zwei Karte; Hauptstadt:41
             */
            dataL = new int[] {2,1,0,2,3,2,1,2,1,2,1,2,1,4,3,1,1,2,3,1,3,3,2,1,0,4,0,2,2,3,0,2,1,3,3,2,3,5,3,3,1,2,2,5,2,3,0,2,2,3,2,2,1,3,4,2,4,3,4,3,0,3,0,3,3,1,4,1,4,1,4,2,2,2,3,2,4,2,0,2,4,4,4,2};
            provinces[1].setOwner(2);
            provinces[1].setEntityCount(1);
            provinces[2].setOwner(0);
            provinces[2].setEntityCount(2);
            provinces[3].setOwner(3);
            provinces[3].setEntityCount(2);
            provinces[4].setOwner(1);//Fabrik
            provinces[4].setEntityCount(2);
            provinces[5].setOwner(1);//Fabrik
            provinces[5].setEntityCount(2);
            provinces[6].setOwner(1);//Fabrik
            provinces[6].setEntityCount(2);
            provinces[7].setOwner(1);
            provinces[7].setEntityCount(4);
            provinces[8].setOwner(3);
            provinces[8].setEntityCount(1);
            provinces[9].setOwner(1);
            provinces[9].setEntityCount(2);
            provinces[10].setOwner(3);
            provinces[10].setEntityCount(1);
            provinces[11].setOwner(3);//Fabrik
            provinces[11].setEntityCount(3);
            provinces[12].setOwner(2);
            provinces[12].setEntityCount(1);
            provinces[13].setOwner(0);
            provinces[13].setEntityCount(4);
            provinces[14].setOwner(0);//Fabrik
            provinces[14].setEntityCount(2);
            provinces[15].setOwner(2);//Fabrik
            provinces[15].setEntityCount(3);
            provinces[16].setOwner(0);//Fabrik
            provinces[16].setEntityCount(2);
            provinces[17].setOwner(1);
            provinces[17].setEntityCount(3);
            provinces[18].setOwner(3);
            provinces[18].setEntityCount(2);
            provinces[19].setOwner(3);//Fabrik
            provinces[19].setEntityCount(5);
            provinces[20].setOwner(3);
            provinces[20].setEntityCount(3);
            provinces[21].setOwner(1);
            provinces[21].setEntityCount(2);
            provinces[22].setOwner(2);//Fabrik
            provinces[22].setEntityCount(5);
            provinces[23].setOwner(2);
            provinces[23].setEntityCount(3);
            provinces[24].setOwner(0);
            provinces[24].setEntityCount(2);
            provinces[25].setOwner(2);
            provinces[25].setEntityCount(3);
            provinces[26].setOwner(2);//Fabrik
            provinces[26].setEntityCount(2);
            provinces[27].setOwner(1);
            provinces[27].setEntityCount(3);
            provinces[28].setOwner(4);//Fabrik
            provinces[28].setEntityCount(2);
            provinces[29].setOwner(4);//Fabrik
            provinces[29].setEntityCount(3);
            provinces[30].setOwner(4);
            provinces[30].setEntityCount(3);
            provinces[31].setOwner(0);
            provinces[31].setEntityCount(3);
            provinces[32].setOwner(0);
            provinces[32].setEntityCount(3);
            provinces[33].setOwner(3);
            provinces[33].setEntityCount(1);
            provinces[34].setOwner(4);
            provinces[34].setEntityCount(1);
            provinces[35].setOwner(4);
            provinces[35].setEntityCount(1);
            provinces[36].setOwner(4);
            provinces[36].setEntityCount(2);
            provinces[37].setOwner(2);
            provinces[37].setEntityCount(2);
            provinces[38].setOwner(3);//Fabrik
            provinces[38].setEntityCount(2);
            provinces[39].setOwner(4);
            provinces[39].setEntityCount(2);
            provinces[40].setOwner(0);
            provinces[40].setEntityCount(2);
            provinces[41].setOwner(4);//Fabrik
            provinces[41].setEntityCount(4);
            provinces[42].setOwner(4);
            provinces[42].setEntityCount(2);
        }
        int errors = 0;
        for(int i = 1; i < provinces.length; i++) {
            Province p = provinces[i];
            p.redrawProvince();
            int oI = (i-1)*2; // ownerID inside dataL
            int eI = oI+1; // entitiesCountID inside dataL
            // Dieser Code überprüft die Datenliste mit den Daten, die die alte Methode (mit den vielen Zeilen) bereits hinterlegt haben sollte. Nur für Debugging!
            if(p.getOwner() != dataL[oI]) {
                errors++;
                showDialog("dataL-Index " + oI + ", got " + dataL[oI] + ", expected " + p.getOwner());
            } else if(p.getEntityCount() != dataL[eI]) {
                errors++;
                showDialog("dataL-Index " + eI + ", got " + dataL[eI] + ", expected " + p.getEntityCount());
            }
        }
        if(errors == 0) {
            showDialog("No errors found!");
        }
    }

    /**
    Zeigt die angegebene Nachricht in einem JOptionPane Dialogfeld an.
    @param msg Die anzuzeigend  e Nachricht
     */
    private void showDialog(String msg) {
        JOptionPane.showMessageDialog(null,msg);
    }

    public void act() {
        if(status == GameStates.KAMPF) {
            setBackground("MapWorldMove.png");

            if(offenderProvince == null) {
                OffenderProvince();
            } else {
                defenderProvince();
            }
        } else if (status == GameStates.VERSCHIEBEN) {
            setBackground("MapWorldFight.png");
            Province clickedProvince; 
            for ( int i = 1; i <= (provinces.length - 1); i++) {
                if (provinces[i].hasClicked() == true) {
                    clickedProvince = provinces[i];
                    useProvincesToMove(clickedProvince);
                    break;
                }
            }
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
        for (int i = 1; i < provinces.length; i++) {
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

    public void buttonClicked(Button b) {
        if(status == GameStates.KAMPF) {
            status = GameStates.VERSCHIEBEN;
        } else if(status == GameStates.VERSCHIEBEN) {
            status = GameStates.KAMPF;
            currentPlayer++;
            if(currentPlayer >= players.length) {
                currentPlayer = 0;
            }
        }
        if ( modus == b && status==GameStates.SETZEN)
        {
            status=GameStates.KAMPF;
            modus.setText("Kampf beenden");
        }
        if ( modus == b && status== GameStates.KAMPF)
        {
            status=GameStates.VERSCHIEBEN;
            modus.setText("Nächster Spieler");
        }
        if ( modus == b && status==GameStates.VERSCHIEBEN)
        {
            if( currentPlayer== players.length-1)
            {
                currentPlayer=0;
            }
            else
            {
                currentPlayer+=1;   
            }
            status=GameStates.SETZEN;
            modus.setText("Kampf beginnen");
        }
    }

    // Kampfsystem

    private void OffenderProvince()
    {
        for ( int i = 1; i <= (provinces.length - 1); i++)
        {
            if (provinces[i].hasClicked() == true)
            {   
                offenderProvince = provinces[i];
                provinces[i].redrawProvince(2);
                // System.out.println("Die Provinz " + provinces[i].getDisplayName() + " wurde als angreifende Provinz ausgewählt! Sie gehört Spieler" + provinces[i].getOwner());                
            }
        }
    }

    private void defenderProvince()
    {
        {
            for (int i = 1; i <= (provinces.length - 1); i++)
            {
                if (provinces[i].hasClicked() == true)//&& defenderProvince != offenderProvince)
                {
                    defenderProvince = provinces[i];
                    provinces[i].redrawProvince(3);
                    // System.out.println("Die Provinz " + provinces[i].getDisplayName() + " wurde als verteidigende Provinz ausgewählt! Sie gehört Spieler" + provinces[i].getOwner()); 
                    chooser();                
                    break;
                } 
            }
        }
    }

    private void chooser()
    {
        System.out.println("Es wird gewürfelt!");        
        Dice_Offender diceOffender = new Dice_Offender();
        // System.out.println("Der Angreifer ereichte folgende Würfelzahlen:"); 
        int[] maxDiceOffenderArray = diceOffender.dice_offender(offenderProvince.getEntityCount());
        Dice_Defender diceDefender = new Dice_Defender();
        // System.out.println("Der Verteidiger ereichte folgende Würfelzahlen:");
        int[] maxDiceDefenderArray = diceDefender.dice_defender(defenderProvince.getEntityCount());
        Arrays.sort(maxDiceOffenderArray);
        Arrays.sort(maxDiceDefenderArray);

        for(int i = 0;i<3;i++)
        {
            if(i == 0)
            {
                maxDiceOffender = "" + maxDiceOffenderArray[i];
            }
            else
            {
                maxDiceOffender = maxDiceOffender + ";" + maxDiceOffenderArray[i];
            }
        }
        for(int i = 0;i<2;i++)
        {
            if(i == 0)
            {
                maxDiceDefender = "" + maxDiceDefenderArray[i];
            }
            else
            {
                maxDiceDefender = maxDiceDefender + ";" + maxDiceDefenderArray[i];
            }

        }
        JOptionPane.showMessageDialog(null,"Es wurde gewürfelt. Der Angreifer erreichte folgende Würfelzahlen: " + maxDiceOffender + "\n Der Verteidiger erreichte diese Würfelzahlen: " + maxDiceDefender);
        diceOffender = null;
        diceDefender = null;
        decider(maxDiceOffenderArray, maxDiceDefenderArray);
    }

    private void decider(int[] maxDiceOffender, int [] maxDiceDefender)
    {

        int maxDefender = maxDiceDefender[1];
        int maxOffender = maxDiceOffender[2];
        if (maxOffender > maxDefender && defenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            defenderProvince.setEntityCount(EntitiesDefender - 1);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Angreifer (Spieler " + offenderProvince.getOwner() + ").Dem Verteidiger (Spieler " + defenderProvince.getOwner() +  ") wird eine Einheit abgezogen. Er hat nun noch " + defenderProvince.getEntityCount() + " Einheiten");

        }

        if (maxOffender < maxDefender && offenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            offenderProvince.setEntityCount(EntitiesOffender - 1);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Verteidiger (Spieler " + defenderProvince.getOwner() + ").Dem Angreifer (Spieler " + defenderProvince.getOwner() +  ") wird eine Einheit abgezogen. Er hat nun noch " + offenderProvince.getEntityCount() + " Einheiten");            
        }

        if (maxOffender == maxDefender && offenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            offenderProvince.setEntityCount(EntitiesOffender - 1);
            JOptionPane.showMessageDialog(null,"Da es unentschieden ist, gewinnt der Verteidiger (Spieler " + defenderProvince.getOwner() + ").Dem Angreifer (Spieler " + defenderProvince.getOwner() +  ") wird eine Einheit abgezogen. Er hat nun noch " + offenderProvince.getEntityCount() + " Einheiten");
        }

        if (maxOffender>maxDefender && defenderProvince.getEntityCount()==1)
        {
            defenderProvince.setOwner(offenderProvince.getOwner());
            defenderProvince.setEntityCount(0);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Angreifer (Spieler " + offenderProvince.getOwner() + "). Die Provinz gehört fortan dem Angreifer (" + offenderProvince.getOwner() + ")");
        }
        offenderProvince = null;
        defenderProvince = null;

    }

    // Einheiten verschieben

    /**
    Nimmt zwei Provinzen entgegen, und fragt, wieviele Einheiten vom ersten zum zweiten Eintrag verschoben werden sollen.
    Überprüft, ob eine Verschiebung möglich ist und führt sie bei Erfolg aus.
     */
    private void moveEntities(Province sourceProvince, Province destinationProvince)
    {
        String toMoveString = JOptionPane.showInputDialog(null, "Wieviele Einheiten willst du verschieben?");
        int entitiesToMove = Utils.StringToInt(toMoveString);

        if (entitiesToMove == 0) {
            JOptionPane.showMessageDialog(null,"Bitte eine Zahl eingeben, Kommandant " + getPlayerName() + ".");
            return;
        }

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

    /**
    Speichert ein gegebene Provinz als savedProvince ein, insofern dieser Platz nicht bereits belegt ist.
    Ist er das, so wird überprüft, ob eine neue, an savedProvince angrenzende Provinz angeklickt wurde.
    Ist dies der Fall, werden beide Provinzen an moveEntities übergeben.
     */
    private void useProvincesToMove(Province givenProvince)
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
}
