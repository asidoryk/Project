package org.example.webdriver.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface HighlightableElement {

    default void highlight() {
    }

    default void unhighlight() {
    }
}
