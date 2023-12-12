package patterns.pageelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Table {
    WebElement table;

    public Table(WebElement table) {
        this.table = table;
    }

    public int getRowsCount() {
        return table.findElements(By.tagName("tr")).size();
    }

    public int getColumnsCount() {
        return table.findElement(By.tagName("tr")).findElements(By.tagName("th")).size();
    }

    public String getCellText(int row, int column) {
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        List<WebElement> cells = rows.get(row).findElements(By.tagName("td"));

        return cells.get(column).getText();
    }

}
