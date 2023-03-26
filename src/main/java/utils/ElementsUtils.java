package utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    public void typeTextIntoElement(WebElement element,String textToBeTyped,long durationInSeconds) {

        WebElement webElement = waitForElement(element,durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);

    }

    public WebElement waitForElement(WebElement element,long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch(Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    public void selectOptionInDropdown(WebElement element,String dropDownOption,long durationInSeconds) {

        WebElement webElement = waitForElement(element,durationInSeconds);
        Select select = new Select(webElement);
        select.selectByVisibleText(dropDownOption);

    }

    public void acceptAlert(long durationInSeconds) {

        Alert alert = waitForAlert(durationInSeconds);
        alert.accept();

    }

    public void dismissAlert(long durationInSeconds) {

        Alert alert = waitForAlert(durationInSeconds);
        alert.dismiss();

    }

    public Alert waitForAlert(long durationInSeconds) {

        Alert alert = null;

        try {
            WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(durationInSeconds));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        }catch(Throwable e) {
            e.printStackTrace();
        }

        return alert;

    }

    public void mouseHoverAndClick(WebElement element,long durationInSeconds) {

        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).click().build().perform();

    }

    public WebElement waitForVisibilityOfElement(WebElement element,long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(webDriver,Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        }catch(Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    public void javaScriptClick(WebElement element,long durationInSeconds) {

        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor)webDriver);
        jse.executeScript("arguments[0].click();",webElement);

    }

    public void javaScriptType(WebElement element,long durationInSeconds,String textToBeTyped) {

        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        JavascriptExecutor jse = ((JavascriptExecutor)webDriver);
        jse.executeScript("arguments[0].value='"+textToBeTyped+"'",webElement);

    }

    public String getTextFromElement(WebElement element,long durationInSeconds) {

        WebElement webElement = waitForElement(element,durationInSeconds);
        return webElement.getText();

    }

    public boolean displayStatusOfElement(WebElement element,long durationInSeconds) {

        try {
            WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
            return webElement.isDisplayed();
        }catch(Throwable e) {
            return false;
        }

    }

}
