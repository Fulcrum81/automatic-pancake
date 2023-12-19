package patterns.cucumber.stepdefs;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import patterns.cucumber.pages.LoginPage;
import patterns.cucumber.pages.LoginErrorPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginStepdefs {

    @Given("user is on application page")
    public void user_is_on_application_page() {
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = "1920x1080";
        open("https://litecart.stqa.ru/en/");
    }

    @When("user enters {string} in username field")
    public void user_enters_string_in_username_field(String username) throws Exception {
        LoginPage.setLogin(username);
    }

    @When("user enters {string} in password field")
    public void user_enters_string_in_password_field(String password) throws Exception {
        LoginPage.setPassword(password);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() throws Exception {
        LoginPage.clickLoginButton();
    }

    @Then("Error message saying {string} appears")
    public void Error_message_saying_string_appears(String message) throws Exception {
        LoginErrorPage.validateErrorMessageText(message);
        LoginErrorPage.errorMessageIsVisible();
    }

    @Then("in {long} seconds the error message disappears")
    public void in_number_seconds_the_error_message_disappears(long timeout) throws Exception {
        Thread.sleep(timeout * 1000 + 500);
        LoginErrorPage.errorMessageIsInvisible();
    }

    @Then("welcome message appears")
    public void welcome_message_appears() {
        // validate welcome message
    }

}
