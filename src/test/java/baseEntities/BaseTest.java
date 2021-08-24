package baseEntities;

import core.BrowsersService;
import core.ReadProperties;

import javafx.util.Builder;
import models.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import tests.LoggerTest;
import utils.Listener;


@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;
    protected User correctUser;
    protected final Logger logger = LogManager.getLogger(this);


    @BeforeSuite
    public void prepareData() {
        correctUser = User.builder()
                .username("standard_user")
                .password("secret_sauce")
                .productName("Sauce Labs Backpack")
                .firstName("Fil")
                .lastName("Bob")
                .zipCode("23346")
                .build();
    }

    @BeforeMethod
    public void openService() {
        browsersService = new BrowsersService();
        //browsersService.getDriver().get(ReadProperties.getInstance().getURL());
    }

    @AfterMethod
    public void closeService() {
        browsersService.getDriver().quit();
        browsersService = null;
    }
}