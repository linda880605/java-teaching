package ntou;

import java.io.*;
import java.net.URL;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ReadWriteImage {
	public static void main(String args[]) throws IOException {
		int width = 800;
		int height = 600;
		BufferedImage image = null;
		// 讀取圖片
		try {
			// URL url = new URL("https://web.cheers.com.tw/issue/2018/master/article/img/ad8.jpg");			
			File file = new File("WebContent/WEB-INF/img/ntou.jpg");
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			// image = ImageIO.read(url);
			image = ImageIO.read(file);
			System.out.println("Reading complete.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
		// 寫入圖片
		try {
			File outputFile = new File("WebContent/WEB-INF/img/output/ReadWriteImage.jpg");
			ImageIO.write(image, "jpg", outputFile);
			System.out.println("Writing complete.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
}