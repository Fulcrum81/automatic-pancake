import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test(groups = "smoke")
    public static void loginWithCorrectCreds() {
        System.out.println("TEST: login with correct credentials");
    }

    @Test(groups = { "smoke", "regression" })
    public static void loginWithEmptyUsername() {
//        int[] array = { 1, 2, 3 };
//        int x = array[6];

        System.out.println("TEST: login with empty username");

        int a = 17;
        int b = 15;

        Assert.assertTrue(a < b, "Expected a to be greater than b: a = " + a + ", b = " + b);
    }
}
