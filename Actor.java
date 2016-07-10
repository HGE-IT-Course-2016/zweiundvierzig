package greenfootReplacement;

import javafx.scene.image.ImageView;

public class Actor {
	
	
	GreenfootImage image = null;
	
	private static javafx.scene.image.Image getFXImage() throws java.io.IOException {
		java.awt.image.BufferedImage i = image.getAwtImage();
		if (!(image instanceof java.awt.image.RenderedImage)) {
			java.awt.image.BufferedImage bufferedImage = new java.awt.image.BufferedImage(image.getWidth(null), image.getHeight(null), java.awt.image.BufferedImage.TYPE_INT_ARGB);
			java.awt.Graphics g = bufferedImage.createGraphics();
			g.drawImage(image, 0, 0, null);
			g.dispose();
			image = bufferedImage;
		}
		java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
		javax.imageio.ImageIO.write((java.awt.image.RenderedImage) image, "png", out);
		out.flush();
		java.io.ByteArrayInputStream in = new java.io.ByteArrayInputStream(out.toByteArray());
		return new javafx.scene.image.Image(in);
	}
	
}