package ntou;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorPicture { // 生成顏色圖片
	public static void main(String[] args) throws Exception {
		int width = 100;
		int height = 100;
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = img.getGraphics();
		g.setColor(new Color(70, 165, 211));

		g.fillRect(0, 0, img.getWidth(), img.getHeight());
		File file = new File("WebContent/WEB-INF/img/output/color.jpg");
		try {
			ImageIO.write(img, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
