package org.example.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractEditableStringElement extends AbstractStringElement<String> {

    protected AbstractEditableStringElement(WebDriver driver, WebElement element) {
        super(driver, element);
    }

}
