package patterns.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static By loginInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");

    public static void setLogin(WebDriver driver, String login) {
        driver.findElement(loginInput).sendKeys(login);
    }

    public static void setPassword(WebDriver driver, String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public static void clickLoginButton(WebDriver driver) {
        driver.findElement(loginButton).click();
    }

    public static void login(WebDriver driver, String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
