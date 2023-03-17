package stepdefinitions;

import Factory.driverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {

    WebDriver webDriver;
    HomePage homePage = new HomePage(webDriver);
    LoginPage loginPage = new LoginPage(webDriver);
    AccountPage accountPage = new AccountPage(webDriver);

    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {

        webDriver = driverFactory.getDriver();
        homePage.clickOnMyAccount();
        homePage.clickOnLogin();
        //webDriver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        //webDriver.findElement(By.linkText("Login")).click();
    }

    @When("User enters valid email address {string} in the email field")
    public void user_enters_valid_email_address_in_the_email_field(String emailAddress) {
        loginPage.setEnterEmailAddr(emailAddress);
    }

    @When("User had entered a valid password {string}")
    public void user_had_entered_a_valid_password(String password) {
        loginPage.setEnterPassword(password);
        //webDriver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLogin();
        //webDriver.findElement(By.xpath("//input[@value='Login']")).click();

    }
    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
        Assert.assertTrue(accountPage.displayAccountInfo());
    }

    @When("User enters invalid email address in the email fields")
    public void user_enters_invalid_email_address_in_the_email_fields() {
        loginPage.enterInvalidEmailAddress(CommonUtils.getEmailWithTimeStamp());
        //webDriver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
    }

    @When("User had entered a invalid password {string}")
    public void user_had_entered_a_invalid_password(String invalidPwd) {
        loginPage.enterInvalidPassword(invalidPwd);
        //webDriver.findElement(By.id("input-password")).sendKeys(invalidPwd);
    }

    @Then("User gets warning message for invalid credentials mismatch")
    public void user_gets_warning_message_for_invalid_credentials_mismatch() {
        Assert.assertTrue(loginPage.validateInvalidCredentialsMismatch().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @When("User does not enter email address in the email field")
    public void user_does_not_enter_email_address_in_the_email_field() {
        loginPage.setDoNotEnterEmailAddr();
        //webDriver.findElement(By.id("input-email")).sendKeys("");
    }
    @When("User does not enter password in the password field")
    public void user_does_not_enter_password_in_the_password_field() {
        loginPage.setDoNotEnterPassword();
        //webDriver.findElement(By.id("input-password")).sendKeys("");
    }

}
