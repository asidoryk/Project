import org.example.BaseTest;
import org.example.pages.ListingPage;
import org.example.pages.LoginPage;
import org.example.pages.ResultsPage;
import org.example.webdriver.controls.DropDown;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    private static final String ITEM_NAME = "iPhone 13 Pro, 256GB, Graphite - Unlocked (Renewed Premium)";

    @Test
    public void testMethod() {
        mainApp().open();

        LoginPage loginPage = new LoginPage(driver);
        ResultsPage resultsPage = loginPage.searchItem(ITEM_NAME);

        ListingPage listingPage = resultsPage.openProduct(ITEM_NAME);
        String price = listingPage.getProductPrice();

        listingPage.addToCard();

    }

}
