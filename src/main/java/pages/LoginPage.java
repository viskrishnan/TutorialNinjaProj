package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver webDriver;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(id = "input-email")
    private WebElement enterEmailAddr;

    public void setEnterEmailAddr(String emailAddress){
        enterEmailAddr.sendKeys(emailAddress);
    }
    @FindBy(id = "input-password")
    private WebElement enterPassword;

    public void setEnterPassword(String enterPwd){
        enterPassword.sendKeys(enterPwd);
    }

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement clickLogin;

    public void clickOnLogin(){
        clickLogin.click();
    }

    @FindBy(id = "input-email")
    private WebElement invalidEmailAddress;

    public void enterInvalidEmailAddress(String invalidEmail){
        invalidEmailAddress.sendKeys(invalidEmail);
    }


    @FindBy(id = "input-password")
    private WebElement invalidPassword;

    public void enterInvalidPassword(String invalidPwd){
        invalidEmailAddress.sendKeys(invalidPwd);
    }




}
