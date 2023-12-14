package patterns.staticpo;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    private static String wrongPasswordErrorMessage = "Wrong password or the account is disabled, or does not exist";

    @Test
    public static void invalidLoginTestSelenide() throws Exception {

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = "1920x1080";

        open("https://litecart.stqa.ru/en/");

//        CertificatePage.acceptCertificate();

        LoginPage.login("Skjhkasclhj", "kajakjjkhahskhjk");

        LoginErrorPage.validateErrorMessageText(wrongPasswordErrorMessage);
        LoginErrorPage.errorMessageIsVisible();

        Thread.sleep(15500); // waiting for 15 seconds until the message disappears
        LoginErrorPage.errorMessageIsInvisible();
    }
}
