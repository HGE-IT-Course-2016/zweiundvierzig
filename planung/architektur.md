# Architekturplan Zweiundvierzig

**Version: 2**

**Stand: 10.04.2016** (TT.MM.JJJJ / DD.MM.YYYY)

[Hier die neuste offizielle Version vom Master-Branch sehen](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/architektur.md)

[Hier zur übersichtlicheren Funktionsliste](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/funktionsliste.md)

Hier ein möglicher Architekturplan von *Felix Stupp*.
Dieser Plan wird regelmäßig angepasst, oben am Datum zu erkennen.

Hier werden alle Klassen und deren öffentliche Methoden und Eigenschaften zusammengefasst.
Auch zu sehen ist der Author / sind die Authoren der Klasse, um bei Fragen diese kontaktieren zu können.

**Alle Anfragen aufgrund von Architekturänderungen erst an mich weitergeben, damit ich dies mit den jeweiligen Authoren besprechen kann!**
Die Authoren sollen nur Fragen zu bisher vorhandenen Methoden erhalten.

### Erklärung

Die englischen Begriffe *World* und *Actor* stehen für die gegebenen Oberklassen von Greenfoot.

### Generell

- Allgemein wird vom Konstruktor erwartet, dass er alle feste Eigenschaften einer Klasse in der Reihenfolge, wie hier in den Listen vorzufinden, und als die angegebenen Typen annimmt und korrekt speichert. Es kann aber auch spezifische Konstruktoren geben.

### Tipps

- Alle Klassen, die als Actor agieren, müssen teilweise mit ihrer Welt interagieren. Um diese richtig gleich richtig entgegen nehmen zu können und auf die Features zugreifen zu können, kann euch folgender Code Snippet helfen. Einfach einfügen und **getWorld()** wird euch besser helfen können.


	@Overrides private GeneralMap getWorld() {
		return (GeneralMap) super.getWorld();
	}

- Schaut bitte in die *Utils*-Klasse hinein, diese kann euch den Code übersichtlicher gestalten, da häufige Methoden in dieser gebündelt werden sollen.

### Explizite Eigenschaften

Explizite Eigenschaften sind speziell Eigenschaften, die von der Klasse selbst gehalten werden und bevorzugt auch nur von ihr festgehalten werden.

Beispiel:

Ein Spieler besitzt zwar Provinzen, nur ist dies eine Eigenschaft der Provinz und nicht vom Spieler.
Der Spieler kann mithilfe der Welt dann herausfinden, welche Provinzen ihm gehören.

## Inhalt

### Worlds

- *GeneralMap*
- Alle spezifischen Maps
	- *Map_World* (gesamte Weltkarte)
- *MainMenu*
- *GameOptions*

### Actors

- *Province* (von Achim)
- *Player*
- *Dice* (Würfel)

### Sonstige Actors (Control Elemente)

- *GUI_Interface*
- *Label*
- *Button*
	- *Menue_Button*
	- *Roll_Button*
- *CurrentPlayerArrow*

### Sonstige

- *Utils*

---

## MainMenu

Stellt eine *World* als Hauptmenü dar, bekommmt die Aufgabe, die einzelnen Menüpunkte anzuzeigen. Aktiviert gegebenenfalls andere *Worlds*.

---

## GameOptions

Eine *World*, welche das Optionsmenü vor dem Start eines Spiels anzeigt. Diese erstellt dann eine Weltkarte über **generateMap()** und übergibt diese Greenfoot als neue *World*.

---

## GeneralMap

Alle spezifischen Maps erben von dieser Oberklasse.
Diese Klasse ist für Greenfoot die aktive *World* im laufenden Spiel und auch für die Anzeigen links/rechts/unten verantwortlich.
Die erbenden Unterklassen legen dann das Hintergrundbild, die Provinzen, und weitere spezifische Eigenschaften der Karten dar.
Diese Oberklasse kümmert sich dabei um die Anzeigen, die Spielmechanik und die Speicherung der Spieler und Provinzen.

### Spezifischer Konstruktor

Für diese Klasse wird der Konstruktor nicht direkt von den Eigenschaften festgelegt, sondern muss folgende Argumente annehmen:

1. Spielerliste mit den Namen **String[]**
2. ...

### Explizite Eigenschaften

- Spielerliste (**Player[]**, der Index ist die Spieler ID, *anfangend bei 0*)
- Provinzliste (**Province[]**, der Index ist die Provinz ID, *anfangend bei 0*)
- aktueller Spieler (**int**)

### Zusätzliche Methoden

- **static GeneralMap generateMap(int mapID, ...)**

- **int getPlayerCount()**
- **String getPlayerName()**
- **String getPlayerName(int)**
- **int getPlayerStars()**

- **int getProvinceOwner(int)**
- **int[] getProvinceOwners()**
- **int getProvinceEntityCount(int)**
- **int getProvincesEntityCounts(int[])**
- **int getProvincesEntityCounts(boolean[])**
- **int getProvincesEntityCounts(int)**

