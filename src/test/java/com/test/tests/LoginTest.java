package com.test.tests;

import com.test.base.BaseTest;
import com.test.pages.HomePage;
import com.test.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void validLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("test@example.com", "Test@123");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoaded(), "Home page didn't load after login");
    }

    @Test(priority = 2)
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("test@example.com", "wrong_password");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        String actualError = loginPage.getErrorMessage();
        Assert.assertTrue(actualError.contains("Incorrect"), "Error message not as expected");
    }

    @Test(priority = 3)
    public void invalidEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateTo();
        loginPage.login("invalid@example.com", "Test@123");

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
    }

    @Test(priority = 4, dataProvider = "loginData")
    public void multipleLoginTest(String email, String password, boolean expectedResult) {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.navigateTo();
        loginPage.login(email, password);

        if (expectedResult) {
            Assert.assertTrue(homePage.isLoaded(), "Home page didn't load after login");
        } else {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed");
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"test@example.com", "Test@123", true},
                {"invalid@example.com", "Test@123", false},
                {"test@example.com", "wrong_password", false},
                {"", "", false}
        };
    }
}