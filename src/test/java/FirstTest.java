import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    @Test
    public void testMethod() {
        mainApp().open();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.searchItem("IPhone 14");
        resultsPage.getSearchResults();
        System.out.println(resultsPage.getProductPrice("iPhone 13 Pro, 256GB, Graphite - Unlocked (Renewed Premium)"));
    }

}
