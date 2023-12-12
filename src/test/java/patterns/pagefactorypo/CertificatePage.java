package patterns.pagefactorypo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CertificatePage {

    @FindBy(id = "details-button")
    private WebElement advancedButton;
    @FindBy(id = "proceed-link")
    private WebElement proceedLink;

    public void acceptCertificate() {
        advancedButton.click();
        proceedLink.click();
    }

}
