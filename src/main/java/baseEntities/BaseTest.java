package baseEntities;

import core.BrowsersService;
import core.ReadProperties;

import javafx.util.Builder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import utils.Listener;

import javax.xml.bind.Marshaller;

@Listeners(Listener.class)
public abstract class BaseTest {
    public BrowsersService browsersService;



   /* @BeforeSuite
    public void prepareData(){
        correctUser = Builder
    }*/

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