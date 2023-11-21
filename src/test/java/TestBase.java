import org.testng.annotations.*;

public class TestBase {

    @BeforeTest
    public static void dataSetup() {
        System.out.println("BEFORE: Preparing application data");
    }

    @AfterTest
    public static void dataCleanup() {
        System.out.println("AFTER: Cleaning up application data");
    }

//    @BeforeGroups("regression")
//    public static void regressionSetup() {
//        System.out.println("BEFORE: Preparing for regression");
//    }
//
//    @AfterGroups("regression")
//    public static void regressionTeardown() {
//        System.out.println("AFTER: Finishing regression");
//    }
//
//    @BeforeGroups("smoke")
//    public static void smokeSetup() {
//        System.out.println("BEFORE: Preparing for smoke testing");
//    }

    @BeforeClass
    public static void classSetup() {
        System.out.println("BEFORE: Before class");
    }

    @AfterClass
    public static void classTeardown() {
        System.out.println("AFTER: After class");
    }

    @BeforeMethod
    public static void testSetup() {
        System.out.println("BEFORE: Opening browser with app url");
    }

    @AfterMethod
    public static void testTeardown() {
        System.out.println("AFTER: Closing browser");
    }
}
