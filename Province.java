import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Province here.
 * 
 * @author GruenerWal
 * @version 0.0.1
 */
public class Province extends Actor
{
    private int stars = 1;
    private String displayName;
    private String owner;

    /**
     * leere Act-Methode
     * (Für später; falls die Provinz bestimmte Aktionen ausführen sollte.)
     */
    public void act() 
    {

    }

    // Konstruktor, benötigt Sterne
    public Province(int s, String d)
    {
        stars = s;
        displayName = d;
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
