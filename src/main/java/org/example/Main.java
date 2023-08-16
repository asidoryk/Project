package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main extends BaseTest {
    public static void main(String[] args) {

        ApplicationManager mainApp = new ApplicationManager();
        mainApp.open();


    }
}