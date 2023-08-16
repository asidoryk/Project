package org.example.webdriver.controls;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BaseElement<I, O> implements HighlightableElement {

    private final WebDriver driver;
    private final WebElement element;

    private static String ensureVisibleJs = "arguments[0].scrollIntoView();";

    public BaseElement(WebDriver driver, By locator) {
        this.driver = driver;
        this.element = driver.findElement(locator);
    }

    public boolean isVisible() {
        return this.element.isDisplayed();
    }

    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    @Override
    public void highlight() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    @Override
    public void unhighlight() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].style.border=''", element);
    }

    public void click() {
        this.ensureVisible();
        highlight();
        element.click();
    }

    public void submit() {
        highlight();
        element.submit();
    }

    protected String getTypeName() {
        String name = this.getClass().getSimpleName();
        if (StringUtils.isBlank(name)) {
            name = this.getClass().getSuperclass().getSimpleName();
        }

        return name;
    }

    protected BaseElement<I, O> ensureInteractive() {
        if (!this.isEnabled()) {
            throw new IllegalStateException(String.format("%1$s %2$s is disabled", this.getTypeName(), this));
        } else {
            return this;
        }
    }

    public void mouseOver() {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    protected BaseElement<I, O> ensureVisible() {
        if (this.isVisible()) {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript(ensureVisibleJs, this.element);
        }

        return this;
    }

    protected abstract void setRawValue(I var1);

    protected String buildSetValueErrorMessage(I value, Exception exception) {
        return String.format("Cannot set value of %1$s %2$s to '%3$s'", this.getTypeName(), this, value);
    }

    public void setValue(I value) {
        highlight();
        this.ensureInteractive();
        this.ensureVisible();

        try {
            this.setRawValue(value);
        } catch (Exception var7) {
            Exception e = var7;
            Exception suppressed = null;

            String errorMessage;
            try {
                errorMessage = this.buildSetValueErrorMessage(value, e);
            } catch (Exception var6) {
                errorMessage = String.format("Cannot set value of %1$s %2$s to '%3$s'", this.getTypeName(), this, value);
                suppressed = var6;
            }

            IllegalStateException mainException = new IllegalStateException(errorMessage, var7);
            if (suppressed != null) {
                mainException.addSuppressed(suppressed);
            }

            throw mainException;
        }
    }

    public WebElement getWebElement() {
        return this.element;
    }

    public WebDriver getDriver() {
        return this.driver;
    }
}


