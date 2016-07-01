import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
	Klasse der Standard-Welt
	(Also die normale Weltkarte mit allen Kontinenten)

	@author GruenerWal, MaxiJohl
	@version 0.3.0
 */

public class Map_World extends GeneralMap
{
	/**
		Anzahl der Provinzen.
	 */

	int provinceCount = 42;

	/** 
		Konstruktor der Weltkarte;
		konstruiert eine GeneralMap mit den Ausmassen 1600 auf 900 Pixel.
	 */

	public Map_World(String[] playerList, int[] colorList)
	{
		super(playerList,colorList);
		setBackground("Risiko Karte.png");
		/*
			Hier werden später sämtliche Provinzen der Standard-Map erstellt.
			Dies funktioniert folgendermassen:
			=================================================================
		
			Dieses kürzere Format ersetzt den langen Code und sorgt eventuell sogar für einen Geschwindigkeitsschub. Dabei sollte diesselbe Funktionalität erhalten bleiben.
			
			provinces[<Provinz-ID>] = new Province(<Provinz-ID>,<Kontinent-ID>,<X-Position>,<Y-Position>,<Anzahl Sterne>,"<Anzeigename>", new int[] { <Liste aller Nachbarprovinzen> });
		
			=================================================================
			Der Speicherplatz für provinces[0] bleibt leer, da es keine Provinz mit der ID 0 gibt!
		
			Und ja, ich weiss, dass das scheisse viel Schreibarbeit ist.
			Aber da muss man durch, wir habens auch hinbekommen :P
		
			~GruenerWal
		 */

		// Festlegung der Provinz-Anzahl

		provinces = new Province[provinceCount + 1];

		// Implementierung sämtlicher Provinzen
		// ACHTUNG! Gaaaaanz viel Code!

		// cID 1 - Nordamerika
		provinces[1] =  new Province( 1 , 1 ,  64 , 106 , 1 , "Alaska" , new int[] {2 , 3 , 36});
		provinces[2] =  new Province( 2 , 1 , 162 , 106 , 1 , "NW-Territorien" , new int[] {1 , 3 , 4 , 9});
		provinces[3] =  new Province( 3 , 1 , 153 , 170 , 1 , "Alberta" , new int[] {1 , 2 , 4 , 5});
		provinces[4] =  new Province( 4 , 1 , 223 , 177 , 2 , "Ontario" , new int[] {2 , 3 , 5 , 6 , 7 , 9});
		provinces[5] =  new Province( 5 , 1 , 160 , 236 , 2 , "Weststaaten" , new int[] {3 , 4 , 6 , 8});
		provinces[6] =  new Province( 6 , 1 , 232 , 273 , 2 , "Oststaaten" , new int[] {4 , 5 , 7 , 8});
		provinces[7] =  new Province( 7 , 1 , 300 , 180 , 2 , "Quebec" , new int[] {4 , 6 , 9});
		provinces[8] =  new Province( 8 , 1 , 181 , 347 , 1 , "Mittelamerika" , new int[] {5 , 6 , 17});
		provinces[9] =  new Province( 9 , 1 , 365 ,  55 , 1 , "Groenland" , new int[] {2 , 4 , 7 , 10});

		// cID 2 - Europa
		provinces[10] = new Province(10 , 2 , 454 , 142 , 1 , "Island" , new int[] {9 , 11 , 12});
		provinces[11] = new Province(11 , 2 , 424 , 221 , 2 , "Grossbritannien" , new int[] {10 , 12 , 14 , 15});
		provinces[12] = new Province(12 , 2 , 520 , 153 , 1 , "Skandinavien" , new int[] {10 , 11 , 13 , 14});
		provinces[13] = new Province(13 , 2 , 636 , 180 , 2 , "Russland" , new int[] {12 , 14 , 16 , 27 , 31 , 32});
		provinces[14] = new Province(14 , 2 , 528 , 232 , 2 , "Nordeuropa" , new int[] {11 , 12 , 13 , 15 , 16});
		provinces[15] = new Province(15 , 2 , 449 , 335 , 2 , "Westeuropa" , new int[] {11 , 14 , 16 , 25});
		provinces[16] = new Province(16 , 2 , 537 , 296 , 2 , "Suedeuropa" , new int[] {13 , 14 , 15 , 25 , 26 , 27});

		// cID 3 - Suedamerika
		provinces[17] = new Province(17 , 3 , 245 , 396 , 1 , "Venezuela" , new int[] {8 , 18 , 19});
		provinces[18] = new Province(18 , 3 , 255 , 498 , 1 , "Peru" , new int[] {17 , 19 , 20});
		provinces[19] = new Province(19 , 3 , 327 , 467 , 2 , "Brasilien" , new int[] {17 , 18 , 20 , 25});
		provinces[20] = new Province(20 , 3 , 274 , 572 , 1 , "Argentinien" , new int[] {18 , 19});
		
		// cID 4 - Afrika
		provinces[21] = new Province(21 , 4 , 680 , 630 , 1 , "Madagaskar" , new int[] {24 , 22});
		provinces[22] = new Province(22 , 4 , 580 , 624 , 1 , "Südafrika" , new int[] {21 , 23 , 24});
		provinces[23] = new Province(23 , 4 , 572 , 537 , 2 , "Zentralafrika" , new int[] {22 , 25 , 24});
		provinces[24] = new Province(24 , 4 , 632 , 500 , 2 , "Ostafrika" , new int[] {21 , 22 , 25 , 23 , 26});
		provinces[25] = new Province(25 , 4 , 491 , 444 , 1 , "Nordafrika" , new int[] {15 , 16 , 26 , 23 , 24});
		provinces[26] = new Province(26 , 4 , 574 , 414 , 1 , "Aegypten" , new int[] {27 , 25 , 24 , 16});
		
		// cID 5 - Asien
		provinces[27] = new Province(27 , 5 , 664 , 345 , 2 , "Mittlerer Osten" , new int[] {24 , 26 , 16 , 23 , 31 , 28});
		provinces[28] = new Province(28 , 5 , 784 , 370 , 2 , "Indien" , new int[] {29 , 31 , 27 , 30});
		provinces[29] = new Province(29 , 5 , 863 , 322 , 2 , "China" , new int[] {30 , 28 , 31 , 32 , 33 , 37});
		provinces[30] = new Province(30 , 5 , 867 , 400 , 1 , "Südost Asien" , new int[] {29 , 39 , 28});
		provinces[31] = new Province(31 , 5 , 724 , 262 , 1 , "Afganistan" , new int[] {29 , 28 , 27 , 13 , 32});
		provinces[32] = new Province(32 , 5 , 740 , 163 , 1 , "Ural" , new int[] {29 , 33 , 31 , 13});
		provinces[33] = new Province(33 , 5 , 802 , 128 , 1 , "Sibirien" , new int[] {34 , 35 , 37 , 29 , 32});
		provinces[34] = new Province(34 , 5 , 884 ,  82 , 1 , "Jakutien" , new int[] {36 , 35 , 33});
		provinces[35] = new Province(35 , 5 , 867 , 176 , 2 , "Irkutsk" , new int[] {34 , 36 , 37 , 33});
		provinces[36] = new Province(36 , 5 , 973 ,  89 , 1 , "Kamtschatka" , new int[] {1 , 38 , 37 , 35 , 34});
		provinces[37] = new Province(37 , 5 , 882 , 243 , 1 , "Mongolei" , new int[] {29 , 33 , 35 , 36 , 38});
		provinces[38] = new Province(38 , 5 , 994 , 249 , 2 , "Japan" , new int[] {37 , 36});
		
		// cID 6 - Ozeanien
		provinces[39] = new Province(39 , 6 , 889 , 519 , 1 , "Indonesien" , new int[] {30 , 40 , 42});
		provinces[40] = new Province(40 , 6 , 983 , 492 , 2 , "Neuguinea" , new int[] {39 , 41 , 42});
		provinces[41] = new Province(41 , 6 , 1000, 595 , 1 , "Ost Australien" , new int[] {40 , 42});
		provinces[42] = new Province(42 , 6 , 934 , 628 , 1 , "West Australien" , new int[] {40 , 41 , 39});

		initProvinces();
	}
}
