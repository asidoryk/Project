package org.example.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class DropDown extends AbstractEditableStringElement {
    private final WebElement dropdownElement;
    private static By menuItemDefault = By.xpath(".//li");
    private static By optionItemDefault = By.tagName("option");

    public DropDown(WebDriver driver, By locator, WebDriverWait wait) {
        super(driver, locator);
        dropdownElement = driver.findElement(locator);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void setValue(String value) {
        expandOption();
        List<WebElement> options = getOptions();
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                return;
            }
        }
        collapse();
        throw new IllegalArgumentException("Option with value '" + value + "' not found in dropdown");
    }

    public void selectByIndex(int index) {
        clickDropdownPromptToOpen();
        expandOption();
        List<WebElement> options = getOptions();
        if (index >= 0 && index < options.size()) {
            options.get(index).click();
        } else {
            collapse();
            throw new IllegalArgumentException("Invalid index provided: " + index);
        }
    }

    public void setValueContains(String partialValue) {
        expandOption();
        List<WebElement> options = getOptions();
        for (WebElement option : options) {
            if (option.getText().toLowerCase().contains(partialValue.toLowerCase())) {
                option.click();
                return;
            }
        }
        collapse();
        throw new IllegalArgumentException("Option containing value '" + partialValue + "' not found in dropdown");
    }

    public List<WebElement> getOptions() {
        return dropdownElement.findElements(menuItemDefault);
    }

    public void expandOption() {
        dropdownElement.click();
    }

    public void collapse() {
        dropdownElement.click();
    }

    public List<String> getAllAvailableValues() {
        clickDropdownPromptToOpen();
        expandOption();
        List<WebElement> options = getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : options) {
            values.add(option.getText());
        }
        collapse();
        return values;
    }

    public String getValue() {
        return dropdownElement.getAttribute("value");
    }

    public boolean hasValue(String expectedValue) {
        return getValue().equalsIgnoreCase(expectedValue);
    }

    public boolean containsValue(String value) {
        List<WebElement> options = getOptions();
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsValues(List<String> values) {
        for (String value : values) {
            if (!containsValue(value)) {
                return false;
            }
        }
        return true;
    }

    private void clickDropdownPromptToOpen() {
        WebElement dropdownPrompt = dropdownElement.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
        if (dropdownPrompt.isDisplayed()) {
            dropdownPrompt.click();
        }

      dropdownElement.findElement(By.xpath("//a[@id='s-result-sort-select_0']")).click();

    }

    @Override
    protected void setRawValue(String var1) {

    }
}
