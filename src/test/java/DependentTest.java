import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class DependentTest {

    @Test
    public static void superadminLoginTest() {
        System.out.println("Logged in as superadmin");
    }

    @Test(dependsOnMethods = "superadminLoginTest", alwaysRun = true)
    public static void superadminCreateUserTest() {
        System.out.println("Created new user");
        Assert.fail();
    }

    @Test(dependsOnMethods = "superadminCreateUserTest", alwaysRun = true)
    public static void superadminEditUserTest() {
        System.out.println("Edited existing user");
    }

    @Test(dependsOnMethods = "superadminEditUserTest", alwaysRun = true)
    public static void superadminDeleteUserTest() {
        System.out.println("Deleted existing user");
    }
}
