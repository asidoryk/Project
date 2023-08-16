package org.example.pages;

import org.example.pages.metaData.ListingPageMetaData;
import org.example.pages.metaData.LoginPageMetaData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListingPage extends Page{

    private ListingPageMetaData metaData;

    public ListingPage(WebDriver driver) {
        super(driver);
        metaData = new ListingPageMetaData(driver);
    }

    public ListingPageMetaData getMetaData() {
        return metaData;
    }

    public String getProductPrice() {
        WebElement priceElement = driver.findElement(By.xpath("//span[contains(@class,'apexPriceToPay')]//span[@class = 'a-offscreen']"));
        return priceElement.getAttribute("textContent");
    }

    public void addToCard() {
        getMetaData().getAddToCartButton().click();
    }
}
