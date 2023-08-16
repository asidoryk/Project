package org.example.pages.metaData;

import org.example.webdriver.controls.Button;
import org.example.webdriver.controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMetaData extends MetaData{

    @Getter
    public static Button shoppingCart;
    public static TextBox searchTextBox;
    public static Button searchButton;



    public LoginPageMetaData(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        shoppingCart = new Button(driver, driver.findElement(By.id("nav-cart-count")));
        searchTextBox = new TextBox(driver, driver.findElement(By.id("twotabsearchtextbox")));
        searchButton = new Button(driver, driver.findElement(By.id("nav-search-submit-text")));

    }

}
