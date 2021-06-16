package com.company.pages;

import com.company.utilities.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercuryFlightConfirmation {
    public MercuryFlightConfirmation() {
        PageFactory.initElements(DriverUtil.getDriver(), this);
    }

    @FindBy(xpath = "//font[contains(text(),'Flight')]")
    public WebElement flightConfirmation;
    @FindBy(xpath = "//td[3]//a[1]//img[1]")
    public WebElement logOut;

    public String departing() {
        return DriverUtil.getDriver().findElement(By.xpath("//tr//tr//tr//tr//tr[3]//td[1]//font[1]//b[1]")).getText();
    }

    public String returning() {
        return DriverUtil.getDriver().findElement(By.xpath("//tr//tr//tr//tr//tr[5]//td[1]//font[1]//b[1]")).getText();
    }

    public String passengers() {
        return DriverUtil.getDriver().findElement(By.xpath("//tr[7]//td[1]//font[1]")).getText();
    }

    public String totalPrice() {
        return DriverUtil.getDriver().
                findElement(By.xpath("//td[@class='data_left']//table//tbody//tr//td//font//b//font//font//b//font"))
                .getText();
    }
}
