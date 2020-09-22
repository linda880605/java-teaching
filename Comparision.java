package ntou;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class Comparision {
	public static void main(String[] args) {
		BufferedImage imgA = null;
		BufferedImage imgB = null;
		try {
			File fileA = new File("123.jpg");
			File fileB = new File("1234.jpg");
			imgA = ImageIO.read(fileA);
			imgB = ImageIO.read(fileB);
		} catch (IOException e) {
			System.out.println(e);
		}
		int width1 = imgA.getWidth();
		int width2 = imgB.getWidth();
		int height1 = imgA.getHeight();
		int height2 = imgB.getHeight();

		if ((width1 != width2) || (height1 != height2))
			System.out.println("兩張照片尺寸大小不符");
		else {
			double difference = 0;
			for (int y = 0; y < height1; y++) {
				for (int x = 0; x < width1; x++) {
					int rgbA = imgA.getRGB(x, y);
					int rgbB = imgB.getRGB(x, y);
					int redA = (rgbA >> 16) & 0xff;
					int greenA = (rgbA >> 8) & 0xff;
					int blueA = (rgbA) & 0xff;
					int redB = (rgbB >> 16) & 0xff;
					int greenB = (rgbB >> 8) & 0xff;
					int blueB = (rgbB) & 0xff;
					difference += Math.abs(redA - redB);
					difference += Math.abs(greenA - greenB);
					difference += Math.abs(blueA - blueB);
				}
			}
			double totalPixels = width1 * height1 * 3; // 乘3是 因為有rgb三個顏色的pixels
			double avg = difference / totalPixels;
			double percentage = (avg / 255) * 100; // 每個pixel的值為0~255
			DecimalFormat df = new DecimalFormat("##.00");
			percentage = Double.parseDouble(df.format(percentage));
			System.out.println("Difference Percentage->" + percentage);
		}
	}
}