# Architekturplan Zweiundvierzig

**Version: 1**

**Stand: 10.04.2016** (TT.MM.JJJJ / DD.MM.YYYY)

[Hier die neuste Version vom Master-Branch sehen](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/architektur.md Link zu GitHub.com)

Hier ein möglicher Architekturplan von *Felix Stupp*.
Dieser Plan wird regelmäßig angepasst, oben am Datum zu erkennen.

Hier werden alle Klassen und deren öffentliche Methoden und Eigenschaften zusammengefasst.
Auch zu sehen ist der Author / sind die Authoren der Klasse, um bei Fragen diese kontaktieren zu können.

**Alle Anfragen aufgrund von Architekturänderungen erst an mich weitergeben, damit ich dies mit den jeweiligen Authoren besprechen kann!**
Die Authoren sollen nur Fragen zu bisher vorhandenen Methoden erhalten.

### Erklärung

Die englischen Begriffe *World* und *Actor* stehen für die gegebenen Oberklassen von Greenfoot.

### Generell

- Alle Funktionen, die einen Wert für ihre Eigenschaft festlegen sollen, sollen auch den aktuellen Wert, denn sie dann gegebenenfalls eintragen (beziehungsweise den alten Wert, falls aus irgend einem Grund doch nichts geändert wird), wieder zurückgeben, um im Code später Abkürzungen verwenden zu können oder direkt die Änderung überprüfen zu können.

### Explizite Eigenschaften

Explizite Eigenschaften sind speziell Eigenschaften, die von der Klasse selbst gehalten werden und bevorzugt auch nur von ihr festgehalten werden.

Beispiel:

Ein Spieler besitzt zwar Provinzen, nur ist dies eine Eigenschaft der Provinz und nicht vom Spieler.
Der Spieler kann mithilfe der Welt dann herausfinden, welche Provinzen ihm gehören.

## Inhalt

- Province (von Achim):
Speichert Informationen zu den einzelnen Provinzen ab und stellt diese später auch als *Actor* dar.
- Spieler (vorläufiger Name):
Stellt die Spieler da, speichert Informationen zu diesen ab. Wird von der Weltkarte als *Actor* behandelt.
- Weltkarte (vorläufiger Name):
Stellt die gesamte Weltkarte mit Hintergrundbild dar. Sie erstellt die spezifisichen Provinzen und stellt die *World* dar, die beim aktiven Spiel zu sehen ist. Ist auch für die Anzeigen links/rechts/unten verantwortlich.
- MainMenu:
Stellt eine *World* als Hauptmenü dar, bekommmt die Aufgabe, die einzelnen Menüpunkte anzuzeigen. Aktiviert gegebenenfalls andere *Worlds*.
- GameOptions:
Eine *World*, welche das Optionsmenü vor dem Start eines Spiels anzeigt. Erstellt dann eine Weltkarte und übergibt diese Greenfoot als neue *World*.

---

## Province

Wird verwaltet von Achim

### Explizite Eigenschaften

- X/Y-Position auf der Karte (fest)
- Angrenzende Provinzen (fest)
- Anzeigename (fest)
- Sterne (fest)
- Besitzer
- Einheitenanzahl

#### Position

Diese zwei Werte legen fest, wo die sichtbaren Eigenschaften der Provinz angezeigt werden sollen.
Sind nach dem Erstellen der Provinz nicht mehr abrufbar.

#### Angrenzende Provinzen

Dies ist ein Array von allen Provinzen, die es gibt (Provinznummer als Index), diese jeweils mit einem **Boolean**-Wert, der festlegt, ob ein Kampf oder ein Weitergeben von Einheiten möglich ist.

	boolean[] nearProvinces;

Über die Methode **boolean isProvinceNear(int)** kann man sich die Einträge einzeln als Booleans ausgeben lassen.

#### Anzeigename

Dies ist der Name, der auf der Karte und bei Events im Zusammenhang mit dieser Provinz angezeigt wird.

Kann über **String getDisplayName()** abgerufen werden, falls benötigt.

#### Sterne

Dieser Wert wird für die zufällige Verteilung von Einheiten benötigt (laut Achim).

Über **int getStars()** soll dieser Wert abrufbar sein.

#### Besitzer

Über die Methode **int getOwner()** bekommt ihr den aktuellen Besitzer zurück (0 = keiner, 1 = Spieler 1, ...).

Die Methode **setOwner(int)** speichert einen neuen Besitzer ab.

#### Einheitenanzahl

Diese Eigenschaft speichert, wie viele Einheiten auf diesem Feld stehen (natürlich welche, die dem Besitzer gehören).

Die Methoden **int getEntityCount()**, **int addToEntities(int)**, **int removeFromEntities(int)** und **int setEntityCount(int)** sollten genügend Möglichkeiten für Änderungen bieten.
Alle Methoden geben nach ihrem Aufruf den nun aktuellen Wert zurück.

### Zusätzliche Methoden

- **redrawProvince()**

#### redrawProvince

Wird von der Karte oder von internen Methoden aufgerurfen, um alle sichtbaren Eigenschaften erneut zu zeichnen.

---

## Spieler

### Explizite Eigenschaften

- Anzeigename (fest)
- Sternanzahl
- Statistiken
	1. Eroberte Provinzen
	2. Verlorene Provinzen
	3. Einflussmaximum (maximale Provinzenanzahl nach einem Zug)
	4. Bekommene Einheiten
	5. Verlorene Einheiten
	6. Maximale Einheitenanzahl

### Zusätzliche Methoden

- 