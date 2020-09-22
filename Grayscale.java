package ntou;

import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Grayscale {
	public static void main(String args[]) throws IOException {
		BufferedImage image = null;
		File file = null;
		try {
			file = new File("WebContent/WEB-INF/img/ntou.jpg");
			image = ImageIO.read(file);
		} catch (IOException e) {
			System.out.println(e);
		}
		int width = image.getWidth();
		int height = image.getHeight();
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int p = image.getRGB(x, y); // 獲取圖像的pixel
				int a = (p >> 24) & 0xff;
				int r = (p >> 16) & 0xff;
				int g = (p >> 8) & 0xff;
				int b = p & 0xff;
				int avg = (r + g + b) / 3;
				p = (a << 24) | (avg << 16) | (avg << 8) | avg;
				image.setRGB(x, y, p);
			}
		}
		try {
			file = new File("WebContent/WEB-INF/img/output/Grayscale.jpg");
			ImageIO.write(image, "png", file);
			System.out.println("Successfully converted a colored image into a grayscale image");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}