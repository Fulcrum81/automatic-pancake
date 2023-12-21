package patterns.staticpo;


import com.codeborne.selenide.AssertionMode;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.$;
import static patterns.staticpo.Locators.getLocator;

public class UserHomePage {

    public static void validateUserPageFields() throws Exception {
        Configuration.assertionMode = AssertionMode.SOFT;
        $(getLocator("userHomePage.customerServiceLink")).shouldBe(Condition.visible);
        $(getLocator("userHomePage.orderHistoryLink")).shouldBe(Condition.visible);
        $(getLocator("userHomePage.editAccount")).shouldBe(Condition.visible);
        $(getLocator("userHomePage.logoutLink")).shouldBe(Condition.visible);

        Configuration.assertionMode = AssertionMode.STRICT;
    }

    public static void validateWelcomeMessage(String message) throws Exception {
        $(getLocator("userHomePage.message")).shouldBe(Condition.visible).shouldHave(Condition.text(message));
    }
}
