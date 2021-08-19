package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import pages.ShoppingCartPage;

public class ShoppingCartStep extends BaseStep {
    public ShoppingCartStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void checkoutClick(){
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(browsersService, true);
        shoppingCartPage.checkoutButtonClick();
    }
}


