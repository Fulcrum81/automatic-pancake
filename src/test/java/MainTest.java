import org.testng.annotations.Test;

public class MainTest extends TestBase {

    @Test(groups = "regression", enabled = false)
    public static void firstTest() {
        System.out.println("TEST: first test");
    }
}
