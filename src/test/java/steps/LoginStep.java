package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.LoginPage1;

public class LoginStep extends BaseStep {

    public LoginStep(WebDriver driver) {
        super(driver);
    }
    public void Login(String username, String password) {
        LoginPage loginPage = new LoginPage(driver, true);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
        loginPage.clickLoginButton();
    }
    public void loginTwoUser(String username, String password) {
        LoginPage1 loginPage1 = new LoginPage1(driver, true);
        loginPage1.setUsername(username);
        loginPage1.setPassword(password);
        loginPage1.clickLoginButton();
    }
    public void loginThreeUser(String username, String password) {
        LoginPage1 loginPage1 = new LoginPage1(driver, true);
        loginPage1.setUsername(username);
        loginPage1.setPassword(password);
        loginPage1.clickLoginButton();
    }
}
