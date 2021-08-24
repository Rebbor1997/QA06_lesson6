package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.LoginPage;
import pages.ProductsPage;


public class LoginStep extends BaseStep {
    private LoginPage loginPage;
    private ProductsPage productsPage;

    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }

    // Для работы с Lombok
    public ProductsStep successLogin(User user){
        logger.info("Начало successLogin");
          new LoginPage(browsersService, true)
                 .setUserName(user.getUsername())
                 .setPassword(user.getPassword())
                 .successLoginButtonClick();
        logger.info("Конец successLogin");
        return new ProductsStep(browsersService);
    }
}
