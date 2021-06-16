package com.company.step_definitions;

import com.company.pages.Heroku_Homepage;
import com.company.pages.JavaScriptAlerts;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;

public class JavaScriptAlerts_steps {

    Heroku_Homepage homepage = new Heroku_Homepage();
    JavaScriptAlerts javaScriptAlerts = new JavaScriptAlerts();

    @When("I click javaScriptAlerts")
    public void i_click_javaScriptAlerts() {
        homepage.javaScriptAlerts.click();
    }

    @Then("I should land to javaScript page")
    public void i_should_land_to_javaScript_page() {
        Assert.assertNotEquals(DriverUtil.getDriver().getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @When("I click click for js alert")
    public void i_click_click_for_js_alert() {
        javaScriptAlerts.clickForJsAlert.click();
    }

    @When("I accept the jsAlert")
    public void i_accept_the_jsAlert() {
        DriverUtil.getDriver().switchTo().alert().accept();
    }

    @Then("I should see {string} message")
    public void i_should_see_message(String string) {
        Assert.assertEquals(javaScriptAlerts.result.getText(), string);
    }

    @When("I click click for js confirm")
    public void i_click_click_for_js_confirm() {
        javaScriptAlerts.clickForJsConfirm.click();
    }

    @When("I dismiss the jsAlert")
    public void i_dismiss_the_jsAlert() {
        DriverUtil.getDriver().switchTo().alert().dismiss();
    }

    @Then("I should see {string} message2")
    public void i_should_see_message2(String string) {
        Assert.assertEquals(javaScriptAlerts.result.getText(), string);
    }

    @When("I click click for js prompt")
    public void i_click_click_for_js_prompt() {
        javaScriptAlerts.clickForJsPrompt.click();
    }

    @When("I send the text {string}")
    public void i_send_the_text(String string) throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_H);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_H);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyRelease(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyRelease(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        BrowserUtils.wait(1);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        BrowserUtils.wait(2);
    }

    @Then("I should see {string} message3")
    public void i_should_see_message3(String string) {
        Assert.assertEquals(javaScriptAlerts.result.getText(), string);
    }
}
