package com.company.step_definitions;

import com.company.pages.DragAndDrop;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop_steps {


    Heroku_Homepage homepage = new Heroku_Homepage();
    DragAndDrop dragAndDrop = new DragAndDrop();

    @Then("I should see {string} module in the homepage")
    public void i_should_see_module_in_the_homepage(String string) {
        Assert.assertTrue(homepage.dragAndDropModule.isDisplayed());
        Assert.assertEquals(homepage.dragAndDropModule.getText(), string);
    }

    @When("I click drag and drop")
    public void i_click_drag_and_drop() {
        homepage.dragAndDropModule.click();
    }

    @Then("I should land drag and drop page")
    public void i_should_land_drag_and_drop_page() {
        Assert.assertNotEquals(DriverUtil.getDriver().getCurrentUrl(), ConfigReader.getProperty("herURL"));
    }

    @Then("I should see A and B elements")
    public void i_should_see_A_and_B_elements() {
        Assert.assertTrue(dragAndDrop.columnA.isDisplayed());
        Assert.assertTrue(dragAndDrop.columnB.isDisplayed());

    }

    @Then("I should be able to drag element A and drop to element B")
    public void i_should_be_able_to_drag_element_A_and_drop_to_element_B() {
        Actions actions = new Actions(DriverUtil.getDriver());
       // actions.moveToElement(dragAndDrop.columnA).clickAndHold().
               // moveToElement(dragAndDrop.columnB).release().build().perform();
        actions.dragAndDrop(dragAndDrop.columnA, dragAndDrop.columnB).build().perform();
    }

}
