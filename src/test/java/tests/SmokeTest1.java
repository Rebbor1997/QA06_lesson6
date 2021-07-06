package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage1;
import pages.PaymentPage;
import pages.ProductsPage1;

public class SmokeTest1 {
    @Test
    public void positiveLoginTest(){
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage1 loginPage1 = new LoginPage1(driver, true);
        loginPage1.setUsername("locked_out_user");
        loginPage1.setPassword("secret_sauce");
        loginPage1.clickLoginButton();
        // проверка на логин 2-го пользователя
        Assert.assertEquals(loginPage1.getLoginErrorText(), "Epic sadface: Sorry, this user has been locked out.", "Страница Products не открылась");
        driver.quit();
    }
    @Test
    public void positiveLoginTest1(){
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage1 loginPage1 = new LoginPage1(driver, true);
        loginPage1.setUsername("problem_user");
        loginPage1.setPassword("secret_sauce");
        loginPage1.clickLoginButton();

        ProductsPage1 productsPage1 = new ProductsPage1(driver, false);
        // проверка на логин 3-го пользователя
        Assert.assertEquals(productsPage1.getTitleNewText(), "PRODUCTS", "Страница Products не открылась");
        driver.quit();
    }
    @Test
    public void positiveLoginTest2() throws InterruptedException {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();

        LoginPage1 loginPage1 = new LoginPage1(driver, true);
        loginPage1.setUsername("performance_glitch_user");
        loginPage1.setPassword("secret_sauce");
        loginPage1.clickLoginButton();
        // проверка на логин 4-го пользователя
        ProductsPage1 productsPage1 = new ProductsPage1(driver,false);
        Assert.assertEquals(productsPage1.getTitleNewText(), "PRODUCTS", "Страница Products не открылась");
        // проверка на добавление нескольких товаров в корзину
        productsPage1.clickAddButton();
        Assert.assertEquals(productsPage1.getRemoveText(), "REMOVE", "Ничего не произошло");
        Assert.assertEquals(productsPage1.getCartText(), "1", "Ничего не произошло");
        productsPage1.clickAddButton2();
        Assert.assertEquals(productsPage1.getRemoveText2(), "REMOVE", "Ничего не произошло");
        Assert.assertEquals(productsPage1.getCartText2(), "2", "Ничего не произошло");
        CartPage cartPage = new  CartPage(driver, true);
        Assert.assertEquals(cartPage.getProduct1Text(),"Sauce Labs Backpack", "Ничего не произошло" );
        Assert.assertEquals(cartPage.getProduct2Text(),"Sauce Labs Bolt T-Shirt", "Ничего не произошло" );
        Assert.assertEquals(cartPage.getCartText(),"2", "Ничего не произошло" );
        // проверка на удаление одного товара из корзины
        cartPage.clickRemove();
        Assert.assertEquals(cartPage.getEmptyText(),"1","Ничего не произошло");
        // заказ товара
        cartPage.clickCheckout();
        PaymentPage paymentPage = new PaymentPage(driver, true);
        paymentPage.setFirstName("aergre");
        paymentPage.setLastName("secret_sauce");
        paymentPage.setPostalCode("3224");
        paymentPage.ContinueClick();
        paymentPage.FinishClick();
        Thread.sleep(3000);
        // проверка на заказ товара
        Assert.assertEquals(paymentPage.getOrderText(),"Your order has been dispatched, and will arrive just as fast as the pony can get there!","Ничего не произошло" );
        driver.quit();
    }
}
