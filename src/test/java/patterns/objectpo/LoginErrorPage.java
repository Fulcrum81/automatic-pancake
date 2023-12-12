package patterns.objectpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginErrorPage {

    private By errorMessage = By.cssSelector("#notices>.notice.errors");

    WebDriver driver;

    public LoginErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }

    public boolean errorMessageIsVisible() {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
