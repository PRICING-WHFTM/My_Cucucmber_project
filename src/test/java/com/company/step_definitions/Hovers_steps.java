package com.company.step_definitions;

import com.company.pages.Heroku_Homepage;
import com.company.pages.Hovers;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Hovers_steps {
    private WebDriver driver = DriverUtil.getDriver();
    Heroku_Homepage homepage = new Heroku_Homepage();
    Hovers hovers = new Hovers();
    List<String> userNames;

    @When("I click hovers")
    public void i_click_hovers() {
        homepage.hovers.click();
    }

    @Then("I should land to hovers page")
    public void i_should_land_to_hovers_page() {
        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @When("I hover to images")
    public void i_hover_to_images() {
        Actions actions = new Actions(driver);
        userNames = new ArrayList<>();
        actions.moveToElement(hovers.image1).pause(2).build().perform();
        userNames.add(hovers.user1Text());
        actions.moveToElement(hovers.image2).pause(2).build().perform();
        userNames.add(hovers.user2Text());
        actions.moveToElement(hovers.image3).pause(2).build().perform();
        userNames.add(hovers.user3Text());
    }

    @Then("I should be able to read the texts under the images")
    public void i_should_be_able_to_read_the_texts_under_the_images(List<String> dataTable) {
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        Assert.assertTrue(userNames.containsAll(dataTable));
        System.out.println(dataTable);

    }


}