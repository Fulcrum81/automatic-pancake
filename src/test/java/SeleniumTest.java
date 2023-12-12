import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    @Test
    public static void firstSeleniumTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");

        Thread.sleep(5000);
        // [alt='Yellow Duck']

//        List<WebElement> checkboxesLinks = driver.findElements(By.cssSelector("aside[class='column-left']"));

        WebElement emailText = driver.findElement(By.cssSelector("[name='login_form'] tr:first-of-type>td"));

        String expectedText = "Email Address *";
        String actualText = emailText.getText();

        Assert.assertEquals(actualText, expectedText);


//        WebElement logotype = driver.findElement(By.id("logotype-wrapper"));
//
//        WebElement searchInput = driver.findElement(By.name("search_form"));
//        searchInput.sendKeys("Purple duck");

        driver.quit();
    }

    @Test
    public static void redAsteriskTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");

        Thread.sleep(5000);

        WebElement asterisk = driver.findElement(By.cssSelector("[name='login_form'] span.required"));

        String expectedColor = "rgba(255, 0, 0, 1)";
        String actualColor = asterisk.getCssValue("color");

        Assert.assertEquals(actualColor, expectedColor);
        driver.quit();
    }

    @Test
    public static void embeddedElementTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://litecart.stqa.ru/en/");

        Thread.sleep(5000);

        WebElement searchColumn = driver.findElement(By.xpath("//aside[@id='navigation']//div[@class='search column']"));

        List<WebElement> searchInputs = searchColumn.findElements(By.xpath("//*[@class='box']"));

        driver.quit();
    }

    @Test
    public static void doubleClickTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        WebElement button =
                driver.findElement(By.cssSelector("button[ondblclick]"));
        Actions builder = new Actions(driver);
        builder.doubleClick(button).perform();
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public static void dragNDropTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");
        WebElement ball = driver.findElement(By.id("ball"));
        WebElement goal = driver.findElement(By.id("gate"));
        Actions builder = new Actions(driver);
//        builder.dragAndDrop(ball, goal).perform();

        builder.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        driver.quit();
    }

    @Test
    public static void alertTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertButton = driver.findElement(By.cssSelector("[onclick='jsAlert()']"));
        jsAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "You successfully clicked an alert");

        driver.quit();
    }

    @Test
    public static void confirmTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertButton = driver.findElement(By.cssSelector("[onclick='jsConfirm()']"));
        jsAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "You clicked: Ok");

        jsAlertButton.click();

        alert = driver.switchTo().alert();
        alert.dismiss();

        Assert.assertEquals(result.getText(), "You clicked: Cancel");

        driver.quit();
    }

    @Test
    public static void promptTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsAlertButton = driver.findElement(By.cssSelector("[onclick='jsPrompt()']"));
        jsAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, alert");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "You entered: Hello, alert");

        driver.quit();
    }

    @Test
    public static void dropdownTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        dropdown.selectByVisibleText("Option 1");

        driver.quit();
    }

    @Test
    public static void waiterTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement awaitedElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("my locator")));
        waitForJquery(driver, 15);
    }

    public static void waitForJquery(WebDriver driver, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor)driver;

                return (Boolean)js.executeScript("return jQuery.active === 0");
            }
        });
    }

    @Test
    public static void framesTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftFrameText = driver.findElement(By.tagName("body"));

        String text = leftFrameText.getText();

        Assert.assertEquals(text.trim(), "LEFT");

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        // do something in middle frame

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        // do something in right frame

        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        // do something in bottom frame
    }

    @Test
    public static void multiTabsTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/windows");

        driver.findElement(By.cssSelector("[href='/windows/new']")).click();

        String newWindowHandle = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(newWindowHandle);

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "New Window");

        driver.close();

        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

        Assert.assertEquals(driver.findElement(By.tagName("h3")).getText(), "Opening a new window");

    }

    @Test
    public static void shadowRootTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://canvas.apps.chrome/");

        WebElement rootElement = driver.findElement(By.id("id"));
        SearchContext shadowRoot = getShadowRoot(driver, rootElement);

        WebElement inlayShadowRootElement = shadowRoot.findElement(By.name("name"));

        WebElement button1 = inlayShadowRootElement.findElement(By.tagName("tag"));
        button1.click();


        SearchContext inlayShadowRoot = getShadowRoot(driver, inlayShadowRootElement);

        WebElement doubleInlayShadowRootElement = inlayShadowRoot.findElement(By.id("ksjdhvjkh"));

        SearchContext doubleInlayShadowRoot = getShadowRoot(driver, doubleInlayShadowRootElement);

        WebElement button2 = inlayShadowRootElement.findElement(By.cssSelector("button[class='my_class']"));
        button2.click();



    }

    public static SearchContext getShadowRoot(WebDriver driver, WebElement rootElement) {
        return (SearchContext) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", rootElement);
    }
}
