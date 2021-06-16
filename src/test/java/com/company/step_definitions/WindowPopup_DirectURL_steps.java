package com.company.step_definitions;

import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class WindowPopup_DirectURL_steps {

    @Given("I enter {string}")
    public void i_enter(String string) {
        DriverUtil.getDriver().get(string);
    }

    @Then("I should see {string} message in the page")
    public void i_should_see_message_in_the_page(String string) {
        Assert.assertTrue(DriverUtil.getDriver().getPageSource().contains(string));
    }
}
