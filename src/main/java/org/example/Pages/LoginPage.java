package org.example.pages;

import org.example.pages.metaData.LoginPageMetaData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends Page{

    private LoginPageMetaData metaData;

    public LoginPage(WebDriver driver) {
        super(driver);
        metaData = new LoginPageMetaData(driver);
    }

    public LoginPageMetaData getMetaData() {
        return metaData;
    }

    private void open() {
        driver.get("https://www.amazon.com/");
    }


    private void searchItem(String value) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(value)); //TODO check
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

