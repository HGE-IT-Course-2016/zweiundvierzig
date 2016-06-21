import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map extends Spielstart
{
    private Button map1 = new Button ("map1",16,this);
    private Button map2 = new Button ("map2",16,this);
    private Button fertigst = new Button (" Fertigstellen",16,this);
    int [] color = new int[6];
    String [] pn = new String [6];
    int pnu;
    //private int x;
    //private int y;
    private int m=0;
    private GeneralMap GM ;
    public Map( int [] bunt, int zahl , String [] name)
    {
        super (1600,900,1);
        for (int i=0; i<6; i++)
        {
            color[x] = bunt[x];
            pn[x] = name[x];
        }
        pnu=zahl;
        addObject(map1, (1600-map1.getWidth())/2, (900-map1.getHeight())/2);
        addObject(map2, ((1600-map2.getWidth())/2)-25, ((900-map1.getHeight())/2)+75);
        addObject(fertigst, (1600-fertigst.getWidth()), 900-fertigst.getWidth());
    } 
    // Die Map Buttons geben der Variable m einen Wert
    public void buttonClicked(Button b)
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
            new  GeneralMap (color, pnu, pn, m);
            Greenfoot.setWorld(GM);
        }
    }

}
