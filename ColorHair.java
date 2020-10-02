package ntou;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ColorHair { // 疊圖

	public static String getColorPicture(String color) {
		// 將十六進制的代碼轉換為RGB分量
		int red = Integer.valueOf(color.substring(1, 3), 16);
		int green = Integer.valueOf(color.substring(3, 5), 16);
		int blue = Integer.valueOf(color.substring(5, 7), 16);
		int width = 400, height = 400;
		BufferedImage colorImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = (Graphics2D) colorImage.getGraphics();
		graphics2d.setPaint(new Color(red, green, blue));
		graphics2d.fillRect(0, 0, width, height);

		File file = new File("color.png");
		try {
			ImageIO.write(colorImage, "png", file);
		} catch (IOException e) {
			System.out.println("IOException " + e);
		}
		return "color.png";
	}

	public BufferedImage add(String onePic, String twoPic, int x, int y, float alpha) throws IOException {
		File oneFile = new File(onePic);
		File twoFile = new File(twoPic);
		BufferedImage oneImage = ImageIO.read(oneFile);
		BufferedImage twoImage = ImageIO.read(twoFile);
		Graphics2D g2d = oneImage.createGraphics();
		int width = twoImage.getWidth();
		int height = twoImage.getHeight();
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
		g2d.drawImage(twoImage, x, y, width, height, null);
		g2d.dispose();
		return oneImage;
	}

	private void generatePic(BufferedImage image, String saveName, String type) throws IOException {
		File outputFile = new File(saveName + "." + type);
		ImageIO.write(image, type, outputFile);
		System.out.println("Successfully ColorHair");
	}

	public static void main(String[] args) throws IOException {
		String color = "#46A3FF";
		String colorPic = getColorPicture(color);
		String hairPic = "WebContent/WEB-INF/img/hair.png";
		String saveName = "WebContent/WEB-INF/img/output/colorHair";
		String type = "png";
		ColorHair colorHair = new ColorHair();
		BufferedImage image = colorHair.add(hairPic, colorPic, 0, 0, 0.5f); // 0.5f為透明度50%
		colorHair.generatePic(image, saveName, type);
	}
}