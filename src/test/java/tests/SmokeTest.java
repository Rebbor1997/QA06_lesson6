package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckoutCompletionPage;
import pages.LoginPage;
import pages.ProductsPage;
import steps.LoginStep;
import steps.ProductsStep;

public class SmokeTest extends BaseTest {


    // Для работы с Lombok (Pages)
    @Test
    public void criticalPathTest(){
        CheckoutCompletionPage checkoutCompletionPage = new LoginPage(browsersService, true)
                .setUserName(correctUser.getUsername())
                .setPassword(correctUser.getPassword())
                .successLoginButtonClick()
                .addItemToCart(correctUser.getProductName())
                .cartBadgeClick()
                .checkoutButtonClick()
                .setFirstName(correctUser.getFirstName())
                .setLastName(correctUser.getLastName())
                .setZipcode(correctUser.getZipCode())
                .continueButtonClick()
                .finishButtonClick();

        Assert.assertEquals(checkoutCompletionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }

    // Для работы с Lombok (Steps)
    @Test
    public void criticalPathStepsTest(){
        CheckoutCompletionPage checkoutCompletionPage = new LoginStep(browsersService)
                .successLogin(correctUser)
                .addItemToCart(correctUser)
                .moveToCart()
                .completeOrder(correctUser);

        Assert.assertEquals(checkoutCompletionPage.getCompletionMessage().trim(), "THANK YOU FOR YOUR ORDER");
    }

    @Test
    public void loginFailedTest(){
        LoginPage loginPage = new LoginPage(browsersService, true)
                .setUserName("locked_out_user")
                .setPassword("secret_sauce")
                .loginButtonClick();

        Assert.assertEquals(loginPage.getErrorMessage().getText().trim(),"Epic sadface: Sorry, this user has been locked out.");
    }
}
