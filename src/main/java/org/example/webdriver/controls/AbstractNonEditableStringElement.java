package org.example.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbstractNonEditableStringElement extends AbstractStringElement<Void>{

    protected AbstractNonEditableStringElement(WebDriver driver, By locator) {
        super(driver, locator);
    }

    @Override
    protected void setRawValue(Void value) {
        throw new UnsupportedOperationException("Buttons do not support setting raw value.");
    }

}
