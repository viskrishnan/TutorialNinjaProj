package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver webDriver;

    public HomePage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath ="//span[text()='My Account']")
    private WebElement myAccountMenu;

    public void clickOnMyAccount(){
        myAccountMenu.click();
    }

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    public void clickOnLogin(){
        loginOption.click();
    }

    @FindBy(linkText = "Register")
    private WebElement registerPage;

    public void clickOnRegister(){
        registerPage.click();
    }

    @FindBy(name = "search")
    private WebElement enterProductIntoSearchBoxField;

    public void setEnterProductIntoSearchBoxField(String searchCriteria){
        enterProductIntoSearchBoxField.sendKeys(searchCriteria);
    }

    @FindBy(xpath = "//i[@class='fa fa-search']")
    private WebElement clickSearchButton;

    public void setClickSearchButton(){
        clickSearchButton.click();
    }

}
