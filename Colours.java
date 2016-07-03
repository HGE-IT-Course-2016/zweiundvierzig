import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Colors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Colours extends World implements ButtonEvent
{
    Button schwarz = new Button ("Schwarz", 16, this);
    Button blau = new Button ("Blau", 16, this);
    Button grün = new Button ("Grün", 16, this);
    Button rot = new Button ("Rot", 16, this);
    Button lila = new Button ("Lila", 16, this);
    Button gelb = new Button ("Gelb", 16, this);
    Button weiter = new Button ("Weiter", 16, this);
    int [] color = new int [6];
    String [] pn = new String [6];
    int x = 0;
    boolean possw = true; // schwarz
    boolean posbl = true; // blau
    boolean posgr = true; // gruen
    boolean posrt = true; // rot
    boolean posgb = true; // gelb
    boolean posli = true; // lila
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
    public Colours(int x, int y, int z)
    {
        super(x, y, z);
        setBackground(Start_Load.backgroundImage);
        
        addObject(schwarz, 50, 30);
        addObject ( blau, 170, 30);
        addObject ( grün, 280, 30);
        addObject ( rot, 390, 30);
        addObject(gelb, 500, 30);
        addObject(lila, 610, 30);
        addObject (weiter, 335,90);
        
        schwarz.setSize(100, 50);
        gelb.setSize(100, 50);
        blau.setSize(100, 50);
        grün.setSize(100, 50);
        rot.setSize(100, 50);
        lila.setSize(100, 50);
        weiter.setSize(100, 50);
        
        schwarz.setTextColor(Color.black);
        gelb.setTextColor(Color.yellow);
        blau.setTextColor(Color.blue);
        grün.setTextColor(Color.green);
        rot.setTextColor(Color.red);
        lila.setTextColor(new Color(161,70,255));
        
        redrawButtons();
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
            color[x] = sw;
            pn[x]="Schwarz";
            x+=1;
            possw = false;
            
        }
        if (b == blau && posbl == true)
        {
            color[x] = bl;
            pn[x] = "Blau";
            x+=1;
            posbl = false;
            
        }
        if (b == grün && posgr == true )
        {
            color[x] = gr;
            pn[x]="Grün";
            x+=1;
            posgr = false;
            
        }
        if ( b == rot && posrt == true)
        {
            color[x] = rt;
            pn[x]="Rot";
            x+=1;
            posrt = false;
            
        }
        if ( b == gelb && posgb == true)
        {
            color [x] = gb;
            pn[x]="Gelb";
            x+=1;
            posgb = false;
            
        }
        if ( b == lila && posli == true)
        {
            color [x] = li;
            pn[x]="Lila";
            x+=1;
            posli = false;
            
        }
        if ( b == weiter && x >=2 )
        {
            String[] newpn = new String[x];
            int[] newcolor = new int[x];
            for (int i = 0; i< x; i++)
            {
                newpn[i] = pn[i];
                newcolor[i] = color[i];

            }

            World m = new Map(newcolor,x,newpn);
            Greenfoot.setWorld(m);
        }
        redrawButtons();
    }
    
    private Color getC(boolean pos) {
        return (pos) ? Color.white : Color.gray;
    }
    
    /**
        Passt die Hintergrundfarbe der Buttons daran an, ob der Button noch gedrückt werden darf.
    */
    private void redrawButtons() {
        schwarz.setTextColor(getC(possw));
        blau.setTextColor(getC(posbl));
        grün.setTextColor(getC(posgr));
        rot.setTextColor(getC(posrt));
        lila.setTextColor(getC(posli));
        gelb.setTextColor(getC(posgb));
    }
}


