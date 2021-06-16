package com.company.step_definitions;

import com.company.pages.EntryAd;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;

public class EntryAd_steps {
    private WebDriver driver = DriverUtil.getDriver();
    Heroku_Homepage homepage = new Heroku_Homepage();
    EntryAd entryAd = new EntryAd();

    @When("I click entryAd link")
    public void i_click_entryAd_link() {
        homepage.entryAd.click();
    }

    @Then("I should land to entryAd page")
    public void i_should_land_to_entryAd_page() {
        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @Then("close html alert should display")
    public void close_html_alert_should_display() {
        BrowserUtils.waitForVisibility(entryAd.close);
        Assert.assertTrue(entryAd.close.isDisplayed());
    }

    @When("I click close")
    public void i_click_close() {
        entryAd.close.click();
    }

    @Then("html alert should disappeared")
    public void html_alert_should_disappeared() {
        boolean isDisplaying = false;
        try {
            isDisplaying = entryAd.close.isDisplayed();
        } catch (NoSuchElementException e) {
        }
        if (isDisplaying) {
            System.out.println("Element did not disappear , still in the page");
        } else {
            System.out.println("Element is gone");
        }
    }

    @When("I double click clickHere")
    public void i_double_click_clickHere() {
        Actions actions = new Actions(driver);
        actions.doubleClick(entryAd.clickHere).build().perform();
    }

    @Then("html alert should display again")
    public void html_alert_should_display_again() {
        List<WebElement> htmlAlerts = driver.findElements(By.tagName("p"));
        if (htmlAlerts.size() > 0) {
            System.out.println("Element again present in the page");
        } else {
            System.out.println("html alert still not in the page");
        }
    }

}
