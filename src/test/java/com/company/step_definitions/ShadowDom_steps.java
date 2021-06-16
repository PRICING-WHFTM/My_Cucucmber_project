package com.company.step_definitions;

import com.company.pages.Heroku_Homepage;
import com.company.utilities.BrowserUtils;
import com.company.utilities.DriverUtil;
import com.company.utilities.JSUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ShadowDom_steps {
    Heroku_Homepage heroku_homepage = new Heroku_Homepage();

    @When("I click shadow dom")
    public void i_click_shadow_dom() {
        heroku_homepage.shadowDOM.click();
    }

    @Then("I should see {string} in landed page")
    public void i_should_see_in_landed_page(String string) {
        WebElement shadowHost = DriverUtil.getDriver().findElement(By.xpath("//div[@id='content']/my-paragraph[1]"));
        JavascriptExecutor js = (JavascriptExecutor) DriverUtil.getDriver();
        WebElement shadowRoot = JSUtil.getShadowDOM(shadowHost);
        BrowserUtils.wait(3);
        WebElement textArea = shadowRoot.findElement(By.cssSelector("span[slot='my-text']"));
        Assert.assertEquals(textArea.getText(), string);
    }
}
