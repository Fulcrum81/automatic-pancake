import org.example.anotherpackage.Deep;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UnitTest {

    @Test
    public static void divisionTest() {
        int a = 10;
        int b = 2;
        int expectedResult = 2;


        System.out.println("starting validation");
        int result = Deep.divideTwoNumbers(a, b);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(result, expectedResult, "my message");
        softAssert.assertTrue(a < b, "Expected a to be smaller than b");
        softAssert.assertEquals(a, b);

        softAssert.assertAll();

        System.out.println("ending validation");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public static void divideByZero() {
        int a = 10;
        int b = 0;
        Deep.divideTwoNumbers(a, b);
    }


    //DO NOT USE JUNIT AND TESTNG IN THE SAME PROJECT!!! (Following code is for learning purpose only)
//    @ParameterizedTest
//    @ValueSource(ints = { 1, 56, 934, 3 })
//    public void parameterizedTest(int a) throws InterruptedException {
//        Thread.sleep(2000);
//        System.out.println("Now running with parameter: " + a);
//        if (a == 56) {
//            Assert.fail();
//        }
//    }

    @Test
    @Parameters(value = "number")
    public void parameterizedTestNgTest(int a) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Now running with parameter: " + a);
        if (a == 56) {
            Assert.fail();
        }
    }

    @Test(dataProvider = "credentials")
    public void dataProviderTest(String login, String password, int a) {

        System.out.println("Attempting login with username: " + login + ", password: " + password + " number: " + a);
    }



    @DataProvider(name = "credentials")
    public Object[][] credentialsProvider() {
        return new Object[][] {
                { "login 1", "password1", 1 },
                { "login 2", "password2", 23 },
                { "login 3", "password3", 98 },
                { "login 4", "password4", 123 }
        };
    }




}
