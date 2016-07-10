 

/**
	Ersetzt die Greenfoot Klasse von Greenfoot und hält das Programm am Laufen.
*/
public class Greenfoot {
	
	private static World currentWorld = null;
	
	public static void main(String[] args) {
		setWorld(new Start_Load());
	}
	
	public static void setWorld(World w) {
		
	}
	
}