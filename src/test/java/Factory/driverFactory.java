package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {

    static WebDriver webdriver = null;
    public static void initializeBrowserDriver(String browserName){

        switch (browserName) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                webdriver = new ChromeDriver();
                break;
            case "Firefox":
                webdriver = new FirefoxDriver();
                break;
            case "Edge":
                webdriver = new EdgeDriver();
                break;
            case "Safari":
                webdriver = new SafariDriver();
                break;
        }

    }

    public static WebDriver getDriver(){

        return webdriver;
    }
}
