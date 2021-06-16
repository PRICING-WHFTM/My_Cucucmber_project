package com.company.step_definitions;

import com.company.pages.FileUpload;
import com.company.pages.Heroku_Homepage;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class FileUpload_SendKeys_steps {
    WebDriver driver = DriverUtil.getDriver();
    Heroku_Homepage homepage = new Heroku_Homepage();
    FileUpload fileUpload = new FileUpload();

    @When("I click file upload")
    public void i_click_file_upload() {
        homepage.uploadFile.click();
    }

    @When("choose the file {string}")
    public void choose_the_file(String string) {
        String fullPath = System.getProperty("user.dir") + "/" + string;
        fileUpload.chooseFile.sendKeys(fullPath);

    }

    @When("click upload button")
    public void click_upload_button() throws InterruptedException {
        fileUpload.uploadButton.click();
        Thread.sleep(1000);
    }

    @Then("I should get {string} confirmation text")
    public void i_should_get_confirmation_text(String string) {
        Assert.assertTrue(driver.getPageSource().contains(string));
    }
}
