package org.example.webdriver.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TextBox extends AbstractEditableStringElement {

    public TextBox(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    @Override
    protected void setRawValue(String value) {
        this.setValue(this, value); //TODO add waiter
    }

    protected void setValue(AbstractEditableStringElement e, String value) {
        WebElement we = e.getWebElement();
        if (value != null && !value.isEmpty()) {
            this.selectText(we);
            this.enterText(we, value);
        } else {
            this.clearText(we);
        }

    }

    public void selectText(WebElement we) {
        RemoteWebDriver remoteDriver = (RemoteWebDriver) getDriver();

        if (remoteDriver.getCapabilities().getPlatform().is(Platform.MAC)) {
            we.click();
            remoteDriver.executeScript("arguments[0].select()", new Object[]{we});
        } else {
            we.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        }

    }


    public void enterText(WebElement we, String value) {
        we.sendKeys(new CharSequence[]{value});
        Actions actions = new Actions(getDriver());
        actions.sendKeys(we, Keys.TAB).build().perform();
    }

    public void clearText(WebElement we) {
        RemoteWebDriver remoteDriver = (RemoteWebDriver) getDriver();

        if (remoteDriver.getCapabilities().getPlatform().is(Platform.MAC)) {
            this.selectText(we);
            this.enterText(we, " ");
        } else {
            we.clear();
        }

    }

}
