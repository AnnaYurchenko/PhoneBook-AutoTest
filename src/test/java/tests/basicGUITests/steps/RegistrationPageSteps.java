package tests.basicGUITests.steps;

import com.github.javafaker.Faker;
import io.cucumber.docstring.DocString;
import io.cucumber.java8.En;
import tests.basicGUITests.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static tests.basicGUITests.utils.Constants.registrationUrl;

public class RegistrationPageSteps implements En {
    public RegistrationPageSteps() {

        Faker faker = new Faker();
        RegistrationPage registrationPage = new RegistrationPage();

        Given("I am on the Registration page", () -> {
            open(registrationUrl);
        });

        When("I create a user with the valid data", () -> {
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 20);
            registrationPage.insertUserData(email, password, password);
        });

        When("I click SignUp button", () -> {
            registrationPage.clickSignUpButton();
        });

        When("I create a user with the wrong password", () -> {
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(21, 25);
            registrationPage.insertUserData(email, password, password);
        });

        Then("I see error message", (DocString errorMessage) -> {
            String message = errorMessage.getContent();
            registrationPage.assertMessage(message);
        });

        When("Registration fields are not filled out", () -> {
            registrationPage.emptyRegistrationFields();
        });

        When("I see SignUp button is enabled", () -> {
            registrationPage.signUpButtonEnabled();
        });

        When("I see SignUp button is disabled", () -> {
            registrationPage.signUpButtonDisabled();
        });
    }

}
