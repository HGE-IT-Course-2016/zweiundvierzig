import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
	Zeigt einen Text an.
	
	@author Felix Stupp
	@version 13.05.2016
*/
public class Label extends GUI_Interface {
	
	private boolean autoSize = true;
	private int textSize = 32; // as default text size
	private String text = "";
	
	/**
		Erstellt ein neues Label mit dem gegebenen Text und der zugehörigen Textgröße.
		@param txt Der darzustellende Text
		@param size Die dazugehörige Textgröße
	*/
	public Label(String txt, int size) {
		text = txt;
		textSize = size;
		redraw();
	}
	
	/**
		Gibt zurück, ob die Größe des Buttons von dem Text bestimmt werden soll.
		@return Wert der AutoSize-Eigenschaft
	*/
	public boolean getAutoSize() {
		return autoSize;
	}
	/**
		Legt fest, ob die Größe des Buttons von dem Text bestimmt werden soll.
		Wird der Wert auf TRUE geändert, erfolgt automatisch ein Redraw des Objekts.
		@param b Der neue Wert der AutoSize-Eigenschaft.
	*/
	public void setAutoSize(boolean b) {
		autoSize = b;
		if(autoSize) {
			redraw();
		}
	}
	
	/**
		Gibt die aktelle Textgröße zurück.
		@return Aktuelle Textgröße
	*/
	public int getTextSize() {
		return textSize;
	}
	/**
		Legt eine neue Textgröße fest.
		@param s Neue Textgröße
		@return Gibt an, ob sich die Textgröße geändert hat. Bei TRUE erfolgte bereits ein Redraw.
	*/
	public boolean setTextSize(int s) {
		if(textSize != s && s > 0) {
			textSize = s;
			redraw();
			return true;
		}
		return false;
	}
	
	/**
		Gibt den aktuellen Text zurück.
		@return Der aktuelle Text
	*/
	public String getText() {
		return text;
	}
	/**
		Setzt den darzustellenden Text auf den neuen Wert.
		@param s Der neue Text
		@return Gibt an, ob sich der Text geändert hat. Bei TRUE erfolgte bereits ein Redraw.
	*/
	public boolean setText(String s) {
		if(text != s) {
			text = s;
			redraw();
			return true;
		}
		return false;
	}
	
	/**
		Zeichnet das GreenfootImage des Labels erneut und zeigt es an.
	*/
	public void redraw() {
		GreenfootImage tI = new GreenfootImage(text,textSize,foreC,backC);
		if(text == "") {
			tI = new GreenfootImage(1,1);
			tI.setColor(new Color(0,0,0,0));
			tI.fill();
		}
		if(autoSize) {
			sx = tI.getWidth();
			sy = tI.getHeight();
		}
		GreenfootImage all = new GreenfootImage(sx,sy);
		all.setColor(backC);
		all.fill();
		all.drawImage(tI,(sx-tI.getWidth())/2,(sy-tI.getHeight())/2);
		setImage(all);
	}
}
