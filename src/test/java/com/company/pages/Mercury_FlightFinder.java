package com.company.pages;

import com.company.utilities.BrowserUtils;
import com.company.utilities.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Mercury_FlightFinder {

    public Mercury_FlightFinder() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='findFlights']")
    public WebElement continueBtn;
    @FindBy(xpath = "//body//b//input[1]")
    public WebElement roundTrip;
    @FindBy(xpath = "//body//b//input[2]")
    public WebElement oneWay;
    @FindBy(xpath = "//select[@name='passCount']")
    public WebElement passengersDropdown;
    @FindBy(xpath = "//select[@name='fromPort']")
    public WebElement departingFromDropdown;
    @FindBy(xpath = "//select[@name='fromMonth']")
    public WebElement fromMonthDropdown;
    @FindBy(xpath = "//select[@name='fromDay']")
    public WebElement fromDayDropdown;
    @FindBy(xpath = "//select[@name='toPort']")
    public WebElement arrivingInDropdown;
    @FindBy(xpath = "//select[@name='toMonth']")
    public WebElement toMonthDropdown;
    @FindBy(xpath = "//select[@name='toDay']")
    public WebElement toDayDropdown;
    @FindBy(xpath = "//input[@name='servClass']")
    public List<WebElement> servClassList;
    @FindBy(xpath = "//select[@name='airline']")
    public WebElement airlineDropdown;


    public void selectRoundTrip() {
        if (!roundTrip.isSelected()) {
            roundTrip.click();
        }
    }

    public void selectOneWay() {
        if (!oneWay.isSelected()) {
            oneWay.click();
        }
    }

    public void selectCountOfPassengers(String value) {
        Select select = new Select(passengersDropdown);
        Assert.assertEquals(select.getFirstSelectedOption().getText().trim(), "1");
        select.selectByVisibleText(value);
        Assert.assertEquals(select.getFirstSelectedOption().getText().trim(), value);
        System.out.println("selected count of passenger : " + value);
    }

    public void selectDepartingFrom(String visibleText) {
        Select select = new Select(departingFromDropdown);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "Acapulco");
        select.selectByVisibleText(visibleText);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), visibleText);
        System.out.println("selected departing from : " + visibleText);
    }

    public void selectDateOfDeparture(String month, String day) {
        Select selectMonth = new Select(fromMonthDropdown);
        Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(), BrowserUtils.get_Current_Month());
        System.out.println("Current Month is " + BrowserUtils.get_Current_Month());
        selectMonth.selectByVisibleText(month);
        Assert.assertEquals(selectMonth.getFirstSelectedOption().getText(), month);
        System.out.println("selected departure month : " + month);
        Select selectDay = new Select(fromDayDropdown);
        Assert.assertEquals(selectDay.getFirstSelectedOption().getText(), BrowserUtils.get_Current_Day());
        System.out.println("Current day is " + BrowserUtils.get_Current_Day());
        selectDay.selectByVisibleText(day);
        Assert.assertEquals(selectDay.getFirstSelectedOption().getText(), day);
        System.out.println("selected departure day : " + day);
    }

    public void selectArrivingInLocation(String value) {
        Select selectArrivingLocation = new Select(arrivingInDropdown);
        Assert.assertEquals(selectArrivingLocation.getFirstSelectedOption().getText(), "Acapulco");
        selectArrivingLocation.selectByVisibleText(value);
        Assert.assertEquals(selectArrivingLocation.getFirstSelectedOption().getText(), value);
        System.out.println("selected arriving in : " + value);
    }

    public void selectDateOfReturning(String month, String day) {
        Select selectToMonth = new Select(toMonthDropdown);
        Assert.assertEquals(selectToMonth.getFirstSelectedOption().getText(), BrowserUtils.get_Current_Month());
        selectToMonth.selectByVisibleText(month);
        Assert.assertEquals(selectToMonth.getFirstSelectedOption().getText(), month);
        System.out.println("selected returning month : " + month);
        Select selectToDay = new Select(toDayDropdown);
        Assert.assertEquals(selectToDay.getFirstSelectedOption().getText(), BrowserUtils.get_Current_Day());
        selectToDay.selectByVisibleText(day);
        Assert.assertEquals(selectToDay.getFirstSelectedOption().getText(), day);
        System.out.println("selected returning day : " + day);
    }

    public void selectServClass(int option) {
        if (!servClassList.get(option - 1).isSelected()) {
            servClassList.get(option - 1).click();
        }
        Assert.assertTrue(servClassList.get(option - 1).isSelected());
        if (option == 1) {
            System.out.println("Selected servClass is : Economy Class");
        } else if (option == 2) {
            System.out.println("Selected servClass is : Business Class");
        } else if (option == 3) {
            System.out.println("Selected servClass is : First Class");
        }
    }


    public void selectAirline(String value) {
        Select selectAirline = new Select(airlineDropdown);
        Assert.assertEquals(selectAirline.getFirstSelectedOption().getText(), "No Preference");
        selectAirline.selectByVisibleText(value);
        Assert.assertEquals(selectAirline.getFirstSelectedOption().getText(), value);
        System.out.println("selected airline : " + value);
    }
}
