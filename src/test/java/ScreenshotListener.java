import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + "Failed! Capturing screenshot on test failure");
    }
}
