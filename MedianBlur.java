package ntou;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class MedianBlur { // 中值濾波法
	public static void main(String args[]) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			Mat source = Imgcodecs.imread("ntou.jpg", Imgcodecs.IMREAD_ANYCOLOR);
			Mat destination = new Mat();
			Imgproc.medianBlur(source, destination, 15); // 中值濾波
			Imgcodecs.imwrite("median.jpg", destination);
			System.out.println("Successfully created a MedianBlur image");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}