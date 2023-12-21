package patterns.staticpo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Listeners({ScreenshotListener.class, SoftAsserts.class})
@Epic("Login")
@Feature("Authorization and Authentication")
public class LoginTest {

    private static final Logger LOG = LogManager.getLogger(LoginTest.class);
    private static final String WRONG_PASSWORD_ERROR_MESSAGE = "Wrong password or the account is disabled, or does not exist";
    private static final String WELCOME_MESSAGE = "You are now logged in as Vadim Zubovich.";

    @BeforeMethod
    public static void methodSetup() throws MalformedURLException {
        LOG.debug("Configuring browser");

        URL hubUrl = new URL("http://192.168.249.1:4444/wd/hub");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.WINDOWS);
        caps.setBrowserName(CHROME);

        RemoteWebDriver driver = new RemoteWebDriver(hubUrl, caps);
        driver.manage().window().maximize();

        WebDriverRunner.setWebDriver(driver);

        LOG.info("Opening application");
        open("https://litecart.stqa.ru/en/");
    }


    @Test
    @Description("Validate error message upon login with incorrect creds (appearance, text and disappearance)")
    public static void loginWithInvalidCredentialsTest() throws Exception {

        LoginPage.login("Skjhkasclhj", "kajakjjkhahskhjk");

        LoginErrorPage.validateErrorMessageText(WRONG_PASSWORD_ERROR_MESSAGE);
        LoginErrorPage.errorMessageIsVisible();

        Thread.sleep(15500); // waiting for 15 seconds until the message disappears
        LoginErrorPage.errorMessageIsInvisible();
    }

    @Test
    @Description("Validate that the user is redirected to new customer page when clicking new customer link")
    public static void registerNewUserLinkTest() throws Exception {
        LoginPage.clickNewCustomerLink();
        NewCustomerPage.validatePageTitle();
    }

    @Test
    @Description("Validate that user-specific controls appear when logged in with correct credentials")
    public static void loginWithCorrectCredentialsTest() throws Exception {

        LoginPage.login("vadim.zubovich@gmail.com", "Test1234!");
        UserHomePage.validateUserPageFields();
    }

    @Test
    @Description("Validate that the welcome message appears when logged in with correct credentials")
    public static void loginWithCorrectCredentialsWelcomeMessageTest() throws Exception {

        LoginPage.login("vadim.zubovich@gmail.com", "Test1234!");
        UserHomePage.validateWelcomeMessage(WELCOME_MESSAGE);
    }

    @Test
    @Description("Fail Validate that the welcome message appears when logged in with correct credentials")
    public static void failLoginWithCorrectCredentialsWelcomeMessageTest() throws Exception {

        LoginPage.login("vadim.zubovich@gmail.com", "Test1234!");
        UserHomePage.validateWelcomeMessage("WELCOME_MESSAGE");
    }

    @Test
    @Description("Broken Validate that the welcome message appears when logged in with correct credentials")
    public static void brokenLoginWithCorrectCredentialsWelcomeMessageTest() throws Exception {
        LoginPage.login("vadim.zubovich@gmail.com", "Test1234!");
        WebDriverRunner.getWebDriver().findElement(By.tagName("slakjdh")).click();
        UserHomePage.validateWelcomeMessage("WELCOME_MESSAGE");
    }

    @AfterMethod
    public static void methodTeardown() {
        WebDriverRunner.closeWebDriver();
    }


    //    @AfterMethod
//    public static void teardown(Method method, ITestResult testResult) {
//        if(testResult.getStatus() == FAILURE) {
//            File screenshot = Selenide.screenshot(OutputType.FILE);
//            try {
//                Allure.addAttachment(testResult.getMethod().getMethodName() + " screenshot", new FileInputStream(screenshot));
//            } catch (FileNotFoundException e) {
//                LOG.warn("Couldn't take screenshot");
//            }
//        }
//    }
}
