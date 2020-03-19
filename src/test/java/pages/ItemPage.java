package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static pages.ProductsPage.itemName;

public class ItemPage extends BasePage {
    @FindBy(className = "inventory_details")
    WebElement itemDetails;
    @FindBy(className = "btn_primary.btn_inventory")
    WebElement addBtn;
    @FindBy(className = "inventory_details_back_button")
    WebElement backBtn;
    @FindBy(className = "btn_secondary.btn_inventory")
    WebElement removeBtn;
    public ItemPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(backBtn), isPresented);
    }
    @Step("Verifying if user is redirected to details page")
    public ItemPage verifyItemPage() {
        String actualItemName = itemDetails.getText();
        Assert.assertEquals(actualItemName, itemName, "Details page verified with selected item name");
        return this;
    }
    @Step("User click add to cart")
    public ItemPage clickAddBtn(){
        addBtn.click();
        return this;
    }
    @Step("User click remove button")
    public HeaderPage clickRemoveBtn(){
        removeBtn.click();
        return new HeaderPage(driver);
    }
    @Step("User click back button")
    public ProductsPage clickBackButton(){
        backBtn.click();
        return new ProductsPage(driver);
    }

}
