package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    WebDriver webDriver;

    public AccountPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//a[normalize-space()='Edit your account information']")
    private WebElement editYourAccountInfoOption;

    public boolean displayAccountInfo(){
        return editYourAccountInfoOption.isDisplayed();
    }

}
