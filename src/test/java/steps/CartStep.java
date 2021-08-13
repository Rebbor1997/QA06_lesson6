package steps;

import baseEntities.BasePage;
import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.PaymentPage;

public class CartStep extends BaseStep {

    public CartStep(WebDriver driver)  {
        super(driver);
    }

    public void removeFromCart(String productName){
        CartPage cartPage = new CartPage(driver, true);
        cartPage.removeElementCart(productName);
    }

    public void checkoutYourInformation(String firstname, String lastname, String zip) {
        PaymentPage paymentPage = new PaymentPage(driver, true);
        paymentPage.setFirstName(firstname);
        paymentPage.setLastName(lastname);
        paymentPage.setPostalCode(zip);
        paymentPage.ContinueClick();
        paymentPage.FinishClick();
    }
}
