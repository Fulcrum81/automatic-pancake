package patterns.objectpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CertificatePage {

    private By advancedButton = By.id("details-button");
    private By proceedLink = By.id("proceed-link");

    WebDriver driver;

    public CertificatePage(WebDriver driver) {
        this.driver = driver;
    }

    public void acceptCertificate() {
        driver.findElement(advancedButton).click();
        driver.findElement(proceedLink).click();
    }

}
