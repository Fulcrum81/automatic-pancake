package patterns.pagefactorypo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    @Test
    public static void invalidLoginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        PageFactory.initElements(driver, CertificatePage.class).acceptCertificate();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        loginPage.login("Skjhkasclhj", "kajakjjkhahskhjk");

        LoginErrorPage loginErrorPage = PageFactory.initElements(driver, LoginErrorPage.class);

        softAssert.assertEquals(loginErrorPage.getErrorMessageText(),
                "Wrong password or the account is disabled, or does not exist");
        softAssert.assertTrue(loginErrorPage.errorMessageIsVisible(), "Error message is not visible");
        Thread.sleep(15500); // waiting for 15 seconds until the message disappears
        softAssert.assertFalse(loginErrorPage.errorMessageIsVisible(),
                "Error message is still displayed after 15 seconds");
        softAssert.assertAll();

        driver.quit();
    }
}
