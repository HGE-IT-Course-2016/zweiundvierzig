import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import System.awt.Color;

/**
 * Zeigt einen Text an.
 * 
 * @author Felix Stupp
 * @version 10.05.2016
 */
public class Label extends GUI_Interface {
	
	Color foreC = Color.WHITE;
	Color backC = Color.BLACK;
	int textSize = 1;
	String text = "";
	
	private void redraw() {
		GreenfootImage tI = new GreenfootImage(text,textSize,foreC,backC);
		setImage(tI);
	}
	
	public int getTextSize() {
		return textSize;
	}
	
	public void setTextSize(int s) {
		if(textSize != s && s > 0) {
			textSize = s;
			redraw();
		}
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String s) {
		if(text != s) {
			text = s;
			redraw();
		}
	}
}
