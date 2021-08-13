package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage extends BasePage {

    private final static By first_name_By = By.id("first-name");
    private final static By last_name_By = By.id("last-name");
    private final static By postal_code_By = By.id("postal-code");
    private final static By continue_By = By.id("continue");
    private final static By finish_By = By.id("finish");

    public PaymentPage(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");

    }

    @Override
    public boolean isPageOpened() {
        try {
            return getContinueClick().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public WebElement getFirstNameInput() { return driver.findElement(first_name_By); }
    public WebElement getLastNameInput() { return driver.findElement(last_name_By); }
    public WebElement getPostalCodeInput() { return driver.findElement(postal_code_By); }
    public WebElement getContinueClick() { return driver.findElement(continue_By); }
    public WebElement getFinish() { return driver.findElement(finish_By); }



    public void setFirstName(String text) {
        getFirstNameInput().sendKeys(text);
    }
    public void setLastName(String text) { getLastNameInput().sendKeys(text);}
    public void setPostalCode (String text){ getPostalCodeInput().sendKeys(text); }
    public void ContinueClick (){ getContinueClick().click(); }
    public void FinishClick (){ getFinish().click(); }

}


