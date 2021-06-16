package com.company.step_definitions;

import com.company.pages.Heroku_Homepage;
import com.company.pages.JqueryUI;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import com.company.utilities.JSUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import javax.swing.text.html.HTML;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JQueryUI_steps {

    Heroku_Homepage homepage = new Heroku_Homepage();
    JqueryUI jqueryUI = new JqueryUI();
    Actions actions = new Actions(DriverUtil.getDriver());
    List<WebElement> formats;
    File file;

    @When("I click jquery")
    public void i_click_jquery() {
        homepage.jQuery.click();
    }

    @Then("I should land to jquery age")
    public void i_should_land_to_jquery_age() {
        Assert.assertNotEquals(DriverUtil.getDriver().getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @When("I hover to enabled")
    public void i_hover_to_enabled() {
        actions.moveToElement(jqueryUI.enabled).build().perform();
        BrowserUtils.wait(2);
    }

    @When("I hover to downloads")
    public void i_hover_to_downloads() throws Exception {
        actions.moveToElement(jqueryUI.downloads).build().perform();
    }

    // We need to store all bootstrap dropdown elements
    @Then("I should see {int} options there")
    public void i_should_see_options_there(int int1) {
        //here we get "xpath of Parent of ul tag//current ul//li //a "
        formats = DriverUtil.getDriver().findElements(By.xpath("//ul[@id='menu']/li[2]/ul/li/ul/li/a"));
        Assert.assertEquals(formats.size(), int1);
        for (WebElement elem : formats) {
            System.out.println(elem.getText());
        }

    }


    @When("I click {string} in options")
    public void i_click_in_options(String string) {
        file = new File(System.getProperty("user.dir") + "/menu.pdf");
        if (!file.exists()) {
            for (WebElement elem : formats) {
                if (elem.getText().equals(string)) {
                    elem.click();
                    BrowserUtils.wait(1);
                    break;
                }
            }
        }
    }

    @Then("It should be downloaded to my computer")
    public void it_should_be_downloaded_to_my_computer() {
        Assert.assertTrue(file.exists());
    }


}
