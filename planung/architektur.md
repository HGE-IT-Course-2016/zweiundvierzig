# Architekturplan Zweiundvierzig

**Letztes Update: 02.06.2016** (TT.MM.JJJJ / DD.MM.YYYY)

[Hier die offizielle Version vom Master-Branch sehen](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/architektur.md)

[Hier zur übersichtlicheren Funktionsliste auf dem aktuellen Branch](funktionsliste.md)

Dieser Plan wird verfasst und regelmäßig gepflegt durch *Felix Stupp*. Das Alter der vorliegenden Version ist am Datum am Dateianfang zu erkennen.

Hier werden alle Klassen mit deren öffentliche Methoden (**public** und **protected**) und den vorgesehenen Eigenschaften (meist nur **private**) festgehalten.

**Alle Anfragen aufgrund von Architekturänderungen erst an mich weitergeben, damit ich dies mit den jeweiligen Autoren besprechen kann!**
Die Autoren sollen nur Fragen zu bisher vorhandenen Methoden erhalten.

### Wichtige Infos

- **Bitte kommentiert all eure Methoden nach dem Java-Standard, damit diese in der automatisch generierten Dokumentation auch mit einer kurzen Erklärung auftauchen.**
- **Die Provinz-ID und somit auch die Indexe der Arrays beginnen dafür erst bei 1!**

### Erklärungen

Die englischen Begriffe *World* und *Actor* stehen für die gegebenen Oberklassen von Greenfoot.

Alle Methoden sind meist als **public** zu sehen und werden hauptsächlich von anderen Klassen aufgerufen.

#### Abkürzungen

