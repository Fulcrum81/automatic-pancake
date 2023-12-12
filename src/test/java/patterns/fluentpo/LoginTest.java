package patterns.fluentpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest {

    @Test
    public static void invalidLoginTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        new CertificatePage(driver)
                .acceptCertificate()
                .attemptLoginWithIncorrectCreds("skjdfhds", "ksjdfhk")
                .validateErrorMessageText("Wrong password or the account is disabled, or does not exist")
                .errorMessageIsVisible()
                .waitSeconds(16)
                .errorMessageIsInvisible();

        driver.quit();
    }
}
