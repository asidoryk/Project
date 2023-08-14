package org.example.Pages;

import org.example.Pages.MetaData.LoginPageMetaData;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;
    private LoginPageMetaData metaData;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        metaData = new LoginPageMetaData(driver);
    }

    public LoginPageMetaData getMetaData() {
        return metaData;
    }

    public void open() {
        driver.get("https://www.amazon.com/");
    }
}
