package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    static WebDriver webdriver = null;
    public static WebDriver initializeBrowserDriver(String browserName) {

        switch (browserName) {
            case "Chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--no-sandbox"); // Bypass OS security model

                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("start-maximized"); // open Browser in maximized mode

                options.addArguments("disable-infobars"); // disabling infobars

                options.addArguments("--disable-extensions"); // disabling extensions

                options.addArguments("--disable-gpu"); // applicable to windows os only

                webdriver = new ChromeDriver(options);
                break;
            case "Edge":
                webdriver = new EdgeDriver();
                break;
            case "Firefox":
                webdriver = new FirefoxDriver();
                break;
            case "Safari":
                webdriver = new SafariDriver();
                break;
        }
        webdriver.manage().deleteAllCookies();
        webdriver.manage().window().maximize();
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return webdriver;
    }

    public static WebDriver getDriver(){

        return webdriver;
    }
}
