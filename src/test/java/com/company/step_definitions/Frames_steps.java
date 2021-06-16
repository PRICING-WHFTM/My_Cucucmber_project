package com.company.step_definitions;

import com.company.pages.Frames;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Frames_steps {
    private WebDriver driver = DriverUtil.getDriver();
    Heroku_Homepage homepage = new Heroku_Homepage();
    Frames frames = new Frames();

    @When("I click frame")
    public void i_click_frame() {
        homepage.frames.click();
    }

    @Then("I should see {string} and {string} the page")
    public void i_should_see_and_the_page(String string, String string2) {
        Assert.assertTrue(driver.getPageSource().contains(string)
                && driver.getPageSource().contains(string2));
    }

    @When("I click iFrame")
    public void i_click_iFrame() {
        frames.iFrame.click();
    }

    @Then("only {int} frame should exist in the page")
    public void only_frame_should_exist_in_the_page(int int1) {
        Assert.assertEquals(driver.findElements(By.tagName("iframe")).size(), int1);
    }

    @Then("I should be able to switch to frame and get current text {string}")
    public void i_should_be_able_to_swithc_to_frame_and_get_current_text(String string) {
        driver.switchTo().frame(frames.frame);
        Assert.assertEquals(frames.textIFrame(), string);
    }

    @When("I clear the existing text and write {string}")
    public void i_clear_the_existing_text_and_write(String string) {
        frames.iFrameTextField.clear();
        frames.iFrameTextField.sendKeys(string + Keys.ENTER);
    }

    @Then("text should e changed to {string}")
    public void text_should_e_changed_to(String string) {
        Assert.assertEquals(frames.textIFrame(), string);
        driver.switchTo().defaultContent();
    }

    @When("I click nested frames")
    public void i_click_nested_frames() throws InterruptedException {
        frames.nestedFrames.click();
        Thread.sleep(1000);
    }

    @Then("{int} nested frames should appear on the page")
    public void nested_frames_should_appear_on_the_page(int int1) {
        Assert.assertEquals(driver.findElements(By.tagName("frame")).size(), int1);

    }

    @Then("I should be able to switch to parent frame")
    public void i_should_be_able_to_switch_to_parent_frame() {
        WebElement parentFrame = driver.findElement(By.xpath("//frame[@name='frame-top']"));
        driver.switchTo().frame(parentFrame);
    }

    @Then("I should be able to switch to middle frame")
    public void i_should_be_able_to_switch_to_middle_frame() {
        WebElement middleFrame = driver.findElement(By.xpath("//frame[@name='frame-middle']"));
        driver.switchTo().frame(middleFrame);
        //verify inside child frame itself is not visible, so that we verify we are in child frame.
        try {
            driver.findElement(By.xpath("//frame[@name='frame-middle']")).isDisplayed();
            System.out.println("We are still in parent frame");
        } catch (Exception e) {
            System.out.println("We are in middle frame");
        }
    }

    @Then("I should be able to switch back to parent frame and back to main webpage")
    public void i_should_be_able_to_switch_back_to_parent_frame_and_back_to_main_webpage() {
        driver.switchTo().parentFrame();
        // check inside parent frame is child frame visible ?, so that we verify we are in parent frame.
        try {
            driver.findElement(By.xpath("//frame[@name='frame-middle']")).isDisplayed();
            System.out.println("We are back to parent frame");
        } catch (Exception e) {
            System.out.println("We are still in middle frame");
        }
        driver.switchTo().defaultContent();
        // check inside default content is parent frame visible ?, so that we verify we are in default content.
        try {
            driver.findElement(By.xpath("//frame[@name='frame-top']")).isDisplayed();
            System.out.println("We are in default content");
        } catch (Exception e) {
            System.out.println("Still in parent frame");
        }

    }


}
