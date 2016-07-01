import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import javax.swing.JOptionPane;

/**
 * Write a description of class ArmyPlacer here.
 * 
 * @author GruenerWal, MaxiJohl
 * @version 1.0.0
 */
public class ArmyPlacer extends Map_World
{

    int freeArmies = -1;

    /**
     * Constructor for objects of class ArmyPlacer.
     * 
     */
    public ArmyPlacer(String[] a1, int[] a2)
    {
        super(a1,a2);
        // Hi.
        // Dies
        // ist
        // ein
        // unnützer
        // Kommentar
        // um
        // Zeilen
        // zu
        // farmen
        // :)
        // Mit
        // freundlichen
        // Grüßen
        // ,
        // GruenerWal
        //
        //
        //
        // I'll be back.
    }

    public int calculateArmies()
    {
        int armiesToPlace;
        Province[] continentArray;
        boolean continentChecked = false;

        // 1. ArmyMinimum einbeziehen
        armiesToPlace = armyMinimum;

        // 2. Einheiten durch Provinzen einbeziehen
        armiesToPlace = armiesToPlace + Math.round(players[currentPlayer].getProvinceCount() / 3);
        System.out.println("Einheiten nach Provinz hinzugefügt");

        // 3. Einheiten durch Kontinente

        // Kontinente durchgehen
        for ( int i = 1; i < continentBoni.length; i++ )
        {

            continentArray = giveContinentArray(i);

            // Provinzen des aktuellen Kontinents durchgehen
            for ( int p = 1; p >= continentArray.length; p++ )
            {

                // Prüfen, ob eine Provinz NICHT dem aktuellen Spieler gehört
                if ( continentArray[p].getOwner() != currentPlayer )
                {
                    break;
                }

                // Wenn nicht, wird der Kontinent als gecheckt markiert
                else
                {
                    continentChecked = true;
                }

            }

            if ( continentChecked == true )
            {
                armiesToPlace = armiesToPlace + continentBoni[i];
                continentChecked = false;
                System.out.println("Kontinent-Boni vergeben");
            }

            else
            {
                System.out.println("Keine Kontinent-Boni vergeben");
            }
        }

        // 4. Einheiten durch Sterne
        if ( players[currentPlayer].getStars() > 0)
        {
            String toUseString = JOptionPane.showInputDialog(null, "Wieviele Sterne willst du verwenden?");
            int starsToUse = Utils.StringToInt(toUseString);
            int[] starBoni = new int [] {1,2,4,7,10,13,17,21,25,30};

            if ( starsToUse > 0 && starsToUse < 11 )
            {
                armiesToPlace = armiesToPlace + starBoni[starsToUse -1];
            } 

            if ( starsToUse < 0 && starsToUse > 10 )
            {
                JOptionPane.showMessageDialog(null,"Ungültige Zahl. Bitte eine Zahl zwischen 0 und 10 eingeben");
            }
        }

        return armiesToPlace;
    }

    public Province[] giveContinentArray(int cID)
    {
        Province[] savedProvinces = new Province[provinceCount +1];
        Province[] continentProvinces;
        int c = 0;
        for (int i = 1; i <= provinceCount; i++)
        {
            if (provinces[i].getContinentID() == cID)
            {
                savedProvinces[i] = provinces[i];
                c++;
            }
        }

        if ( c < 1 )
        {
            return null;
        }

        else
        {
            return Utils.cutArray(savedProvinces);
        }

    }

    public void placeArmies()
    {
        if ( freeArmies == -1 )
        {
            freeArmies = calculateArmies();
        }

        for ( int i = 1; i <= (provinces.length - 1); i++) {
            if (provinces[i].hasClicked() == true && provinces[i].getOwner() == currentPlayer)
            {
                String toUseString = JOptionPane.showInputDialog(null, "Wieviele Einheiten willst du setzen? Du hast noch" + freeArmies + "freie Einheiten.");
                int armiesToUse = Utils.StringToInt(toUseString);

                if (armiesToUse <= freeArmies)
                {
                    provinces[i].addToEntities(armiesToUse);
                    freeArmies = freeArmies- armiesToUse;
                }

            }
        }

    }
    
    public void act()
    {
        placeArmies();
    }
}
