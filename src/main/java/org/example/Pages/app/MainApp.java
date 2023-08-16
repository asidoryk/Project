package org.example.pages.app;

import org.openqa.selenium.WebDriver;

public class MainApp {
    private WebDriver driver;
    public static final String MAIN_URL = "https://www.amazon.com/";

    public MainApp(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        if (!isApplicationOpened()) {
            driver.get(MAIN_URL);
        }
    }

    public boolean isApplicationOpened() {
        return driver.getCurrentUrl().equals(MAIN_URL);
    }
}