- **GUI** ([Graphical User Interface](https://de.wikipedia.org/wiki/Grafische_Benutzeroberfl%C3%A4che)): Beschreibt die Möglichkeit, durch welche ein Benutzer gewöhnlicherweise mit Programmen interagieren kann.

### Tipps

- Falls euere Aufgabe die Umsetzung einer Methode ist, die hier bereits beschrieben wird, müsst ihr nicht diesselben Parameterbezeichner verwenden, wie sie hier verwendet wurden. Falls aus diesem Bezeichner jedoch die Bedeutung des

- Alle Klassen, die als Actor agieren und **nur** in der auf der *GeneralMap* beziehungsweise der Unterklassen dieser Klasse eingesetzt werden, müssen teilweise mit dieser Welt interagieren. Um die aktuelle Welt sofort im richtigen Typ zu bekommen, damit auf unsere Funktionen zugegriffen werden können, kann euch folgender Code Snippet helfen. Einfach in die Klassen einfügen einfügen und **getWorld** () wird euch besser helfen können.


	@Override public GeneralMap getWorld() {
		return (GeneralMap) super.getWorld();
	}
- Arbeitet bitte, wenn möglich, mit der *Utils*-Klasse, diese kann helfen den Code übersichtlicher und kürzer zu gestalten, da häufige und allgemein umsetzbare Aufgaben über diese einheitlich abgearbeitet werden sollen. Das Debuggen wird somit auch einfacher, sowohl für mich als auch für euch selbst.

- Ihr könnt auch ab und zu in die Dokumentationen der offiziellen Java-Bibliotheken schauen, falls ihr denkt, dass es bereits eine Methode geben sollte für den Vorgang, den ihr sonst selbst programmieren müsstet.

## Klassenverzeichnis

### Worlds

- World für den Spielstart
- *GeneralMap*
- Alle spezifischen Maps
	- *Map_World* (gesamte Weltkarte)

### Actors

- *Province*
- *Player*
- *Dice*

### GUI Objekte

- *GUI_Interface*
- *Label*
- *Button*

### Sonstige

- *Utils*

---

## Spielstart

Diese *World* hat die Aufgabe, zum einen den Titelbildschirm (mit einem schönen Hintergrundbild, welches später noch optional gezeichnet wird) des Spiels anzeigt, daraufhin ein Menü mit den Möglichkeiten, ein Spiel zu starten oder zu laden (der Button für das Laden eines Speicherstand's bleibt vorerst ohne Funktion, auch optional geplant). Beim Erstellen eines neuen Spiels soll man sowohl die Möglichkeit bekommen, die Eigenschaften der Spieler und die der Map auszuwählen.

Dies kann entweder in verschiedenen *World*'s gelöst werden, als auch in einer einzelnen. Dies bleibt euch zusammen mit dem Design diesem Menü überlassen.

Ich schlage euch vor, die bereits von mir erstellen Steuerelemente *Label* und *Button* zu verwenden. Diese sollten die Arbeit für euch wesentlich erleichtern, genauso wie das Schreiben von neuen Steuerelementen, falls ihr bemerken sollte, dass ihr diese öfters braucht als einmal. Diese sollten dann auch selbst von der Oberklasse *GUI_Interface* erben.

---

## GeneralMap

Alle spezifischen Maps erben von dieser Oberklasse.
Diese Klasse ist für Greenfoot die aktive *World* im laufenden Spiel und auch für die Anzeigen links/rechts/unten verantwortlich.
Die erbenden Unterklassen legen dann das Hintergrundbild, die Provinzen, und weitere spezifische Eigenschaften der Karten dar.
Diese Oberklasse kümmert sich dabei um die Anzeigen, die Spielmechanik und die Speicherung der Spieler und Provinzen.
Auch, wenn diese Klasse einen Konstruktor besitzt, ist dieser nur für die Unterklassen, also für die spezifischen Maps, als Vereinfachung gedacht.

### Konstruktorparameter

1. Der Dateiname des Hintergrundbildes der Karte als *String*
2. Spielerliste mit den Namen als *String[]*

#### Hintergrundbild

Dies soll von den Konstruktoren der spezifischen Maps weitergegeben werden. Der Dateiname ist dort jeweils angepasst und direkt im Code als Konstante angegebenen. Diese Oberklasse übernimmt dann alle Aktionen, um es im Hintergrund der GUI Grafik anzuzeigen.

### Vorgesehene Eigenschaften

- Spielerliste (*Player[]*, der Index entspricht der Spieler ID, *anfangend bei 0*)
- Provinzliste (*Province[]*, als **protected** definiert, der Index entspricht der Provinz ID, *anfangend bei 1*)

#### Spielerliste

Diese Liste soll alle *Player*-Objekte für die Spieler enthalten, welche dann auch als Actor links von der Karte zu sehen sein sollten.

#### Provinzliste

Die Provinzliste enthält alle Provinzobjekte, die auf der Karte zu sehen sind. Diese wird erst vom Konstruktor der spezifischen Maps gefüllt.

### Protected Methoden

- *void* **addProvinceToMap** ( *Province* province )

#### addProvinceToMap()

Diese Methode soll das Hinzufügen der Provinzen, sowohl in das Array, als auch an die richtige Position auf der *World* übernehmen. Sollte eine Provinz-ID zweimal verwendet werden sollen, wird diese Methode einen Fehler auslösen!

### Public Methoden

- *int* **getPlayerCount** ()
- *String* **getPlayerName** ()
- *String* **getPlayerName** ( *int* playerID )
- *int* **getPlayerStars** ()

- *int* **getProvinceOwner** ( *int* )
- *int[]* **getProvinceOwners** ()
- *int* **getProvinceEntityCount** ( *int* playerID )

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

Gibt die Anzahl der Einheiten von einer bestimmten Provinz zurück. Bei falschen Indexen muss eine 0 zurückgegeben werden.

---

## Spezifische Maps

Alle Maps erben von *GeneralMap*

### Spezifischer Konstruktor

Die Konstruktoren der Unterklassen rufen erst mit den gegebenen Argumenten den *GeneralMap*-Konstruktor auf, um danach die spezifischen Dinge festlegen zu können (Provinzen beispielsweise).

---

## Province
*extends Actor*

Speichert Informationen zu den einzelnen Provinzen ab und stellt diese später auch als *Actor* dar.

### Konstrukturparameter

- Provinznummer *int*
- Kontinentnummer *int*
- X-Position auf der Karte *int*
- Y-Position auf der Karte *int*
- Anzeigename  *String*
- Sterne *int*
- Angrenzende Provinzen *int[]* (als *boolean[]* gespeichert)

#### Provinz-ID und Kontinent-ID

- Stellt die ID der Provinz dar und ist mit *int* **getID** () abrufbar.
- Stellt die ID des Kontinentes dar und ist mit *int* **getContinentID** () abrufbar.

#### Position

Diese zwei Werte legen fest, wo die sichtbaren Eigenschaften der Provinz angezeigt werden sollen.
Sind nach dem Erstellen der Provinz nicht mehr abrufbar.

#### Anzeigename

Dies ist der Name, der auf der Karte und bei Events im Zusammenhang mit dieser Provinz angezeigt wird.

Kann über *String* **getDisplayName** () abgerufen werden, falls benötigt.

#### Sterne

Dieser Wert wird für die zufällige Verteilung von Einheiten benötigt (laut Achim).

Über *int* **getStars** () soll dieser Wert abrufbar sein.

#### Angrenzende Provinzen

Dies ist ein Array von allen Provinzen, die es gibt (Provinznummer als Index), diese jeweils mit einem *boolean*-Wert, der festlegt, ob ein Kampf oder ein Weitergeben von Einheiten möglich ist.

	boolean[] nearProvinces;

Dem Konstruktor kann stattdessen auch ein *int[]* mit allen angrenzenden Provinzen als Werte übergeben werden, dieses wird dann automatisch konvertiert.

Über die Methode *boolean* **isProvinceNear** ( *int* ) kann man sich die Einträge einzeln als Booleans ausgeben lassen.

### Zusätzliche Eigenschaften

- Besitzer
- Einheitenanzahl

#### Besitzer

Über die Methode **int getOwner()** bekommt ihr den aktuellen Besitzer zurück (-1 = keiner, 0 = Spieler 1, ...).

Die Methode **boolean setOwner(int)** speichert einen neuen Besitzer ab. Sie gibt den Erfolg des Setzens zurück, falls also die Zahl kleiner -1 oder größer gleich als die Spieleranzahl sein sollte, wird die Änderung nicht durchgeführt und es wird **false** zurückgegeben.

#### Einheitenanzahl

Diese Eigenschaft speichert, wie viele Einheiten auf diesem Feld stehen (natürlich welche, die dem Besitzer gehören).

Die Methoden *int* **getEntityCount** (), *int* **addToEntities** ( *int* ), *int* **removeFromEntities** ( *int* ) und *int* **setEntityCount** ( *int* ) sollten genügend Möglichkeiten für Änderungen bieten.
Alle Methoden geben nach ihrem Aufruf den nun aktuellen Wert zurück.

### Public Methoden

- **redrawProvince()**

#### redrawProvince

Wird von der Karte oder von internen Methoden aufgerurfen, um alle sichtbaren Eigenschaften erneut zu zeichnen.

---

## Player
*extends Actor*

Stellt die Spieler da, speichert Informationen zu diesen ab.

### Explizite Eigenschaften

- Spielernummer (über Konstruktor festgelegt, *int*)
- Anzeigename (über Konstruktor festgelegt, *String*)
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

*int* **getStars** (), *int* **addToStars** ( *int* ), *int* **removeFromStars** ( *int* ), *int* **setStars** ( *int* ) sind zum Bearbeiten des Werts da. Auch sie geben danach den nun aktuellen Wert zurück.

*boolean* **canStarsRemoved** ( *int* ) gibt zurück, ob der Spieler diese Anzahl an Sternen verwenden kann (als Vereinfachung).

#### Statistik

Die Statistik soll Events festhalten, um nach einem Spiel verschiedene Werte einsehen zu können. Diese werden von der Welt mit speziellen Funktionen erhöht. Zurückgegeben sollen diese als *int[]*-Array in der Reihenfolge, wie sie oben in der Liste auftretten. Es wird auch vorgeschlagen, sie so zu speichern.

*int[]* **getStatistics()** gibt diese Liste zurück, damit sie von der Welt angezeigt werden kann.

**gotProvince** (), **lostProvince** (), **gotEntities** ( *int* ), **lostEntity** ()

### Zusätzliche Methoden

- *boolean[]* **getMyProvinces** ()
- *int* **getProvinceCount** ()
- *void* **redrawPlayer** ()

#### getMyProvinces()

Diese Methode hat die Aufgabe, eine Liste aller Provinzen zurückzugeben, wobei jede Provinz mit einem *boolean*-Wert gesagt bekommt, ob sie dem Spieler gehört oder nicht.

Diese Methode muss zwingend mit der Welt interagieren, um diese Informationen zu bekommen.

#### getProvinceCount()

Gibt die Anzahl der Provinzen, die der Spieler hat, zurück. Gut für die Statistik und die Anzeigen.

#### redrawPlayer()

Erzwingt das erneute Zeichnen des Player Objekts, um alle sichtbaren Eigenschaften erneut zu zeichnen.

---

## Dice
*extends Actor*

Stellt einen Würfel als *Actor* dar (vergleichbar mit dem Würfel aus unserem Projekt Zehntausend).

### Eigenschaften

- Augenzahl

#### Augenzahl

Diese Zahl zeigt der Würfel gerade an und kann mit **int getNumber()** abgerufen werden.

### Zusätzliche Methoden

- *int* **roll** ()

#### roll()

Berechnet eine Zufallszahl von 1 bis 6, speichert diese ab und gibt sie auch so gleich zurück. Ändert auch die Anzeige des Würfels.

---

## GUI_Interface
*extends Actor*

Die Oberklasse für alle Interface-Objekte wie Buttons und Labels. Diese Klasse ist *abstract*.

### 

### Public Methoden

---

## Label
*extends GUI_Interface*

Zeigt einen Text auf dem Bildschirm an. Zuvor wurde dieses Objekt "Text" genannt, "Label" ist der fachlichere Ausdruck dafür.

### Eigenschaften

- Anzeigetext (*String*; kann vom Konstruktor entgegen genommen werden, sonst ist der Standardtext "" zu sehen)

#### Anzeigetext

Dieser Text wird von dem Actor aus zu sehen sein.
Mit **String getText()** und **String setText(String)** bekommt Zugriff darauf.

---

## Button
*extends GUI_Interface*

Die Hauptklasse für Buttons, wird durch Erbung spezifiziert.

---

## Utils

Eine finale Klasse mit vielen kleinen Methoden, die den restlichen Code verkleinern und besser lesbar gestalten soll. Ergänzungen in Form von eigenen Funktionen dürfen **selbst** eingebracht werden.

### copyArray()

Kopiert ein Array des Types *boolean*, *int* oder *String* mit identischer Größe.

### drawInsideRectangle()

Zeichnet innerhalb eines **GreenfootImage** ein Rechteck gefüllt mit der angegebenen Farbe. Es besitzt zu allen Seiten den gegebenen Abstand zum Rand des Image.
