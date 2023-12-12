package patterns.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TableTest {

    @Test
    public static void tableTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");

        TablePage tablePage = new TablePage(driver);

        System.out.println(tablePage.table1.getColumnsCount());
        System.out.println(tablePage.table2.getRowsCount());

        System.out.println(tablePage.table1.getCellText(4, 5));
        System.out.println(tablePage.table2.getCellText(3, 3));


    }

}
