package baseEntities;

import core.BrowsersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;
import steps.LoginStep;
import steps.ProductsStep;
import steps.ShoppingCartStep;

public abstract class BaseStep {
    protected final Logger logger = LogManager.getLogger(this);
    public BrowsersService browsersService;


    public BaseStep(BrowsersService browsersService) {
        this.browsersService = browsersService;
    }

    public LoginPage getLoginPage(){
        return new LoginPage(browsersService, false);
    }
    public ProductsPage getProductsPage(){
        return new ProductsPage(browsersService, false);
    }
    public ShoppingCartPage getShoppingCartPage(){
        return new ShoppingCartPage(browsersService, false);
    }
}
