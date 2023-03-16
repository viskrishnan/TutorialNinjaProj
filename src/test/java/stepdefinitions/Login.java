package stepdefinitions;

import Factory.driverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Date;


public class Login {

    WebDriver webDriver;
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        webDriver = driverFactory.getDriver();
        webDriver.findElement(By.xpath(" //span[normalize-space()='My Account']")).click();
        webDriver.findElement(By.linkText("Login")).click();
    }

    @When("User enters valid email address {string} in the email field")
    public void user_enters_valid_email_address_in_the_email_field(String emailAddress) {
        webDriver.findElement(By.id("input-email")).sendKeys(emailAddress);
    }

    @When("User had entered a valid password {string}")
    public void user_had_entered_a_valid_password(String password) {
        webDriver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        webDriver.findElement(By.xpath("//input[@value='Login']")).click();

    }
    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        Assert.assertTrue(webDriver.findElement(By.linkText("Edit your account information")).isDisplayed());
    }

    @When("User enters invalid email address in the email fields")
    public void user_enters_invalid_email_address_in_the_email_fields() {
        webDriver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
    }

    public String getEmailWithTimeStamp(){
        Date date = new Date();
        return "amotoori"+date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
    }

    @When("User had entered a invalid password {string}")
    public void user_had_entered_a_invalid_password(String invalidPwd) {
        webDriver.findElement(By.id("input-password")).sendKeys(invalidPwd);
    }

    @Then("User gets warning message for invalid credentials mismatch")
    public void user_gets_warning_message_for_invalid_credentials_mismatch() {
        Assert.assertTrue(webDriver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains(" Warning: No match for E-Mail Address and/or Password."));
    }

    @When("User does not enter email address in the email field")
    public void user_does_not_enter_email_address_in_the_email_field() {
        webDriver.findElement(By.id("input-email")).sendKeys("");
    }
    @When("User does not enter password in the password field")
    public void user_does_not_enter_password_in_the_password_field() {
        webDriver.findElement(By.id("input-password")).sendKeys("");
    }

}
