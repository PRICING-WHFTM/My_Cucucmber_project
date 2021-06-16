package com.company.step_definitions;

import com.company.pages.GoogleTranslator;
import com.company.utilities.BrowserUtils;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class GoogleTranslate_steps {
    GoogleTranslator googleTranslator = new GoogleTranslator();

    @Given("I am in {string} page")
    public void i_am_in_page(String string) {
        DriverUtil.getDriver().get(string);
    }

    @Given("I choose from language {string}")
    public void i_choose_from_language(String string) {
        googleTranslator.fromLanguage.click();
        BrowserUtils.wait(1);
        googleTranslator.selectLanguage(string);
        BrowserUtils.wait(1);
    }

    @When("I am entering  {string}")
    public void i_am_entering(String string) {
        googleTranslator.fromTextArea.sendKeys(string);
        BrowserUtils.wait(1);
    }

    @Given("To language is {string}")
    public void to_language_is(String string) {
        googleTranslator.toLanguage.click();
        googleTranslator.selectLanguage(string);
        BrowserUtils.wait(1);
    }

    @Then("I should see text {string}")
    public void i_should_see_text(String string) {
        String actual = googleTranslator.outputText.getText();
        System.out.println(actual);
        Assert.assertEquals(actual, string);
    }


}
