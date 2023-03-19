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

        if(browserName.equals("Chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            webdriver = new ChromeDriver();
        } else if (browserName.equals("Edge")) {
            webdriver = new EdgeDriver();
        } else if (browserName.equals("Firefox")) {
            webdriver = new FirefoxDriver();
        } else if (browserName.equals("Safari")) {
            webdriver = new SafariDriver();
        }

//        switch (browserName) {
//            case "Chrome":
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--remote-allow-origins=*");
//                webdriver = new ChromeDriver();
//                break;
//            case "Firefox":
//                webdriver = new FirefoxDriver();
//                break;
//            case "Edge":
//                webdriver = new EdgeDriver();
//                break;
//            case "Safari":
//                webdriver = new SafariDriver();
//                break;
//        }

    }

    public static WebDriver getDriver(){

        return webdriver;
    }
}
