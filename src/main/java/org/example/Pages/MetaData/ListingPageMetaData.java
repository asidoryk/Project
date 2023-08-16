package org.example.pages.metaData;

import lombok.Getter;
import org.example.webdriver.controls.Button;
import org.example.webdriver.controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListingPageMetaData extends MetaData {

    @Getter
    public Button addToCartButton;
    @Getter
    public TextBox searchTextBox;
    @Getter
    public Button buyNowButton;

    public ListingPageMetaData(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        addToCartButton = new Button(driver, By.xpath("//input[@id='add-to-cart-button']"), wait);
        buyNowButton = new Button(driver, By.xpath("//input[@id='buy-now-button']"), wait);
    }
}
