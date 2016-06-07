import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Province here.
 * 
 * @author GruenerWal, Felix Stupp
 * @version 0.0.2
 */
public class Province extends Actor
{
    @Override public GeneralMap getWorld() {
        return (GeneralMap) super.getWorld();
    }
    
    private int stars = 1;
    private int provinceID;
    private String displayName;
    private int owner;
    private boolean[] nextProvinces;
    private int continentID;
    private int xPos;
    private int yPos;
    private int eCount;
    
    private boolean clicked = false;
    
    /**
     * Überprüft, ob die Provinz angeklickt wurde.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)) {
            clicked = true;
        }
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
        GreenfootImage province = new GreenfootImage(100,65);   
        GreenfootImage provinceName = new GreenfootImage(displayName,16,new Color(0,0,0),new Color(1.0f,1.0f,1.0f,0.5f));
        province.drawImage(provinceName,0,0);
        eCalculate(province);        
    }

    private void eCalculate(GreenfootImage province)
    {
        int eCountTanks = eCount / 5;
        GreenfootImage tryOut = new GreenfootImage("C:\\Users\\samue\\Documents\\GitHub\\zweiundvierzig\\Tank.jpg");
        if(eCountTanks <= 3)
        {
            if(eCountTanks == 1)
            {
                province.drawImage(tryOut,0,17);                 
            }
            if(eCountTanks == 2)
            {
                province.drawImage(tryOut,0,17);
                province.drawImage(tryOut,17,17);  
            }
            if(eCountTanks == 3)
            {
                province.drawImage(tryOut,0,17);
                province.drawImage(tryOut,17,17);  
                province.drawImage(tryOut,34,17); 
            }
        }
        else
        {
            GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",16,Color.CYAN,new Color(1.0f,1.0f,1.0f,0.5f));
            province.drawImage(eCountTanksImage,0,17);
            province.drawImage(tryOut,22,18);
        }
        int eCountHorse = (eCount - (eCountTanks * 5))/3;
        if(eCountHorse == 1)
        {
            province.drawImage(tryOut,0,34);           
        }
        int eCountInf = eCount - (eCountTanks * 5) - (eCountHorse * 3);
        if(eCountInf <= 4)
        {
            if(eCountInf == 1)
            {
                province.drawImage(tryOut,0,51);
            }
            if(eCountInf == 2)
            {
                province.drawImage(tryOut,0,51);
                province.drawImage(tryOut,17,51);  
            }
            if(eCountInf == 3)
            {
                province.drawImage(tryOut,0,51);
                province.drawImage(tryOut,17,51);  
                province.drawImage(tryOut,34,51); 
            }
            if(eCountInf == 4)
            {
                province.drawImage(tryOut,0,51);
                province.drawImage(tryOut,17,51);  
                province.drawImage(tryOut,34,51);
                province.drawImage(tryOut,51,51);
            }
        }
        setImage(province);
    }

    public boolean hasClicked() {
        boolean b = clicked;
        clicked = false;
        return b;
    }
    
}
