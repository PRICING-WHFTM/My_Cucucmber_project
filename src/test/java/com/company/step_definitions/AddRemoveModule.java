package com.company.step_definitions;

import com.company.pages.AddRemoveElements;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AddRemoveModule {

    private WebDriver driver = DriverUtil.getDriver();
    Heroku_Homepage homepage = new Heroku_Homepage();
    AddRemoveElements addRemovePage = new AddRemoveElements();
    String homePageTitle;

    @Given("User navigates to homepage")
    public void user_navigates_to_homepage() {
        driver.get(ConfigReader.getProperty("herURL"));

    }

    @Then("Add\\/Remove Elements should display in homePage")
    public void add_Remove_Elements_should_display_in_homePage() {
        Assert.assertTrue(homepage.add_Remove_Elements.isDisplayed());
    }

    @Given("I am in HomePage")
    public void i_am_in_HomePage() {
        driver.get(ConfigReader.getProperty("herURL"));
        homePageTitle = driver.getTitle();

    }

    @When("I click on Add\\/Remove Elements module")
    public void i_click_on_Add_Remove_Elements_module() {
        homepage.add_Remove_Elements.click();
    }

    @Then("I should land to Add\\/Remove Elements page")
    public void i_should_land_to_Add_Remove_Elements_page() {
        Assert.assertTrue(addRemovePage.addElement.isDisplayed());
    }

    @Then("Only Add Elements button should display at the pagee")
    public void only_Add_Elements_button_should_display_at_the_pagee() {
        List<WebElement> button = driver.findElements(By.tagName("button"));
        Assert.assertTrue(button.size() == 1);
    }


    @When("I click Add\\/Elements button")
    public void i_click_Add_Elements_button() {
        addRemovePage.addElement.click();
    }

    @Then("Delete Elements button is displaying")
    public void delete_Elements_button_is_displaying() {
        Assert.assertTrue(addRemovePage.deleteElement.isDisplayed());
        List<WebElement> button = driver.findElements(By.tagName("button"));
        Assert.assertTrue(button.size() == 2);
    }


    @When("I click to Delete Elements")
    public void i_click_to_Delete_Elements() {
        addRemovePage.deleteElement.click();
    }

    @Then("The element is disappearing")
    public void the_element_is_disappearing() {
        List<WebElement> button = driver.findElements(By.tagName("button"));
        Assert.assertTrue(button.size() == 1);
    }
}
