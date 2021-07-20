package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProductsPage;
import pages.ProductsPage1;

public class OrderStep extends BaseStep {

    public OrderStep(WebDriver driver) {
        super(driver);
    }


    public void orderOneProduct(String productName) {
        ProductsPage1 productsPage1= new ProductsPage1(driver, true);
        productsPage1.addToCard(productName);
    }

    public void cart(){
        ProductsPage1 productsPage1 = new ProductsPage1(driver, true);
        productsPage1.clickCart();
    }
}
