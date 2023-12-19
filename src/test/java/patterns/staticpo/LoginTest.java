package patterns.staticpo;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Listeners(ScreenshotListener.class)
@Epic("Login")
@Feature("Authorization and Authentication")
public class LoginTest {

    private static Logger LOG = LogManager.getLogger(LoginTest.class);
    private static String wrongPasswordErrorMessage = "Wrong password or the account is disabled, or does not exist";

    @Test
    @Description("Validate error message upon login with incorrect creds (appearance, text and disappearance)")
    public static void invalidLoginTestSelenide() throws Exception {
        LOG.debug("Configuring browser");

        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = "1920x1080";
        LOG.info("Opening browser");
        open("https://litecart.stqa.ru/en/");

//        CertificatePage.acceptCertificate();

        LoginPage.login("Skjhkasclhj", "kajakjjkhahskhjk");

        LoginErrorPage.validateErrorMessageText(wrongPasswordErrorMessage);
        LoginErrorPage.errorMessageIsVisible();

        Thread.sleep(15500); // waiting for 15 seconds until the message disappears
        LoginErrorPage.errorMessageIsInvisible();
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
