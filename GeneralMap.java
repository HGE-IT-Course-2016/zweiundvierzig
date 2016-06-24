import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.Arrays;
import greenfoot.MouseInfo.*;
import javax.swing.JOptionPane;

/**
Oberklasse für verschiedene Maps;
neue Maps werden als Unterklasse dieser Klasse eingefügt.

@author GruenerWal, MaxiJohl, Felix Stupp
@version 0.3.0
 */
public abstract class GeneralMap extends World implements ButtonEvent
{
	/*
	Felder, im Moment nur Anzahl der Provinzen
	Später evtl. weitere Werte wie Schwierigkeit denkbar
	 */

	private final int X_OFFSET = 160; // Verschiebt die Provinzen nach rechts
	private final int Y_OFFSET = 0; // Verschiebt die Provinzen nach unten

	/*
	Die einzelnen Positionen der Provinzen wird mit SCALE_VALUE/10000 multipliziert.
	Dies ist nützlich, wenn die Karte beispielsweise nur noch 80% der Originalgröße bei ihrer Darstellung groß ist.
	Bei diesem Beispiel wäre hier, neben dem Offset oben, der Wert 0.8 einzutragen.
	 */
	private final double SCALE_VALUE = 1;

	protected enum GameStates {
		KAMPF,
		VERSCHIEBEN
	}

	protected Province[] provinces;
	protected Player[] players;

	protected int currentPlayer = 0;
	protected GameStates status = GameStates.VERSCHIEBEN;

	Province offenderProvince;
	Province defenderProvince;

	Province savedProvince = null;

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

		createPlayerObjects(playerList.length);
	}
	
	private void createPlayerObjects(int playerCount)
	{
		addObject(players[0],82,110);
		
		if (playerCount > 1)
		{
			addObject(players[1],82,230);
			
			if (playerCount > 2)
			{
				addObject(players[2],82,350);
				
				if (playerCount > 3)
				{
					addObject(players[3],1512,110);
					
					if (playerCount > 4)
					{
						addObject(players[4],1512,230);
						
						if (playerCount > 5)
						
						{
							addObject(players[5],1512,350);
						}
					}	                   	                  
				}
			}
		}
	}

	/**
	Fügt alle Provinzen aus dem Array der Welt an der entsprechden Stelle zu.
	 */
	protected void initProvinces() {
		for(int i = 1; i < provinces.length; i++) {
			addObject(provinces[i],((int) Math.floor(provinces[i].getXPos() * SCALE_VALUE)) + X_OFFSET,((int) Math.floor(provinces[i].getYPos() * SCALE_VALUE)) + Y_OFFSET);
		}
	}

	public void act() {
		if(status == GameStates.KAMPF) {
			if(offenderProvince == null)
			{
				OffenderProvince();
			}
			else
			{
				defenderProvince();
			}
		} else if(status == GameStates.VERSCHIEBEN) {
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
	}
	
	// Kampfsystem

	private void OffenderProvince()
	{
		for ( int i = 1; i <= (provinces.length - 1); i++)
		{
			if (provinces[i].hasClicked() == true)
			{   
				offenderProvince = provinces[i];
				System.out.println("1");                
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
					System.out.println("2");
					chooser();                
					break;
				} 
			}
		}
	}

	private void chooser()
	{
		Dice_Offender diceOffender = new Dice_Offender();        
		int[] maxDiceOffender = diceOffender.max_offender(offenderProvince.getEntityCount());
		Dice_Defender diceDefender = new Dice_Defender();
		int[] maxDiceDefender = diceDefender.max_defender(defenderProvince.getEntityCount());
		Arrays.sort(maxDiceOffender);
		Arrays.sort(maxDiceDefender); 
		decider(maxDiceOffender, maxDiceDefender);
	}

	private void decider(int[] maxDiceOffender, int [] maxDiceDefender)
	{
		int maxDefender = maxDiceDefender[1];
		int maxOffender = maxDiceOffender[2];
		if (maxOffender>maxDefender && defenderProvince.getEntityCount()>1)
		{
			int EntitiesOffender = offenderProvince.getEntityCount();
			int EntitiesDefender = defenderProvince.getEntityCount();
			defenderProvince.setEntityCount(EntitiesDefender - 1);   
		}

		if (maxOffender<maxDefender && offenderProvince.getEntityCount()>1)
		{
			int EntitiesOffender = offenderProvince.getEntityCount();
			int EntitiesDefender = defenderProvince.getEntityCount();
			offenderProvince.setEntityCount(EntitiesOffender - 1);   
		}

		if (maxOffender>maxDefender && defenderProvince.getEntityCount()==1)
		{
			defenderProvince.setOwner(offenderProvince.getOwner());
			defenderProvince.setEntityCount(0);
		}

		if (maxOffender>maxDefender && offenderProvince.getEntityCount()==1)
		{
			offenderProvince.setOwner(defenderProvince.getOwner());
			offenderProvince.setEntityCount(0);
		}
		System.out.println("3");
		offenderProvince = null;
		defenderProvince = null;
	}

	// Einheiten verschieben

	/**
	 * Nimmt zwei Provinzen entgegen, und fragt, wieviele Einheiten vom ersten zum zweiten Eintrag verschoben werden sollen.
	 * Überprüft, ob eine Verschiebung möglich ist und führt sie bei Erfolg aus.
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
	 * Speichert ein gegebene Provinz als savedProvince ein, insofern dieser Platz nicht bereits belegt ist.
	 * Ist er das, so wird überprüft, ob eine neue, an savedProvince angrenzende Provinz angeklickt wurde.
	 * Ist dies der Fall, werden beide Provinzen an moveEntities übergeben.
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
