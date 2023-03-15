package stepdefinitions;

import Factory.driverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Register {

    WebDriver webDriver;

    @Given("User navigates to Register account page")
    public void user_navigates_to_register_account_page() {
        webDriver = driverFactory.getDriver();
        webDriver.findElement(By.xpath(" //span[normalize-space()='My Account']")).click();
        webDriver.findElement(By.linkText("Register")).click();
    }

    @When("User enters the below fields")
    public void user_enters_the_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
        webDriver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
        webDriver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
        webDriver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
        webDriver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
        webDriver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
        webDriver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));


    }

    @When("User clicks on Privacy policy")
    public void user_clicks_on_privacy_policy() {
        webDriver.findElement(By.xpath("//input[@name='agree']")).click();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        webDriver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    @Then("User Account should be created successfully")
    public void user_account_should_be_created_successfully() {
        Assert.assertEquals("Your Account Has Been Created!", webDriver.findElement(By.xpath("//div[@id='Content']/h1")).getText());
    }

    @When("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter() {
        webDriver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
    }

    @Then("User Account should get error message with duplicate email")
    public void user_account_should_get_error_message_with_duplicate_email() {
        Assert.assertEquals(" Warning: E-Mail Address is already registered!", webDriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText());
        //Assert.assertTrue(webDriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains(" Warning: E-Mail Address is already registered!"));
    }

    @Then("User does not enter any user details")
    public void user_does_not_enter_any_user_details() {
        //Intentionally kept blank
    }

    @Then("User should get proper warning message for all mandatory fields")
    public void user_should_get_proper_warning_message_for_all_mandatory_fields() {
//div[@class='alert alert-danger alert-dismissible']
        Assert.assertTrue(webDriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains(" Warning: You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!",webDriver.findElement(By.xpath("//div[contains(text(),'First Name must be between 1 and 32 characters!')]")).getText());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!",webDriver.findElement(By.className("text-danger")).getText());
        Assert.assertEquals("E-Mail Address does not appear to be valid!",webDriver.findElement(By.className("text-danger")).getText());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!",webDriver.findElement(By.className("text-danger")).getText());
        Assert.assertEquals("Password must be between 4 and 20 characters!",webDriver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText());
    }
}
