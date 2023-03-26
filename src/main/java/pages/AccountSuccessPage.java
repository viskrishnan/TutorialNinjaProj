package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementsUtils;

public class AccountSuccessPage {

    WebDriver webDriver;
    ElementsUtils elementUtils;

    public AccountSuccessPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        elementUtils = new ElementsUtils(webDriver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement accountCreationSuccess;

    public String setAccountCreationSuccess(){
        return elementUtils.getTextFromElement(accountCreationSuccess, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }
}
