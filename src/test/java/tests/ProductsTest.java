package tests;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.ItemPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test(description = "Redirection to Details page")
    public void userIsRedirectedToItemPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getItemName(3);
        productsPage
                .clickItem(3);
        new ItemPage(driver)
                .verifyItemPage();
    }

    @Test(description = "Items count")
    public void itemIsAddedToCart() {
        new ProductsPage(driver)
                .clickAddBtn(2)
                .clickAddBtn(1);
        new HeaderPage(driver)
                .verifyCount("2");
    }

    @Test(description = "Items in cart")
    public void itemIsAddedToCartOnCartPage() {
        new ProductsPage(driver)
                .clickAddBtn(2);
        new HeaderPage(driver)
                .clickCartIcon()
                .verifyPresenceOfItem(true);
    }

    @Test(description = "Empty counter")
    public void itemIsRemovedFromCounter() {
        new ProductsPage(driver)
                .clickAddBtn(2)
                .clickRemoveBtn(1)
                .verifyPresenceOfItem(true);
    }

    @Test(description = "Sort by name in ascending order")
    public void itemsSortedByNameASC() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getItemName(1);
        productsPage
                .sortAtoZ();

    }

    @Test(description = "Sort by name in descending order")
    public void itemsSortedByNameDESC() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortZtoA()
                .getItemName(1);

    }

    @Test(description = "Sort by price in ascending order")
    public void itemsSortedByPriceASC() {
        new ProductsPage(driver)
                .sortPriceLoHi();
    }

    @Test(description = "Sort by price in descending order")
    public void itemsSortedByPriceDESC() {
        new ProductsPage(driver)
                .sortPriceHiLo();
    }
}
