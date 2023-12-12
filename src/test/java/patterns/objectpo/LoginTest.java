package patterns.objectpo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends TestBase {

    @BeforeMethod
    public static void setup() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        new CertificatePage(driver).acceptCertificate();
    }

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


}
