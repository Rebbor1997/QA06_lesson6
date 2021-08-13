package tests;

import baseEntities.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage1;
import pages.PaymentPage;
import pages.ProductsPage1;
import steps.CartStep;
import steps.LoginStep;
import steps.OrderStep;

public class SmokeTest1 extends BaseTest {

    @Feature("Feature_1")
    @Story("Story_1")
    @Severity(SeverityLevel.NORMAL)
    @Description("Первый тест")
    @Flaky
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

    //Пример для Attachment (скриншота)
    @Severity(SeverityLevel.NORMAL)
    @Test(description = "Второй тест")
    public void positiveLoginTest1 (){
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginTwoUser(properties.getUsername1(), properties.getPassword());

        Assert.assertTrue(false);

        ProductsPage1 productsPage1 = new ProductsPage1(driver, true);
        // проверка на логин 3-го пользователя
        Assert.assertEquals(productsPage1.getTitleNewText(), "PRODUCTS", "Страница Products не открылась");
        driver.quit();
    }


    @Features(value = {@Feature("Feature_1"), @Feature("Feature_2")})
    @Stories(value = {@Story("Story_1"), @Story("Story_2")})
    @Link(value = "link", url ="https://www.saucedemo.com/inventory.html")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void positiveLoginTest2() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.loginThreeUser(properties.getUsername2(), properties.getPassword());

        // проверка на логин 4-го пользователя
        ProductsPage1 productsPage1 = new ProductsPage1(driver,false);
        Assert.assertEquals(productsPage1.getTitleNewText(), "PRODUCTS", "Страница Products не открылась");

        // проверка на добавление нескольких товаров в корзину
        OrderStep orderStep = new OrderStep(driver);
        orderStep.orderOneProduct("Sauce Labs Bolt T-Shirt");
        orderStep.orderOneProduct("Sauce Labs Backpack");
        orderStep.cart();

        // проверка на удаление одного товара из корзины
        CartStep cartStep = new CartStep(driver);
        cartStep.removeFromCart("Sauce Labs Backpack");

        //ввод информации в аккаунт
        cartStep.checkoutYourInformation(properties.getFirstname(),properties.getLastname(), properties.getZip());

        driver.quit();
    }
}
