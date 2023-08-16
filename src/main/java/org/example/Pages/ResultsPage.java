package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends Page {

    protected ResultsPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getSearchResults() {
        return driver.findElements(By.xpath("//div[@data-asin]"));
    }

    private List<String> getProductsName() {
        List<WebElement> searchResults = getSearchResults();
        List<String> productsName = new ArrayList<>();

        for (WebElement result : searchResults) {
            WebElement titleElement = result.findElement(By.xpath(".//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
            productsName.add(titleElement.getText());
        }
        return productsName;
    }

    public String getProductPrice(String productName) {
        List<WebElement> searchResults = getSearchResults();

        for (WebElement result : searchResults) {
            WebElement titleElement = result.findElement(By.xpath(".//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
            String title = titleElement.getText();

            if (title.toLowerCase().contains(productName.toLowerCase())) {
                WebElement priceElement = result.findElement(By.xpath(".//span[@class='a-offscreen']"));
                return priceElement.getText();
            }
        }

        return "Price not found";
    }

    private String getProductTitle(WebElement result) {
        WebElement titleElement = result.findElement(By.xpath(".//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
        return titleElement.getText();
    }

    private String getProductRatingFromElement(WebElement result) {
        try {
            WebElement ratingElement = result.findElement(By.xpath(".//span[@class='a-icon-alt']"));
            return ratingElement.getText();
        } catch (Exception e) {
            return null;
        }
    }

    public String getProductRating(String productName) {
        List<WebElement> searchResults = getSearchResults();

        for (WebElement result : searchResults) {
            String title = getProductTitle(result);

            if (title.toLowerCase().contains(productName.toLowerCase())) {
                String rating = getProductRatingFromElement(result);
                if (rating != null) {
                    return rating;
                }
            }
        }

        return null;
    }

    public WebElement getProductLink(String productName) {
        List<WebElement> searchResults = getSearchResults();

        for (WebElement result : searchResults) {
            String title = getProductTitle(result);

            if (title.toLowerCase().contains(productName.toLowerCase())) {
                WebElement linkElement = result.findElement(By.tagName("a"));
                return linkElement;
            }
        }

        return null;
    }
}
