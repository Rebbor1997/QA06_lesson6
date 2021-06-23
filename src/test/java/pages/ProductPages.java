package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPages {
    private final static By title_label_By= By.className("title");

    public ProductPages  (WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getTitleLabel(){ return driver.findElement(title_label_By); }
    public String getTitleText() {return getTitleLabel().getText();}

}
