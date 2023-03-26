package hooks;

import Factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

import java.time.Duration;
import java.util.Properties;

public class myHooks {

    WebDriver webdriver;

    @Before
    public void setUp(){
        Properties properties = ConfigReader.initializeConfigProperties();
        webdriver = DriverFactory.initializeBrowserDriver(properties.getProperty("browser"));
        webdriver.get(properties.getProperty("URL"));
    }

    @After
    public void tearDown(Scenario scenario){
        String scenarioName = scenario.getName().replaceAll("","_");
        if(scenario.isFailed()){
            byte[] srcScreenShot = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(srcScreenShot,"image/png", scenarioName);
        }
        webdriver.quit();
    }
}
