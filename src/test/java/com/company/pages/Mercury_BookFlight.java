package com.company.pages;

import com.company.utilities.DriverUtil;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mercury_BookFlight {
    Faker faker;

    public Mercury_BookFlight() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='passFirst0']")
    public WebElement passenger1FirstName;
    @FindBy(xpath = "//input[@name='passLast0']")
    public WebElement passenger1LastName;
    @FindBy(xpath = "//input[@name='passFirst1']")
    public WebElement passenger2FirstName;
    @FindBy(xpath = "//input[@name='passLast1']")
    public WebElement passenger2LastName;
    @FindBy(xpath = "//select[@name='pass.0.meal']")
    public WebElement passenger1MealDropDown;
    @FindBy(xpath = "//select[@name='pass.1.meal']")
    public WebElement passenger2MealDropDown;
    @FindBy(xpath = "//select[@name='creditCard']")
    public WebElement cardTypeDropDown;
    @FindBy(xpath = "//input[@name='creditnumber']")
    public WebElement cardNumber;
    @FindBy(xpath = "//select[@name='cc_exp_dt_mn']")
    public WebElement expirationMonth;
    @FindBy(xpath = "//select[@name='cc_exp_dt_yr']")
    public WebElement expirationYear;
    @FindBy(xpath = "//tr[15]//td[2]//input[1]")
    public WebElement sameAsBillingCheckBox;
    @FindBy(xpath = "//input[@name='buyFlights']")
    public WebElement securePurchaseBtn;

    public void billingAddress() {
        DriverUtil.getDriver().findElement(By.xpath("//input[@name='billAddress1']")).sendKeys("655 Oaklynn ct");
        DriverUtil.getDriver().findElement(By.xpath("//input[@name='billCity']")).sendKeys("Pittsburgh");
        DriverUtil.getDriver().findElement(By.xpath("//input[@name='billState']")).sendKeys("PA");
    }
}
