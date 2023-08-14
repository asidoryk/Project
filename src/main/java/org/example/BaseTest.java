package org.example;

import org.example.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "/Users/asidoryk/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}

