package patterns.staticpo;

import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static patterns.staticpo.Locators.getLocator;

public class LoginPage {
    public static void setLogin(String login) throws Exception {
        $(getLocator("loginPage.loginInput")).sendKeys(login);
    }

    public static void setPassword(String password) throws Exception {
        $(getLocator("loginPage.passwordInput")).sendKeys(password);
    }

    public static void clickLoginButton() throws Exception {
        $(getLocator("loginPage.loginButton")).click();
    }

    public static void login(String login, String password) throws Exception {
        $(getLocator("loginPage.loginInput")).sendKeys(login);
        $(getLocator("loginPage.passwordInput")).sendKeys(password);
        $(getLocator("loginPage.loginButton")).click();
    }
}
