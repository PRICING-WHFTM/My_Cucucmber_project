package com.company.step_definitions;

import com.company.pages.CheckboxesPage;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxes {


    private WebDriver driver;
    Heroku_Homepage homepage = new Heroku_Homepage();
    CheckboxesPage checkboxesPage = new CheckboxesPage();

    @Then("I should see CheckBoxes module in Homepage")
    public void i_should_see_CheckBoxes_module_in_Homepage() {
        driver = DriverUtil.getDriver();
        Assert.assertTrue(homepage.checkboxes.isDisplayed());
    }

    @When("I click on Checkbox module")
    public void i_click_on_Checkbox_module() {
        homepage.checkboxes.click();
    }

    @Then("I should land to new page")
    public void i_should_land_to_new_page() {
        String currentURL = driver.getCurrentUrl();
        Assert.assertNotEquals(currentURL, ConfigReader.getProperty("herURL"));
    }


    @Then("I should see two Checkboxes in the page with name {string} and {string}")
    public void i_should_see_two_Checkboxes_in_the_page_with_name_and(String string, String string2) {
        Assert.assertEquals(checkboxesPage.checkboxesList.size(), 2);
        System.out.println(checkboxesPage.checkboxesList.size());
        for (int i = 0; i < driver.findElements(By.xpath("//input[@type='checkbox']")).size(); i++) {
            driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).getText();
        }
//        Assert.assertEquals(" checkbox 1", checkboxesPage.checkbox1.getAttribute("innerHTML"));
//        Assert.assertEquals(" checkbox 2", checkboxesPage.checkbox2.getAttribute("innerHTML"));
    }


    @Then("checkbox{int} should be checked by default")
    public void checkbox_should_be_checked_by_default(Integer int1) {
        Assert.assertTrue(checkboxesPage.checkbox2.isSelected());
    }

    @When("I uncheck checkbox{int} and check checkbox{int}")
    public void i_uncheck_checkbox_and_check_checkbox(Integer int1, Integer int2) {
        try {
            checkboxesPage.checkbox2.click();
            Thread.sleep(1000);
            checkboxesPage.checkbox1.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("checkbox{int} should be checked and checkbox{int} should be unchecked")
    public void checkbox_should_be_checked_and_checkbox_should_be_unchecked(Integer int1, Integer int2) {
        Assert.assertFalse(checkboxesPage.checkbox2.isSelected());
        Assert.assertTrue(checkboxesPage.checkbox1.isSelected());
    }


}
