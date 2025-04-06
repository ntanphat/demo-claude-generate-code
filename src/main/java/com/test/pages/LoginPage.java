package com.test.pages;

import org.openqa.selenium.WebDriver;
import com.test.ui.LoginPageUI;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateTo() {
        navigateToUrl(LoginPageUI.PAGE_URL);
    }

    public void enterEmail(String email) {
        sendKeysToElement(LoginPageUI.EMAIL_FIELD, email);
    }

    public void enterPassword(String password) {
        sendKeysToElement(LoginPageUI.PASSWORD_FIELD, password);
    }

    public void clickLoginButton() {
        clickElement(LoginPageUI.LOGIN_BUTTON);
    }

    public boolean isErrorMessageDisplayed() {
        return isElementDisplayed(LoginPageUI.ERROR_MESSAGE);
    }

    public String getErrorMessage() {
        return getElementText(LoginPageUI.ERROR_MESSAGE);
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void clickForgotPasswordLink() {
        clickElement(LoginPageUI.FORGOT_PASSWORD_LINK);
    }

    public void clickRegisterLink() {
        clickElement(LoginPageUI.REGISTER_LINK);
    }
}