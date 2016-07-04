import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import javax.swing.JOptionPane;

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
    int[] color = new int [5];
    String[] pn = new String [5];
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
    Button remove = new Button("Rückgängig",16,this);
    Label pl1 = new Label("",16);
    Label pl2 = new Label("",16);
    Label pl3 = new Label("",16);
    Label pl4 = new Label("",16);
    Label pl5 = new Label("",16);

    /**
     * Constructor for objects of class Colors.
     * 
     */
    public Colours(int x, int y, int z)
    {
        super(x, y, z);
        setBackground(Start_Load.backgroundImage);
        
        Button[] bList = new Button[] {schwarz,gelb,blau,grün,rot,lila,weiter,remove};
        Label[] lList = new Label[] {header,pl1,pl2,pl3,pl4,pl5};
        
        addObject(header,200,15);
        
        addObject(schwarz, 70, 50);
        addObject ( blau, 190, 50);
        addObject ( grün, 300, 50);
        addObject ( rot, 410, 50);
        addObject(gelb, 520, 50);
        addObject(lila, 630, 50);
        addObject(remove,300,110);
        addObject (weiter, 410,110);
        
        addObject(pl1,355,160);
        addObject(pl2,355,180);
        addObject(pl3,355,200);
        addObject(pl4,355,220);
        addObject(pl5,355,240);
        
        schwarz.setForeColor(Color.black);
        gelb.setForeColor(Color.yellow);
        blau.setForeColor(Color.blue);
        grün.setForeColor(Color.green);
        rot.setForeColor(Color.red);
        lila.setForeColor(new Color(161,70,255));
        
        for(int i = 0; i < bList.length; i++) {
            bList[i].setSize(100,50);
        }
        for(int i = 0; i < lList.length; i++) {
            lList[i].setBackColor(new Color(0,0,0,0));
        }
        
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
        if (x < 5) {
            if (b == schwarz && possw == true) {
                color[x] = sw;
                pn[x]=getName(x,"Schwarz");
                if(pn[x].length() > 0) {
                    x+=1;
                    possw = false;
                }
            } else if (b == blau && posbl == true) {
                color[x] = bl;
                pn[x]=getName(x,"Blau");
                if(pn[x].length() > 0) {
                    x+=1;
                    posbl = false;
                }
            } else if (b == grün && posgr == true )  {
                color[x] = gr;
                pn[x]=getName(x,"Grün");
                if(pn[x].length() > 0) {
                    x+=1;
                    posgr = false;
                }
            } else if (b == rot && posrt == true) {
                color[x] = rt;
                pn[x]=getName(x,"Rot");
                if(pn[x].length() > 0) {
                    x+=1;
                    posrt = false;
                }
            } else if (b == gelb && posgb == true) {
                color [x] = gb;
                pn[x]=getName(x,"Gelb");
                if(pn[x].length() > 0) {
                    x+=1;
                    posgb = false;
                }
            } else if (b == lila && posli == true) {
                color [x] = li;
                pn[x]=getName(x,"Lila");
                if(pn[x].length() > 0) {
                    x+=1;
                    posli = false;
                }
            }
        }
        if(b == remove && x > 0) {
            x -= 1;
            switch(color[x]) {
                case 1: possw = true; break;
                case 2: posbl = true; break;
                case 3: posgr = true; break;
                case 4: posrt = true; break;
                case 5: posgb = true; break;
                case 6: posli = true; break;
            }
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
        if(x >= 5) {
            return Color.gray;
        }
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
        remove.setBackColor((x > 0) ? Color.black : Color.gray);
        pl1.setText("");
        pl2.setText("");
        pl3.setText("");
        pl4.setText("");
        pl5.setText("");
        switch(x) {
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
    
    private String getName(int id, String col) {
        String name = JOptionPane.showInputDialog(null, "Wie soll Spieler Nr. "+id+" mit der Farbe "+col+" heißen?");
        if(name == null) {
            name = "";
        }
        return name;
    }
}


