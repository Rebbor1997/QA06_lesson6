package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.ProductsPage;
import pages.ShoppingCartPage;

public class ProductsStep extends BaseStep {
    public ProductsStep(BrowsersService browsersService) {
        super(browsersService);

    }

    //Для работы с Lombok

    public ProductsStep addItemToCart(User user){
        logger.info("Начало addItemToCart");
        new ProductsPage(browsersService, false).getItemAddToCartButton(user.getProductName()).click();
        return this;
    }

    public CheckoutInfoStep moveToCart(){
        new ProductsPage(browsersService, false).cartBadgeClick();
        logger.info("Конец addItemToCart");
        return new CheckoutInfoStep(browsersService);
    }
}
