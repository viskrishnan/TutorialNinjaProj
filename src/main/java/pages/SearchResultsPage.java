package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    WebDriver webDriver;

    public SearchResultsPage(WebDriver webDriver){
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(linkText = "HP LP3065")
    private WebElement searchValidProduct;

    public boolean setSearchValidProduct(){
        return searchValidProduct.isDisplayed();
    }
    @FindBy(name = "search")
    private WebElement searchInvalidProduct;

    public void searchInvalidProduct(String invalidProduct){
        searchValidProduct.sendKeys(invalidProduct);

    }
    @FindBy(xpath = "//p[contains(text(),'There is no product that matches the search criter')]")
    private WebElement noResultSearch;

    public String validateNoResultSearch(){
        return noResultSearch.getText();

    }
}
