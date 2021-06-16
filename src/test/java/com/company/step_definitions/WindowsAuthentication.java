package com.company.step_definitions;

import com.company.pages.Heroku_Homepage;
import com.company.utilities.ConfigReader;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class WindowsAuthentication {

    private static Logger log = LogManager.getLogger(WindowsAuthentication.class.getName());
    Heroku_Homepage homepage = new Heroku_Homepage();

    @Given("I am in Home page")
    public void i_am_in_Home_page() {
        DriverUtil.getDriver().get(ConfigReader.getProperty("herURL"));
        log.info("navigated the website");
    }

    @Given("Basic Auth element should display in Ho")
    public void basic_Auth_element_should_display_in_Ho() {
        Assert.assertTrue(homepage.basicAuth.isDisplayed());
        log.info("Basic auth element is displayed");

    }


}
