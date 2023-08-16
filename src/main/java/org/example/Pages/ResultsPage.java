package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultsPage extends Page {

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.cssSelector("div[data-asin]"));
    }

    public List<String> getProductsName() {
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
            WebElement titleElement = result.findElement(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']"));
            String title = titleElement.getText();

            if (title.equalsIgnoreCase(productName)) {
                WebElement priceElement = result.findElement(By.xpath(".//span[@id='priceblock_ourprice' or @id='priceblock_dealprice' or contains(@class, 'a-price')]/span[contains(@class, 'a-offscreen')]"));
                return priceElement.getAttribute("textContent");
            }
        }

        return "Price not found";
    }



    private String getProductTitle(WebElement result) {
        WebElement titleElement = result.findElement(By.xpath("//h2/a/span"));
        return titleElement.getText();
    }

    public List<String> getProductTitles(List<WebElement> searchResults) {
        List<String> allProductsTitles = new ArrayList<>();

        for (WebElement result : searchResults) {
            WebElement titleElement = result.findElement(By.cssSelector("h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-2"));
            allProductsTitles.add(titleElement.getText());
        }
        return allProductsTitles;
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

            if (title.equalsIgnoreCase(productName)) {
                WebElement linkElement = result.findElement(By.xpath("//a[contains(@class, 'link-normal s-underline-text')]"));
                return linkElement;
            }
        }

        return null;
    }

    public ListingPage openProduct(String productName) {
        getProductLink(productName).click();
        return new ListingPage(driver);
    }

    public List<String> getProductTitlesUsingJavaScript() {
        List<String> productTitles = new ArrayList<>();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        List<String> titles = (List<String>) jsExecutor.executeScript(
                "return [...document.querySelectorAll('div[data-asin] h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-2')].map(title => title.textContent);"
        );

        productTitles.addAll(titles);

        return productTitles;
    }
}
