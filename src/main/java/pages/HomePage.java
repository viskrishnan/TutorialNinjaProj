package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonUtils;
import utils.ElementsUtils;

public class HomePage {

    WebDriver webDriver;
    private ElementsUtils elementsUtils;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath ="//span[text()='My Account']")
    private WebElement myAccountDropMenu;

    public void clickOnMyAccount(){
        elementsUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    }

    @FindBy(linkText = "Login")
    private WebElement loginToApplication;

    public LoginPage clickOnApplicationLogin(){
        elementsUtils.clickOnElement(loginToApplication, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new LoginPage(webDriver);
    }

    @FindBy(linkText = "Register")
    private WebElement registerPage;

    public RegisterPage clickOnRegister(){
        elementsUtils.clickOnElement(registerPage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new RegisterPage(webDriver);
    }

    @FindBy(name = "search")
    private WebElement enterProductIntoSearchBoxField;

    public void setEnterProductIntoSearchBoxField(String searchCriteria){
        enterProductIntoSearchBoxField.sendKeys(searchCriteria);
    }

    @FindBy(xpath = "//i[@class='fa fa-search']")
    private WebElement clickSearchButton;

    public SearchResultsPage setClickSearchButton(){
        elementsUtils.clickOnElement(clickSearchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
        return new SearchResultsPage(webDriver);
    }

}
