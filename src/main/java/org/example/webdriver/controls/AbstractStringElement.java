package org.example.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractStringElement<I> extends BaseElement<I, String> {
    protected AbstractStringElement( WebDriver driver, WebElement element) {
        super(driver, element);
    }
}
