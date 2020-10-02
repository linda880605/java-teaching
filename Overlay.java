package ntou;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Overlay { // 疊圖

	public BufferedImage add(String onePic, String twoPic, int x, int y, float alpha) throws IOException {
		File oneFile = new File(onePic);
		File twoFile = new File(twoPic);
		BufferedImage oneImage = ImageIO.read(oneFile);
		BufferedImage twoImage = ImageIO.read(twoFile);
		Graphics2D g2d = oneImage.createGraphics();
		// int width = twoImage.getWidth();
		// int height = twoImage.getHeight();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
		g2d.drawImage(twoImage, x, y, 200, 200, null);
		// 人臉+頭髮 g2d.drawImage(twoImage, x, y, 300, 300, null);
		
		g2d.dispose();
		return oneImage;
	}

	private void generatePic(BufferedImage image, String saveName, String type) throws IOException {
		File outputFile = new File(saveName + "." + type);
		ImageIO.write(image, type, outputFile);
		System.out.println("Successfully Overlay");
	}

	public static void main(String[] args) throws IOException {
		String onePic = "WebContent/WEB-INF/img/ntou.jpg";
		String twoPic = "WebContent/WEB-INF/img/ntou-logo.png";
		//人臉+頭髮  String onePic = "WebContent/WEB-INF/img/face.jpg";
		//人臉+頭髮 String twoPic = "WebContent/WEB-INF/img/colorHair.png";
		String saveName = "WebContent/WEB-INF/img/output/Overlay";
		String type = "png";
		Overlay overlay = new Overlay();
		BufferedImage image = overlay.add(onePic, twoPic, 0, 0, 1.0f);
		// 人臉+頭髮 BufferedImage image = overlay.add(onePic, twoPic, 160, -10, 1.0f);
		overlay.generatePic(image, saveName, type);
	}
}