package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath ="//span[normalize-space()='My Account']")
    private WebElement myAccountMenu;

    public void clickOnMyAccount(){
        myAccountMenu.click();
    }

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    public void clickOnLogin(){
        loginOption.click();
    }

}
