import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Colors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colors extends World implements ButtonEvent
{
    Button schwarz = new Button ("Schwarz", 16, this);
    Button blau = new Button ("Blau", 16, this);
    Button grün = new Button ("Grün", 16, this);
    Button rot = new Button ("Rot", 16, this);
    Button lila = new Button ("Lila", 16, this);
    Button gelb = new Button ("Gelb", 16, this);
    Button weiter = new Button ("Weiter", 16, this);
    int [] color = new int [6];
    int x;
    boolean possw = true;
    boolean posbl = true;
    boolean posgr = true;
    boolean posrt = true;
    boolean posgb = true;
    boolean posli = true;
    int sw = 1;
    int bl = 2;
    int gr = 3;
    int rt = 4;
    int gb = 5;
    int li = 6;
   
    /**
     * Constructor for objects of class Colors.
     * 
     */
    public Colors()
    {    
        super(1600, 900, 1); 
        addObject(schwarz, 10, 10);
        addObject ( blau, 25, 10);
        addObject ( grün, 40, 10);
        addObject ( rot, 55, 10);
        addObject(gelb, 70, 10);
        addObject(lila, 85, 10);
        
    }
    // Überprüft, ob ein Farbbutton geklickt wurde
    //Überprüft, ob die Farbe noch nicht ausgewählt wurde
    // Wenn alle Bedingungen erfüllt wurden:
    // Setzt die aktuelle Stelle des Farbarrays gleich der Zahl der aktuellen Farbe
    // erhöht die Variable zum Durchzählen um eins
    // verhindert durch falschsetzten einer Variable die Wiederauswahl einer Farbe
    // wenn Weiter geklickt wurde und x größer 1 ist wird eine neue Welt Map erzeugt, 
    //der per Konstruktor die Daten der Colorklasse übertragen werden, dannach wird die Map die aktive Welt
    public void buttonClicked (Button b)
    {
        if ( b == schwarz && possw == true)
        {
            color [x] = sw;
            x+=1;
            possw = false;
        }
        if (b == blau && posbl == true)
        {
            color[x] = bl;
            x+=1;
            posbl = false; 
        }
        if (b == grün && posgr == true )
        {
            color[x] = gr;
            x+=1;
            posgr = false;
        }
        if ( b == rot && posrt == true)
        {
            color[x] = rt;
            x+=1;
            posrt = false;
        }
        if ( b == gelb && posgb == true)
        {
            color [x] = gb;
            x+=1;
            posgb = false;
        }
        if ( b == lila && posli == true)
        {
            color [x] = li;
            x+=1;
            posli = false;
        }
        if ( b == weiter && x >1)
        {
            Map m = new Map(color[], x);
            addObject(m);
            setWorld(Map,m);
        }
    }
   
}
