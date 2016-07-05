import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Player here.
 * 
 * @author (Genosse Betakevin und Genosse Julien und Genosse GruenerWal) 
 * @version 6.6.6-build2
 */
public class Player extends Actor
{
    @Override public GeneralMap getWorld(){
        return (GeneralMap) super.getWorld();
    }
    int stars=0;
    int add=0;
    int id=0;
    int provZahl=0;
    int provVgl=0;
    int[] stats = new int [6];
    String n;
    int color;
    int textsize;
    int c;
    public int active;

    //definiert die ID und Namens Variable
    public Player(int identity,String name, int c)
    {
        n = name;
        id = identity;
        color = c;
        // redrawPlayer();
    }
    //gibt die Spieler ID zurück
    public int getID()
    {
        return id;
    }
    // gibt den Spielernamen zurück
    public String getDisplayName ()
    {
        return n;
    }
    //gibt die Sternenanzahl zurück
    public int getStars()
    {
        return stars;
    }

    /**
     * Gibt die Farbe des Spielers als int-Wert heraus.
     * Wahnsinn, dass du dir den Scheiß hier grad durchliest.
     * ~GruenerWal
     */
    public int getColor()
    {
        return color;
    }

    // Von Felix: Methode nicht architektur-konform

    /* // erhöht die Sternenzahl um eine random ausgewählte Anzahl von 1-3
    public void addToStars()
    {
    int rand;
    int pre;
    rand = (int)(1+6*Math.random());
    if (rand == 1 || rand == 2|| rand == 3)
    {
    add = 1;
    redrawPlayer();
    }
    if (rand == 4|| rand == 5)
    {
    add = 2;
    redrawPlayer();
    }
    if (rand == 6)
    {
    add = 3;
    redrawPlayer();
    }
    if (gotProv== true)
    {
    pre = stars;
    stars+=add;
    System.out.println("Deine vorherige Sternenanzahl betrug " + pre + ".");
    System.out.println("Du hast " + add + " Sterne erhalten.");
    System.out.println("Deine aktuelle Sternenanzahl beträgt " + stars + ".");
    redrawPlayer();
    }
    } */

    private void checkStars() {
        if(stars < 0) {
            stars = 0;
        }
    }

    // Von Felix: Architektur-konforme Funktion
    public int addToStars(int s) {
        stars += s;
        checkStars();
        redrawPlayer();
        return stars;
    }
    //eine für das Testen gedachte Methode, die die Anzahl der Sterne auf ein gewünschtes Maß setzt
    public int setStars (int set)
    {
        stars = set;
        checkStars();
        redrawPlayer();
        return stars;
    }
    //eine Methode, die das Abziehen von Sternen testet und, wenn das Ergebnis >= 0 ist, die Sternenanzahl um eine gewählte Anzahl verringert
    public int removeFromStars(int sub)
    {
        stars -= sub;
        checkStars();
        redrawPlayer();
        return stars;
    }

    public boolean canStarsRemoved(int s) {
        return (stars - s) >= 0;
    }

    public int getProvinceCount()
    { 
        int p = 0;
        int[] provinces = getWorld().getProvinceOwners();
        for (int x=1; x < provinces.length; x++)
        {
            if (provinces[x] == id)
            {
                p++;
                redrawPlayer();
            }
        }
        return p;
    }

    public void gotEntities(int gotEnt)
    {
        stats[3]+= gotEnt;
        redrawPlayer();
    }

    public void lostEntity()
    {
        stats[4]+=1;
        redrawPlayer();
    }

    private void maxEntities(int entNumber)
    {
        if (stats[5]< entNumber)
        {
            stats[5]=entNumber;
            redrawPlayer();
        }
    }

    public boolean[] getMyProvinces()
    {
        int[] provinces = getWorld().getProvinceOwners();
        boolean[] myProvinces = new boolean[provinces.length];
        for (int x=0; x < provinces.length; x++)
        {
            if (provinces[x]== id)
            {
                myProvinces[x]=true;
            }
            else 
            {
                myProvinces[x]=false;
            }

        }
        redrawPlayer();
        return myProvinces;
    }

    public int[] getStatistics()
    {
        redrawPlayer();
        return stats;
    }

    public int setColor(int c)
    {
        color = c;
        redrawPlayer();
        return color;

    }

    public void redrawPlayer()
    {
        int textSize = 20;
        if(n == null)
        {
            n = "leererSpieler";
        }
        GreenfootImage statistics = new GreenfootImage(137,120);   
        GreenfootImage Name = new GreenfootImage(n,textSize,new Color(0,0,0),new Color(1.0f,1.0f,1.0f,0.5f));        
        statistics.drawImage(Name,0,0);

        setImage(statistics);
        oDecide(statistics,textSize);        
    }

    private void oDecide(GreenfootImage statistics,int textSize)
    {
        GreenfootImage flag = new GreenfootImage("images\\BlaueArmee.jpg");
        redraw(statistics,flag,textSize);
        switch(color)
        {
            case 2:
            flag = new GreenfootImage("images\\BlaueArmee.jpg");

            redraw(statistics,flag,textSize);
            break;
            case 5:
            flag = new GreenfootImage("images\\GelbeArmee.jpg");

            redraw(statistics,flag,textSize);
            break;
            case 6:
            flag = new GreenfootImage("images\\LilaArmee.jpg");

            redraw(statistics,flag,textSize);
            break;
            case 4:
            flag = new GreenfootImage("images\\RoteArmee.jpg");

            redraw(statistics,flag,textSize);
            break;
            case 1:
            flag = new GreenfootImage("images\\SchwarzeArmee.jpg");

            redraw(statistics,flag,textSize);
            break;
            case 3:
            flag = new GreenfootImage("images\\GrueneArmee.jpg");
            redrawArrow(statistics,flag,textSize);
            break;
        }

    }

    private void redrawArrow(GreenfootImage statistics,GreenfootImage flag, int textSize)
    {
        // redraw(statistics,flag,textSize);
        redraw(statistics,flag,textSize);
    }

    private void redraw(GreenfootImage statistics,GreenfootImage flag, int textSize)
    {
        flag.scale(137,83);
        statistics.drawImage(flag,0,textSize);
        GreenfootImage playerStatistics = new GreenfootImage(stats[0] + "||" + stats[1] + "||" + stats[2] + "||" +stats[3] + "||" + stats[4] + "||" + stats[5],textSize,new Color(0,0,0),new Color(1.0f,1.0f,1.0f,0.5f));
        statistics.drawImage(playerStatistics, 0, 103);

        setImage(statistics);
    }
}
