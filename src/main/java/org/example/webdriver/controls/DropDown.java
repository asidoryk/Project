package org.example.webdriver.controls;

import java.util.ArrayList;
import java.util.List;

public class DropDown extends AbstractEditableStringElement {
    private final WebElement dropdownElement;
    private static By menuItemDefault = By.xpath(".//li");
    private static By optionItemDefault = By.tagName("option");

    public DropDown(WebDriver driver, By locator, WebDriverWait wait) {
        super(driver, locator);
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
        return dropdownElement.findElements(optionItemDefault);
    }

    public void expandOption() {
        dropdownElement.click();
    }

    public void collapse() {
        dropdownElement.click();
    }

    public List<String> getAllAvailableValues() {
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

    @Override
    protected void setRawValue(String var1) {

    }
}
