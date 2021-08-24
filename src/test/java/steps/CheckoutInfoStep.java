package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.CheckoutCompletionPage;
import pages.CheckoutInfoPage;
import pages.ShoppingCartPage;

public class CheckoutInfoStep extends BaseStep {
    public CheckoutInfoStep(BrowsersService browsersService) {
        super(browsersService);
    }

    // Для работы с Lombok
    public CheckoutCompletionPage completeOrder (User user) {
        return new ShoppingCartPage(browsersService, false)
                .checkoutButtonClick()
                .setFirstName(user.getFirstName())
                .setLastName(user.getLastName())
                .setZipcode(user.getZipCode())
                .continueButtonClick()
                .finishButtonClick();
    }
}
