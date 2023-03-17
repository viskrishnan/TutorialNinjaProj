package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {

    WebDriver webDriver;

    public AccountSuccessPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    private WebElement accountCreationSuccess;

    public String setAccountCreationSuccess(){
        return accountCreationSuccess.getText();
    }
}
