package steps;

import baseEntities.BaseStep;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import pages.ProductsPage1;

public class OrderStep extends BaseStep {

    public OrderStep(WebDriver driver)  {
        super(driver);
    }

    @Step
    public void orderOneProduct(String productName) {
        ProductsPage1 productsPage1= new ProductsPage1(driver, true);
        productsPage1.addToCard(productName);
    }
    @Step
    public void cart(){
        ProductsPage1 productsPage1 = new ProductsPage1(driver, true);
        productsPage1.clickCart();
    }
}
