package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementsUtils;

public class LoginPage {

    WebDriver webDriver;
    ElementsUtils elementsUtils;

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

    public AccountPage clickOnLoginButton(){
        elementsUtils.clickOnElement(clickLogin, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new AccountPage(webDriver);
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

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement invalidCredentialsMismatch;

    public String validateInvalidCredentialsMismatch(){
        return invalidCredentialsMismatch.getText();
    }

    @FindBy(id = "input-email")
    private WebElement doNotEnterEmailAddr;

    public void setDoNotEnterEmailAddr(){
        doNotEnterEmailAddr.sendKeys("");
    }

    @FindBy(id = "input-password")
    private WebElement doNotEnterPassword;

    public void setDoNotEnterPassword(){
        doNotEnterPassword.sendKeys("");
    }

}
