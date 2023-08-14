package org.example;

import org.example.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main extends BaseTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\42770\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("amazon.com");
        ApplicationManager mainApp = new ApplicationManager();
        mainApp.open();

        LoginPage loginPage = new LoginPage(mainApp.getDriver());
        loginPage.getMetaData().shoppingCart.click();
    }
}