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
    int[] color = new int [6];
    String[] pn = new String [6];
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
    
    Label header = new Label("Klicke auf eine Farbe, um einen Spieler hinzuzufügen:",16);
    Label pl1 = new Label("",16);
    Label pl2 = new Label("",16);
    Label pl3 = new Label("",16);
    Label pl4 = new Label("",16);
    Label pl5 = new Label("",16);
    Label pl6 = new Label("",16);

    /**
     * Constructor for objects of class Colors.
     * 
     */
    public Colours(int x, int y, int z)
    {
        super(x, y, z);
        setBackground(Start_Load.backgroundImage);
        
        addObject(header,50, 20);
        
        addObject(schwarz, 50, 50);
        addObject ( blau, 170, 50);
        addObject ( grün, 280, 50);
        addObject ( rot, 390, 50);
        addObject(gelb, 500, 50);
        addObject(lila, 610, 50);
        addObject (weiter, 335,110);
        
        addObject(pl1,50,170);
        addObject(pl2,50,190);
        addObject(pl3,50,210);
        addObject(pl4,50,230);
        addObject(pl5,50,250);
        addObject(pl6,50,270);
        
        schwarz.setSize(100, 50);
        gelb.setSize(100, 50);
        blau.setSize(100, 50);
        grün.setSize(100, 50);
        rot.setSize(100, 50);
        lila.setSize(100, 50);
        weiter.setSize(100, 50);
        
        schwarz.setForeColor(Color.black);
        gelb.setForeColor(Color.yellow);
        blau.setForeColor(Color.blue);
        grün.setForeColor(Color.green);
        rot.setForeColor(Color.red);
        lila.setForeColor(new Color(161,70,255));
        
        redraw();
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
        if ( b == weiter && x > 2 )
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
        redraw();
    }
    
    private Color getC(boolean pos) {
        return (pos) ? Color.lightGray : Color.gray;
    }
    
    /**
        Passt alle adaptiven Parameter automatisch an.
    */
    private void redraw() {
        schwarz.setBackColor(getC(possw));
        blau.setBackColor(getC(posbl));
        grün.setBackColor(getC(posgr));
        rot.setBackColor(getC(posrt));
        lila.setBackColor(getC(posli));
        gelb.setBackColor(getC(posgb));
        switch(x) {
            case 6:
                pl6.setText(pn[5]);
            case 5:
                pl5.setText(pn[4]);
            case 4:
                pl4.setText(pn[3]);
            case 3:
                pl3.setText(pn[2]);
            case 2:
                pl2.setText(pn[1]);
            case 1:
                pl1.setText(pn[0]);
        }
    }
}


