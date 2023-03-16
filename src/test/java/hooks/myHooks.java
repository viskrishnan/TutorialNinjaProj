package hooks;

import Factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class myHooks {

    WebDriver webdriver;

    @Before
    public void setUp(){
        driverFactory.initializeBrowserDriver("Edge");
        webdriver = driverFactory.getDriver();
        webdriver.manage().deleteAllCookies();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webdriver.get("http://tutorialsninja.com/demo/");

    }

    @After
    public void tearDown(){
        webdriver.quit();
    }
}
