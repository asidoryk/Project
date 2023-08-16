package org.example.pages.metaData;

import org.openqa.selenium.WebDriver;

public abstract class MetaData {
    protected WebDriver driver;

    protected MetaData(WebDriver driver) {
        this.driver = driver;
    }
}
