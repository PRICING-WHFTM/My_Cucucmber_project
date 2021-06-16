package com.company.step_definitions;

import com.company.pages.ForgotPassword;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

public class ForgotPassword_steps {
    Heroku_Homepage homepage = new Heroku_Homepage();
    ForgotPassword forgotPassword = new ForgotPassword();

    @When("I click forgot password")
    public void i_click_forgot_password() {
        homepage.forgotPassword.click();
    }

    @When("I provide email {string}")
    public void i_provide_email(String string) {
        forgotPassword.emailBox.sendKeys(string + Keys.ENTER);
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String string) {
        DriverUtil.getDriver().getPageSource().contains(string);
    }



}
