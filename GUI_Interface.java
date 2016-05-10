import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Oberklasse für sämtliche GUI Objekte, wie Labels und Buttons
 * 
 * @author Felix Stupp 
 * @version 10.05.2016
 */
public class GUI_Interface extends Actor
{
	protected int sx = 1;
	protected int sy = 1;
	
	public int getWidth() {
		return sx;
	}
	
	public int getHeight() {
		return sy;
	}
	
	public void setSize(int w, int h) {
		if(w < 0 || h < 0) {
			return;
		}
		sx = w;
		sy = h;
		redraw();
	}
	
	public void act() 
	{
		// Add your action code here.
	}
	
	public abstract void redraw();
}
