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
    private boolean[] nextProvinces;
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
        // Der Teil, der sich um die Konvertierung des int-Array in ein boolean-Array kümmert.
        int maxNum = 0;
        for(int i = 0; i < ia1.length(); i++) {
            if(maxNum < ia1[i]) {
                maxNum = ia1[i];
            }
        }
        nextProvinces = new boolean[ia1.length];
        for(int i = 0; i < ia1.length(); i++) {
            if(ia1[i] >= 0) {
                nextProvinces = ia1[i];
            }
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
    
    // Fragt ab, ob die angegebene Provinz in der Nähe von dieser liegt.
    public boolean isProvinceNear(int i) {
        if(i >= nextProvinces.length()) {
            return false;
        }
        return nearProvinces[i];
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
