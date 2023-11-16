import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainTest {

    @Test
    public static void firstTest() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/rubber-ducks-c-1/");

        // some code that fixes main test
    }
}
