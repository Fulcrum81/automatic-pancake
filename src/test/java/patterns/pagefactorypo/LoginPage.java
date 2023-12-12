package patterns.pagefactorypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class LoginPage {

    @FindBy(name = "email")
    private WebElement loginInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "login")
    private WebElement loginButton;

    public void setLogin(String login) {
        loginInput.sendKeys(login);
    }

    public void setPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
