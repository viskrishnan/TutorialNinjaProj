package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {

    static WebDriver webdriver = null;
    public static void initializeBrowserDriver(String browserName){



        if(browserName.equals("Chrome")){

            webdriver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {

            webdriver = new FirefoxDriver();
        } else if (browserName.equals("Edge")) {
            webdriver = new EdgeDriver();
            
        } else if (browserName.equals("Safari")) {
            webdriver = new SafariDriver();
            
        }

    }

    public static WebDriver getDriver(){

        return webdriver;
    }
}
