import org.testng.annotations.Test;

public class HomepageTest extends TestBase {

    @Test(groups = "smoke", timeOut = 1000)
    public static void someHomepageTest() throws InterruptedException {
        System.out.println("TEST: homepage test");
        helperMethod();
    }

    private static void helperMethod() throws InterruptedException {
        System.out.println("HELPER: doing something helpful");
        Thread.sleep(2000);
    }
}
