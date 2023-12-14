package patterns.objectpo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {


    @Test
    public static void invalidLoginTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = new LoginPage(driver);
        LoginErrorPage loginErrorPage = new LoginErrorPage(driver);

        loginPage.login("Skjhkasclhj", "kajakjjkhahskhjk");

        softAssert.assertEquals(loginErrorPage.getErrorMessageText(),
                "Wrong password or the account is disabled, or does not exist");
        softAssert.assertTrue(loginErrorPage.errorMessageIsVisible(), "Error message is not visible");
        Thread.sleep(15500); // waiting for 15 seconds until the message disappears
        softAssert.assertFalse(loginErrorPage.errorMessageIsVisible(),
                "Error message is still displayed after 15 seconds");
        softAssert.assertAll();
    }

    @Test
    public static void browserTest() {

    }


}
