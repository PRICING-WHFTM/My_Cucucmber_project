package com.company.step_definitions;

import com.company.pages.ContextMenu;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextMenu_step {

    private WebDriver driver;
    Heroku_Homepage homepage = new Heroku_Homepage();
    ContextMenu contextMenu = new ContextMenu();


    @Given("I should see ContextMenu module in Homepage")
    public void i_should_see_ContextMenu_module_in_Homepage() {
        driver = DriverUtil.getDriver();
        Assert.assertTrue(homepage.contextMenuModule.isDisplayed());
    }

    @When("I click on contextMenu module")
    public void i_click_on_contextMenu_module() {
        homepage.contextMenuModule.click();
    }

    @Then("I should land to contextmenu page")
    public void i_should_land_to_contextmenu_page() {
        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @Then("empty square should display in the page")
    public void empty_square_should_display_in_the_page() {
        Assert.assertTrue(contextMenu.square.isDisplayed());
    }

    @When("I do rightclik on square")
    public void i_do_rightclik_on_square() {
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenu.square).build().perform();
    }

    @Then("JS Alert should popup")
    public void js_Alert_should_popup() {
        String alertMessage = driver.switchTo().alert().getText();
        System.out.println("Alert text:  " + alertMessage);
        if (!alertMessage.isEmpty()) {
            System.out.println("Alert present in the page");
        } else {
            throw new RuntimeException("Alert is not in the page");
        }
    }

    @When("I dismiss the alert")
    public void i_dismiss_the_alert() {
        driver.switchTo().alert().accept();
    }

    @Then("alert should disappear.")
    public void alert_should_disappear() {
        try {
            driver.switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Alert not present in page"); // I can catch the exception and
        }                                                    // display my own message, if try block failse
                                                            // it will run my message in catch block

    }

}
