import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Province here.
 * 
 * @author GruenerWal
 * @version 0.0.2
 */
public class Province extends Actor
{
    private int stars = 1;
    private int provinceID;
    private String displayName;
    private int owner;
    private boolean[] nextProvinces;
    private int continentID;
    private int xPos;
    private int yPos;
    private int eCount;
    
    /**
     * leere Act-Methode
     * (Für später; falls die Provinz bestimmte Aktionen ausführen sollte.)
     */
    public void act() 
    {
        // GruenerWal war hier :3
    }
    
    // Haupt-Konstruktor
    public Province(int pID, int cID, int x, int y, int st, String s1, int[] ia1)
    {
        provinceID = pID;
        continentID = cID;
        xPos = x;
        yPos = y;
        if(st > 0) {
            stars = st;
        }
        displayName = s1;
        // Der Teil, der sich um die Konvertierung des int-Array in ein boolean-Array kümmert.
        int maxNum = 0;
        for(int i = 0; i >= ia1.length; i++) {
            if(maxNum < ia1[i]) {
                maxNum = ia1[i];
            }
        }
        nextProvinces = new boolean[ia1.length];
        for(int i = 0; i >= ia1.length; i++) {
            if(ia1[i] >= 0) {
                nextProvinces[ia1[i]] = true;
            }
        }
    }
    
    // Zweiter Konstruktor, um auch das boolean-Array gegebenenfalls verwenden zu könnnen.
    public Province(int pID, int cID, int x, int y, int st, String s1, boolean[] ba1)
    {
        provinceID = pID;
        continentID = cID;
        xPos = x;
        yPos = y;
        if(st > 0) {
            stars = st;
        }
        displayName = s1;
        nextProvinces = Utils.copyArray(ba1);
    }

    // Liefert die X-Position als Integer
    public int getXPos()
    {
        return xPos;
    }
    
    // Liefert die Y-Position als Integer
    public int getYPos()
    {
        return yPos;
    }
    
    // Liefert die Provinz-ID als Integer
    public int getID()
    {
        return provinceID;
    }
    
    // Liefert die Kontinent-ID als Integer
    public int getContinentID()
    { 
        return continentID;
    }
    
    // Fragt ab, ob die angegebene Provinz in der Nähe von dieser liegt.
    public boolean isProvinceNear(int i) {
        if(i >= nextProvinces.length) {
            return false;
        }
        return nextProvinces[i];
    }
    
    // Liefert den Anzeigenamen als String
    public String getDisplayName()
    {
        return displayName;
    }
    
    // Liefert die Sterne als Integer
    public int getStars()
    {
        return stars;
    }
    
    // Liefert den Owner als String
    public int getOwner()
    {
        return owner;
    }
    
    // Setzt den Owner, benötigt String
    public void setOwner(int o)
    {
        if(o < -1) {
            o = -1;
        }
        owner = o;
    }
    
    public int getEntityCount() {
        return eCount;
    }
    
    private void checkEntityCount() {
        if(eCount < 0) {
            eCount = 0;
        }
    }
    
    public int addToEntities(int a) {
        eCount = eCount + a;
        checkEntityCount();
        return eCount;
    }
    
    public int removeFromEntities(int a) {
        eCount = eCount - a;
        checkEntityCount();
        return eCount;
    }
    
    public int setEntityCount(int a) {
        eCount = a;
        checkEntityCount();
        return eCount;
    }
    
    public void redrawProvince() {
        //Platzhalter
    }

}
