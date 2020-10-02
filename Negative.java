package ntou;

import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Negative { // 負片影像
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
				r = 255 - r;
				g = 255 - g;
				b = 255 - b;
				p = (a << 24) | (r << 16) | (g << 8) | b;
				image.setRGB(x, y, p); // 設定每個pixel的RGB值
			}
		}
		try {
			file = new File("WebContent/WEB-INF/img/output/Negative.jpg");
			ImageIO.write(image, "jpg", file);
			System.out.println("Successfully converted a colored image into a negative image");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}