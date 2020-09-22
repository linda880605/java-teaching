package ntou;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Mosaic { // 圖片打馬賽克

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
		if (image.getWidth() < size || image.getHeight() < size || size <= 0) { // 馬賽克格尺寸太大或太小
			return false;
		}

		int countX = 0; // x軸矩形格個數
		int countY = 0; // y軸矩形格個數
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
		int x = 0; // x軸坐標
		int y = 0; // y軸坐標
		// 繪制馬賽克(繪制矩形並填充顏色)
		Graphics gs = outputImage.getGraphics();
		for (int i = 0; i < countX; i++) {
			for (int j = 0; j < countY; j++) {
				// 馬賽克矩形格大小
				int mWidth = size;
				int mHeight = size;
				if (i == countX - 1) { // 最後一格可能不夠一個size
					mWidth = image.getWidth() - x;
				}
				if (j == countY - 1) { // 最後一格可能不夠一個size
					mHeight = image.getHeight() - y;
				}
				// 矩形顏色取中心像素點RGB值
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
				gs.fillRect(x, y, mWidth, mHeight); // 畫出填滿顏色的長方形
				y = y + size;// 計算下一個矩形的y坐標
			}
			y = 0;// 還原y坐標
			x = x + size;// 計算x坐標
		}
		gs.dispose();
		File outputFile = new File(saveName + "." + type);
		ImageIO.write(outputImage, type, outputFile);
		System.out.println("Successfully mosaic");
		return true;
	}

	public static void main(String[] args) throws Exception {
		Mosaic mosaic = new Mosaic("ntou.jpg", "mosaic", "jpg");
		mosaic.pixelate(17); // 數值越大越模糊
	}

}