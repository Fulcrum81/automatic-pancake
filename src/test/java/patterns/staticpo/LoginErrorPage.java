package patterns.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginErrorPage {

    private static By errorMessage = By.cssSelector("#notices>.notice.errors");

    public static String getErrorMessageText(WebDriver driver) {
        return driver.findElement(errorMessage).getText();
    }

    public static boolean errorMessageIsVisible(WebDriver driver) {
        return driver.findElement(errorMessage).isDisplayed();
    }
}
