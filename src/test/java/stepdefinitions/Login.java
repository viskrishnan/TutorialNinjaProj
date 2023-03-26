package stepdefinitions;

import Factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class Login {

    WebDriver webDriver = null;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private HomePage homePage;
    private CommonUtils commonUtils;
    @Given("User navigates to login page")
    public void user_navigates_to_login_page() {
        webDriver = DriverFactory.getDriver();
        homePage = new HomePage(webDriver);
//        webDriver.findElement(By.xpath("//span[text()='My Account']")).click();
        homePage.clickOnMyAccount();
        loginPage = homePage.clickOnApplicationLogin();
//        loginPage = homePage.clickOnLogin();
       // webDriver.findElement(By.linkText("Login")).click();
    }

    @When("User enters valid email address {string} in the email field")
    public void user_enters_valid_email_address_in_the_email_field(String emailAddress) {
        loginPage.enterEmailAddress(emailAddress);
        //webDriver.findElement(By.id("input-email")).sendKeys(emailAddress);
    }

    @When("User had entered a valid password {string}")
    public void user_had_entered_a_valid_password(String password) {
        loginPage.enterPassword(password);
        //webDriver.findElement(By.id("input-password")).sendKeys(password);
    }

    @When("User clicks on Login button")
    public void user_clicks_on_login_button() {
        loginPage.clickOnLoginButton();
        //webDriver.findElement(By.xpath("//input[@value='Login']")).click();

    }
    @Then("User should get successfully logged in")
    public void user_should_get_successfully_logged_in() {
//        accountPage = new AccountPage(webDriver);
        //Assert.assertTrue(accountPage.displayAccountInfo());
        Assert.assertTrue(webDriver.findElement(By.xpath("//a[normalize-space()='Edit your account information']")).isDisplayed());
    }

    @When("User enters invalid email address in the email fields")
    public void user_enters_invalid_email_address_in_the_email_fields() {
        commonUtils = new CommonUtils();
        loginPage.enterEmailAddress(commonUtils.getEmailWithTimeStamp());
        //webDriver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
    }

    @When("User had entered a invalid password {string}")
    public void user_had_entered_a_invalid_password(String invalidPwd) {
        loginPage.enterPassword(invalidPwd);
        //webDriver.findElement(By.id("input-password")).sendKeys(invalidPwd);
    }

    @Then("User gets warning message for invalid credentials mismatch")
    public void user_gets_warning_message_for_invalid_credentials_mismatch() {
//        Assert.assertTrue(loginPage.validateInvalidCredentialsMismatch().contains("Warning: No match for E-Mail Address and/or Password."));
        Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
    }

    @When("User does not enter email address in the email field")
    public void user_does_not_enter_email_address_in_the_email_field() {
        loginPage.enterEmailAddress("");
    }
    @When("User does not enter password in the password field")
    public void user_does_not_enter_password_in_the_password_field() {
        loginPage.enterPassword("");
    }

}
