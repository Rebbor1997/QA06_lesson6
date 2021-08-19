package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.CheckoutInfoPage;

public class CheckoutInfoStep extends BaseStep {
    public CheckoutInfoStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void  checkoutInfo(){
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(browsersService, true);
        checkoutInfoPage.getFirstName();
        checkoutInfoPage.getLastName();
        checkoutInfoPage.getZipcode();
        checkoutInfoPage.continueButtonClick();
    }

    public CheckoutOverviewStep valueObject(User user){
        CheckoutInfoPage checkoutInfoPage = new CheckoutInfoPage(browsersService, false);
        checkoutInfoPage.setFirstName(user.getFirstName());
        checkoutInfoPage.setLastName(user.getLastName());
        checkoutInfoPage.setZipcode(user.getZipCode());
        checkoutInfoPage.continueButtonClick();
        return new CheckoutOverviewStep(browsersService);
    }
}
