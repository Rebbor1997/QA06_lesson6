package tests;


import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import steps.CheckoutInfoStep;
import steps.LoginStep;
import steps.ProductsStep;


public class LoggerTest extends BaseTest {
   Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void loginLevelsTest(){
        logger.info("loginLevelsTest is started...");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.successLogin(correctUser);
        logger.info("Step1 - ввод корректного логина");
        ProductsStep productsStep = new ProductsStep(browsersService);
        productsStep.addItemToCart(correctUser);
        logger.info("Step2 - выбор товара в корзину");
        productsStep.moveToCart();
        CheckoutInfoStep checkoutInfoStepStep = new CheckoutInfoStep(browsersService);
        checkoutInfoStepStep.completeOrder(correctUser);
        logger.info("Step3 - ввод firstName и lastName, заказ товара");
        logger.info("loginLevelsTest is finished.");
    }
}
