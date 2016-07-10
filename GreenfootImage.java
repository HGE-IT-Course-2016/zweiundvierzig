package greenfootReplacement;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class GreenfootImage {
	
	private BufferedImage image = null;
	
	public GreenfootImage(GreenfootImage i) {
		image = i.getAwtImage().clone();
	}
	
	public GreenfootImage(int w, int h) {
		image = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
	}
	
	public GreenfootImage(String fileName) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(fileName));
		} catch (IOException e) {
		}
		image = img;
	}
	
	public GreenfootImage(String txt, int size, Color foreCol, Color backCol) {
		
	}
	
	public BufferedImage getAwtImage() {
		return image;
	}
	
}