package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage1 extends BasePage {

    private final static By title_new_label_By= By.className("title");

    private final static String product_addToCart = "//div[.= 'replace']/ancestor::div[@class='inventory_item_description']//button";
    private final static By cart_By = By.className ("shopping_cart_link");

    public ProductsPage1(WebDriver driver, boolean openPageByUrl){
        super(driver, openPageByUrl);
    }
    @Override
    protected void openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
    }
    @Override
    public boolean isPageOpened() {
        try {
            return getTitleNewLabel().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getTitleNewLabel() { return driver.findElement(title_new_label_By); }
    public String getTitleNewText() { return getTitleNewLabel().getText(); }

    //Добавление товара через степ
    public WebElement getAddToCartElement(String productName) {
        return driver.findElement(By.xpath(product_addToCart.replace("replace", productName)));
    }

    public void addToCard (String productName) {
        getAddToCartElement(productName).click();
    }

    public WebElement getCart() {return driver.findElement(cart_By);}
    public void clickCart(){getCart().click();}
}
