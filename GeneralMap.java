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
