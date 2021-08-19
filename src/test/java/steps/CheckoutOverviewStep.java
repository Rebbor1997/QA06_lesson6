package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import pages.CheckoutOverviewPage;

public class CheckoutOverviewStep extends BaseStep {
    public CheckoutOverviewStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void checkoutOverview(){
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(browsersService, false);
        checkoutOverviewPage.finishButtonClick();
    }
}
