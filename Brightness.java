package ntou;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Brightness { // 調整圖像亮度
	static double alpha = 1; // 對比度 比例
	static double beta = 50; // 亮度
	// 線性變換 圖像的每個像素與Alpha值相乘 再加上beta值來增強圖像的亮度

	public static void main(String[] args) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // 調用openCV的method需引入
			Mat source = Imgcodecs.imread("WebContent/WEB-INF/img/ntou.jpg"); // 將圖像讀取為Mat物件
			Mat destination = new Mat(source.rows(), source.cols(), source.type());
			source.convertTo(destination, -1, alpha, beta);
			Imgcodecs.imwrite("WebContent/WEB-INF/img/output/Brightness.jpg", destination); // 將Mat物件寫入圖像
			System.out.println("Successfully created a Brightness image");
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}
}