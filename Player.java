import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Player here.
 * 
 * @author (Genosse Betakevin und Genosse Julien) 
 * @version (version 666)
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
	int [] stats = new int [6];
	boolean [] pBesitzer = new boolean [42];
	boolean gotProv = false;
	boolean lostProv = false;
	int identity;
	String name;
	int color;
	int textsize;

	private String n;
	private int c;
	//definiert die ID und Namens Variable
	public Player( int identity,String name, int color)
	{
		n = name;
		id = identity;
		c = color;
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
	public int getStars ()
	{
		return stars;
	}
	// erhöht die Sternenzahl um eine random ausgewählte Anzahl von 1-3
	public void  addToStars ()
	{  

		int rand;
		int pre;
		rand = (int)(1+6*Math.random());
		if (rand == 1 || rand == 2|| rand == 3)
		{
			add = 1;
		}
		if (rand == 4|| rand == 5)
		{
			add = 2;
		}
		if (rand == 6)
		{
			add = 3;
		}
		if (gotProv== true)
		{
			pre = stars;
			stars+=add;
			System.out.println("Deine vorherige Sternenanzahl betrug " + pre + ".");
			System.out.println("Du hast " + add + " Sterne erhalten.");
			System.out.println("Deine aktuelle Sternenanzahl beträgt " + stars + ".");

		}
	}
	//eine Methode um addToStars zu testen
	public void add ()
	{
		addToStars();
	}
	//eine für das Testen gedachte Methode, die die Anzahl der Sterne auf ein gewünschtes Maß setzt
	public int setStars (int set)
	{
		stars = set;
		return stars;
	}
	//eine Methode, die das Abziehen von Sternen testet und, wenn das Ergebnis >= 0 ist, die Sternenanzahl um eine gewählte Anzahl verringert
	public int removeFromStars(int sub)
	{
		int s;

		s = stars - sub;
		if (s>=0)
		{
			stars = s;
		}
		else 
		{
			System.out.println ("Du hast nur " + stars + " Sterne, du kannst also nicht " + sub + " Sterne abziehen");
		}
		return stars;
	}

	public int getProvinceCount ()
	{ 
		GeneralMap w= getWorld();
		int[] provinces = w.getProvinceOwners();
		for (int x=0; x<=42; x++ )
		{
			if ( provinces [x] ==id)
			{
				provZahl++;

			}
		}
		if(stats[2] < provZahl)
		{
			stats[2]=provZahl;

		}
		return provZahl;
	}

	public void gotEntities(int gotEnt)
	{
		stats[3]+= gotEnt;
	}

	public void lostEntity()
	{
		stats[4]+=1;
	}

	private void maxEntities(int entNumber)
	{
		if (stats[5]< entNumber)
		{
			stats[5]=entNumber;
		}
	}

	public boolean[] getMyProvinces()
	{
		GeneralMap w= getWorld();
		int[] provinces = w.getProvinceOwners();
		for (int x=0; x<=42; x++)
		{
			if (provinces[x]== id)
			{
				pBesitzer[x]=true;
			}
			else 
			{
				pBesitzer[x]=false;
			}

		}
		return pBesitzer;
	}

	private void gotlostProvince()
	{
		if (provVgl== provZahl)
		{
			gotProv = false;
			lostProv =false;

		}
		if(provVgl< provZahl)
		{
			gotProv = true;
			lostProv = false;
			stats[0]+=1;
		}
		if (provVgl > provZahl) 
		{
			gotProv = false;
			lostProv = true;
			stats[1]+=1;
		}
		provVgl = provZahl;
	}

	public boolean getGotProvince ()
	{
		return gotProv;  
	}

	public boolean getLostProvince()
	{
		return lostProv; 
	}

	public int[] getStatistics()
	{
		return stats;
	}
	public int setColor(int c)
	{
	   color = c;
	   return color;
	}
   
	public void redrawPlayer()
	{
		int textSize = 20;
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
			flag = new GreenfootImage("images\\Gr++neArmee.jpg");
			
			redraw(statistics,flag,textSize);
			break;
		}

	}

	private void redraw(GreenfootImage statistics,GreenfootImage flag, int textSize)
	{
		
		flag.scale(137,100);
		statistics.drawImage(flag,0,textSize);
		GreenfootImage playerStatistics = new GreenfootImage(stats[0] + "||" + stats[1] + "||" + stats[2],textSize,new Color(0,0,0),new Color(1.0f,1.0f,1.0f,0.5f));
		GreenfootImage playerStatistics2 = new GreenfootImage(stats[3] + "||" + stats[4] + "||" + stats[5],textSize,new Color(0,0,0),new Color(1.0f,1.0f,1.0f,0.5f));
		statistics.drawImage(playerStatistics, 0, 123);
		statistics.drawImage(playerStatistics2, 0, 123 + textSize);
		
		setImage(statistics);
	}
}
