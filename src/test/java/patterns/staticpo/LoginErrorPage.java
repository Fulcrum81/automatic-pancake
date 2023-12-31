package patterns.staticpo;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static patterns.staticpo.Locators.getLocator;

public class LoginErrorPage {

    @Step("Validating message text")
    public static void validateErrorMessageText(String errorMessage) throws Exception {
        $(getLocator("loginErrorPage.errorMessage")).shouldHave(Condition.text(errorMessage));
    }

    @Step("Validating message visibility")
    public static void errorMessageIsVisible() throws Exception {
        $(getLocator("loginErrorPage.errorMessage")).shouldBe(Condition.visible);
    }


    @Step("Validating that message disappears")
    public static void errorMessageIsInvisible() throws Exception {
        $(getLocator("loginErrorPage.errorMessage")).shouldNot(Condition.visible);
    }
}
