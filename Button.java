import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
	Diese Klasse stellt einen Button dar.
	Als funktionelles Vorbild dafür hält der Button aus dem .NET-Framework für UWP-Apps dar.

	@author Felix Stupp
	@version 20.05.2016
*/
public class Button extends GUI_Interface {
	
	private boolean autoSize = false;
	private int textSize = 32; // as default text size
	private String text = "";
	
	private ButtonEvent handler;
	
	/**
		Erstellt einen Button mit dem gegebenen Text und der zugehörigen Textgröße.
		@param txt Der Text, den der Button darstellen soll.
		@param size Die Textgröße, in der der Button den Text darstellen soll.
	*/
	public Button(String txt, int size) {
		text = txt;
		textSize = size;
		redraw();
	}
	/**
		Erstellt einen Button mit dem gegebenen Objekt als Event-Handler.
		@param h Der Handler mit dem Interface ButtonEvent implementiert.
	*/
	public Button(ButtonEvent h) {
		handler = h;
		redraw();
	}
	/**
		Erstellt einen Button mit dem gegebenen Text, der zugehörigen Textgröße und dem gegebenen Objekt als Event-Handler.
		@param txt Der Text, den der Button darstellen soll.
		@param size Die Textgröße, in der der Button den Text darstellen soll.
		@param h Der Handler mit dem Interface ButtonEvent implementiert.
	*/
	public Button(String txt, int size, ButtonEvent h) {
		text = txt;
		textSize = size;
		handler = h;
		redraw();
	}
	
	/**
		Fragt ab, ob ein Klick auf den Button gekommen ist.
		Wird intern von Greenfoot benötigt.
	*/
	public void act() {
		if(Greenfoot.mouseClicked(this) && handler != this) {
			handler.buttonClicked(this);
		}
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
		Gibt den aktuellen EventHandler des Buttons zurück.
		@return Der Handler als ButtonEvent
	*/
	public ButtonEvent getHandler() {
		return handler;
	}
	/**
		Setzt den EventHandler auf ein neues Objekt.
		@param h Der Handler mit implementiertem ButtonEvent-Interface
	*/
	public void setHandler(ButtonEvent h) {
		handler = h;
	}
	/**
		Entfernt den aktuellen EventHandler, um die Ausführung zukünftiger Events zu verhindern.
	*/
	public void removeHandler() {
		handler = null;
	}
	
	/**
		Zeichnet das GreenfootImage des Buttons erneut und zeigt es an.
	*/
	public void redraw() {
		GreenfootImage tI = new GreenfootImage(text,textSize,foreC,backC);
		if(autoSize) {
			sx = tI.getWidth() + (6 * 2) + 4;
			sy = tI.getHeight() + (6 * 2) + 4;
		}
		GreenfootImage all = new GreenfootImage(sx,sy);
		Color gray = new Color(133,133,133,255);
		Color black = new Color(0,0,0,255);
		Color trans = new Color(0,0,0,0);
		Utils.drawInsideRectangle(all,gray,0);
		Utils.drawInsideRectangle(all,black,2);
		Utils.drawInsideRectangle(all,gray,6);
		Utils.drawInsideRectangle(all,black,7);
		all.setColorAt(0,0,trans);
		all.setColorAt(sx-1,0,trans);
		all.setColorAt(0,sy-1,trans);
		all.setColorAt(sx-1,sy-1,trans);
		all.drawImage(tI,(sx-tI.getWidth())/2,(sy-tI.getHeight())/2);
		setImage(all);
	}
}
