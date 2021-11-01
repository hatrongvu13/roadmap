import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Application {
    public static void main(String[] args) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Imgcodecs.imread("test.jpg");

        Imgproc.rectangle(mat, new Point(10, 10),
                new Point(100, 100),
                new Scalar(0, 255, 0));

        Imgcodecs.imwrite("result_test.jpg", mat);
    }
}
