package patterns.objectpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");

        new CertificatePage(driver).acceptCertificate();
    }

    @AfterMethod
    public static void teardown() {
        driver.quit();
    }
}
