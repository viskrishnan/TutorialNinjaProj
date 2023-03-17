package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountWarningsPage {

    WebDriver webDriver;

    public AccountWarningsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement duplicateEmailMessage;

    public String checkDuplicateEmail(){
        return duplicateEmailMessage.getText();
    }
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement agreePrivacyPolicyWarning;
    @FindBy(xpath = "//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
    private WebElement agreeFirstNameWarning;
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement agreeLastNameWarning;
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement agreeEmailAddressWarning;
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement agreeTelephoneNumberWarning;
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement agreePasswordCharactersWarning;

    public String setAgreePrivacyPolicyWarning(){
        return agreePrivacyPolicyWarning.getText();
    }

    public String setFirstNameWaring(){
        return agreeFirstNameWarning.getText();
    }

    public String setLastNameWaring(){
        return agreeLastNameWarning.getText();
    }

    public String setEmailAddressWaring(){
        return agreeEmailAddressWarning.getText();
    }
    public String setTelephoneNumberWaring(){
        return agreeTelephoneNumberWarning.getText();
    }
    public String setPasswordCharactersWarning(){
        return agreePasswordCharactersWarning.getText();
    }
}
