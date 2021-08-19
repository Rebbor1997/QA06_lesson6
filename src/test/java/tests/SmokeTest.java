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

    @Test
    public void criticalPathTest(){
        CheckoutCompletionPage checkoutCompletionPage = new LoginPage(browsersService, true)
                .setUserName("standard_user")
                .setPassword("secret_sauce")
                .successLoginButtonClick()
                .addItemToCart("Sauce Labs Backpack")
                .cartBadgeClick()
                .checkoutButtonClick()
                .setFirstName("Fil")
                .setLastName("Bob")
                .setZipcode("242545")
                .continueButtonClick()
                .finishButtonClick();

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
