package patterns.fluentpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginErrorPage {

    private By errorMessage = By.cssSelector("#notices>.notice.errors");

    WebDriver driver;

    public LoginErrorPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginErrorPage validateErrorMessageText(String expectedMessage) {
        Assert.assertEquals(driver.findElement(errorMessage).getText(), expectedMessage);
        return this;
    }

    public LoginErrorPage errorMessageIsVisible() {
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed());
        return this;
    }

    public LoginErrorPage waitSeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
        return this;
    }

    public LoginErrorPage errorMessageIsInvisible() {
        Assert.assertFalse(driver.findElement(errorMessage).isDisplayed());
        return this;
    }
}
