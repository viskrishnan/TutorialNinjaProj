package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementsUtils {

    WebDriver webDriver;

    public ElementsUtils(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void clickOnElement(WebElement element, long durationInSeconds){

        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(durationInSeconds));
        WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(element));

        webElement.click();
    }
}
