package org.example.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page  {

    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }
}
