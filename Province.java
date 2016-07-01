import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

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
    private int owner = 0;
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
        for(int i = 0; i < ia1.length; i++) {
            if(maxNum < ia1[i]) {
                maxNum = ia1[i];
            }
        }
        nextProvinces = new boolean[maxNum+1];
        for(int i = 0; i < ia1.length; i++) {
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
        redrawProvince();
        return eCount;
    }

    public int removeFromEntities(int a) {
        eCount = eCount - a;
        checkEntityCount();
        redrawProvince();
        return eCount;
    }

    public int setEntityCount(int a) {
        eCount = a;
        checkEntityCount();
        redrawProvince();
        return eCount;
    }

    public void redrawProvince()
    {
        int textSize;
        textSize = 20;
        GreenfootImage province = new GreenfootImage(120,100);   
        GreenfootImage provinceName = new GreenfootImage(displayName,textSize,new Color(0,0,0),new Color(1.0f,1.0f,1.0f,0.5f));
        province.drawImage(provinceName,0,0);
        setImage(province);
        oDecide(province,textSize,owner,eCount);

    }
    
    public void oDecide(GreenfootImage province,int textSize, int owner, int eCount)
    {
        String ownerString;
        if(owner == 0)
        {
            ownerString = "schwarz";
            eCalculate(province,ownerString,textSize);
        }
        else
        {
            switch(owner)
            {
                case 1:
                ownerString = "schwarz";
                eCalculate(province,ownerString,textSize);
                break;
                case 2:
                ownerString = "rot";
                eCalculate(province,ownerString,textSize);
                break;
                case 3:
                ownerString = "blau";
                eCalculate(province,ownerString,textSize);
                break;
                case 4:
                ownerString = "gelb";
                eCalculate(province,ownerString,textSize);
                break;
                case 5:
                ownerString = "gr++n";
                eCalculate(province,ownerString,textSize);
                break;
                case 6:
                ownerString = "lila";
                eCalculate(province,ownerString,textSize);
                break;

            }
        }
    }

    private void eCalculate(GreenfootImage province, String ownerString,int textSize)
    {
        int eCountTanks = eCount / 5;
        int eCountHorse = (eCount - (eCountTanks * 5))/3;
        int eCountInf = eCount - (eCountTanks * 5) - (eCountHorse * 3);

        if(eCountTanks >= 1 && eCountInf == 0 && eCountHorse == 0)
        {
            OnlyTanks(province,eCountTanks,ownerString,textSize);
        }
        if(eCountTanks == 0 && eCountInf == 0 && eCountHorse != 0)
        {
            OnlyHorses(province,eCountHorse,ownerString,textSize);
        }
        if(eCountTanks == 0 && eCountInf != 0 && eCountHorse == 0)
        {
            OnlyInf(province,eCountInf,ownerString,textSize);
        }
        if(eCountTanks == 0 && eCountInf != 0 && eCountHorse != 0)
        {
            NoTanks(province,eCountInf,eCountHorse, ownerString, textSize);   
        }
        if(eCountTanks != 0 && eCountInf != 0 && eCountHorse == 0)
        {
            NoHorse(province,eCountInf,eCountTanks, ownerString, textSize);   
        }
        if(eCountTanks != 0 && eCountInf == 0 && eCountHorse != 0)
        {
            NoInf(province,eCountInf,eCountTanks, ownerString, textSize);   
        }
        if(eCountTanks == 0 && eCountInf == 0 && eCountHorse == 0)
        {
            NoEntity(province, ownerString, textSize);   
        }
        if(eCountTanks != 0 && eCountInf != 0 && eCountHorse != 0)
        {
            AllEntity(province, ownerString,eCountTanks, eCountHorse, eCountInf, textSize);   
        }

    }

    private void NoEntity(GreenfootImage province, String ownerString, int textSize)
    {

    }

    private void OnlyTanks(GreenfootImage province,int eCountTanks, String ownerString, int textSize)
    {
        GreenfootImage tank = new GreenfootImage("images\\dickebertaskal-" + ownerString + ".png");
        tank.scale(textSize,textSize);
        if(eCountTanks <= 3)
        {
            if(eCountTanks == 1)
            {
                province.drawImage(tank,0,textSize);                 
            }
            if(eCountTanks == 2)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
            }
            if(eCountTanks == 3)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
                province.drawImage(tank,textSize*2,textSize); 
            }
        }
        else
        {
            GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
            province.drawImage(eCountTanksImage,0,textSize);
            province.drawImage(tank,eCountTanksImage.getWidth(),textSize);
        }
        setImage(province);
    }

    private void OnlyHorses(GreenfootImage province,int eCountHorse, String ownerString, int textSize)
    {
        GreenfootImage horse = new GreenfootImage("images\\pferdreiterskal-" + ownerString + ".png");
        horse.scale(textSize,textSize);
        province.drawImage(horse,0,textSize);
        setImage(province);
    }

    private void OnlyInf(GreenfootImage province,int eCountInf, String ownerString, int textSize)
    {
        GreenfootImage Inf = new GreenfootImage("images\\infanterieskal-" + ownerString + ".png");
        Inf.scale(textSize,textSize);
        if(eCountInf == 1)
        {
            province.drawImage(Inf,0,textSize);
        }
        if(eCountInf == 2)
        {
            province.drawImage(Inf,0,textSize);
            province.drawImage(Inf,textSize,textSize);  
        }
        setImage(province);
    }

    private void NoTanks(GreenfootImage province,int eCountInf,int eCountHorse, String ownerString, int textSize)
    {
        GreenfootImage Inf = new GreenfootImage("images\\infanterieskal-" + ownerString + ".png");
        Inf.scale(textSize,textSize);
        GreenfootImage horse = new GreenfootImage("images\\pferdreiterskal-" + ownerString + ".png");
        horse.scale(textSize,textSize);
        province.drawImage(horse,0,textSize);
        setImage(province);
        if(eCountInf == 1)
        {
            province.drawImage(Inf,textSize,textSize);
        }
        if(eCountInf == 2)
        {
            province.drawImage(Inf,textSize,textSize);
            province.drawImage(Inf,2*textSize,textSize);
        }
        setImage(province);
    }

    private void NoHorse(GreenfootImage province,int eCountInf,int eCountTanks, String ownerString, int textSize)
    {
        GreenfootImage Inf = new GreenfootImage("images\\infanterieskal-" + ownerString + ".png");
        Inf.scale(textSize,textSize);
        GreenfootImage tank = new GreenfootImage("images\\dickebertaskal-" + ownerString + ".png");
        tank.scale(textSize,textSize);
        if(eCountTanks <= 3)
        {
            if(eCountTanks == 1)
            {
                province.drawImage(tank,0,textSize);                 
            }
            if(eCountTanks == 2)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
            }
            if(eCountTanks == 3)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
                province.drawImage(tank,textSize*2,textSize); 
            }
        }
        else
        {
            GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
            province.drawImage(eCountTanksImage,0,textSize);
            province.drawImage(tank,eCountTanksImage.getWidth(),textSize);
        }
        if(eCountTanks<=3)
        {
            if(eCountInf == 1)
            {
                province.drawImage(Inf,eCountTanks * textSize,textSize);
            }
            if(eCountInf == 2)
            {
                province.drawImage(Inf,eCountTanks * textSize,textSize);
                province.drawImage(Inf,eCountTanks * 2 *textSize,textSize);
            }
        }
        if(eCountTanks>3)
        {
            if(eCountInf == 1)
            {
                GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
                province.drawImage(Inf,eCountTanksImage.getWidth() + textSize,textSize);
            }
            if(eCountInf == 2)
            {
                GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
                province.drawImage(Inf,eCountTanksImage.getWidth() + textSize,textSize);
                province.drawImage(Inf,eCountTanksImage.getWidth() + (2 *textSize),textSize); 
            }
        }
        setImage(province);
    }

    private void NoInf(GreenfootImage province,int eCountHorse,int eCountTanks, String ownerString, int textSize)
    {

        GreenfootImage tank = new GreenfootImage("images\\dickebertaskal-" + ownerString + ".png");
        tank.scale(textSize,textSize);
        GreenfootImage horse = new GreenfootImage("images\\pferdreiterskal-" + ownerString + ".png");
        horse.scale(textSize,textSize);

        if(eCountTanks <= 3)
        {
            if(eCountTanks == 1)
            {
                province.drawImage(tank,0,textSize);                 
            }
            if(eCountTanks == 2)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
            }
            if(eCountTanks == 3)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
                province.drawImage(tank,textSize*2,textSize); 
            }
        }
        else
        {
            GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
            province.drawImage(eCountTanksImage,0,textSize);
            province.drawImage(tank,eCountTanksImage.getWidth(),textSize);
        }
        if(eCountTanks<=3)
        {

            province.drawImage(horse,eCountTanks * textSize,textSize);
            setImage(province);

        }
        if(eCountTanks>3)
        {

            GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
            province.drawImage(horse,eCountTanksImage.getWidth() + textSize,textSize);
            setImage(province);

        }
        setImage(province);
    }

    private void AllEntity(GreenfootImage province, String ownerString,int eCountTanks, int eCountHorse, int eCountInf,int textSize) 
    {
        GreenfootImage tank = new GreenfootImage("images\\dickebertaskal-" + ownerString + ".png");
        tank.scale(textSize,textSize);
        GreenfootImage horse = new GreenfootImage("images\\pferdreiterskal-" + ownerString + ".png");
        horse.scale(textSize,textSize);
        GreenfootImage Inf = new GreenfootImage("images\\infanterieskal-" + ownerString + ".png");
        Inf.scale(textSize,textSize);
        if(eCountTanks <= 3)
        {
            if(eCountTanks == 1)
            {
                province.drawImage(tank,0,textSize);                 
            }
            if(eCountTanks == 2)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
            }
            if(eCountTanks == 3)
            {
                province.drawImage(tank,0,textSize);
                province.drawImage(tank,textSize,textSize);  
                province.drawImage(tank,textSize*2,textSize); 
            }
        }
        else
        {
            GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
            province.drawImage(eCountTanksImage,0,textSize);
            province.drawImage(tank,eCountTanksImage.getWidth(),textSize);
        }
        if(eCountHorse == 1)
        {
            if(eCountTanks<=3)
            {

                province.drawImage(horse,eCountTanks * textSize,textSize);
                if(eCountInf == 1)
                {
                    province.drawImage(Inf,eCountTanks * textSize + textSize,textSize);
                }
                if(eCountInf == 2)
                {
                    province.drawImage(Inf,eCountTanks * textSize + textSize + textSize,textSize);
                }
                setImage(province);

            }
            if(eCountTanks>3)
            {

                GreenfootImage eCountTanksImage = new GreenfootImage(Integer.toString(eCountTanks) + "x",textSize,Color.BLACK,new Color(1.0f,1.0f,1.0f,0.5f));
                province.drawImage(horse,eCountTanksImage.getWidth() + textSize,textSize);
                if(eCountInf == 1)
                {
                    province.drawImage(Inf,eCountTanksImage.getWidth() + textSize + textSize,textSize);
                }
                if(eCountInf == 2)
                {
                    province.drawImage(Inf,eCountTanksImage.getWidth() + textSize + textSize + textSize + textSize,textSize);
                }
                setImage(province);

            }
        }
        setImage(province);
    }


    public boolean hasClicked()
    {
        boolean b = clicked;
        clicked = false;
        return b;
    }

}

