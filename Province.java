import greenfoot.*;
import java.awt.Color;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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

    public void redrawProvince()
    {
        int schriftgröße;
        schriftgröße = 20;
        GreenfootImage province = new GreenfootImage(100,100);   
        GreenfootImage provinceName = new GreenfootImage(displayName,schriftgröße,new Color(0,0,0),new Color(1.0f,1.0f,1.0f,0.5f));
        province.drawImage(provinceName,0,0);
        oDecide(province,schriftgröße);        
    }

    public void oDecide(GreenfootImage province,int schriftgröße)
    {
        String ownerString;
        switch(owner)
        {
            case 1:
            ownerString = "schwarz";
            eCalculate(province,ownerString,schriftgröße);
            break;
            case 2:
            ownerString = "rot";
            eCalculate(province,ownerString,schriftgröße);
            break;
            case 3:
            ownerString = "blau";
            eCalculate(province,ownerString,schriftgröße);
            break;
            case 4:
            ownerString = "gelb";
            eCalculate(province,ownerString,schriftgröße);
            break;
            case 5:
            ownerString = "gr++n";
            eCalculate(province,ownerString,schriftgröße);
            break;
            case 6:
            ownerString = "lila";
            eCalculate(province,ownerString,schriftgröße);

        }
        
    }

    private void eCalculate(GreenfootImage province, String ownerString,int schriftgröße)
    {
        int eCountTanks = eCount / 5;
        GreenfootImage tank = new GreenfootImage("images\\dickebertaskal-" + ownerString + ".png");
        tank.scale(schriftgröße,schriftgröße);
        if(eCountTanks <= 3)
        {
            if(eCountTanks == 1)
            {
                province.drawImage(tank,0,schriftgröße);                 
            }
            if(eCountTanks == 2)
            {
                province.drawImage(tank,0,schriftgröße);
                province.drawImage(tank,17,schriftgröße);  
            }
            if(eCountTanks == 3)
            {
                province.drawImage(tank,0,schriftgröße);
                province.drawImage(tank,schriftgröße,schriftgröße);  
                province.drawImage(tank,schriftgröße,schriftgröße); 
            }
        }
        else
        {
            GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",schriftgröße,Color.CYAN,new Color(1.0f,1.0f,1.0f,0.5f));
            province.drawImage(eCountTanksImage,0,schriftgröße);
            province.drawImage(tank,45,schriftgröße);
        }
        int eCountHorse = (eCount - (eCountTanks * 5))/3;
        GreenfootImage horse = new GreenfootImage("images\\pferdreiterskal-" + ownerString + ".png");
        horse.scale(schriftgröße,schriftgröße);
        if(eCountHorse == 1)
        {
            province.drawImage(horse,0,2 * schriftgröße);           
        }
        GreenfootImage Inf = new GreenfootImage("images\\infanterieskal-" + ownerString + ".png");
        int eCountInf = eCount - (eCountTanks * 5) - (eCountHorse * 3);
        Inf.scale(schriftgröße,schriftgröße);
        if(eCountInf <= 4)
        {
            if(eCountInf == 1)
            {
                province.drawImage(Inf,0,3* schriftgröße);
            }
            if(eCountInf == 2)
            {
                province.drawImage(Inf,0,3 * schriftgröße);
                province.drawImage(Inf,25,3 * schriftgröße);  
            }           
        }
        setImage(province);
    }

}

