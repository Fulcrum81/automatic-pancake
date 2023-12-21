package patterns.staticpo;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static patterns.staticpo.Locators.getLocator;

public class NewCustomerPage {

    public static void validatePageTitle() throws Exception {
        $(getLocator("newCustomerPage.createAccountTitle")).shouldHave(Condition.text("Create Account"));
    }
}
