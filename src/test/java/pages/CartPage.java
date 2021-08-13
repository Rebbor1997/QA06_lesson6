package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {
    private final static By product1_By= By.id("item_4_title_link");
    private final static By remove_click_By= By.id("remove-sauce-labs-backpack");
    private final static By empty_cart_By= By.className("shopping_cart_badge");
    private final static By product2_By= By.id("item_1_title_link");
    private final static By cart_By= By.className("shopping_cart_badge");
    private final static By checkout_By= By.id("checkout");

    private final static String product_removeCart = "//div[.= 'replace']/ancestor::div[@class='cart_item_label']//button";

    public CartPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://www.saucedemo.com/cart.html");
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getProduct1().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getProduct1() { return driver.findElement(product1_By); }
    public String getProduct1Text() { return getProduct1().getText(); }

    public WebElement getProduct2() { return driver.findElement(product2_By); }
    public String getProduct2Text() { return getProduct2().getText(); }

    public WebElement getCart() { return driver.findElement(cart_By); }
    public String getCartText() { return getCart().getText(); }

    public WebElement getRemoveClick() { return driver.findElement(remove_click_By); }
    public void  clickRemove() {getRemoveClick().click();}

    public WebElement getEmptyCart() { return driver.findElement(empty_cart_By); }
    public String getEmptyText() { return getEmptyCart().getText(); }

    public WebElement getCheckout() { return driver.findElement(checkout_By); }
    public void  clickCheckout() {getCheckout().click();}

    //удаление товара через степ
    public WebElement getRemoveCartElement(String productName) {
        return driver.findElement(By.xpath(product_removeCart.replace("replace", productName)));
    }

    public void removeElementCart (String productName) {
        getRemoveCartElement(productName).click();
    }




}
