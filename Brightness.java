package ntou;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

public class Brightness { // �վ�Ϲ��G��
	static double alpha = 1; // ���� ���
	static double beta = 50; // �G��
	// �u���ܴ� �Ϲ����C�ӹ����PAlpha�Ȭۭ� �A�[�Wbeta�ȨӼW�j�Ϲ����G��

	public static void main(String[] args) {
		try {
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // �ե�openCV��method�ݤޤJ
			Mat source = Imgcodecs.imread("WebContent/WEB-INF/img/ntou.jpg"); // �N�Ϲ�Ū����Mat����
			Mat destination = new Mat(source.rows(), source.cols(), source.type());
			source.convertTo(destination, -1, alpha, beta);
			Imgcodecs.imwrite("WebContent/WEB-INF/img/output/Brightness.jpg", destination); // �NMat����g�J�Ϲ�
			System.out.println("Successfully created a Brightness image");
		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}
}