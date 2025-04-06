package com.test.ui;

import org.openqa.selenium.By;

public class LoginPageUI {
    // Page URL
    public static final String PAGE_URL = "https://rahulshettyacademy.com/client";

    // Locators
    public static final By EMAIL_FIELD = By.xpath("//input[@id='userEmail']");
    public static final By PASSWORD_FIELD = By.xpath("//input[@id='userPassword']");
    public static final By LOGIN_BUTTON = By.xpath("//input[@id='login']");
    public static final By ERROR_MESSAGE = By.cssSelector(".ng-trigger-flyInOut");
    public static final By FORGOT_PASSWORD_LINK = By.xpath("//a[contains(text(),'Forgot password?')]");
    public static final By REGISTER_LINK = By.xpath("//a[contains(text(),'Register here')]");
}