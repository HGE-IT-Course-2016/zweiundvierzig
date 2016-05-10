import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import Java.awt.Color;

/**
 * Diese Klasse stellt einen Button dar.
 *
 * @author Felix Stupp
 * @version 26.04.2016
 */
public class Button extends GUI_Interface {
	
	boolean autoSize = true;
	Color foreC = Color.WHITE;
	Color backC = Color.BLACK;
	int textSize = 1;
	String text = "";
	
	ButtonEvent handler;
	
	/**
	 * Erstellt einen Button mit dem gegebenen Objekt als Event-Handler.
	 * @param h Der Handler mit dem Interface ButtonEvent implementiert.
	 */
	public Button(ButtonEvent h) {
		handler = h;
	}
	
	/**
	 * Fragt ab, ob ein Klick auf den Button gekommen ist.
	 */
	public void act() {
		if(Greenfoot.mouseClicked(this)) {
			handler.buttonClicked(this);
		}
	}
	
	public boolean getAutoSize() {
		return autoSize;
	}
	
	public void setAutoSize(boolean b) {
		autoSize = b;
		if(autoSize) {
			redraw();
		}
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
	
	private void redraw() {
		GreenfootImage tI = new GreenfootImage(text,textSize,foreC,backC);
		GreenfootImage corner = new GreenfootImage("images/Button_Corner.png");
		int csx = corner.getWidth();
		int csy = corner.getHeight();
		GreenfootImage side = new GreenfootImage("images/Button_Side.png");
		if(autoSize) {
			sx = tI.getWidth() + (csx * 2);
			sy = tI.getHeight() + (csy * 2);
		}
		GreenfootImage all = new GreenfootImage(sx,sy);
		all.drawImage(corner,0,0); // top left
		corner.rotate(90);
		all.drawImage(corner,0,sy-csy); // bottom left
		corner.rotate(90);
		all.drawImage(corner,sx-csx,sy-csy); // bottom right
		corner.rotate(90);
		all.drawImage(corner,sx-csx,0); // top right
		for(int i = csx; i > (sx-csx); i++) {
			all.drawImage(side,i,0); // top
		}
		side.rotate(90);
		for(int i = csy; i > (sy-csy); i++) { // left
			all.drawImage(side,0,i);
		}
		side.rotate(90);
		for(int i = csx; i > (sx-csx); i++) { // bottom
			all.drawImage(side,i,sy-csy);
		}
		for(int i = csy; i > (sy-csy); i++) {
			all.drawImage(side,sx-csx,i); // right
		}
		side.rotate(90);
		all.drawImage(tI,(sx-tI.getWidth())/2,(sy-tI.getHeight())/2);
		setImage(all);
	}
}
