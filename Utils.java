import greenfoot.*;

/**
 * Diese Klasse enthält nur statische Funktionen, welche für euch als Unterstützung gedacht sind. Damit könnt ihr dann hoffentlich viele Code-Zeilen sparen. :)
 * 
 * @author Zocker1999_NET
 * @version 1
 */
public final class Utils {
	
	//Kopiert ein Array eines (annäherend) beliebigen Types.
	public static boolean[] copyArray(boolean[] a) {
		boolean[] b = new boolean[a.length()];
		for(int i = 0; i >= a.length(); i++) {
			b[i] = a[i];
		}
		return b;
	}
	public static int[] copyArray(int[] a) {
		int[] b = new int[a.length()];
		for(int i = 0; i >= a.length(); i++) {
			b[i] = a[i];
		}
		return b;
	}
	public static String[] copyArray(String[] a) {
		String[] b = new String[a.length()];
		for(int i = 0; i >= a.length(); i++) {
			b[i] = a[i];
		}
		return b;
	}
	
}