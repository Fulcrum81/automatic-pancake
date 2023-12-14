package patterns.objectpo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static patterns.objectpo.Browser.chrome;

public class TestBase {
    protected static WebDriver driver;

    @BeforeMethod
    public static void setup() {

        Browser browser = Browser.valueOf(System.getProperty("browser", "edge").toUpperCase());

        switch(browser) {
            case chrome:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                driver = new ChromeDriver(chromeOptions);
                break;
            case edge:
                EdgeOptions edgeCaps = new EdgeOptions();
                edgeCaps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                new EdgeDriver(edgeCaps);
                break;
            case firefox:
                FirefoxOptions firefoxCaps = new FirefoxOptions();
                firefoxCaps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                new FirefoxDriver(firefoxCaps);
                break;
            case safari:
                SafariOptions safariCaps = new SafariOptions();
                safariCaps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
                new SafariDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get("https://litecart.stqa.ru/en/");
    }

    @AfterMethod
    public static void teardown() {
        driver.quit();
    }
}
