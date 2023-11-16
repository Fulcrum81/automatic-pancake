import org.testng.annotations.Test;

public class HomepageTest {

    @Test
    public static void someHomepageTest() {
        helperMethod();
        // assert somethig
        // changes that should conflict
    }

    private static void helperMethod() {
        // do something helpful
    }
}
