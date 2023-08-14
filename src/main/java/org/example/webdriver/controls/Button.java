package org.example.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Button extends AbstractNonEditableStringElement {

    public Button( WebDriver driver, WebElement element) {
        super(driver, element);
    }

    protected void setRawValue(Void value) {
        this.click();
    }
}
