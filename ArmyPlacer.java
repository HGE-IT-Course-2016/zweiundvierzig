import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArmyPlacer here.
 * 
 * @author GruenerWal, MaxiJohl
 * @version 1.0.0
 */
public class ArmyPlacer extends Map_World
{

    
    public int armiesToPlace;
    public int armyMinimum;

    
    /**
     * Constructor for objects of class ArmyPlacer.
     * 
     */
    public ArmyPlacer(String[] a1, int[] a2)
    {
        super(a1,a2);
        // Hi.
        // Dies
        // ist
        // ein
        // unnützer
        // Kommentar
        // um
        // Zeilen
        // zu
        // farmen
        // :)
        // Mit
        // freundlichen
        // Grüßen
        // ,
        // GruenerWal
    }

    
    public int calculateArmies()
    {
        armiesToPlace = armyMinimum;
        
        armiesToPlace = armiesToPlace + Math.round(players[currentPlayer].getProvinceCount() / 3);
        
        return 0;
    }
    
    
    public Province[] giveContinentArray(int cID)
    {
        Province[] savedProvinces = new Province[provinceCount +1];
        Province[] continentProvinces;
        for (int i = 1; i <= provinceCount; i++)
        {
            if (provinces[i].getContinentID() == cID)
            {
                savedProvinces[i] = provinces[i];
            }
        }
        
        return Utils.cutArray(savedProvinces);
        
    }

    
    public void placeArmies()
    {

    }
}
