package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    WebDriver webDriver;

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
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
    private WebElement privacy_policy;

    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
  private WebElement setYesForNewsLetter;

    public void enterRegistrationFieldsFirstName(String enterFirstName){
        enterRegistrationFieldsFirstName.sendKeys(enterFirstName);
    }
    public void enterRegistrationFieldsLastName(String enterLastName){
        enterRegistrationFieldsLastName.sendKeys(enterLastName);
    }
    public void enterRegistrationFieldsEmail(String enterEmail){
        enterRegistrationFieldsEmail.sendKeys(enterEmail);
    }

    public void setEnterTelephoneNumber(String enterTelephone){
        enterTelephoneNumber.sendKeys(enterTelephone);
    }
    public void setEnterPassword(String enterPwd){
        enterPassword.sendKeys(enterPwd);
    }

    public void setEnterPasswordConfirm(String enterPasswordConfirm){
        setEnterPasswordConfirm(enterPasswordConfirm);
    }

    public void setPrivacy_policy(){
        privacy_policy.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void selectYesForNewsLetter(){
        setYesForNewsLetter.click();
    }


}
