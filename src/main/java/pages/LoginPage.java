package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementsUtils;

public class LoginPage {

    WebDriver webDriver;
    ElementsUtils elementUtils;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        elementUtils = new ElementsUtils(webDriver);
    }

//    @FindBy(id = "input-email")
//    private WebElement enterEmailAddr;
//
//    public void setEnterEmailAddr(String emailAddress){
//        elementUtils.typeTextIntoElement(enterEmailAddr, emailAddress,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//    }
//    @FindBy(id = "input-password")
//    private WebElement enterPassword;
//
//    public void setEnterPassword(String enterPwd){
//        elementUtils.typeTextIntoElement(enterPassword, enterPwd,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//    }
//
//    @FindBy(xpath = "//input[@value='Login']")
//    private WebElement clickLogin;
//
//    public AccountPage clickOnLoginButton(){
//        elementUtils.clickOnElement(clickLogin, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//        return new AccountPage(webDriver);
//    }
//
//    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
//    private WebElement warningMessage;
//
//    public String getWarningMessageText() {
//
//        return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
//
//    }
//    @FindBy(id = "input-email")
//    private WebElement invalidEmailAddress;
//
//    public void enterInvalidEmailAddress(String invalidEmail){
//        invalidEmailAddress.sendKeys(invalidEmail);
//    }
//
//
//    @FindBy(id = "input-password")
//    private WebElement invalidPassword;
//
//    public void enterInvalidPassword(String invalidPwd){
//        invalidEmailAddress.sendKeys(invalidPwd);
//    }
//
//    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
//    private WebElement invalidCredentialsMismatch;
//
//    public String validateInvalidCredentialsMismatch(){
//        return invalidCredentialsMismatch.getText();
//    }
//
//    @FindBy(id = "input-email")
//    private WebElement doNotEnterEmailAddr;
//
//    public void setDoNotEnterEmailAddr(){
//        doNotEnterEmailAddr.sendKeys("");
//    }
//
//    @FindBy(id = "input-password")
//    private WebElement doNotEnterPassword;
//
//    public void setDoNotEnterPassword(){
//        doNotEnterPassword.sendKeys("");
//    }
//
//}

    @FindBy(id="input-email")
    private WebElement emailField;

    @FindBy(id="input-password")
    private WebElement passwordField;

    @FindBy(xpath="//input[@value='Login']")
    private WebElement loginButton;

    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessage;

    public void enterEmailAddress(String emailText) {

        elementUtils.typeTextIntoElement(emailField, emailText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public void enterPassword(String passwordText) {

        elementUtils.typeTextIntoElement(passwordField, passwordText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public AccountPage clickOnLoginButton() {

        elementUtils.clickOnElement(loginButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new AccountPage(webDriver);

    }

    public String getWarningMessageText() {

        return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

}
