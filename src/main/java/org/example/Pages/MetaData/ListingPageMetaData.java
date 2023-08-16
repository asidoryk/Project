package org.example.pages.metaData;

import org.example.webdriver.controls.Button;
import org.example.webdriver.controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListingPageMetaData extends MetaData {

    public static Button addToCartButton;
    public static TextBox searchTextBox;
    public static Button buyNowButton;

    protected ListingPageMetaData(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        addToCartButton = new Button(driver, driver.findElement(By.xpath("//input[@id='add-to-cart-button']")));
        buyNowButton = new Button(driver, driver.findElement(By.xpath("//input[@id='buy-now-button']")));

    }
}
