package tests;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ProductsPage;

public class CartTest extends BaseTest {
    @Test(description = "Verifying redirect to products page")
    public void redirectToProductPage(){
        new HeaderPage(driver)
                .clickCartIcon()
                .clickContinue();
        new ProductsPage(driver)
                .verifyPresenceOfItem(true);
    }
}
