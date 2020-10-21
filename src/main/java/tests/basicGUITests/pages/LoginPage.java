package tests.basicGUITests.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    // web elements
    private By username = By.name("email");
    private By password = By.name("password");
    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By errorMessage = By.xpath("//*[@id=\"error-message\"]");
    private By emailError = By.xpath("//*[@id=\"email-error-required\"]");

    public LoginPage() {
    }

    public void emptyLoginFields() {
    }

    public void insertUserData(String username, String password) {
        $(this.username).setValue(username);
        $(this.password).setValue(password);
    }

    public void loginBtnExists() {
        $(loginButton).should(exist);
    }

    public void clickLoginButton() {
        $(loginButton).click();
    }

    public void assertMessage(String msg) {
        $(errorMessage).shouldHave(text(msg));
    }

    public void loginButtonEnabled() {
        $(loginButton).is(enabled);
    }

    public void loginButtonDisabled() {
        $(loginButton).is(disabled);
    }

    public void clickEmptyFields() {
        $(username).click();
        $(password).click();
    }

    public void emailError(String msg) {
        $(emailError).shouldHave(text(msg));
    }

}
