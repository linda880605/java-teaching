package ntou;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Mosaic { // �Ϥ������ɧJ

	String picture;
	String saveName;
	String type;

	public Mosaic(String picture, String saveName, String type) {
		this.picture = picture;
		this.saveName = saveName;
		this.type = type;
	}

	public boolean pixelate(int size) throws Exception {
		File file = new File(picture);
		BufferedImage image = ImageIO.read(file);
		BufferedImage outputImage = new BufferedImage(image.getWidth(), image.getHeight(), image.TYPE_INT_RGB);
		if (image.getWidth() < size || image.getHeight() < size || size <= 0) { // ���ɧJ��ؤo�Ӥj�ΤӤp
			return false;
		}

		int countX = 0; // x�b�x�ή�Ӽ�
		int countY = 0; // y�b�x�ή�Ӽ�
		if (image.getWidth() % size == 0) {
			countX = image.getWidth() / size;
		} else {
			countX = image.getWidth() / size + 1;
		}
		if (image.getHeight() % size == 0) {
			countY = image.getHeight() / size;
		} else {
			countY = image.getHeight() / size + 1;
		}
		int x = 0; // x�b����
		int y = 0; // y�b����
		// ø��ɧJ(ø��x�Ψö�R�C��)
		Graphics gs = outputImage.getGraphics();
		for (int i = 0; i < countX; i++) {
			for (int j = 0; j < countY; j++) {
				// ���ɧJ�x�ή�j�p
				int mWidth = size;
				int mHeight = size;
				if (i == countX - 1) { // �̫�@��i�ण���@��size
					mWidth = image.getWidth() - x;
				}
				if (j == countY - 1) { // �̫�@��i�ण���@��size
					mHeight = image.getHeight() - y;
				}
				// �x���C������߹����IRGB��
				int centerX = x;
				int centerY = y;
				if (mWidth % 2 == 0) {
					centerX += mWidth / 2;
				} else {
					centerX += (mWidth + 1) / 2;
				}
				if (mHeight % 2 == 0) {
					centerY += mHeight / 2;
				} else {
					centerY += (mHeight + 1) / 2;
				}
				Color color = new Color(image.getRGB(centerX, centerY));
				gs.setColor(color);
				gs.fillRect(x, y, mWidth, mHeight); // �e�X���C�⪺�����
				y = y + size;// �p��U�@�ӯx�Ϊ�y����
			}
			y = 0;// �٭�y����
			x = x + size;// �p��x����
		}
		gs.dispose();
		File outputFile = new File(saveName + "." + type);
		ImageIO.write(outputImage, type, outputFile);
		System.out.println("Successfully mosaic");
		return true;
	}

	public static void main(String[] args) throws Exception {
		Mosaic mosaic = new Mosaic("ntou.jpg", "mosaic", "jpg");
		mosaic.pixelate(17); // �ƭȶV�j�V�ҽk
	}

}