package com.company.step_definitions;

import com.company.pages.Heroku_Homepage;
import com.company.pages.ShiftingContent;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ShiftingContent_steps {
    Heroku_Homepage homepage = new Heroku_Homepage();
    ShiftingContent shiftingContent = new ShiftingContent();

    @When("I click shifting content")
    public void i_click_shifting_content() {
        homepage.shiftingContent.click();
    }

    @Then("I should see {int} examples")
    public void i_should_see_examples(int int1) {
        List<WebElement> examples = DriverUtil.getDriver().findElements(By.xpath("//div[@id='content']//a"));
        Assert.assertEquals(examples.size(), int1);
    }

    @When("I click first example")
    public void i_click_first_example() {
        shiftingContent.example1.click();
    }

    @Then("I should see {int} options")
    public void i_should_see_options(int int1, List<String> dataTable) {
        List<WebElement> options = DriverUtil.getDriver().findElements(By.xpath("//div[@class='example']//ul//li//a"));
        Assert.assertEquals(options.size(), int1);
        List<String> optionNames = new ArrayList<>();
        for (WebElement option : options) {
            optionNames.add(option.getText());
        }
        Assert.assertTrue(optionNames.containsAll(dataTable));
        Assert.assertTrue(optionNames.equals(dataTable));


    }
}