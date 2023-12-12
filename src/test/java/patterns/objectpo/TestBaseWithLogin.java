package patterns.objectpo;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBaseWithLogin extends TestBase {

    @BeforeMethod
    public static void setup() {
        TestBase.setup();
        System.out.println("logging it");
    }
}
