package tests.basicGUITests.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public RegistrationPage() {
    }

    //web elements
    private By username = By.name("email");
    private By password = By.name("password");
    private By confirmPass = By.name("confirm-password");
    private By signUpButton = By.xpath("//*[@id=\"registration-form\"]/div[4]/div[1]/button");
    private By errorMessage = By.id("password-error-maxlength");

    public void insertUserData(String username, String password, String confirmPass) {
        $(this.username).setValue(username);
        $(this.password).setValue(password);
        $(this.confirmPass).setValue(confirmPass);
    }

    public void emptyRegistrationFields() {
    }

    public RegistrationConfirmationPage clickSignUpButton() {
        $(signUpButton).click();
        return new RegistrationConfirmationPage();
    }

    public void assertMessage(String msg) {
        $(errorMessage).shouldHave(text(msg));
    }

    public void signUpButtonEnabled() {
        $(signUpButton).is(enabled);
    }

    public void signUpButtonDisabled() {
        $(signUpButton).is(disabled);
    }

}
