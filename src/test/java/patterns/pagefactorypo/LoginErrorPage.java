package patterns.pagefactorypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginErrorPage {

    @FindBy(css = "#notices>.notice.errors")
    private WebElement errorMessage;

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public boolean errorMessageIsVisible() {
        return errorMessage.isDisplayed();
    }
}
