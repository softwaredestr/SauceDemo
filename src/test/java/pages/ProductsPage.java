package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ProductsPage extends BasePage{
    public static String itemName;
    @FindBy(className = "product_label")
    WebElement productsTitle;
    @FindBy(className = "inventory_item_name")
    List<WebElement> items;
    @FindBy(className = "btn_primary.btn_inventory")
    List<WebElement> addBtns;
    @FindBy(className = "btn_secondary.btn_inventory")
    List<WebElement> removeBtns;
    @FindBy(className = "product_sort_container")
    WebElement sortMenu;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void verifyPresenceOfItem(boolean isPresented){
        Assert.assertEquals(isElementPresented(productsTitle), isPresented);
    }
    @Step("Getting item name")
    public String getItemName(int itemNumber){
         itemName = items.get(itemNumber - 1).getText();
         return itemName;
    }
    @Step("Select item")
    public ItemPage clickItem(int itemNumber){
        items.get(itemNumber - 1).click();
        return new ItemPage(driver);
    }
    @Step("Click add to cart")
    public ProductsPage clickAddBtn(int itemNumber){
        addBtns.get(itemNumber - 1).click();
        return this;
    }
    @Step("Click remove button")
    public ProductsPage clickRemoveBtn(int itemNumber){
        removeBtns.get(itemNumber - 1).click();
        return this;
    }
    @Step("Select sorting by Name (A to Z)")
    public ProductsPage sortAtoZ(){
        Select select = new Select(sortMenu);
        select.selectByValue("az");
        return this;
    }
    @Step("Select sorting by Name (Z to A)")
    public ProductsPage sortZtoA(){
        Select select = new Select(sortMenu);
        select.selectByValue("za");
        return this;
    }
    @Step("Select sorting by Price (low to high)")
    public ProductsPage sortPriceLoHi(){
        Select select = new Select(sortMenu);
        select.selectByValue("lohi");
        return this;
    }
    @Step("Select sorting by Price (high to low)")
    public ProductsPage sortPriceHiLo(){
        Select select = new Select(sortMenu);
        select.selectByValue("hilo");
        return this;
    }


}
