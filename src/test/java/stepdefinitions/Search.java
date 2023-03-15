package stepdefinitions;

import Factory.driverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Search {

    WebDriver webDriver;
    @Given("User opens the Application")
    public void user_opens_the_application() {
        webDriver = driverFactory.getDriver();
    }

    @When("User enters valid product {string} into search box field")
    public void user_enters_valid_product_into_search_box_field(String searchValidProduct) {
        webDriver.findElement(By.name("search")).sendKeys(searchValidProduct);
    }

    @When("User clicks on Search button")
    public void user_clicks_on_search_button() {
        webDriver.findElement(By.xpath("//i[@class='fa fa-search']")).click();

    }

    @Then("User should get valid product displayed in search results")
    public void user_should_get_valid_product_displayed_in_search_results() {
        Assert.assertTrue(webDriver.findElement(By.linkText("HP LP3065")).isDisplayed());
    }

    @When("User enters invalid product {string} into search box field")
    public void user_enters_invalid_product_into_search_box_field(String invalidProdSearch) {
        webDriver.findElement(By.name("search")).sendKeys(invalidProdSearch);
    }

    @Then("User should get a message about no product listing")
    public void user_should_get_a_message_about_no_product_listing() {
        Assert.assertEquals("There is no product that matches the search criteria.", webDriver.findElement(By.xpath("//p[contains(text(),'There is no product that matches the search criter')]")).getText());
    }

    @When("User does not enter valid any product details into search box field")
    public void user_does_not_enter_valid_any_product_details_into_search_box_field() {
        //Intentionally kept blank
    }
}