package org.example.pages.metaData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class MetaData {
    protected WebDriver driver;
    protected WebDriverWait wait;

    protected MetaData(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }
}
