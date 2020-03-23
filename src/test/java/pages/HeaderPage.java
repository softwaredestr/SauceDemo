package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HeaderPage extends BasePage {
    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    WebElement itemsCount;
    @FindBy(tagName = "svg")
    WebElement cartIcon;
    @FindBy(xpath = "//button[text()='Open Menu']")
    WebElement menuBtn;
    @FindBy(id = "inventory_sidebar_link")
    WebElement allItems;
    @FindBy(id = "about_sidebar_link")
    WebElement aboutLink;
    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;
    @FindBy(id = "reset_sidebar_link")
    WebElement resetLink;
    public HeaderPage(WebDriver driver) {
        super(driver);
    }
    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(itemsCount), isPresented, "Counter presented");
    }
    @Step("Get items count from cart")
    public String getItemsCount(){
        return itemsCount.getText();
    }
    @Step("Verifying correct number of items in cart")
    public HeaderPage verifyCount(String expectedCount) {
        Assert.assertEquals(getItemsCount(), expectedCount, "Correct count displayed");
        return this;
    }
    @Step("Click cart icon")
    public CartPage clickCartIcon(){
        cartIcon.click();
        return new CartPage(driver);
    }
    @Step("Click menu button")
    public HeaderPage clickMenuBtn(){
        menuBtn.click();
        waitClickableElement(allItems);
        return this;
    }
    @Step("Click All items")
    public ProductsPage clickAllItems(){
        waitClickableElement(allItems);
        allItems.click();
        return new ProductsPage(driver);
    }
    @Step("Click Reset App State")
    public HeaderPage clickReset(){
        waitClickableElement(resetLink);
        resetLink.click();
        waitClickableElement(cartIcon);
        return this;
    }
    @Step("Click About")
    public HeaderPage clickAbout(){
        waitClickableElement(aboutLink);
        aboutLink.click();
        return this;
    }
    @Step("Click Logout")
    public LoginPage clickLogout(){
        logoutLink.click();
        return new LoginPage(driver);
    }
}
