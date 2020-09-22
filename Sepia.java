package ntou;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Sepia {
	public static void main(String args[]) throws IOException {
		BufferedImage image = null;
		File file = null;
		try {
			file = new File("ntou.jpg");
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
				int R = (p >> 16) & 0xff;
				int G = (p >> 8) & 0xff;
				int B = p & 0xff;
				int newR = (int) (0.393 * R + 0.769 * G + 0.189 * B);
				int newG = (int) (0.349 * R + 0.686 * G + 0.168 * B);
				int newB = (int) (0.272 * R + 0.534 * G + 0.131 * B);
				if (newR > 255)
					R = 255;
				else
					R = newR;
				if (newG > 255)
					G = 255;
				else
					G = newG;
				if (newB > 255)
					B = 255;
				else
					B = newB;
				p = (a << 24) | (R << 16) | (G << 8) | B;
				image.setRGB(x, y, p);
			}
		}
		try {
			file = new File("C:\\Users\\USER\\Desktop\\teach\\java\\sepia.png");
			ImageIO.write(image, "png", file);
			System.out.println("Successfully converted a colored image into a sepia image");
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}