# Funktionsliste Zweiundvierzig

**Letztes Update: 04.06.2016** (TT.MM.JJJJ / DD.MM.YYYY)

[Hier die offizielle Version vom Master-Branch sehen](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/funktionsliste.md)

[Hier zum gesamten Architekturplan auf dem aktuellen Branch](architektur.md)

Hier einfach eine grobe Übersicht über alle Methoden und eventuellen Variabled, die jede Klasse als *public* oder *protected* besitzen soll beziehungsweise bereits besitzt.
Weitere Informationen zu den Methoden findet ihr in der Architektur oder, falls die Methoden bereits vorhanden ist, in der Dokumentation, die von Greenfoot automatisch erstellt wird (durch die InCode Dokumentation).

Falls euere Aufgabe die Umsetzung einer Methode ist, die hier bereits beschrieben wird, müsst ihr nicht diesselben Parameterbezeichner verwenden, wie sie hier verwendet wurden. Falls aus diesem Bezeichner jedoch nicht mehr die Bedeutung des Parameters ausgeht, muss dies in einem Java-Documentation Kommentar erklärt werden.

Dies könnt auch als Checkliste nehmen, um zu sehen, ob ihr bereits alle Methodenn im Code präsent habt.

## GeneralMap

- *GeneralMap* ( *String* backgroundImage, *String[]* playerList, *int[]* colorList )

- protected *void* **addProvinceToMap** ( *Province* province )

- *int* **getPlayerCount** ()
- *String* **getPlayerName** ()
- *String* **getPlayerName** ( *int* playerID )
- *int* **getPlayerStars** ()

- *int* **getProvinceOwner** ( *int* provinceID )
- *int[]* **getProvinceOwners** ()
- *int* **getProvinceEntityCount** ( *int* playerID )

## Province

- *Province* ( *int* provinceID, *int* continentID, *int* xPos, *int* yPos, *String* displayName, *int* stars, *int[]* neighbourProvinces )

- *int* **getID** ()
- *int* **getContinentID** ()
- *String* **getDisplayName** ()
- *int* **getStars** ()

- *boolean* **isProvinceNear** ( *int* provinceID )

- *int* **getOwner** ()
- *boolean* **setOwner** ( *int* playerID )

- *int* **getEntityCount** ()
- *int* **addToEntities** ( *int* entityCountToAdd )
- *int* **removeFromEntities** ( *int* entityCountToRemove )
- *int* **setEntityCount** ( *int* newEntityCount)

- *boolean* **hasClicked** ()

- *void* **redrawProvince** ()

## Player

- *Player* ( *int* playerID, *String* displayName, *int* playerColor )

- *int* **getID** ()
- *String* **getDisplayName** ()

- *int* **getStars** ()
- *int* **addToStars** ( *int* starsToAdd )
- *int* **removeFromStars** ( *int* starsToRemove )
- *int* **setStars** ( *int* newStarsCount )
- *boolean* **canStarsRemoved** ( *int* requiredStarsCount )

- *int[]* **getStatistics** ()
	- *void* **gotProvince** ()
	- *void* **lostProvince** ()
	- *void* **gotEntities** ( *int* addedEntities )
	- *void* **lostEntity** ()

- *boolean[]* **getMyProvinces** ()
- *int* **getProvinceCount** ()
- *void* **redrawPlayer** ()

## Dice

- *Dice* ()

- *int* **getNumber** ()

- *int* **roll** ()

## GUI_Interface

- protected *int* **sx**
- protected *int* **sy**

- *int* **getWidth** ()
- *int* **getHeight** ()
- *void* **setSize** ( *int* width , *int* height )

- *java.awt.Color* **getBackColor** ()
- *boolean* **setBackColor** ( *java.awt.Color* newBackColor)
- *java.awt.Color* **getForeColor** ()
- *boolean* **setForeColor** ( *java.awt.Color* newForeColor)

- abstract *void* **redraw** ()

## Label (erweitert GUI_Interface)

- *Label* ( *String* text, *int* textSize )

- *boolean* **getAutoSize** ()
- *void* **setAutoSize** ( *boolean* newValue )
- *int* **getTextSize** ()
- *boolean* **setTextSize** ( *int* newSize )
- *String* **getText** ()
- *boolean* **setText** ( *String* newText )

- *void* **redraw** ()

## Button (erweitert GUI_Interface)

- *Button* ( *String* text, *int* textSize )
- *Button* ( *ButtonEvent* eventHandler )
- *Button* ( *String* text, *int* textSize, *ButtonEvent* eventHandler )

- *boolean* **getAutoSize** ()
- *void* **setAutoSize** ( *boolean* newValue )
- *int* **getTextSize** ()
- *boolean* **setTextSize** ( *int* newSize )
- *String* **getText** ()
- *boolean* **setText** ( *String* newText )

- *ButtonEvent* **getHandler** ()
- *void* **setHandler** ( *ButtonEvent* newEventHandler )
- *void* **removeHandler** ()

- *void* **redraw** ()