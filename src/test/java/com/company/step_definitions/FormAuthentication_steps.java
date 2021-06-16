package com.company.step_definitions;

import com.company.pages.FormAuthentication;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class FormAuthentication_steps {
    private WebDriver driver = DriverUtil.getDriver();
    Heroku_Homepage homepage = new Heroku_Homepage();
    FormAuthentication formAuthentication = new FormAuthentication();

    @When("I click form authentication")
    public void i_click_form_authentication() {
        homepage.formAuthentication.click();
    }

    @Then("I should land to {string}")
    public void i_should_land_to(String string) {
        Assert.assertTrue(driver.getPageSource().contains(string));
    }

    @When("I enter the following data for login")
    public void i_enter_the_following_data_for_login(List<Map<String, String>> dataTable) {
        // List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        formAuthentication.username.sendKeys(dataTable.get(1).get("username")); //tomsmith
        formAuthentication.password.sendKeys(dataTable.get(1).get("password")); //SuperSecretPassword!

    }

    @When("click login button")
    public void click_login_button() {
        formAuthentication.login.click();
    }

    @Then("I {string} should display in the page")
    public void i_should_display_in_the_page(String string) {
        Assert.assertTrue(driver.getPageSource().contains(string));
    }

    @When("I click logout")
    public void i_click_logout() {
        formAuthentication.logout.click();
    }

    @Then("I should land back to {string}")
    public void i_should_land_back_to(String string) {
        Assert.assertTrue(driver.getPageSource().contains(string));
    }


}
