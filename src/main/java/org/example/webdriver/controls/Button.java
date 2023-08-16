package org.example.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Button extends AbstractNonEditableStringElement {

    public Button( WebDriver driver, By locator,  WebDriverWait wait) {
        super(driver, locator);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    protected void setRawValue(Void value) {
        this.click();
    }
}
