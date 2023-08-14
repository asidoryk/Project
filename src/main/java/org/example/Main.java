package org.example;

import org.example.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main extends BaseTest{
    public static void main(String[] args) {


        LoginPage loginPage = new LoginPage(driver);
        loginPage.getMetaData().shoppingCart.highlight();
    }
}