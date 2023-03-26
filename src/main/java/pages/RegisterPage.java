package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementsUtils;

public class RegisterPage {

    WebDriver webDriver;
    ElementsUtils elementUtils;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        elementUtils = new ElementsUtils(webDriver);
    }

    @FindBy(id = "input-firstname")
    private WebElement enterRegistrationFieldsFirstName;
    @FindBy(id = "input-lastname")
    private WebElement enterRegistrationFieldsLastName;
    @FindBy(id = "input-email")
    private WebElement enterRegistrationFieldsEmail;
    @FindBy(id = "input-telephone")
    private WebElement enterTelephoneNumber;
    @FindBy(id = "input-password")
    private WebElement enterPassword;

    @FindBy(id = "input-confirm")
    private WebElement enterPasswordConfirm;

    @FindBy(xpath = "//input[@name='agree']")
    private WebElement privacyPolicyOption;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
  private WebElement YesNewsletterOption;

    @FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement warningMessage;

    @FindBy(xpath="//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarning;

    @FindBy(xpath="//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWaring;

    @FindBy(xpath="//input[@id='input-email']/following-sibling::div")
    private WebElement emailWarning;

    @FindBy(xpath="//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneWarning;

    @FindBy(xpath="//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarning;

    public void enterRegistrationFieldsFirstName(String enterFirstName){
        elementUtils.typeTextIntoElement(enterRegistrationFieldsFirstName, enterFirstName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void enterRegistrationFieldsLastName(String enterLastName){
        elementUtils.typeTextIntoElement(enterRegistrationFieldsLastName, enterLastName,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void enterRegistrationFieldsEmail(String enterEmail){
        elementUtils.typeTextIntoElement(enterRegistrationFieldsEmail, enterEmail,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public void enterTelephoneNumber(String enterTelephone){
        elementUtils.typeTextIntoElement(enterTelephoneNumber, enterTelephone,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
    public void setEnterPassword(String enterPwd){
        elementUtils.typeTextIntoElement(enterPassword, enterPwd,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public void setEnterPasswordConfirm(String enterPwdConfirm){
        elementUtils.typeTextIntoElement(enterPasswordConfirm, enterPwdConfirm,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public void setPrivacy_policy(){
        elementUtils.clickOnElement(privacyPolicyOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public AccountSuccessPage clickContinueButton(){
        elementUtils.clickOnElement(continueButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new AccountSuccessPage(webDriver);
    }

    public void selectYesForNewsLetter(){
        elementUtils.clickOnElement(YesNewsletterOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    public String getWarningMessageText() {

        return elementUtils.getTextFromElement(warningMessage,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public String getFirstNameWarning() {

        return elementUtils.getTextFromElement(firstNameWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public String getLastNameWarning() {

        return elementUtils.getTextFromElement(lastNameWaring,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public String getEmailWarning() {

        return elementUtils.getTextFromElement(emailWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public String getTelephoneWarning() {

        return elementUtils.getTextFromElement(telephoneWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }

    public String getPasswordWarning() {

        return elementUtils.getTextFromElement(passwordWarning,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

    }



}
