package hooks;

import Factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class myHooks {

    WebDriver webdriver;

    @Before
    public void setUp(){
        Properties properties = ConfigReader.initializeConfigProperties();
        driverFactory.initializeBrowserDriver(properties.getProperty("browser"));
        webdriver = driverFactory.getDriver();
        webdriver.manage().deleteAllCookies();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        webdriver.get(properties.getProperty("URL"));

    }

    @After
    public void tearDown(){
        webdriver.quit();
    }
}
