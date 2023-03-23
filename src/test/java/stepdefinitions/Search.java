package stepdefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search {

    WebDriver webDriver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    @Given("User opens the Application")
    public void user_opens_the_application() {
        webDriver = DriverFactory.getDriver();
    }

    @When("User enters valid product {string} into search box field")
    public void user_enters_valid_product_into_search_box_field(String searchValidProduct) {
        homePage = new HomePage(webDriver);
        homePage.setEnterProductIntoSearchBoxField(searchValidProduct);
        //webDriver.findElement(By.name("search")).sendKeys(searchValidProduct);
    }

    @When("User enters invalid product {string} into search box field")
    public void user_enters_invalid_product_into_search_box_field(String invalidProdSearch) {
        homePage = new HomePage(webDriver);
        homePage.setEnterProductIntoSearchBoxField(invalidProdSearch);
//        webDriver.findElement(By.name("search")).sendKeys(invalidProdSearch);
    }
    @When("User clicks on Search button")
    public void user_clicks_on_search_button() {
        homePage = new HomePage(webDriver);
        homePage.setClickSearchButton();
        //webDriver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

    }

    @Then("User should get valid product displayed in search results")
    public void user_should_get_valid_product_displayed_in_search_results() {
        searchResultsPage = new SearchResultsPage(webDriver);
        Assert.assertTrue(searchResultsPage.setSearchValidProduct());
    }



    @Then("User should get a message about no product listing")
    public void user_should_get_a_message_about_no_product_listing() {
        searchResultsPage = new SearchResultsPage(webDriver);
        Assert.assertEquals("There is no product that matches the search criteria.", searchResultsPage.validateNoResultSearch());
    }

    @When("User does not enter valid any product details into search box field")
    public void user_does_not_enter_valid_any_product_details_into_search_box_field() {
        //Intentionally kept blank
    }
}
