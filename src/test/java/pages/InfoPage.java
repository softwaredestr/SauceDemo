package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class InfoPage extends BasePage {
    @FindBy(id = "checkout_info_container")
    WebElement container;
    @FindBy(id = "first-name")
    WebElement name;
    @FindBy(id = "last-name")
    WebElement lastName;
    @FindBy(id = "postal-code")
    WebElement postalCode;
    @FindBy(css = ".btn_secondary")
    WebElement cancelBtn;
    @FindBy(css = ".btn_primary")
    WebElement continueBtn;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMsg;


    public InfoPage(WebDriver driver){
        super(driver);
    }

    @Override
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(container), isPresented);
    }
    @Step("Input name")
    public InfoPage nameInput(String firstName){
        name.sendKeys(firstName);
        waitClickableElement(lastName);
        return this;
    }
    @Step("Input last name")
    public InfoPage lastNameInput(String last){
        lastName.sendKeys(last);
        waitClickableElement(postalCode);
        return this;
    }
    @Step("Input postal code")
    public InfoPage postalCodeInput(String code){
        postalCode.sendKeys(code);
        return this;
    }
    @Step("Click continue button")
    public InfoPage clickContinue(){
        continueBtn.click();
        return this;
    }
    @Step("Click cancel button")
    public CartPage clickCancel(){
        waitClickableElement(cancelBtn);
        cancelBtn.click();
        return new CartPage(driver);
    }
    @Step("Verifying error message")
    public InfoPage verifyErrorMsg(String message){
        waitVisibleElement(errorMsg);
        Assert.assertEquals(errorMsg.getText(), message);
        return this;
    }
}