#### generateMap()

Diese statische Funktion generiert eine Map mit der gegebenen ID. Die **...**-Argumente sind dabei alle Argumente, die an dessen Konstruktor weitergegeben werden müssen.

#### getPlayerCount()

Gibt die Anzahl der im Spiel vorhandenen Spieler aus.

#### getPlayerName()

Gibt den Namen des gegebenen Spielers aus. Muss Fehler durch falschen Indexen ausweichen. Falls kein Wert oder ein ungültiger übergeben wird, soll stattdessen der Name des aktuellen Spielers zurückgegeben werden.

#### getPlayerStars()

Diese Funktion soll die Anzahl der Sterne des aktuellen Spielers zurückgeben.

#### getProvinceOwner()

Gibt die Spieler ID von dem Spieler aus, dem die Provinz gehört. Bei falschen Indexen muss eine -1 (kein Spieler) zurückgegeben werden.

#### getProvinceOwners()

Gibt ein Array mit allen Provinzen (deren ID als Indexen) und den Spieler IDs als Wert aus.

#### getProvinceEntityCount()

Gibt die Anzahl der Einheiten aus einer bestimmten Provinz zurück. Bei falschen Indexen muss eine 0 zurückgegeben werden.

#### getProvincesEntityCounts()

Zählt die Einheiten aus mehreren Provinzen zusammen und gibt die Summe davon aus.

Die **int[]** Variante bekommt dabei in einem Array als Werte die IDs der Provinzen, von denen sie es zählen soll, unabhängig vom Besitzer.

Die **boolean[]** Variante bekommt ein Array, bei dem die Indexen die Provinzen angeben und der **boolean**-Wert, ob diese Provinz mitgezählt werden soll.

Die **int** Variante bekommt nur die ID des Spielers und zählt dabei alle Einheiten, die er besitzt.

---

## Spezifische Maps

Alle Maps erben von *GeneralMap*

### Spezifischer Konstruktor

Die Konstruktoren der Unterklassen rufen erst mit den gegebenen Argumenten den *super*-Konstruktor auf, um danach die spezifischen Dinge festlegen zu können (Provinzen bspw.)

---

## Province

Wird verwaltet von Achim.
Speichert Informationen zu den einzelnen Provinzen ab und stellt diese später auch als *Actor* dar.

### Explizite Eigenschaften

- Provinznummer (über Konstruktor festgelegt, **int**)
- Kontinentnummer (über Konstruktor festgelegt, **int**)
- X/Y-Position auf der Karte (über Konstruktor festgelegt; **int**,**int**)
- Anzeigename (über Konstruktor festgelegt, **String**)
- Sterne (über Konstruktor festgelegt, **int**)
- Angrenzende Provinzen (über Konstruktor als **int[]** festgelegt, als **boolean[]** gespeichert)
- Besitzer
- Einheitenanzahl

#### Provinz-ID und Kontinent-ID

- Stellt die ID der Provinz dar und ist mit **int getID()** abrufbar.
- Stellt die ID des Kontinentes dar und ist mit **int getContinentID()** abrufbar.

#### Position

Diese zwei Werte legen fest, wo die sichtbaren Eigenschaften der Provinz angezeigt werden sollen.
Sind nach dem Erstellen der Provinz nicht mehr abrufbar.

#### Anzeigename

Dies ist der Name, der auf der Karte und bei Events im Zusammenhang mit dieser Provinz angezeigt wird.

Kann über **String getDisplayName()** abgerufen werden, falls benötigt.

#### Sterne

Dieser Wert wird für die zufällige Verteilung von Einheiten benötigt (laut Achim).

Über **int getStars()** soll dieser Wert abrufbar sein.

#### Angrenzende Provinzen

Dies ist ein Array von allen Provinzen, die es gibt (Provinznummer als Index), diese jeweils mit einem **Boolean**-Wert, der festlegt, ob ein Kampf oder ein Weitergeben von Einheiten möglich ist.

	boolean[] nearProvinces;

Dem Konstruktor kann stattdessen auch ein **int[]** mit allen angrenzenden Provinzen als Werte übergeben werden, dieses wird dann automatisch konvertiert.

Über die Methode **boolean isProvinceNear(int)** kann man sich die Einträge einzeln als Booleans ausgeben lassen.

#### Besitzer

Über die Methode **int getOwner()** bekommt ihr den aktuellen Besitzer zurück (-1 = keiner, 0 = Spieler 1, ...).

Die Methode **boolean setOwner(int)** speichert einen neuen Besitzer ab. Sie gibt den Erfolg des Setzens zurück, falls also die Zahl kleiner -1 oder größer gleich als die Spieleranzahl sein sollte, wird die Änderung nicht durchgeführt und es wird **false** zurückgegeben.

#### Einheitenanzahl

Diese Eigenschaft speichert, wie viele Einheiten auf diesem Feld stehen (natürlich welche, die dem Besitzer gehören).

