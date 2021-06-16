package com.company.step_definitions;

import com.company.pages.LoginPage;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Login_DDT {

   WebDriver driver;
    @Given("Navigate to website")
    public void navigate_to_website() {
        driver = DriverUtil.getDriver();
        driver.get(ConfigReader.getProperty("heroURL"));
    }

    @When("I enter {string} and {string}")
    public void i_enter_and(String string, String string2) {
        LoginPage loginPage = new LoginPage();
        loginPage.username.sendKeys(string);
        loginPage.password.sendKeys(string2);
        loginPage.submit.click();
    }

    @Then("I should get the {string}")
    public void i_should_get_the(String string) {
        LoginPage loginPage = new LoginPage();
        BrowserUtils.waitForVisibility(loginPage.textField);
        Assert.assertTrue(loginPage.flashMessage().contains(string));
    }
}
