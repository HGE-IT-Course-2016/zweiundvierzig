import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Province here.
 * 
 * @author GruenerWal
 * @version 0.0.1
 */
public class Province extends Actor
{
    private int stars = 1;
    private int provinceID;
    private String displayName;
    private int owner;
    private int[] nextProvinces;
    private int continentID;

    /**
     * leere Act-Methode
     * (Für später; falls die Provinz bestimmte Aktionen ausführen sollte.)
     */
    public void act() 
    {
        // GruenerWal war hier :3
    }

    // Konstruktor, benötigt Sterne
    public Province(int i1, int i2, int i3, String s1, int[] ia1)
    {
        provinceID = i1;
        continentID = i2;
        stars = i3;
        displayName = s1;
        nextProvinces = new int[ia1.length];
                
        for ( int z1 = 0; z1 < ia1.length; z1++)
        {
            nextProvinces[z1] = ia1[z1];
        }
    }

    // Liefert die Sterne als Integer
    public int getStars()
    {
        return stars;
    }

    // Liefert die Provinz-ID als Integer
    public int getProvinceID()
    {
        return provinceID;
    }

    // Liefert den Anzeigenamen als String
    public String getDisplayName()
    {
        return displayName;
    }

    // Liefert den Owner als String
    public int getOwner()
    {
        return owner;
    }
            
    // Liefert angrenzende Provinzen als Integer-Array
    public int[] getNextProvinces()
    {
        return nextProvinces;
    }
    
    // Liefert die Kontinent-ID als Integer
    public int getContinentID()
    { 
        return continentID;
    }

    // Setzt den Owner, benötigt String
    public void setOwner(int o)
    {
        owner = o;
    }
    
}
