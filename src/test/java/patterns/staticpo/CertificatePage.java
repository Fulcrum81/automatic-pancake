package patterns.staticpo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class CertificatePage {

    private static By advancedButton = By.id("details-button");
    private static By proceedLink = By.id("proceed-link");

    public static void acceptCertificate() {
        $(advancedButton).click();
        $(proceedLink).click();
    }

}
