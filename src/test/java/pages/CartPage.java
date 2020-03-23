package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends BasePage {
    @FindBy(css = ".inventory_item_name")
    WebElement itemName;
    @FindBy(id = "cart_contents_container")
    WebElement cartContents;
    @FindBy(className = "btn_secondary")
    WebElement continueBtn;
    @FindBy(css = ".checkout_button")
    WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(itemName), isPresented);

    }
    @Step("Click continue shopping button")
    public ProductsPage clickContinue(){
        continueBtn.click();
        return new ProductsPage(driver);
    }
    @Step("Click checkout button")
    public InfoPage clickCheckout(){
        checkoutBtn.click();
        return new InfoPage(driver);
    }
}
