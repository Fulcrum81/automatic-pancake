package patterns.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CertificatePage {

    private static By advancedButton = By.id("details-button");
    private static By proceedLink = By.id("proceed-link");

    public static void acceptCertificate(WebDriver driver) {
        driver.findElement(advancedButton).click();
        driver.findElement(proceedLink).click();
    }

}
