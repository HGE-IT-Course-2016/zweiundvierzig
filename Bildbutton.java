import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.awt.Graphics2D;

/**
	Diese Klasse stellt einen Button dar.
	Als funktionelles Vorbild dafür hält der Button aus dem .NET-Framework für UWP-Apps dar.

	@author Felix Stupp
	@version 20.05.2016
*/
public class Bildbutton extends GUI_Interface {
	
	private boolean autoSize = false;
	protected GreenfootImage picture = new GreenfootImage(1,1);
	
	private ButtonEvent handler;
	
	/**
		Erstellt einen Button mit dem gegebenen Text und der zugehörigen Textgröße.
		@param txt Der Text, den der Button darstellen soll.
		@param size Die Textgröße, in der der Button den Text darstellen soll.
	*/
	public Bildbutton(GreenfootImage pict) {
		picture = pict;
	    redrawInternal();
	}
	/**
		Erstellt einen Button mit dem gegebenen Objekt als Event-Handler.
		@param h Der Handler mit dem Interface ButtonEvent implementiert.
	*/
	public Bildbutton(ButtonEvent h) {
		handler = h;
	    redrawInternal();
	}
	/**
		Erstellt einen Button mit dem gegebenen Text, der zugehörigen Textgröße und dem gegebenen Objekt als Event-Handler.
		@param txt Der Text, den der Button darstellen soll.
		@param size Die Textgröße, in der der Button den Text darstellen soll.
		@param h Der Handler mit dem Interface ButtonEvent implementiert.
	*/
	public Bildbutton(GreenfootImage pict, ButtonEvent h) {
		picture = pict;
		handler = h;
	    redrawInternal();
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
		Gibt den aktuellen Text zurück.
		@return Der aktuelle Text
	*/
	public GreenfootImage getPicture() {
		return picture;
	}
	/**
		Setzt den darzustellenden Text auf den neuen Wert.
		@param s Der neue Text
		@return Gibt an, ob sich der Text geändert hat. Bei TRUE erfolgte bereits ein Redraw.
	*/
	public boolean setPicture(GreenfootImage s) {
		if(picture != s) {
			picture = s;
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
	
	protected void redrawInternal() {
		GreenfootImage tI = picture;
		if(autoSize) {
			sx = tI.getWidth() + (6 * 2) + 4;
			sy = tI.getHeight() + (6 * 2) + 4;
		}
		GreenfootImage all = new GreenfootImage(sx,sy);
		Color trans = new Color(0,0,0,0);
		all.setColor(trans);
		all.fill();
		Graphics2D g = all.getAwtImage().createGraphics();
		g.setColor(backC);
		g.fillRoundRect(0,0,sx,sy,24,24);
		all.drawImage(tI,(sx-tI.getWidth())/2,(sy-tI.getHeight())/2);
		setImage(all);
	}
	
	/**
		Zeichnet das GreenfootImage des Buttons erneut und zeigt es an.
	*/
	public void redraw() {
	    redrawInternal();
	}
}
