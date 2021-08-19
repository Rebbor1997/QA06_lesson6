package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.User;
import pages.LoginPage;

public class LoginStep extends BaseStep {
    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void login(){
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.loginButtonClick();
    }

    public ProductsStep loginValueObject(User user){
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setUserName(user.getUsername());
        loginPage.setPassword(user.getPassword());
        loginPage.loginButtonClick();
        return new ProductsStep(browsersService);
    }
}
