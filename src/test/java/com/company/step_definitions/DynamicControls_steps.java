package com.company.step_definitions;

import com.company.pages.DynamicControls;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.BrowserUtils;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class DynamicControls_steps {

    private WebDriver driver;
    Heroku_Homepage homepage = new Heroku_Homepage();
    DynamicControls dynamicControls = new DynamicControls();

    @Given("{string} module should exists in homepage")
    public void module_should_exists_in_homepage(String string) {
        driver = DriverUtil.getDriver();
        Assert.assertTrue(homepage.dynamicControlsModule.isDisplayed());
        Assert.assertEquals(homepage.dynamicControlsModule.getText(), string);
    }

    @When("I click dynamic controls")
    public void i_click_dynamic_controls() {
        homepage.dynamicControlsModule.click();
    }

    @Then("I should land t dynamic controls page")
    public void i_should_land_t_dynamic_controls_page() {
        Assert.assertNotEquals(driver.getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @Then("editBox in the page should be disabled by default")
    public void editbox_in_the_page_should_be_disabled_by_default() {
        Assert.assertFalse(dynamicControls.editBox.isEnabled());
    }

    @Then("{string} button should exist in the page")
    public void button_should_exist_in_the_page(String string) {
        Assert.assertTrue(dynamicControls.enableBtn.isDisplayed());
        Assert.assertEquals(dynamicControls.enableBtn.getText(), string);
    }

    @When("I click enable button")
    public void i_click_enable_button() {
        dynamicControls.enableBtn.click();
    }

    @Then("editBox should be enabled")
    public void editbox_should_be_enabled() {
        BrowserUtils.waitForClickablility(dynamicControls.editBox);
        Assert.assertTrue(dynamicControls.editBox.isEnabled());
    }

    @Then("I should see {string} text displayed")
    public void i_should_see_text_displayed(String string) {
        Assert.assertEquals(dynamicControls.enableText(), string);
    }

    @Then("{string} should display in the page")
    public void should_display_in_the_page(String string) {
        Assert.assertTrue(dynamicControls.checkBox.isDisplayed());
        Assert.assertEquals(dynamicControls.checkBox.getText(), string);
    }

    @Then("{string} button should display in the page")
    public void button_should_display_in_the_page(String string) {
        Assert.assertTrue(dynamicControls.removeBtn.isDisplayed());
        Assert.assertEquals(dynamicControls.removeBtn.getText(), string);
    }

    @Then("I should be able to check the checkbox")
    public void i_should_be_able_to_check_the_checkbox() {
        Assert.assertFalse(dynamicControls.checkBox.isSelected());
        dynamicControls.checkBox.click();
    }

    @When("I click remove button")
    public void i_click_remove_button() {
        dynamicControls.removeBtn.click();
        BrowserUtils.waitForVisibility(dynamicControls.addBtn);
    }


    @Then("checkbox should not display in the page")
    public void checkbox_should_not_display_in_the_page() {
        BrowserUtils.verifyElementNotDisplayed("//input[@type='checkbox']");
    }

    @Then("{string} text should display in the page")
    public void text_should_display_in_the_page(String string) {
        Assert.assertTrue(driver.getPageSource().contains(string));
    }

    @Then("remove button should not display in the page")
    public void remove_button_should_not_display_in_the_page() {
        BrowserUtils.verifyElementNotDisplayed("//button[contains(text(),'Remove')]");
    }


}
