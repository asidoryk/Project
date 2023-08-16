package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    private WebDriver driver;
    private LoginPage mainPage;

    public ApplicationManager() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\42770\\chromedriver.exe");

        driver = new ChromeDriver();
        mainPage = new LoginPage(driver);
    }

    public void open() {
        driver.get("https://www.amazon.com");
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    public LoginPage getLoginPage() {
        return mainPage;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
