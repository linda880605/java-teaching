package ntou;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Blur { // µê¤Æ¹Ï¹³
	public static void main(String[] args) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			Mat source = Imgcodecs.imread("ntou.jpg", Imgcodecs.IMREAD_ANYCOLOR);
			Mat destination = new Mat(source.rows(), source.cols(), source.type());
			Imgproc.GaussianBlur(source, destination, new Size(65, 65), 0);
			Imgcodecs.imwrite("GaussianBlur.jpg", destination);
			System.out.println("Successfully created a Blur image");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

}
