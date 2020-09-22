package ntou;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resize { // �վ�Ϥ��j�p ���e
	public static void main(String[] args) throws IOException {

		File imgFile = new File("WebContent/WEB-INF/img/ntou.jpg");
		BufferedImage image = ImageIO.read(imgFile);

		int width = image.getWidth() / 2;
		int height = image.getHeight() / 2;
		BufferedImage emptyImage = new BufferedImage(width, height, image.getType());
		// �إߪťժ� BufferedImage���� �w�q �e�סB���סB��X����

		Graphics2D g2d = emptyImage.createGraphics();
		g2d.drawImage(image, 0, 0, width, height, null); // ��Ū�J���Ϥ��e�W�h
		g2d.dispose(); // ���񪫥�

		File outputFile = new File("WebContent/WEB-INF/img/output/Resize.jpg");
		ImageIO.write(emptyImage, "jpg", outputFile);
		System.out.println("Successfully resize image");
		
	}
}
