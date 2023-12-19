package patterns.cucumber.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static patterns.staticpo.Locators.getLocator;

public class LoginErrorPage {

    public static void validateErrorMessageText(String errorMessage) throws Exception {
        $(getLocator("loginErrorPage.errorMessage")).shouldHave(Condition.text(errorMessage));
    }

    public static void errorMessageIsVisible() throws Exception {
        $(getLocator("loginErrorPage.errorMessage")).shouldBe(Condition.visible);
    }

    public static void errorMessageIsInvisible() throws Exception {
        $(getLocator("loginErrorPage.errorMessage")).shouldNot(Condition.visible);
    }
}
