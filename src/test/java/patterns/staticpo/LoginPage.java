package patterns.staticpo;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

import static com.codeborne.selenide.Selenide.$;
import static patterns.staticpo.Locators.getLocator;

public class LoginPage {
    static Logger LOG = LogManager.getLogger(LoginPage.class);

    public static void setLogin(String login) throws Exception {
        LOG.info("Attempting to set username");
        $(getLocator("loginPage.loginInput")).sendKeys(login);
        LOG.debug("Username successfully set");
    }

    public static void setPassword(String password) throws Exception {
        LOG.info("Attempting to set password");
        $(getLocator("loginPage.passwordInput")).sendKeys(password);
        LOG.debug("Password successfully set");
    }

    public static void clickLoginButton() throws Exception {
        LOG.info("Attempting to click login button");
        $(getLocator("loginPage.loginButton")).click();
        LOG.debug("Login button successfully clicked");
    }

    @Step("Entering credentials, clicking login button")
    public static void login(String login, String password) throws Exception {
        LOG.info("Attempting to login with credentials: un: " + login + ", pw: " + password);
        $(getLocator("loginPage.loginInput")).sendKeys(login);
        $(getLocator("loginPage.passwordInput")).sendKeys(password);
        $(getLocator("loginPage.loginButton")).click();
        LOG.debug("Login operation complete");
    }

    @Step("Clicking New Customers link")
    public static void clickNewCustomerLink() throws Exception {
        LOG.info("Clicking new customer link");
        $(getLocator("loginPage.newCustomerLink")).click();
    }
}
