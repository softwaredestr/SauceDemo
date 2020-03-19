package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    String URL = "https://www.saucedemo.com";
    @FindBy(id = "user-name")
    WebElement userName;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(className = "btn_action")
    WebElement lgnBtn;
    @FindBy(xpath = "//h3[@data-test=error]")
    WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @Override
    @Step("Verifying if user is successfully logged out")
    public void verifyPresenceOfItem(boolean isPresented) {
        Assert.assertEquals(isElementPresented(lgnBtn), isPresented);
    }


    @Step("Open loging page")
    public LoginPage openPage() {
        driver.get(URL);
        return this;
    }
    @Step("User enters name")
    public LoginPage inputName(String name){
        userName.sendKeys(name);
        return this;
    }
    @Step("User enters password")
    public LoginPage inputPassword(String pass){
        password.sendKeys(pass);
        return this;
    }
    @Step("User click login button")
    public LoginPage clickLgn(){
        lgnBtn.click();
        return this;
    }
    @Step("Verifying error message")
    public LoginPage verifyErrorMsg(String error){
        Assert.assertTrue(errorMsg.getText().contains(error), "Correct message displayed");
        return this;

    }




}