Die Methoden **int getEntityCount()**, **int addToEntities(int)**, **int removeFromEntities(int)** und **int setEntityCount(int)** sollten genügend Möglichkeiten für Änderungen bieten.
Alle Methoden geben nach ihrem Aufruf den nun aktuellen Wert zurück.

### Zusätzliche Methoden

- **redrawProvince()**

#### redrawProvince

Wird von der Karte oder von internen Methoden aufgerurfen, um alle sichtbaren Eigenschaften erneut zu zeichnen.

---

## Player

Stellt die Spieler da, speichert Informationen zu diesen ab. Wird von der Weltkarte als *Actor* behandelt.

### Explizite Eigenschaften

- Spielernummer (über Konstruktor festgelegt, **int**)
- Anzeigename (über Konstruktor festgelegt, **String**)
- Sternanzahl
- Statistiken
	1. Eroberte Provinzen
	2. Verlorene Provinzen
	3. Einflussmaximum (maximale Provinzenanzahl, nach einem Zug zu überprüfen)
	4. Bekommene Einheiten
	5. Verlorene Einheiten
	6. Maximale Einheitenanzahl (nach einem Zug zu überprüfen)

#### Spielernummer

Wird bei der Welt intern benötigt und stellt die Position im Menü und in den Arrays an.

**int getID()** gibt diese wieder zurück.

#### Anzeigename

Ist der lesbare Name des Spielers, damit nicht nur "Spieler 1", ... usw. zu sehen ist.

**String getDisplayName()** gibt diesen zurück.

#### Sternanzahl

Die Anzahl der Sterne, die ein Spieler besitzt und gegebenenfalls dann in Einheiten umtauschen kann.

**int getStars()**, **int addToStars(int)**, **int removeFromStars(int)**, **int setStars(int)** sind zum Bearbeiten des Werts da. Auch sie geben danach den nun aktuellen Wert zurück.

**boolean canStarsRemoved(int)** gibt zurück, ob der Spieler diese Anzahl an Sternen verwenden kann (Vereinfachung).

#### Statistik

Die Statistik soll Events festhalten, um nach einem Spiel verschiedene Werte einsehen zu können. Diese werden von der Welt mit speziellen Funktionen erhöht. Zurückgegeben sollen diese als **int[]**-Array in der Reihenfolge, wie sie oben in der Liste auftretten. Es wird auch vorgeschlagen, sie so zu speichern.

**int[] getStatistics()** gibt diese Liste zurück, damit sie von der Welt angezeigt werden kann.

**gotProvince()**, **lostProvince()**, **gotEntities(int)**, **lostEntity()**

### Zusätzliche Methoden

- **boolean[] getMyProvinces()**
- **int getProvinceCount()**
- **redrawPlayer()**

#### getMyProvinces()

Diese Methode hat die Aufgabe, eine Liste aller Provinzen zurückzugeben, wobei jede Provinz mit einem **boolean**-Wert gesagt bekommt, ob sie dem Spieler gehört oder nicht.

Diese Methode muss zwingend mit der Welt interagieren, um diese Informationen zu bekommen.

#### getProvinceCount()

Gibt die Anzahl der Provinzen, die der Spieler hat, zurück. Gut für die Statistik und die Anzeigen.

#### redrawPlayer()

Erzwingt das erneute Zeichnen des Player Objekts, um alle sichtbaren Eigenschaften erneut zu zeichnen.

---

## Dice

Stellt einen Würfel als *Actor* dar (vergleichbar mit dem Würfel aus dem Spiel 10000).

### Eigenschaften

- Augenzahl

#### Augenzahl

Diese Zahl zeigt der Würfel gerade an und kann mit **int getNumber()** abgerufen werden.

### Zusätzliche Methoden

- **int roll()**

#### roll()

Berechnet eine Zufallszahl von 1 bis 6, speichert diese ab und gibt sie auch so gleich zurück. Ändert auch die Anzeige des Würfels.

---

## GUI_Interface

Die Oberklasse für alle Interfaces.

Besitzt noch keine relevanten Eigenschaften

---

## Label

Zeigt einen Text auf dem Bildschirm an. Zuvor wurde dieses Objekt "Text" genannt, "Label" ist der fachlichere Ausdruck dafür.

### Eigenschaften

- Anzeigetext (**String**; kann vom Konstruktor entgegen genommen werden, sonst ist der Standardtext "" zu sehen)

#### Anzeigetext

Dieser Text wird von dem Actor aus zu sehen sein.
Mit **String getText()** und **String setText(String)** bekommt Zugriff darauf.

---

## Button

Die Hauptklasse für Buttons, wird durch Erbung spezifiziert.

---

## Utils

Eine finale Klasse mit vielen kleinen Methoden, die den restlichen Code verkleinern und besser lesbar gestalten soll. Ergänzungen in Form von eigenen Funktionen dürfen selbst eingebracht werden.

### copyArray()

Kopiert ein Array des Types **boolean**, **int** oder **String** mit identischer Größe.