package tests;

import baseEntities.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import pages.ProductsPage;
import steps.LoginStep;

public class SmokeTest extends BaseTest {


    @Issue("0")
    @TmsLink("4")
    @Test
    public void PositiveLoginTest() throws InterruptedException {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login(properties.getUsername(), properties.getPassword());

        ProductsPage productsPage = new ProductsPage(driver, false);

        Assert.assertEquals(productsPage.getTitleText(), "PRODUCTS", "Страница Products не открылась.");

    }
    @Test
    public void negativeLoginTest() {
        LoginStep loginStep = new LoginStep(driver);
        loginStep.Login("asdasds", "adsasd");

        Assert.assertEquals(new LoginPage(driver, false).getErrorLabel().getText() ,
                "Epic sadface: Username and password do not match any user in this service");
    }
}
