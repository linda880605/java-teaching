package ntou;

import java.io.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ReadWriteImage {
	public static void main(String args[]) throws IOException {
		int width = 800; // width of the image
		int height = 600; // height of the image
		BufferedImage image = null;
		// READ IMAGE
		try {
			// URL url = new URL("https://a.ksd-i.com/a/2020-03-02/124715-819810.jpg");
			//File file = new File("C:\\Users\\USER\\Desktop\\teach\\java\\boy75.png");
			File file = new File("boy75.png");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(file); // Reading input file
			System.out.println("Reading complete.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		// WRITE IMAGE
		try {
			File outputFile = new File("outputImage.png");
			ImageIO.write(image, "png", outputFile);
			System.out.println("Writing complete.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
}