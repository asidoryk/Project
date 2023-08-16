import org.example.BaseTest;
import org.example.pages.LoginPage;
import org.example.pages.ResultsPage;
import org.testng.annotations.Test;


public class FirstTest extends BaseTest {

    @Test
    public void testMethod() {
        mainApp().open();

        LoginPage loginPage = new LoginPage(driver);
        ResultsPage resultsPage = loginPage.searchItem("iPhone 14");
        resultsPage.getProductTitlesUsingJavaScript();

        System.out.println(resultsPage.getProductPrice("iPhone 13 Pro, 256GB, Graphite - Unlocked (Renewed Premium)"));
    }

}
