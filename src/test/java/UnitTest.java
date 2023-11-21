import org.example.anotherpackage.Deep;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

    @Test
    public static void divisionTest() {
        int a = 10;
        int b = 2;
        int expectedResult = 2;


        System.out.println("starting validation");
        int result = Deep.divideTwoNumbers(a, b);
        Assert.assertEquals(result, expectedResult, "my message");
        Assert.assertTrue(true);
        System.out.println("ending validation");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public static void divideByZero() {
        int a = 10;
        int b = 0;
        Deep.divideTwoNumbers(a, b);
    }
}
