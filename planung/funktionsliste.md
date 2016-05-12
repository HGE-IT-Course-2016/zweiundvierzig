# Funktionsliste Zweiundvierzig

**Version: 3**

**Stand: 12.05.2016** (TT.MM.JJJJ / DD.MM.YYYY)

[Hier die neuste offizielle Version vom Master-Branch sehen](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/funktionsliste.md)

[Hier zum gesamten Architekturplan](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/architektur.md)

Hier einfach eine grobe Übersicht über alle Funktionen, die jede Klasse als Public / Protected besitzen soll beziehungsweise bereits besitzt.
Weitere Informationen zu den Funktionen findet ihr in der Architektur oder, falls die Funktion bereits vorhanden ist, in der Dokumentation, die von Greenfoot automatisch erstellt wird (durch die InCode Dokumentation).

Dies könnt auch als Checkliste nehmen, um zu sehen, ob ihr bereits alle Funktionen im Code präsent habt.

## GeneralMap

- static *GeneralMap* **generateMap** ( *int* mapID, ... )

- *int* **getPlayerCount** ()
- *String* **getPlayerName** ()
- *String* **getPlayerName** ( *int* )
- *int* **getPlayerStars** ()

- *int* **getProvinceOwner** ( *int* )
- *int[]* **getProvinceOwners** ()
- *int* **getProvinceEntityCount** ( *int* )
- *int* **getProvincesEntityCounts** ( *int[]* )
- *int* **getProvincesEntityCounts** ( *boolean[]* )
- *int* **getProvincesEntityCounts** ( *int* )

## Province

- *Province* ( *int*, *int*, *int*, *int*, *int*, *String*, *int[]* )
- *Province* ( *int*, *int*, *int*, *int*, *int*, *String*, *boolean[]* )

- *int* **getID** ()
- *int* **getContinentID** ()
- *String* **getDisplayName** ()
- *boolean* **isProvinceNear** ( *int* )

- *int* **getStars** ()

- *int* **getOwner** ()
- *void* **setOwner** ( *int* )

- *int* **getEntityCount** ()
- *int* **addToEntities** ( *int* )
- *int* **removeFromEntities** ( *int* )
- *int* **setEntityCount** ( *int* )

- *void* **redrawProvince** ()

## Player

- *Player* ( *int*, *String* )

- *int* getID ()
- *String* **getDisplayName** ()
- *int* **getStars** ()
- *int* **addToStars** ( *int* )
- *int* **removeFromStars** ( *int* )
- *int* **setStars** ( *int* )
- *boolean* **canStarsRemoved**( *int* )

- *int[]* **getStatistics** ()
- *void* **gotProvince** ()
- *void* **lostProvince** ()
- *void* **gotEntities** ( *int* )
- *void* **lostEntity** ()

- *boolean[]* **getMyProvinces** ()
- *int* **getProvinceCount** ()
- *void* **redrawPlayer** ()

## Dice

- *Dice* ()

- *int* **getNumber** ()

- *int* **roll** ()

## GUI_Interface

- *int* **getWidth** ()
- *int* **getHeight** ()
- *void* **setSize** ( *int*, *int* )

- *System.awt.Color* **getBackColor** ()
- *boolean* **setBackColor** ( *System.awt.Color* )
- *System.awt.Color* **getForeColor** ()
- *boolean* **setForeColor** ( *System.awt.Color* )

- abstract *void* **redraw** ()

## Label (erweitert GUI_Interface)

- *Label* ( *String*, *int* )

- *boolean* **getAutoSize** ()
- *boolean* **setAutoSize** ( *boolean* )

- *int* **getTextSize** ()
- *boolean* **setTextSize** ( *int* )

- *String* **getText** ()
- *boolean* **setText** ( *String* )

## Button (erweitert GUI_Interface)

- *Button* ( *String*, *int* )
- *Button* ( *ButtonEvent* )
- *Button* ( *String*, *int*, *ButtonEvent* )

- *boolean* **getAutoSize** ()
- *boolean* **setAutoSize** ( *boolean* )

- *int* **getTextSize** ()
- *boolean* **setTextSize** ( *int* )

- *String* **getText** ()
- *boolean* **setText** ( *String* )

- *ButtonEvent* **getHandler** ()
- *void* **setHandler** ( *ButtonEvent* )
- *void* **removeHandler** ()