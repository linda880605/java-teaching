package ntou;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resize { // 調整圖片大小 長寬
	public static void main(String[] args) throws IOException {

		File imgFile = new File("WebContent/WEB-INF/img/ntou.jpg");
		BufferedImage image = ImageIO.read(imgFile);

		int width = image.getWidth() / 2;
		int height = image.getHeight() / 2;
		BufferedImage emptyImage = new BufferedImage(width, height, image.getType());
		// 建立空白的 BufferedImage物件 定義 寬度、高度、輸出類型

		Graphics2D g2d = emptyImage.createGraphics();
		g2d.drawImage(image, 0, 0, width, height, null); // 把讀入的圖片畫上去
		g2d.dispose(); // 釋放物件

		File outputFile = new File("WebContent/WEB-INF/img/output/Resize.jpg");
		ImageIO.write(emptyImage, "jpg", outputFile);
		System.out.println("Successfully resize image");
		
	}
}
