package com.company.pages;

import com.company.utilities.DriverUtil;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Mercury_SelectFlight {

    public Mercury_SelectFlight() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(css = "input[type='radio']")
    public List<WebElement> selectRadioBtns;
    @FindBy(xpath = "//input[@name='reserveFlights']")
    public WebElement continueBtn;

    public void selectDepartAirline(int i) {
        if (i < 1 ||i > 4) {
            System.out.println("Invalid Depart Airline, please choose 1-4 airline numbers");
            Assert.assertTrue(i >= 1 && i <= 4);
        }
        if (i >= 1 && i <= 4) {
            if (!selectRadioBtns.get(i - 1).isSelected()) {
                selectRadioBtns.get(i - 1).click();
                Assert.assertTrue(selectRadioBtns.get(i - 1).isSelected());
            }
            if (i == 1) {
                System.out.println("Depart Airline selected : Blue Skies 360");
            } else if (i == 2) {
                System.out.println("Depart Airline selected : Blue Skies Airlines 361");
            } else if (i == 3) {
                System.out.println("Depart Airline selected : Pangaea Airlines 362");
            } else if (i == 4) {
                System.out.println("Depart Airline selected : Unified Airlines 362");
            }
        }
    }

    public void selectReturnAirline(int i) {
        if (i < 5 || i > 8) {
            System.out.println("Invalid Return Airline, please choose 5-8 airline numbers");
            Assert.assertTrue(i >= 5 && i <= 8);
        }
        if (i >= 5 && i <= 8) {
            if (!selectRadioBtns.get(i - 1).isSelected()) {
                selectRadioBtns.get(i - 1).click();
                Assert.assertTrue(selectRadioBtns.get(i - 1).isSelected());
            }
            if (i == 5) {
                System.out.println("Return Airline selected : Blue Skies 630");
            } else if (i == 6) {
                System.out.println("Return Airline selected : Blue Skies Airlines 631");
            } else if (i == 7) {
                System.out.println("Return Airline selected : Pangaea Airlines 632");
            } else if (i == 8) {
                System.out.println("Return Airline selected : Unified Airlines 633");
            }
        }
    }

}