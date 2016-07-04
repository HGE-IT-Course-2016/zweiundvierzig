import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.Arrays;
import java.awt.Color;
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
    Button modus = new Button("Kampf\nbeginnen",25,this);
    
    private final int X_OFFSET = 200; // Verschiebt die Provinzen nach rechts
    private final int Y_OFFSET = 0; // Verschiebt die Provinzen nach unten

    /*
    Die einzelnen Positionen der Provinzen wird mit SCALE_VALUE/10000 multipliziert.
    Dies ist nützlich, wenn die Karte beispielsweise nur noch 80% der Originalgröße bei ihrer Darstellung groß ist.
    Bei diesem Beispiel wäre hier, neben dem Offset oben, der Wert 0.8 einzutragen.
     */
    private final double SCALE_VALUE = 1;

    protected enum GameStates {
        SETZEN,
        KAMPF,
        VERSCHIEBEN
    }

    protected Province[] provinces;
    protected int[] continentBoni;
    protected Player[] players;

    protected int currentPlayer = 0;
    protected GameStates status = GameStates.SETZEN;

    protected int provinceCount;
    protected int armyMinimum;

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
        modus.setSize(100,100);
        modus.setBackColor(Color.white);
        modus.setForeColor(Color.black);
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
            GreenfootImage States = new GreenfootImage("MapWorldMove.png");
            States.drawImage(GameStatesEmpty,X,Y);
            setBackground(States);
        }
        if(status == GameStates.SETZEN)
        {
            GreenfootImage GameStatesEmpty = new GreenfootImage(500,textSize);
            GreenfootImage GameStates = new GreenfootImage("SETZEN! Wähle die Provinz aus!",textSize,new Color(255,255,255),new Color(0,0,0)); // "Setzten" Lern Deutsch, Samuel
            GameStatesEmpty.drawImage(GameStates,0,0);
            GreenfootImage States = new GreenfootImage("MapWorld.png");
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
    }

    /**
    Zeigt die angegebene Nachricht in einem JOptionPane Dialogfeld an.
    @param msg Die anzuzeigend  e Nachricht
     */
    private void showDialog(String msg) {
        JOptionPane.showMessageDialog(null,msg);
    }

    public void act() {
        if (status == GameStates.SETZEN) {
            actPlace();
        } else if(status == GameStates.KAMPF) {
            actFight();
        } else if (status == GameStates.VERSCHIEBEN) {
            actMove();
        }
       redrawGameStates();
    }

    /**
    Gibt die Anzahl der vorhandenen Spieler aus.
     */
    public int getPlayerCount()
    {
        return players.length;
    }
    
    /**
     * Gibt die Farbe des angefragten Spielers heraus.
     * @param int pID -> Farbe des Spielers
     */
    public int getPlayerColor(int pID)
    {
        return players[pID].getColor();
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

    private void resetClicked() {
        for(int i = 1; i <= (provinces.length - 1); i++) {
            provinces[i].hasClicked();
        }
    }

    public void buttonClicked(Button b) {
        if ( modus == b ) {
            if(status==GameStates.SETZEN && freeArmies == 0 ) {
                status=GameStates.KAMPF;
                offenderProvince = null;
                defenderProvince = null;
                maxDiceOffender = "";
                maxDiceDefender = "";
                modus.setBackColor(Color.white);
                modus.setForeColor(Color.black);
                modus.setText("Kampf\nbeenden");
                System.out.println("KAMPF");
            } else if (status==GameStates.KAMPF) {
                status=GameStates.VERSCHIEBEN;
                savedProvince = null;
                modus.setText("Nächster\nSpieler");
                System.out.println("VERSCHIEBEN");
            } else if (status==GameStates.VERSCHIEBEN) {
                freeArmies = -1;
                if(currentPlayer >= players.length-1)
                {
                    currentPlayer=0;
                }
                else
                {
                    currentPlayer+=1;   
                }
                status=GameStates.SETZEN;
                modus.setText("Kampf\nbeginnen");
                System.out.println("SETZEN");
            }
        }
    }

    // Kampfsystem
    
    Province offenderProvince;
    Province defenderProvince;
    String maxDiceOffender = "";
    String maxDiceDefender = "";
    
    private void actFight() {
        for(int i = 1; i <= (provinces.length - 1); i++) {
            if (provinces[i].hasClicked() == true) {
                if(provinces[i].getOwner() == currentPlayer) {
                    OffenderProvince(provinces[i]);
                } else {
                    DefenderProvince(provinces[i]);
                }
            }
        }
    }

    private void OffenderProvince(Province p)
    {
        if(offenderProvince != null) {
            offenderProvince.redrawProvince();
        }
        offenderProvince = p;
        p.redrawProvince(2);
        // System.out.println("Die Provinz " + provinces[i].getDisplayName() + " wurde als angreifende Provinz ausgewählt! Sie gehört Spieler" + provinces[i].getOwner());
        chooser();
    }

    private void DefenderProvince(Province p)
    {
        if(defenderProvince != null) {
            defenderProvince.redrawProvince();
        }
        defenderProvince = p;
        p.redrawProvince(3);
        // System.out.println("Die Provinz " + provinces[i].getDisplayName() + " wurde als verteidigende Provinz ausgewählt! Sie gehört Spieler" + provinces[i].getOwner());
        chooser();
    }

    private void chooser()
    {
        if(offenderProvince == null || defenderProvince == null) {
            return;
        }
        //System.out.println("Es wird gewürfelt!");        
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
    
    // berechnet Zahlen und findet Gewinner; führt Konsequenz aus
    private void decider(int[] maxDiceOffender, int [] maxDiceDefender)
    {

        int maxDefender = maxDiceDefender[1];
        int maxOffender = maxDiceOffender[2];
        if (maxOffender > maxDefender && defenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            defenderProvince.setEntityCount(EntitiesDefender - 1);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Angreifer (" + getPlayerName(offenderProvince.getOwner()) + "). Dem Verteidiger (" + getPlayerName(defenderProvince.getOwner()) + ") wird eine Einheit abgezogen. Er hat nun noch " + defenderProvince.getEntityCount() + " Einheiten.");

        }

        if (maxOffender < maxDefender && offenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            offenderProvince.setEntityCount(EntitiesOffender - 1);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Verteidiger (" + getPlayerName(defenderProvince.getOwner()) + "). Dem Angreifer (" + getPlayerName(offenderProvince.getOwner()) + ") wird eine Einheit abgezogen. Er hat nun noch " + offenderProvince.getEntityCount() + " Einheiten.");            
        }

        if (maxOffender == maxDefender && offenderProvince.getEntityCount()>1)
        {
            int EntitiesOffender = offenderProvince.getEntityCount();
            int EntitiesDefender = defenderProvince.getEntityCount();
            offenderProvince.setEntityCount(EntitiesOffender - 1);
            JOptionPane.showMessageDialog(null,"Da es unentschieden ist, gewinnt der Verteidiger (" + getPlayerName(defenderProvince.getOwner()) + "). Dem Angreifer (" + getPlayerName(offenderProvince.getOwner()) + ") wird eine Einheit abgezogen. Er hat nun noch " + offenderProvince.getEntityCount() + " Einheiten.");
        }

        if (maxOffender>maxDefender && defenderProvince.getEntityCount()==1)
        {
            defenderProvince.setOwner(offenderProvince.getOwner());
            defenderProvince.setEntityCount(1);
            JOptionPane.showMessageDialog(null,"Somit gewinnt der Angreifer (" + getPlayerName(offenderProvince.getOwner()) + "). Die Provinz gehört fortan dem Angreifer (" + getPlayerName(offenderProvince.getOwner()) + ").");
        }
        offenderProvince.redrawProvince();
        defenderProvince.redrawProvince();
        offenderProvince = null;
        defenderProvince = null;
    }

    // Einheiten verschieben
    
    Province savedProvince = null;
    
    private void actMove() {
        for ( int i = 1; i <= (provinces.length - 1); i++) {
            if (provinces[i].hasClicked() == true) {
                useProvincesToMove(provinces[i]);
                break;
            }
        }
    }

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
        if(givenProvince.getOwner() != currentPlayer) {
            return;
        }
        if (savedProvince == null)
        {
            savedProvince = givenProvince;
            givenProvince.redrawProvince(2);
        }
        else if ((savedProvince != null) && (givenProvince != savedProvince))
        {
            if (givenProvince.isProvinceNear(savedProvince.getID()) == true)
            {
                moveEntities(savedProvince,givenProvince);
            }
            savedProvince.redrawProvince();
            savedProvince = null;
        } 
    }
    
    // Einheiten setzen
    
    int freeArmies = -1;
    
    private void actPlace()
    {
        if ( freeArmies == -1 ) {
            freeArmies = calculateArmies();
        } else if ( freeArmies == 0 ) {
            modus.setBackColor(Color.white);
            modus.setForeColor(Color.black);
        } else {
            modus.setBackColor(Color.black);
            modus.setForeColor(Color.black);
        }
        for ( int i = 1; i <= (provinces.length - 1); i++) {
            if (provinces[i].hasClicked() == true && provinces[i].getOwner() == currentPlayer)
            {
                String toUseString = JOptionPane.showInputDialog(null, "Wieviele Einheiten willst du setzen? Du hast noch " + freeArmies + " freie Einheiten.");
                int armiesToUse = Utils.StringToInt(toUseString);
                if ( armiesToUse <= freeArmies )
                {
                    if ( armiesToUse > 0 )
                    {
                        provinces[i].addToEntities(armiesToUse);
                        freeArmies = freeArmies- armiesToUse;
                        JOptionPane.showMessageDialog(null,"Einheiten erfolgreich gesetzt, Kommandant " + getPlayerName() + ".");
                    }
                    if ( armiesToUse < 0 )
                    {
                        JOptionPane.showMessageDialog(null,"Willst du mich verarschen?");
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Nicht genügend freie Einheiten.");
                }
            }
        }
    }

    private int calculateArmies()
    {
        int armiesToPlace;
        Province[] continentArray;
        boolean continentChecked = false;

        // 1. ArmyMinimum einbeziehen
        armiesToPlace = armyMinimum;

        // 2. Einheiten durch Provinzen einbeziehen
        armiesToPlace = armiesToPlace + Math.round(players[currentPlayer].getProvinceCount() / 3);

        // 3. Einheiten durch Kontinente

        // Kontinente durchgehen
        for ( int i = 1; i < continentBoni.length; i++ )
        {
            continentArray = giveContinentArray(i);
            // Provinzen des aktuellen Kontinents durchgehen
            for ( int p = 1; p >= continentArray.length; p++ )
            {
                // Prüfen, ob eine Provinz NICHT dem aktuellen Spieler gehört
                if ( continentArray[p].getOwner() != currentPlayer )
                {
                    break;
                }
                // Wenn nicht, wird der Kontinent als gecheckt markiert
                else
                {
                    continentChecked = true;
                }
            }
            if ( continentChecked == true )
            {
                armiesToPlace = armiesToPlace + continentBoni[i];
                continentChecked = false;
            }
        }

        // 4. Einheiten durch Sterne
        if ( players[currentPlayer].getStars() > 0)
        {
            String toUseString = JOptionPane.showInputDialog(null, "Wieviele Sterne willst du verwenden?");
            int starsToUse = Utils.StringToInt(toUseString);
            int[] starBoni = new int [] {1,2,4,7,10,13,17,21,25,30};
            if ( starsToUse > 0 && starsToUse < 11 )
            {
                armiesToPlace = armiesToPlace + starBoni[starsToUse -1];
            }
            if ( starsToUse < 0 && starsToUse > 10 )
            {
                JOptionPane.showMessageDialog(null,"Ungültige Zahl. Bitte eine Zahl zwischen 0 und 10 eingeben");
            }
        }
        return armiesToPlace;
    }

    private Province[] giveContinentArray(int cID)
    {
        Province[] savedProvinces = new Province[provinceCount +1];
        Province[] continentProvinces;
        int c = 0;
        for (int i = 1; i <= provinceCount; i++)
        {
            if (provinces[i].getContinentID() == cID)
            {
                savedProvinces[i] = provinces[i];
                c++;
            }
        }
        if ( c < 1 )
        {
            return null;
        }
        else
        {
            return Utils.cutArray(savedProvinces);
        }
    }
}
