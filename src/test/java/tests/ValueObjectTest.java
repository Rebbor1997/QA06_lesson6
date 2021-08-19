package tests;

import baseEntities.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletionPage;
import steps.*;

public class ValueObjectTest extends BaseTest {

    @Test
    public void valueObjectTest() throws InterruptedException {
        User user = setupUser();
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginValueObject(user);

        ProductsStep productsStep = new ProductsStep(browsersService);
        productsStep.loginValueObject(user);

        ShoppingCartStep shoppingCartStep = new ShoppingCartStep(browsersService);
        shoppingCartStep.checkoutClick();

        CheckoutInfoStep checkoutInfoStep = new CheckoutInfoStep(browsersService);
        checkoutInfoStep.valueObject(user);

        CheckoutOverviewStep checkoutOverviewStep = new CheckoutOverviewStep(browsersService);
        checkoutOverviewStep.checkoutOverview();

        CheckoutCompletionPage checkoutCompletionPage = new CheckoutCompletionPage(browsersService, false);
        Assert.assertEquals(checkoutCompletionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");

    }

    private User setupUser(){
        User user = new User();
        user.setUsername("standard_user");
        user.setPassword("secret_sauce");
        user.setProductName("Sauce Labs Backpack");
        user.setFirstName("Fil");
        user.setLastName("Bob");
        user.setZipCode("23346");

        return user;
    }
}
