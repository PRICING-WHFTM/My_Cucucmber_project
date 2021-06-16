package com.company.step_definitions;

import com.company.pages.*;
import com.company.utilities.DriverUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class MercuryBuyingTicket_steps {
    private WebDriver driver = DriverUtil.getDriver();
    Mercury_Homepage homepage = new Mercury_Homepage();
    Mercury_SignOn signOn = new Mercury_SignOn();
    Mercury_FlightFinder flightFinder = new Mercury_FlightFinder();
    Mercury_SelectFlight selectFlight = new Mercury_SelectFlight();
    Mercury_BookFlight bookFlight = new Mercury_BookFlight();
    MercuryFlightConfirmation flightConfirmation = new MercuryFlightConfirmation();
    String passengerCount = "2";

    @Given("I logged in the account")
    public void i_logged_in_the_account() {
        homepage.signOn.click();
        signOn.logIn();
        signOn.submitBtn.click();
    }

    @When("I select trip type")
    public void i_select_trip_type() {
        flightFinder.selectRoundTrip();
    }

    @When("I select passengers count")
    public void i_select_passengers_count() {
        flightFinder.selectCountOfPassengers(passengerCount);
    }

    @When("I select departing location")
    public void i_select_departing_location() {
        flightFinder.selectDepartingFrom("New York");
    }

    @When("I select departing month and date")
    public void i_select_departing_month_and_date() {
        flightFinder.selectDateOfDeparture("June", "13");
    }

    @When("I select arriving location")
    public void i_select_arriving_location() {
        flightFinder.selectArrivingInLocation("London");
    }

    @When("I select returning month and date")
    public void i_select_returning_month_and_date() {
        flightFinder.selectDateOfReturning("July", "15");
    }

    @When("I select service class")
    public void i_select_service_class() {
        flightFinder.selectServClass(2);
    }

    @When("I select airline")
    public void i_select_airline() {
        flightFinder.selectAirline("Unified Airlines");
    }

    @When("I click continue button in the page")
    public void i_click_continue_button_in_the_page() {
        flightFinder.continueBtn.click();
    }

    @Then("I should see {string} text in the page")
    public void i_should_see_text_in_the_page(String string) {
        Assert.assertTrue(driver.getPageSource().contains(string));
    }

    @When("I choose depart and return flight")
    public void i_choose_depart_and_return_flight() {
        selectFlight.selectDepartAirline(4);
    }

    @When("I click continue button in select flight page")
    public void i_click_continue_button_in_select_flight_page() {
        selectFlight.selectReturnAirline(8);
        selectFlight.continueBtn.click();
    }

    @Then("I should be abe to see {string} test in the next page")
    public void i_should_be_abe_to_see_test_in_the_next_page(String string) {
        Assert.assertTrue(driver.getPageSource().contains(string));
    }

    @When("I provide passengers details")
    public void i_provide_passengers_details(List<Map<String, String>> dataTable) {
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // will point the ro after header/2nd row
        bookFlight.passenger1FirstName.sendKeys(dataTable.get(0).get("firstname"));
        bookFlight.passenger1LastName.sendKeys(dataTable.get(0).get("lastname"));
        bookFlight.passenger2FirstName.sendKeys(dataTable.get(1).get("firstname"));
        bookFlight.passenger2LastName.sendKeys(dataTable.get(1).get("lastname"));
    }

    @When("I choose meal for passenger1 as {string} passenger2 as {string}")
    public void i_choose_meal_for_passenger1_as_passenger2_as(String string, String string2) {
        Select selectPas1Meal = new Select(bookFlight.passenger1MealDropDown);
        selectPas1Meal.selectByVisibleText(string);
        Assert.assertEquals(selectPas1Meal.getFirstSelectedOption().getText(), string);
        Select selectPas2Meal = new Select(bookFlight.passenger2MealDropDown);
        selectPas2Meal.selectByVisibleText(string2);
        Assert.assertEquals(selectPas2Meal.getFirstSelectedOption().getText(), string2);
    }

    @When("I choose payment method as {string}")
    public void i_choose_payment_method_as(String string) {
        Select selectCardType = new Select(bookFlight.cardTypeDropDown);
        selectCardType.selectByVisibleText(string);
        Assert.assertEquals(selectCardType.getFirstSelectedOption().getText(), string);
    }

    @When("card number {string} , expiration {string} , year {string}")
    public void card_number_expiration_year(String string, String string2, String string3) {
        bookFlight.cardNumber.sendKeys(string);
        Select expirationMonth = new Select(bookFlight.expirationMonth);
        expirationMonth.selectByVisibleText(string2);
        Assert.assertEquals(expirationMonth.getFirstSelectedOption().getText().trim(), string2);
        Select expirationYear = new Select(bookFlight.expirationYear);
        expirationYear.selectByVisibleText(string3);
        Assert.assertEquals(expirationYear.getFirstSelectedOption().getText().trim(), string3);

    }

    @When("I provide address and click same as billing address")
    public void i_provide_address_and_click_same_as_billing_address() {
        bookFlight.sameAsBillingCheckBox.click();
        Assert.assertTrue(bookFlight.sameAsBillingCheckBox.isSelected());
    }

    @When("I click secure purchase")
    public void i_click_secure_purchase() {
        bookFlight.securePurchaseBtn.click();
    }

    @Then("I should get flight confirmation number")
    public void i_should_get_flight_confirmation_number() {
        Assert.assertTrue(flightConfirmation.flightConfirmation.isDisplayed());
        System.out.println("Confirmation number : " + flightConfirmation.flightConfirmation.getText());
    }

    @Then("in departing I should see {string}")
    public void in_departing_I_should_see(String string) {
        Assert.assertEquals(flightConfirmation.departing(), string);
    }

    @Then("in Returning I should see {string}")
    public void in_Returning_I_should_see(String string) {
        Assert.assertEquals(flightConfirmation.returning(), string);
        Assert.assertEquals(flightConfirmation.passengers(), passengerCount + " " + "passengers");
    }

    @Then("total price including taxes should be {string}")
    public void total_price_including_taxes_should_be(String string) {
        Assert.assertEquals(flightConfirmation.totalPrice(), string);

    }

    @When("I click logout in flight confirmation page")
    public void i_click_logout_in_flight_confirmation_page() {
        flightConfirmation.logOut.click();
    }

    @Then("I should land to the signOn page")
    public void I_should_land_to_the_signOn_page() {
        Assert.assertTrue(driver.getTitle().contains("Sign-on: Mercury Tours"));
    }

}
