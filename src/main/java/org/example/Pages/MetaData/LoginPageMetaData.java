package org.example.Pages.MetaData;

import org.example.webdriver.controls.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMetaData {
    private final WebDriver driver;

    public Button shoppingCart;

    public LoginPageMetaData(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        shoppingCart = new Button(driver, driver.findElement(By.id("nav-cart-count")));
    }
}
