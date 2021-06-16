package com.company.step_definitions;

import com.company.pages.Heroku_Homepage;
import com.company.pages.Inputs_increment;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Inputs_increments_steps {
    Heroku_Homepage homepage = new Heroku_Homepage();
    Inputs_increment inputs_increment = new Inputs_increment();

    @When("I click inputs")
    public void i_click_inputs() {
        homepage.inputs.click();
    }

    @Then("I should land to inputs page")
    public void i_should_land_to_inputs_page() {
        Assert.assertNotEquals(DriverUtil.getDriver().getCurrentUrl(), ConfigReader.getProperty("hetURL"));
    }

    @When("I increment {int} times")
    public void i_increment_times(int int1) {
        inputs_increment.editBox.click();
        for (int i = 0; i < int1; i++) {
            inputs_increment.editBox.sendKeys(Keys.UP);
        }
        BrowserUtils.wait(1);
    }

    @When("Decrement {int} times")
    public void decrement_times(int int1) {
        for (int i = 0; i < int1; i++) {
            inputs_increment.editBox.sendKeys(Keys.DOWN);
        }
        BrowserUtils.wait(1);
    }

    @Then("I should see {int} in editbox")
    public void i_should_see_in_editbox(int int1) {
        Assert.assertEquals(inputs_increment.editBox.getAttribute("value"), String.valueOf(int1));
    }

}
