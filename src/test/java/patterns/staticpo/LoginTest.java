package patterns.staticpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    private static String wrongPasswordErrorMessage = "Wrong password or the account is disabled, or does not exist";

    @Test
    public static void invalidLoginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        CertificatePage.acceptCertificate(driver);

        LoginPage.login(driver, "Skjhkasclhj", "kajakjjkhahskhjk");

        String messageText = LoginErrorPage.getErrorMessageText(driver);
        boolean messageIsDisplayed = LoginErrorPage.errorMessageIsVisible(driver);

        softAssert.assertEquals(messageText,wrongPasswordErrorMessage);
        softAssert.assertTrue(messageIsDisplayed, "Error message is not visible");
        Thread.sleep(15500); // waiting for 15 seconds until the message disappears
        messageIsDisplayed = LoginErrorPage.errorMessageIsVisible(driver);
        softAssert.assertFalse(messageIsDisplayed,"Error message is still displayed after 15 seconds");
        softAssert.assertAll();

        driver.quit();
    }
}
