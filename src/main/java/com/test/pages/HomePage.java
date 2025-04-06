package com.test.pages;

import org.openqa.selenium.WebDriver;
import com.test.ui.HomePageUI;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isElementDisplayed(HomePageUI.LOGO);
    }

    public String getUserName() {
        return getElementText(HomePageUI.USER_NAME_LABEL);
    }

    public int getProductCount() {
        return waitForElementsVisible(HomePageUI.PRODUCT_TITLES).size();
    }
}