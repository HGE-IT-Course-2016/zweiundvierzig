# Funktionsliste Zweiundvierzig

**Version: 2**

**Stand: 10.04.2016** (TT.MM.JJJJ / DD.MM.YYYY)

[Hier die neuste offizielle Version vom Master-Branch sehen](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/funktionsliste.md)

[Hier zum gesamten Architekturplan](https://github.com/HGE-IT-Course-2016/zweiundvierzig/blob/master/planung/architektur.md)

Hier einfach eine grobe Übersicht über alle Funktionen, die jede Klasse als Public / Protected besitzen soll.

Dies könnt auch als Checkliste nehmen, um zu sehen, ob ihr bereits alle Funktionen im Code präsent habt.

## GeneralMap

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

## Province

- **Province(int, int, int, boolean[], String, int)**

- **int getID()**
- **boolean isProvinceNear(int)**
- **String getDisplayName()**
- **int getStars()**
- **int getOwner()**
- **setOwner(int)**
- **int getEntityCount()**
- **int addToEntities(int)**
- **int removeFromEntities(int)**
- **int setEntityCount(int)**

- **redrawProvince()**

## Player

- **Player(int, String)**

- **int getID()**
- **String getDisplayName()**
- **int getStars()**
- **int addToStars(int)**
- **int removeFromStars(int)**
- **int setStars(int)**
- **boolean cnaStarsRemoved(int)**

- **int[] getStatistics()**
- **gotProvince()**
- **lostProvince()**
- **gotEntities(int)**
- **lostEntity()**

- **boolean[] getMyProvinces()**
- **int getProvinceCount()**
- **redrawPlayer()**

## Dice

- **Dice()**

- **int getNumber()**

- **int roll()**

## GUI_Interface

*Noch unvollständig*

## Label

*Noch unvollständig*

- **String getText()**
- **String setText(String)**

## Button

*Noch unvollständig*