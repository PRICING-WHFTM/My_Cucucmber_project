package com.company.step_definitions;

import com.company.pages.DynamicLoading;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.BrowserUtils;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DynamicLoading_steps {

    Heroku_Homepage homepage = new Heroku_Homepage();
    DynamicLoading dynamicLoading = new DynamicLoading();

    @When("I click dynamic load")
    public void i_click_dynamic_load() {
        homepage.dynamicLoad.click();
    }

    @When("I click example2")
    public void i_click_example2() {
        dynamicLoading.example2.click();
    }

    @When("I click start and fluently wait")
    public void i_click_start_and_fluently_wait() {
        dynamicLoading.start.click();
    }

    @Then("I should see {string} in the page")
    public void i_should_see_in_the_page(String string) {
        // -> Could be done with Explicit wait as well but we wanted t try fluentWait
        // BrowserUtils.waitForVisibility(dynamicLoading.helloWorld);
        BrowserUtils.fluentWait(dynamicLoading.helloWorld, DriverUtil.getDriver());
        Assert.assertEquals(dynamicLoading.helloWorldText(), string);


    }

}
