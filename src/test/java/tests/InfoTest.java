package tests;

import org.testng.annotations.Test;
import pages.HeaderPage;
import pages.InfoPage;

public class InfoTest extends BaseTest {
    @Test(description = "Cancel checkout")
    public void cancelCheckout(){
        new HeaderPage(driver)
                .clickCartIcon()
                .clickCheckout()
                .clickCancel()
                .verifyPresenceOfItem(false);
    }
    @Test(description = "Click checkout")
    public void clickCheckout(){
        new HeaderPage(driver)
                .clickCartIcon()
                .clickCheckout();
        new InfoPage(driver)
                .verifyPresenceOfItem(true);
    }
    @Test(description = "Fill in the fields on the information page")
    public void fillFields(){
        new HeaderPage(driver)
                .clickCartIcon()
                .clickCheckout();
        new InfoPage(driver)
                .nameInput("dsda")
                .lastNameInput("sdasda")
                .postalCodeInput("123")
                .clickContinue();
    }
    @Test(description = "Verifying first name error message")
    public void verifyingErrorFirstName(){
        new HeaderPage(driver)
                .clickCartIcon()
                .clickCheckout();
        new InfoPage(driver)
                .lastNameInput("sdasda")
                .postalCodeInput("123")
                .clickContinue()
                .verifyErrorMsg("Error: First Name is required");
    }
    @Test(description = "Verifying last name error message")
    public void verifyingErrorLastName(){
        new HeaderPage(driver)
                .clickCartIcon()
                .clickCheckout();
        new InfoPage(driver)
                .nameInput("sdasda")
                .postalCodeInput("123")
                .clickContinue()
                .verifyErrorMsg("Error: Last Name is required");
    }
    @Test(description = "Verifying postal code error message")
    public void verifyingErrorPostalCode(){
        new HeaderPage(driver)
                .clickCartIcon()
                .clickCheckout();
        new InfoPage(driver)
                .nameInput("sdasda")
                .lastNameInput("sds")
                .clickContinue()
                .verifyErrorMsg("Error: Postal Code is required");
    }
}
