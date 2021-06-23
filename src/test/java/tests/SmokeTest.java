package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductPages;

public class SmokeTest {

    @Test
    public void PositiveLogintest() {
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
        WebDriver driver = new ChromeDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUsername("standard_user");
        loginPage.getLoginButton("");
        loginPage.clickLoginButton();

        ProductPages productPages = new ProductPages(driver);

        Assert.assertEquals(productPages.getTitleText(), "PRODUCTS", "Страница Products", );


    }
}
