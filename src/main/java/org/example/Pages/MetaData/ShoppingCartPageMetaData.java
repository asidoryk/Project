package org.example.pages.metaData;

import org.example.webdriver.controls.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPageMetaData extends MetaData {

    protected ShoppingCartPageMetaData(WebDriver driver) {
        super(driver);
    }

    Button goToCartButton = new Button(driver, By.xpath("//span[contains(@class,'a-button a-spacing-top-base')]"), wait);
    Button proceedToCheckoutButton = new Button(driver, By.xpath("//input[@name='proceedToRetailCheckout']"), wait);
    Button cartSubtotalAmount = new Button(driver, By.xpath("//span[@class='a-price sw-subtotal-amount']//span[@class='a-offscreen']"), wait); //TODO change type

}
