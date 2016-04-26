import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Diese Klasse stellt einen Button dar.
 * 
 * @author Felix Stupp
 * @version 26.04.2016
 */
public class Button extends GUI_Interface {
    
    ButtonEvent handler;
    
    /**
     * Erstellt einen Button mit dem gegebenen Objekt als Event-Handler.
     * 
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
    
}
