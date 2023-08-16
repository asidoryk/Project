package org.example.pages.metaData;


import lombok.Getter;
import org.example.webdriver.controls.Button;
import org.example.webdriver.controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMetaData extends MetaData{

    @Getter
    private Button shoppingCart;
    @Getter
    private TextBox searchTextBox;
    @Getter
    private Button searchButton;


    public LoginPageMetaData(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {

        shoppingCart = new Button(driver, By.id("nav-cart-count"), wait);
        searchTextBox = new TextBox(driver, By.id("twotabsearchtextbox"), wait);
        searchButton = new Button(driver, By.id("nav-search-submit-text"), wait);

    }

}
