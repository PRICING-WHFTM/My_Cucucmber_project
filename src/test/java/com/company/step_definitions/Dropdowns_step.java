package com.company.step_definitions;

import com.company.pages.Dropdowns;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Dropdowns_step {

    public WebDriver driver = DriverUtil.getDriver();
    Heroku_Homepage homepage = new Heroku_Homepage();
    Dropdowns dropdowns = new Dropdowns();
    private List<WebElement> options;
    private Select selectDropdown;


    @Given("{string} module  should exist in homepage")
    public void module_should_exist_in_homepage(String string) {
        Assert.assertTrue(homepage.dropdownsModule.isDisplayed());
        String dropdownModuleText = homepage.dropdownsModule.getText();
        Assert.assertEquals(dropdownModuleText, string);
    }

    @When("I click dropdown")
    public void i_click_dropdown() {
        homepage.dropdownsModule.click();
    }

    @Then("I should land to dropdown page")
    public void i_should_land_to_dropdown_page() {
        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.getProperty("herURL"));

    }

    @Then("should exist {int} dropdowns")
    public void should_exist_dropdowns(int int1) {
        selectDropdown = new Select(dropdowns.dropdownContainer);
        options = selectDropdown.getOptions();
        Assert.assertEquals(int1, options.size());
    }

    @Then("dropdowns should have name {string} and {string}")
    public void dropdowns_should_have_name_and(String string, String string2) {
        List<String> optionsNames = new ArrayList<>();
        for (WebElement option : options) {
            optionsNames.add(option.getText());
        }
        Assert.assertTrue(optionsNames.contains(string) && optionsNames.contains(string2));

    }

    @When("I select {string}")
    public void i_select(String string) {
        selectDropdown.selectByVisibleText(string);
    }

    @Then("{string} should be selectedDropdown")
    public void should_be_selectedDropdown(String string) {
        Assert.assertEquals(selectDropdown.getFirstSelectedOption().getText(), string);
    }


}
