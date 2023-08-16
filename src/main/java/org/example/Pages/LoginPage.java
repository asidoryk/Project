package org.example.pages;

import lombok.Getter;
import org.example.pages.metaData.LoginPageMetaData;
import org.example.webdriver.controls.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.example.pages.app.MainApp.MAIN_URL;

public class LoginPage extends Page {

    private LoginPageMetaData metaData;

    public LoginPage(WebDriver driver) {
        super(driver);
        metaData = new LoginPageMetaData(driver);
    }

    public LoginPageMetaData getMetaData() {
        return metaData;
    }

    public void open() {
        if (!this.isApplicationOpened()) {
            driver.get(MAIN_URL);
        }
    }

    public boolean isApplicationOpened() {
        return driver.getCurrentUrl().equals(MAIN_URL);
    }

    public ResultsPage searchItem(String value) {
        getMetaData().getSearchTextBox().setRawValue(value); //TODO change Method in BaseElement
        getMetaData().getSearchButton().click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(value)); //TODO check
        return new ResultsPage(driver);
    }

    private List<String> getSuggestions() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        List<WebElement> suggestionElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 's-suggestion')]")));

        List<String> suggestions = new ArrayList<>();
        for (WebElement suggestionElement : suggestionElements) {
            suggestions.add(suggestionElement.getText());
        }

        return suggestions;
    }


}

