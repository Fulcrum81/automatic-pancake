package patterns.fluentpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private By loginInput = By.name("email");
    private By passwordInput = By.name("password");
    private By loginButton = By.name("login");

    private WebDriver driver;

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage setLogin(String login) {
        driver.findElement(loginInput).sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
        return this;
    }

    public LoginErrorPage attemptLoginWithIncorrectCreds(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new LoginErrorPage(driver);
    }

    public HomePage attemptLoginWithCorrectCreds(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
