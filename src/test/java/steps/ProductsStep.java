package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.ProductsPage;

public class ProductsStep extends BaseStep {
    public ProductsStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void productSelection(){
        ProductsPage productsPage = new ProductsPage(browsersService, true);
        productsPage.addItemToCart("Sauce Labs Backpack");
        productsPage.cartBadgeClick();
    }

    public ShoppingCartStep loginValueObject(User user){
        ProductsPage productsPage = new ProductsPage(browsersService, true);
        productsPage.addItemToCart(user.getProductName());
        productsPage.cartBadgeClick();
        return new ShoppingCartStep(browsersService);
    }
}
