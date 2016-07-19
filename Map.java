import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map extends World implements ButtonEvent
{
    private Button map1 = new Button ("map1",16,this);
    private Button map2 = new Button ("map2",16,this);
    private Button fertigst = new Button (" Fertigstellen",16,this);
    int[] colour;
    String[] pn;
    int pnu;
    //private int x;
    //private int y;
    private int m=0;
    private Map_World MW ;
    // int [] newcolour = new int [pnu];
    // String [] newpn = new String [pnu];
    public Map( int[] bunt, int zahl , String [] name)
    {
        super (1600,900,1);
        setBackground(Start_Load.backgroundImage);
        colour = new int[zahl];
        pn = new String[zahl];        
        for (int i=0; i<zahl; i++)
        {
            colour[i] = bunt[i];
            pn[i] = name[i];
        }
        pnu=zahl;
        addObject(map1, 50, 30);
        addObject(map2, 170, 30);
        addObject(fertigst,110,90 );
        map1.setSize(100, 50);
        map2.setSize(100, 50);
        fertigst.setSize(100, 50);
        // for ( int i=0; i<=pnu; i++)
        // {
        // newpn[i] = pn[i];
        // newcolour[i] = colour[i];
        // }
    } 
    // Die Map Buttons geben der Variable m einen Wert
    public void buttonClicked(Bildbutton b)
    {

        if (b== map1)
        {
            //x= ;
            //y= ;
            m =1;

        }
        if (b== map2)
        {
            m =2;

        }
        if (b == fertigst)
        {
            if (m==1)
            {
                GeneralMap m = new Map_World (pn, colour);
                Greenfoot.setWorld(m);
            }

        }
    }

}
