package ntou;

import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MirrorImage { // 鏡像反射
	public static void main(String args[]) throws IOException {
		BufferedImage img1 = null;
		File file = null;
		try {
			file = new File("WebContent/WEB-INF/img/ntou.jpg");
			img1 = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		int width = img1.getWidth();
		int height = img1.getHeight();
		BufferedImage img2 = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int y = 0; y < height; y++) {
			for (int lx = 0, rx = width - 1; lx < width; lx++, rx--) {
				int p = img1.getRGB(lx, y);
				img2.setRGB(rx, y, p);
			}
		}
		try {
			file = new File("WebContent/WEB-INF/img/output/Mirror.jpg");
			ImageIO.write(img2, "png", file);
			System.out.println("Successfully created a mirror image");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
}