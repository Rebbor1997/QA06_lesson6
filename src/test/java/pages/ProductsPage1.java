package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage1 extends BasePage {

    private final static By title_new_label_By= By.className("title");
    private final static By add_label_By = By.id("add-to-cart-sauce-labs-backpack");
    private final static By remove_label_By = By.name("remove-sauce-labs-backpack");
    private final static By cart_label_By = By.className("shopping_cart_link");
    private final static By add_label2_By = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final static By remove_label2_By = By.id("remove-sauce-labs-bolt-t-shirt");
    private final static By cart_label2_By = By.className("shopping_cart_badge");


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

    public WebElement getAddButton() {return driver.findElement(add_label_By); }
    public void clickAddButton() { getAddButton().click(); }

    public WebElement getRemoveLabel() { return driver.findElement(remove_label_By); }
    public String getRemoveText() { return getRemoveLabel().getText(); }

    public WebElement getCartLabel() { return driver.findElement(cart_label_By); }
    public String getCartText() { return getCartLabel().getText(); }

    public WebElement getAddButton2() {return driver.findElement(add_label2_By); }
    public void clickAddButton2() { getAddButton2().click(); }

    public WebElement getRemoveLabel2() { return driver.findElement(remove_label2_By); }
    public String getRemoveText2() { return getRemoveLabel2().getText(); }

    public WebElement getCartLabel2() { return driver.findElement(cart_label2_By); }
    public String getCartText2() { return getCartLabel2().getText(); }


}
