package com.company.step_definitions;

import com.company.pages.Mercury_Homepage;
import com.company.pages.Mercury_Register;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class MercuryRegister_steps {

    private WebDriver driver = DriverUtil.getDriver();
    Mercury_Homepage homepage = new Mercury_Homepage();
    Mercury_Register register = new Mercury_Register();

    @Given("I am in mercury homepage")
    public void i_am_in_mercury_homepage() {
        driver.get(ConfigReader.getProperty("mercury"));
        Assert.assertTrue(driver.getTitle().contains("Welcome: Mercury Tours"));
    }

    @When("I click register")
    public void i_click_register() {
        homepage.register.click();
    }

    @When("I provide account details")
    public void i_provide_account_details() {
        register.accountDetails();
    }

    @When("I click submit button in the register page")
    public void i_click_submit_button_in_the_register_page() {
        register.submitBtn.click();
    }

    @Then("I should be able to see confirmation message containing my email.")
    public void i_should_be_able_to_see_confirmation_message_containing_my_email() {
        String expectedConfirmation = "Note: Your user name is " + register.email;
        Assert.assertTrue(driver.getPageSource().contains(expectedConfirmation));
        System.out.println("email is: " + register.email);
        System.out.println("password is: " + register.password);
    }


}
