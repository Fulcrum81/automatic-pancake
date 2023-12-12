package patterns.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TablePage {
    Table table1;
    Table table2;

    private By table1Locator = By.id("table1");
    private By table2Locator = By.id("table2");

    public TablePage(WebDriver driver) {
        table1 = new Table(driver.findElement(table1Locator));
        table2 = new Table(driver.findElement(table2Locator));
    }

}
