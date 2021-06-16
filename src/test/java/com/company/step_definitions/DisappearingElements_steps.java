package com.company.step_definitions;

import com.company.pages.DisappearingElements;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DisappearingElements_steps {

    private WebDriver driver;
    Heroku_Homepage homepage = new Heroku_Homepage();
    DisappearingElements disappearingElements = new DisappearingElements();

    @Given("I should see {string} module in homepage")
    public void i_should_see_module_in_homepage(String string) {
        driver = DriverUtil.getDriver();
        Assert.assertTrue(homepage.disappearingElementsModule.isDisplayed());
        String nameOfModule = homepage.disappearingElementsModule.getText();
        Assert.assertEquals(string, nameOfModule);
    }

    @When("I click disappearing elements module in homepage")
    public void i_click_disappearing_elements_module_in_homepage() {
        homepage.disappearingElementsModule.click();
    }

    @Then("I should land to Disappearing Elements page")
    public void i_should_land_to_Disappearing_Elements_page() {
        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @When("I click About element in the page")
    public void i_click_About_element_in_the_page() {
        disappearingElements.about.click();
    }

    @When("element should disappear")
    public void element_should_disappear() {
        // here I will use list to verify the element not exist, because when I try directly
        // use AssertFalse then during locating the element it will
        // throw an exception NoSuchElementException even if I use AssertFalse.
        // this is the best way
        List<WebElement> aboutList = driver.findElements(By.linkText("About"));
        if (aboutList.size() > 0) {
            System.out.println("Element still exists in the page");
        } else {
            System.out.println("Element disappeared");
        }

    }


}


