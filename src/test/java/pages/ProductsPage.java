package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final static String endpoint = "inventory.html";
    private final static By title_label_By= By.className("title");

    public ProductsPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getTitleLabel().isDisplayed();
        }catch (NoSuchElementException ex){
            return false;
        }
    }
    public WebElement getTitleLabel(){ return driver.findElement(title_label_By); }
    public String getTitleText() {return getTitleLabel().getText();}
}
