package ntou;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

public class FaceDetector {
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		CascadeClassifier faceDetector = new CascadeClassifier(
				"WebContent/opencv/sources/data/haarcascades_cuda/haarcascade_frontalface_alt.xml");
		Mat image = Imgcodecs.imread("WebContent/WEB-INF/img/Face-Detect.jpg");

		MatOfRect faceDetections = new MatOfRect();
		faceDetector.detectMultiScale(image, faceDetections); // 偵測人臉
		for (Rect rect : faceDetections.toArray()) { // faceDetections.toArray()返回可以迭代的Rect物件陣列
			Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
					new Scalar(0, 255, 0), 2); // 畫出框線
		}
		Imgcodecs.imwrite("WebContent/WEB-INF/img/output/FaceDetector.jpg", image);
		System.out.println("Successfully created a FaceDetector image");
	}
}