package tests.basicGUITests.steps;

import com.github.javafaker.Faker;
import io.cucumber.docstring.DocString;
import io.cucumber.java8.En;
import tests.basicGUITests.pages.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static tests.basicGUITests.utils.Constants.loginUrl;

public class LoginPageSteps implements En {
    public LoginPageSteps() {

        LoginPage loginPage = new LoginPage();
        Faker faker = new Faker();

        Given("I am on the Login page", () -> {
            open(loginUrl);
        });

        When("I enter the valid data", () -> {
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();
            loginPage.insertUserData(email, password);
        });

        Then("I see Login button", () -> {
            loginPage.loginBtnExists();
        });

        When("I click on the Login button", () -> {
            loginPage.clickLoginButton();
        });

        Then("I see activation error message", (DocString errorMessage) -> {
            String message = errorMessage.getContent();
            loginPage.assertMessage(message);
        });

        When("Login fields are not filled out", () -> {
            loginPage.emptyLoginFields();
        });

        When("I see Login button is enabled", () -> {
            loginPage.loginButtonEnabled();
        });

        When("I see Login button is disabled", () -> {
            loginPage.loginButtonDisabled();
        });

        When("I click on the empty fields", () -> {
            loginPage.clickEmptyFields();
        });

        Then("I see empty fields error message", (DocString errorMessage) -> {
            String message = errorMessage.getContent();
            loginPage.assertMessage(message);
        });
    }

}
