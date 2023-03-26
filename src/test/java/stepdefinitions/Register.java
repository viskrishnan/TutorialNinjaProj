package stepdefinitions;

import Factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AccountSuccessPage;
import pages.AccountWarningsPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

import java.util.Map;

public class Register {

    WebDriver webDriver;
    private RegisterPage registerPage;
    private AccountSuccessPage accountSuccessPage;
    private AccountWarningsPage accountWarningsPage;

    private HomePage homePage;
    private CommonUtils commonUtils;
    private DriverFactory driverFactory;
    @Given("User navigates to Register account page")
    public void user_navigates_to_register_account_page() {
        driverFactory = new DriverFactory();
        webDriver = driverFactory.getDriver();
        homePage = new HomePage(webDriver);
        homePage.clickOnMyAccount();
        registerPage = homePage.clickOnRegister();
        //webDriver.findElement(By.xpath(" //span[normalize-space()='My Account']")).click();
        //webDriver.findElement(By.linkText("Register")).click();
    }

    @When("User enters the below fields")
    public void user_enters_the_below_fields(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
        registerPage.enterRegistrationFieldsFirstName(dataMap.get("firstName"));
        registerPage.enterRegistrationFieldsLastName(dataMap.get("lastName"));
        commonUtils = new CommonUtils();
        registerPage.enterRegistrationFieldsEmail(commonUtils.getEmailWithTimeStamp());
        registerPage.enterTelephoneNumber(dataMap.get("telephone"));
        registerPage.setEnterPassword(dataMap.get("password"));
        registerPage.setEnterPasswordConfirm(dataMap.get("password"));
//        webDriver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
//        webDriver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
//        webDriver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//        webDriver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//        webDriver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
    }

    @When("User enters the below fields with duplicate email address")
    public void user_enters_the_below_fields_with_duplicate_email_address(DataTable dataTable) {
        Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
        registerPage.enterRegistrationFieldsFirstName(dataMap.get("firstName"));
        registerPage.enterRegistrationFieldsLastName(dataMap.get("lastName"));
        registerPage.enterRegistrationFieldsEmail(dataMap.get("email"));
        registerPage.enterTelephoneNumber(dataMap.get("telephone"));
        registerPage.setEnterPassword(dataMap.get("password"));
        registerPage.setEnterPasswordConfirm(dataMap.get("password"));
//        webDriver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
//        webDriver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
//        webDriver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
//        webDriver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
//        webDriver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
    }

    @When("User clicks on Privacy policy")
    public void user_clicks_on_privacy_policy() {
        registerPage.setPrivacy_policy();
        //webDriver.findElement(By.xpath("//input[@name='agree']")).click();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        registerPage.clickContinueButton();
        //webDriver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    @Then("User Account should be created successfully")
    public void user_account_should_be_created_successfully() {
        //accountSuccessPage = new AccountSuccessPage(webDriver);
        //Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.setAccountCreationSuccess());
        Assert.assertEquals("Your Account Has Been Created!", webDriver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText());
    }

    @When("User selects Yes for Newsletter")
    public void user_selects_yes_for_newsletter() {
        registerPage.selectYesForNewsLetter();
        //webDriver.findElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']")).click();
    }

    @Then("User Account should get error message with duplicate email")
    public void user_account_should_get_error_message_with_duplicate_email() {
        Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: E-Mail Address is already registered!"));
        //Assert.assertEquals("Warning: E-Mail Address is already registered!", accountWarningsPage.checkDuplicateEmail() );
        //Assert.assertEquals("Warning: E-Mail Address is already registered!", webDriver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText());
    }

    @Then("User does not enter any user details")
    public void user_does_not_enter_any_user_details() {
        registerPage.enterRegistrationFieldsFirstName("");
        registerPage.enterRegistrationFieldsLastName("");
        registerPage.enterRegistrationFieldsEmail("");
        registerPage.enterTelephoneNumber("");
        registerPage.setEnterPassword("");
        registerPage.setEnterPasswordConfirm("");
    }

    @Then("User should get proper warning message for all mandatory fields")
    public void user_should_get_proper_warning_message_for_all_mandatory_fields() {
//        accountWarningsPage = new AccountWarningsPage(webDriver);
        //Assert.assertTrue(webDriver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
//        Assert.assertEquals("Warning: You must agree to the Privacy Policy!",accountWarningsPage.setAgreePrivacyPolicyWarning());
//        Assert.assertEquals("First Name must be between 1 and 32 characters!",accountWarningsPage.setFirstNameWaring());
//        Assert.assertEquals("Last Name must be between 1 and 32 characters!",accountWarningsPage.setLastNameWaring());
//        Assert.assertEquals("E-Mail Address does not appear to be valid!",accountWarningsPage.setEmailAddressWaring());
//        Assert.assertEquals("Telephone must be between 3 and 32 characters!",accountWarningsPage.setTelephoneNumberWaring());
//        Assert.assertEquals("Password must be between 4 and 20 characters!",accountWarningsPage.setPasswordCharactersWarning());
        Assert.assertTrue(registerPage.getWarningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
        Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarning());
        Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarning());
        Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailWarning());
        Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneWarning());
        Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarning());
    }
}
