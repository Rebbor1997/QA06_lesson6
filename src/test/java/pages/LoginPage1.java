package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage1 extends BasePage {

    //Селекторы
    private final static By username_Input_By = By.id("user-name");
    private final static By password_Input_By = By.id("password");
    private final static By login_Button_By = By.id("login-button");
    private final static By error_By = By.tagName("h3");


    //Конструктор
    public LoginPage1(WebDriver driver, boolean openPageByUrl) {
        super(driver, openPageByUrl);
    }

    @Override
    protected void openPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @Override
    public boolean isPageOpened() {
        try {
            return getLoginButton().isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    protected void openPage1() {
        driver.get("https://www.saucedemo.com/");
    }
    //Getter
    public WebElement getUsernameInput() { return driver.findElement(username_Input_By); }
    public WebElement getPasswordInput() {return driver.findElement(password_Input_By); }
    public WebElement getLoginButton() {return driver.findElement(login_Button_By); }

      //К второму пользователю
    public WebElement getLoginError() {return driver.findElement(error_By); }
    public String getLoginErrorText() { return getLoginError().getText(); }

    //Атомарные методы по работе с методами
    public void setUsername(String text) {
        getUsernameInput().sendKeys(text);
    }
    public void setPassword(String text) { getPasswordInput().sendKeys(text); }
    public void clickLoginButton() {
        getLoginButton().click(); }

}
