package com.company.step_definitions;

import com.company.pages.MapRoom;
import com.company.pages.Sign_In;
import com.company.utilities.BrowserUtils;
import com.company.utilities.DBUtils;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapDetails_steps {
    private WebDriver driver;
    ResultSet resultset;

    Sign_In sign_in = new Sign_In();
    MapRoom mapRoom = new MapRoom();

    @Given("User is in the login page")
    public void user_is_in_the_login_page() {
        driver = DriverUtil.getDriver();
        driver.get("https://cybertek-reservation-qa.herokuapp.com/sign-in");
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        sign_in.login(string, string2);
    }

    @Then("User should be able to see {string} room")
    public void user_should_be_able_to_see_room(String string) {
        BrowserUtils.waitForVisibility(mapRoom.denali);
        Assert.assertTrue(mapRoom.denali.isDisplayed());
        Assert.assertEquals(mapRoom.denali.getText(), string);
    }

    @Then("In DB I should see the {string} room")
    public void in_DB_I_should_see_the_room(String string) throws SQLException {
        DBUtils.createConnectionToRoomDB();
        String query = "Select * from room;";
        List<String> allRoomNames = DBUtils.executeQueryAndGetColumnValuesAsList(query, "name");
        System.out.println(allRoomNames);
        Assert.assertTrue(allRoomNames.contains(string));
        DBUtils.destroy();
    }


}

















