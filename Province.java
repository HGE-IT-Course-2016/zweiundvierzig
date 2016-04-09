import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Eine Provinz, die später weiter von der Karte/Spielwelt genutzt werden kann.
 * 
 * @author GruenerWal
 * @version 0.0.1
 */
public class Province extends Actor
{
    private int stars = 1;
    private String owner;
      
    /**
     * Act - do whatever the Province wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /**
         * - leer -
         * (Für später; falls die Provinz bestimmte Aktionen ausfüren sollte.)
         */
    }
    
    // Konstruktor, benötigt Sterne
    public Province(int s)
    {
        stars = s;
    }

    // Liefert die Sterne als Integer
    public int getStars()
    {
        return stars;
    }
    
    // Setzt die Sterne, benötigt Integer
    public void setStars(int s)
    {
        s = stars;
    }
    
    // Liefert den Owner als String
    public String getOwner()
    {
        return owner;
    }
    
    // Setzt den Owner, benötigt String
    public void setOwner(String o)
    {
        o = owner;
    }
    
}
