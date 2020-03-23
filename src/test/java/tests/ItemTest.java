package tests;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ProductsPage;

public class ItemTest extends BaseTest {
    @Test(description = "Verification of added products in counter")
    public void addedProductsInCounter(){
        new ProductsPage(driver)
                .clickAddBtn(2)
                .clickAddBtn(1);
        new HeaderPage(driver)
                .verifyCount("2");
    }
    @Test(description = "Adding products in cart")
    public void addingProducts(){
        new ProductsPage(driver)
                .clickAddBtn(2)
                .clickAddBtn(1);
        new HeaderPage(driver)
                .clickCartIcon()
                .verifyPresenceOfItem(true);
    }
    @Test(description = "Removing products from counter")
    public void removingProductsFromCounter(){
        new ProductsPage(driver)
                .clickAddBtn(1)
                .clickRemoveBtn(1);
        new HeaderPage(driver)
                .clickCartIcon()
                .verifyPresenceOfItem(false);
    }
}
