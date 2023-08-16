package org.example.pages;

import org.example.pages.metaData.LoginPageMetaData;
import org.openqa.selenium.WebDriver;

public class ListingPage extends Page{

    private LoginPageMetaData metaData;

    public ListingPage(WebDriver driver) {
        super(driver);
        metaData = new LoginPageMetaData(driver);
    }

    public LoginPageMetaData getMetaData() {
        return metaData;
    }
}
